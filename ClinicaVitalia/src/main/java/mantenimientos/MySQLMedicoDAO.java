package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import dao.MedicoDAO;
import model.MedicoDTO;
import utils.MySQLConexion;

public class MySQLMedicoDAO implements MedicoDAO {

	@Override
	public int registrar(MedicoDTO medicoDTO) {
		int resultado=0;
		Connection con = null;
		PreparedStatement pst= null;
		
		try {
			con = MySQLConexion.getConexion();
			  //Creado en query sql
			  String sql = "insert into tb_medico values (null, ?,?,?,?,?,?)";
			  
			  pst= con.prepareStatement(sql);
			  
			  pst.setString(1, medicoDTO.getNombres());
			  pst.setString(2, medicoDTO.getApellidos());
			  pst.setInt(3, medicoDTO.getEspecialidad().getCodigo());
			  pst.setString(4, medicoDTO.getEmail());
			  pst.setInt(5, medicoDTO.getCelular());
			  
			  resultado = pst.executeUpdate();
			  
		} catch (Exception e) {
			 System.out.println("Error en la sentencia "+e.getMessage());
		} finally {
			
				try {
					if (pst!=null)pst.close();
					if (con!=null)con.close();
				} catch (Exception e2) {
					 System.out.println("Error al cerrar "+e2.getMessage());
				}
		}
	
		return resultado;
	}

	@Override
	public int actualizar(MedicoDTO medico) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MedicoDTO> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MedicoDTO obtenerMedico(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int eliminar(int codigo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
