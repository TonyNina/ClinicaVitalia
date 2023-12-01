package dao;

import mantenimientos.MySQLCitaDAO;
import mantenimientos.MySQLMedicoDAO;
import mantenimientos.MySQLPacienteDAO;

public class MySQLDAOFactory extends DAOFactory {

	@Override
	public PacienteDAO getPacienteDAO() {
		return new MySQLPacienteDAO();
	}
	
	public MedicoDAO getMedicoDAO() {
		return new MySQLMedicoDAO();
	}
	
	public CitaDAO getCitaDAO() {
		return new MySQLCitaDAO();
	}

}
