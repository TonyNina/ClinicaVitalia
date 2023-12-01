package dao;

import java.util.List;

import model.PacienteDTO;

public interface PacienteDAO {
	
	public List<PacienteDTO> listar(); 
	public PacienteDTO obtenerPaciente(int codigo);
	public int registrar(PacienteDTO pacienteDTO);
	public int actualizar(PacienteDTO pacienteDTO);
	public int eliminar(int codigo);
	
	public PacienteDTO validarUsuario(String paciente, String contrasena);

}
