package dao;

import java.util.List;

import model.MedicoDTO;

public interface MedicoDAO {
	
	public int registrar(MedicoDTO medicoDTO);
	public int actualizar(MedicoDTO medicoDTO);
	
	public List<MedicoDTO> listar();
	public MedicoDTO obtenerMedico(int codigo);
	public int eliminar(int codigo);
	

}
