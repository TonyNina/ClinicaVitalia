package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.CitaDAO;
import model.CitaDTO;
import model.MedicoDTO;
import model.TipoEspecialidadDTO;
import model.TipoConsultaDTO;
import model.SedeDTO;
import utils.MySQLConexion;

public class MySQLCitaDAO implements CitaDAO {

    @Override
    public int registrar(CitaDTO citaDTO) {
        int resultado = 0;
        Connection con = null;
        PreparedStatement pst = null;

        try {
            con = MySQLConexion.getConexion();
            String sql = "INSERT INTO tb_cita (id_medico, id_especialidad, fecha, hora, motivo, id_tipoConsulta, id_sede) VALUES (?, ?, ?, ?, ?, ?, ?)";
            pst = con.prepareStatement(sql);

            pst.setInt(1, citaDTO.getIdMedico().getCodigo());
            pst.setInt(2, citaDTO.getIdEspecialidad().getCodigo());
            pst.setString(3, citaDTO.getFecha());
            pst.setString(4, citaDTO.getHora());
            pst.setString(5, citaDTO.getMotivo());
            pst.setInt(6, citaDTO.getTipoConsulta().getCodigo());
            pst.setInt(7, citaDTO.getSede().getCodigo());

            resultado = pst.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error en la sentencia " + e.getMessage());
        } finally {
            try {
                if (pst != null)
                    pst.close();
                if (con != null)
                    con.close();
            } catch (Exception e2) {
                System.out.println("Error al cerrar " + e2.getMessage());
            }
        }

        return resultado;
    }

    @Override
    public int actualizar(CitaDTO citaDTO) {
        int resultado = 0;
        Connection con = null;
        PreparedStatement pst = null;

        try {
            con = MySQLConexion.getConexion();
            String sql = "UPDATE tb_cita SET fecha=?, hora=?, motivo=?, id_medico=?, id_especialidad=?, id_tipoConsulta=?, id_sede=? WHERE id=?";
            pst = con.prepareStatement(sql);

            pst.setString(1, citaDTO.getFecha());
            pst.setString(2, citaDTO.getHora());
            pst.setString(3, citaDTO.getMotivo());
            pst.setInt(4, citaDTO.getIdMedico().getCodigo());
            pst.setInt(5, citaDTO.getIdEspecialidad().getCodigo());
            pst.setInt(6, citaDTO.getTipoConsulta().getCodigo());
            pst.setInt(7, citaDTO.getSede().getCodigo());
            pst.setInt(8, citaDTO.getCodigo());

            resultado = pst.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error en la sentencia " + e.getMessage());
        } finally {

            try {
                if (pst != null)
                    pst.close();
                if (con != null)
                    con.close();
            } catch (Exception e2) {
                System.out.println("Error al cerrar " + e2.getMessage());
            }
        }

        return resultado;
    }

