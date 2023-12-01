package dao;

public abstract class DAOFactory {
	
	public static final int MYSQL=1;
	public static final int SQL=2;
	
	public abstract PacienteDAO getPacienteDAO();
	public abstract MedicoDAO getMedicoDAO();	
	public abstract CitaDAO getCitaDAO(); 
	
	public static DAOFactory getDAOFactory(int qBD) {
		
		switch(qBD) {
			case MYSQL: {
				return new MySQLDAOFactory();
			}
			default:
				return null;
		}
	}
	

}
