package dao;

import java.util.List;

import model.CitaDTO;

public interface CitaDAO {
	
	public int registrar(CitaDTO citaDTO);
	public int actualizar(CitaDTO citaDTO);
	
	public List<CitaDTO> listar(); 
	public CitaDTO obtenerCita(int codigo);
	public int eliminar(int codigo);
	
}