    @Override
    public List<CitaDTO> listar() {
        List<CitaDTO> lista = new ArrayList<>();
        ResultSet rs = null;
        Connection con = null;
        PreparedStatement pst = null;

        try {
            con = MySQLConexion.getConexion();
            String sql = "SELECT c.id, c.fecha, c.hora, c.motivo, c.id_medico, m.nombres AS nombre_medico, m.apellidos AS apellidos_medico, " +
                         "c.id_especialidad, e.descripcion AS nombre_especialidad, c.id_tipoConsulta, tc.des_tipoConsulta AS tipo_consulta, " +
                         "c.id_sede, s.des_sede AS nombre_sede " +
                         "FROM tb_cita c " +
                         "INNER JOIN tb_medico m ON c.id_medico = m.id " +
                         "INNER JOIN tb_especialidad e ON c.id_especialidad = e.id " +
                         "INNER JOIN tb_tipoConsulta tc ON c.id_tipoConsulta = tc.id " +
                         "INNER JOIN tb_sede s ON c.id_sede = s.id";

            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                CitaDTO cita = new CitaDTO();
                cita.setCodigo(rs.getInt("id"));
                cita.setFecha(rs.getString("fecha"));
                cita.setHora(rs.getString("hora"));
                cita.setMotivo(rs.getString("motivo"));
                
                // Datos del médico
                MedicoDTO medico = new MedicoDTO();
                medico.setCodigo(rs.getInt("id_medico"));
                medico.setNombres(rs.getString("nombre_medico"));
                medico.setApellidos(rs.getString("apellidos_medico"));
                cita.setIdMedico(medico);
                
                // Datos de la especialidad
                TipoEspecialidadDTO especialidad = new TipoEspecialidadDTO();
                especialidad.setCodigo(rs.getInt("id_especialidad"));
                especialidad.setDesTipoEspecialidad(rs.getString("nombre_especialidad"));
                cita.setIdEspecialidad(especialidad);
                
                // Datos del tipo de consulta
                TipoConsultaDTO tipoConsulta = new TipoConsultaDTO();
                tipoConsulta.setCodigo(rs.getInt("id_tipoConsulta"));
                tipoConsulta.setDesTipoConsulta(rs.getString("tipo_consulta"));
                cita.setTipoConsulta(tipoConsulta);
                
                // Datos de la sede
                SedeDTO sede = new SedeDTO();
                sede.setCodigo(rs.getInt("id_sede"));
                sede.setDesSede(rs.getString("nombre_sede"));
                cita.setSede(sede);

                lista.add(cita);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (pst != null)
                    pst.close();
                if (con != null)
                    con.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        return lista;
    }

    @Override
    public CitaDTO obtenerCita(int codigo) {
        CitaDTO cita = null;
        ResultSet rs = null;
        Connection con = null;
        PreparedStatement pst = null;

        try {
            con = MySQLConexion.getConexion();
            String sql = "SELECT c.id, c.fecha, c.hora, c.motivo, c.id_medico, c.id_especialidad, c.tipoConsulta, c.Sede " +
                         "FROM tb_cita c " +
                         "WHERE c.id = ?";

            pst = con.prepareStatement(sql);
            pst.setInt(1, codigo);

            rs = pst.executeQuery();

            while (rs.next()) {
                cita = new CitaDTO();
                cita.setCodigo(rs.getInt("id"));
                cita.setFecha(rs.getString("fecha"));
                cita.setHora(rs.getString("hora"));
                cita.setMotivo(rs.getString("motivo"));
                
                MedicoDTO medico = new MedicoDTO();
                medico.setCodigo(rs.getInt("codigo"));
                medico.setNombres(rs.getString("nombres"));
                cita.setIdMedico(medico);
                
                TipoEspecialidadDTO especialidad = new TipoEspecialidadDTO();
                especialidad.setCodigo(rs.getInt("codigo"));
                especialidad.setDesTipoEspecialidad(rs.getString("desTipoEspecialidad"));
                cita.setIdEspecialidad(especialidad);
                
                TipoConsultaDTO consulta = new TipoConsultaDTO();
                consulta.setCodigo(rs.getInt("codigo"));
                consulta.setDesTipoConsulta(rs.getString("desTipoConsulta"));
                cita.setTipoConsulta(consulta);
               
               
                SedeDTO sede = new SedeDTO();
                sede.setCodigo(rs.getInt("codigo"));
                sede.setDesSede(rs.getString("desSede"));
                cita.setSede(sede);
            }

        } catch (Exception e) {
            System.out.println("Error en la sentencia " + e.getMessage());
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (pst != null)
                    pst.close();
                if (con != null)
                    con.close();
            } catch (Exception e2) {
                System.out.println("Error al cerrar conexiones " + e2.getMessage());
            }
        }

        return cita;
    }


	@Override
	public int eliminar(int codigo) {

		int resultado=0;
		Connection con = null;
		PreparedStatement pst = null;
	
		try {
			con= MySQLConexion.getConexion();
			String sql = "delete from tb_cita where id=?";
			pst = con.prepareStatement(sql);

			pst.setInt(1, codigo);
			
			resultado= pst.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error en la sentencia "+e.getMessage());
		} finally {
			
			try {
				if(pst!=null)pst.close();
				if(con!=null)con.close();
			} catch (Exception e2) {
				System.out.println("Error al cerrar "+e2.getMessage());
			}
		}		
		return  resultado;
	}

}
