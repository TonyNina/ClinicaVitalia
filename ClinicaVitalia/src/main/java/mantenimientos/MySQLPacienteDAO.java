package mantenimientos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.PacienteDAO;
import model.PacienteDTO;
import utils.MySQLConexion;

public class MySQLPacienteDAO implements PacienteDAO {

	@Override
	public List<PacienteDTO> listar() {
		List<PacienteDTO> lista = new ArrayList<PacienteDTO>();
		ResultSet rs= null; 
		Connection con = null;
		PreparedStatement pst=null;
		
		try {
			con=MySQLConexion.getConexion();
			String sql= "select * from tb_paciente";
			
			pst = con.prepareStatement(sql);
			
			rs= pst.executeQuery();
			
			while(rs.next()) {
				PacienteDTO pacienteDTO = new PacienteDTO();
				pacienteDTO.setCodigo(rs.getInt(1));
				pacienteDTO.setNombre(rs.getString(2));
				pacienteDTO.setApePaterno(rs.getString(3));
				pacienteDTO.setApeMaterno(rs.getString(4));
				pacienteDTO.setFechaNac(rs.getDate(5));
				pacienteDTO.setSexo(rs.getInt(6));
				pacienteDTO.setEmail(rs.getString(7));
				pacienteDTO.setNumCel(rs.getInt(8));
				pacienteDTO.setUsername(rs.getString(9));
				pacienteDTO.setContrasena(rs.getString(10));
				lista.add(pacienteDTO);
				
			}
			
		} catch (Exception e) {
			 System.out.println("Error en la sentencia "+e.getMessage());
		} finally {//cerrar conexiones
			try {
				
				if (rs!=null)  rs.close();
				if (pst!=null) pst.close();
				if (con!=null) con.close();
				
				
			} catch (Exception e2) {
				 System.out.println("Error al cerrar conexiones "+e2.getMessage());
			}
		}
		
		return lista;
	}

	@Override
	public PacienteDTO obtenerPaciente(int codigo) {
		PacienteDTO pacienteDTO = new PacienteDTO();
		ResultSet rs= null; 
		Connection con = null;
		PreparedStatement pst=null;
		
		try {
			con=MySQLConexion.getConexion();
			String sql= "select * from tb_paciente where id=?";
			
			pst = con.prepareStatement(sql);
			
			pst.setInt(1, codigo); 
			
			rs = pst.executeQuery();
			
			while(rs.next()) {
				pacienteDTO = new PacienteDTO();
				pacienteDTO.setCodigo(rs.getInt(1));
				pacienteDTO.setNombre(rs.getString(2));
				pacienteDTO.setApePaterno(rs.getString(3));
				pacienteDTO.setApeMaterno(rs.getString(4));
				pacienteDTO.setFechaNac(rs.getDate(5));
				pacienteDTO.setSexo(rs.getInt(6));
				pacienteDTO.setEmail(rs.getString(7));
				pacienteDTO.setNumCel(rs.getInt(8));
				pacienteDTO.setUsername(rs.getString(9));
				pacienteDTO.setContrasena(rs.getString(10));
				
				
			}
			
		} catch (Exception e) {
			 System.out.println("Error en la sentencia "+e.getMessage());
		} finally {//cerrar conexiones
			try {
				
				if (rs!=null)  rs.close();
				if (pst!=null) pst.close();
				if (con!=null) con.close();			
				
			} catch (Exception e2) {
				 System.out.println("Error al cerrar conexiones "+e2.getMessage());
			}
		}
		
		return pacienteDTO;
	}

