package model;

public class CitaDTO {
    private int codigo;
    private MedicoDTO idMedico;
    private TipoEspecialidadDTO idEspecialidad;
    private String fecha;
    private String hora;
    private String motivo;
    private TipoConsultaDTO tipoConsulta;
    private SedeDTO sede;
    
    
	public CitaDTO(int codigo, MedicoDTO idMedico, TipoEspecialidadDTO idEspecialidad, String fecha, String hora,
			String motivo, TipoConsultaDTO tipoConsulta, SedeDTO sede) {

		this.codigo = codigo;
		this.idMedico = idMedico;
		this.idEspecialidad = idEspecialidad;
		this.fecha = fecha;
		this.hora = hora;
		this.motivo = motivo;
		this.tipoConsulta = tipoConsulta;
		this.sede = sede;
	}
    
	 
		public CitaDTO(MedicoDTO idMedico, TipoEspecialidadDTO idEspecialidad, String fecha, String hora,
				String motivo, TipoConsultaDTO tipoConsulta, SedeDTO sede) {
			this.idMedico = idMedico;
			this.idEspecialidad = idEspecialidad;
			this.fecha = fecha;
			this.hora = hora;
			this.motivo = motivo;
			this.tipoConsulta = tipoConsulta;
			this.sede = sede;
		}
	    
		public CitaDTO() {}


		public int getCodigo() {
			return codigo;
		}


		public void setCodigo(int codigo) {
			this.codigo = codigo;
		}


		public MedicoDTO getIdMedico() {
			return idMedico;
		}


		public void setIdMedico(MedicoDTO idMedico) {
			this.idMedico = idMedico;
		}


		public TipoEspecialidadDTO getIdEspecialidad() {
			return idEspecialidad;
		}


		public void setIdEspecialidad(TipoEspecialidadDTO idEspecialidad) {
			this.idEspecialidad = idEspecialidad;
		}


		public String getFecha() {
			return fecha;
		}


		public void setFecha(String fecha) {
			this.fecha = fecha;
		}


		public String getHora() {
			return hora;
		}


		public void setHora(String hora) {
			this.hora = hora;
		}


		public String getMotivo() {
			return motivo;
		}


		public void setMotivo(String motivo) {
			this.motivo = motivo;
		}


		public TipoConsultaDTO getTipoConsulta() {
			return tipoConsulta;
		}


		public void setTipoConsulta(TipoConsultaDTO tipoConsulta) {
			this.tipoConsulta = tipoConsulta;
		}


		public SedeDTO getSede() {
			return sede;
		}


		public void setSede(SedeDTO sede) {
			this.sede = sede;
		}
    
    
    
    
}