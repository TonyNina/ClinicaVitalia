package model;

public class MedicoDTO {
	private int codigo;
	private String nombres;
	private String apellidos;
	private TipoEspecialidadDTO especialidad;
	private String email;
	private int celular;
	
	
	public MedicoDTO(int codigo, String nombres, String apellidos, TipoEspecialidadDTO especialidad, String email,
			int celular) {

		this.codigo = codigo;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.especialidad = especialidad;
		this.email = email;
		this.celular = celular;
	}
	
	public MedicoDTO(String nombres, String apellidos, TipoEspecialidadDTO especialidad, String email,
			int celular) {
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.especialidad = especialidad;
		this.email = email;
		this.celular = celular;
	}
	
	public MedicoDTO() {}
	
	/*Getter ans setters*/
	

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public TipoEspecialidadDTO getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(TipoEspecialidadDTO especialidad) {
		this.especialidad = especialidad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCelular() {
		return celular;
	}

	public void setCelular(int celular) {
		this.celular = celular;
	}
	

	
	
	
}