	@Override
	public int registrar(PacienteDTO pacienteDTO) {
		int resultado=0;
		Connection con = null;
		PreparedStatement pst= null;
		
		try {
			con = MySQLConexion.getConexion();
			  //Creado en query sql
			  String sql = "insert into tb_paciente values (null, ?,?,?,?,?,?,?,?,?)";
			  
			  pst= con.prepareStatement(sql);
			  
			  pst.setString(1, pacienteDTO.getNombre());
			  pst.setString(2, pacienteDTO.getApePaterno());
			  pst.setString(3, pacienteDTO.getApeMaterno());
			  java.sql.Date fechaSql = new java.sql.Date(pacienteDTO.getFechaNac().getTime());
		      pst.setDate(4, fechaSql);
			  pst.setInt(5, pacienteDTO.getSexo());
			  pst.setString(6, pacienteDTO.getEmail());
			  pst.setInt(7, pacienteDTO.getNumCel());
			  pst.setString(8, pacienteDTO.getUsername());
			  pst.setString(9, pacienteDTO.getContrasena());
			  
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
	public int actualizar(PacienteDTO pacienteDTO) {
		int resultado=0;
		Connection con = null;
		PreparedStatement pst= null;
		
		try {
			
			//Conexión
			  con = MySQLConexion.getConexion();
			  //Creado en query sql
			  String sql = "update tb_paciente set nombre=?, apePaterno=?, apeMaterno=?, fechaNac=?, sexo=?, email = ?, numCel=?, userName=?, contrasena=? where id=? ";

			  pst= con.prepareStatement(sql);
			  
			  pst.setString(1, pacienteDTO.getNombre());
			  pst.setString(2, pacienteDTO.getApePaterno());
			  pst.setString(3, pacienteDTO.getApeMaterno());
			  java.sql.Date fechaSql = new java.sql.Date(pacienteDTO.getFechaNac().getTime());
		      pst.setDate(4, fechaSql);
			  pst.setInt(5, pacienteDTO.getSexo());
			  pst.setString(6, pacienteDTO.getEmail());
			  pst.setInt(7, pacienteDTO.getNumCel());
			  pst.setString(8, pacienteDTO.getUsername());
			  pst.setString(9, pacienteDTO.getContrasena());
			  pst.setInt(10, pacienteDTO.getCodigo());
			  
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
	public int eliminar(int codigo) {
		int resultado=0;
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			con=MySQLConexion.getConexion();
			String sql="delete from tb_paciente where id=?" ;
			pst= con.prepareStatement(sql);
			
			pst.setInt(1, codigo);
			resultado=pst.executeUpdate();

			
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

	@Override
	public PacienteDTO validarUsuario(String paciente, String contrasena) {
		
		PacienteDTO pacienteDTO = null;
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
		
		try {
			con = MySQLConexion.getConexion();
			String sql = "call usp_validarAcceso(?,?)";
			cst = con.prepareCall(sql);
			
			//parametrizar
			cst.setString(1, paciente);
			cst.setString(2, contrasena);
			//ejecucion
			
			rs = cst.executeQuery();
			while(rs.next()) {
				pacienteDTO = new PacienteDTO();
				pacienteDTO.setCodigo(rs.getInt(1));
				pacienteDTO.setNombre(rs.getString(2));
				pacienteDTO.setApePaterno(rs.getString(3));
				pacienteDTO.setApeMaterno(rs.getString(4));
				pacienteDTO.setFechaNac(rs.getDate(5));
				pacienteDTO.setSexo(rs.getInt(6));
				pacienteDTO.setEmail(rs.getString(7));
				pacienteDTO.setNumCel(rs.getInt(8));
				pacienteDTO.setUsername(rs.getString(9));
				pacienteDTO.setContrasena(rs.getString(10));
			}
			
			
		} catch (Exception e) {
			 System.out.println("Error en la sentencia "+e.getMessage());
		} finally {//cerrar conexiones
			try {
				
				if (rs!=null)  rs.close();
				if (cst!=null) cst.close();
				if (con!=null) con.close();			
				
			} catch (Exception e2) {
				 System.out.println("Error al cerrar conexiones "+e2.getMessage());
			}
		}
		
		return pacienteDTO;
	}

}
