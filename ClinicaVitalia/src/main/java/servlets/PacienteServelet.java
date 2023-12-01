package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mantenimientos.MySQLPacienteDAO;
import model.PacienteDTO;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import dao.DAOFactory;
import dao.MySQLDAOFactory;
import dao.PacienteDAO;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Servlet implementation class pacienteServelet
 */
@WebServlet("/pacienteServlet")
public class PacienteServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PacienteServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		String opcion= request.getParameter("opcion");
		System.out.println("get opcion ---> " + opcion);
		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion=request.getParameter("opcion");
		System.out.println("get opcion --->" +opcion);
		
		if (opcion != null) {
			switch (opcion) {
			case "reg":
						registrar(request, response);
						break;
			case "act": 
						actualizar(request, response);
						break;
			case "lis": 
						listar(request, response);
						break;
			case "nue":
						nuevo(request, response);
						break;
			case "bus": 
						buscar(request, response);
						break;
			case "eli": 
						eliminar(request, response);
						break;
			default:
				throw new IllegalArgumentException("Unexpected Value: " + opcion);
			}
		} else {
		    throw new IllegalArgumentException("Opcion is null");
		}
	}

	private void nuevo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("paciente/registrarPaciente.jsp").forward(request, response);
		
	}

	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int codigo = Integer.parseInt(request.getParameter("cod"));
		
		DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		PacienteDAO dao = fabrica.getPacienteDAO();
		PacienteDTO paciente = dao.obtenerPaciente(codigo);
		
		//salida
		request.setAttribute("paciente", paciente);
		request.getRequestDispatcher("paciente/actualizarPaciente.jsp").forward(request, response);
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mensaje ="";
		
		int codigo = Integer.parseInt(request.getParameter("cod"));
		
		DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		PacienteDAO dao = fabrica.getPacienteDAO();
		
		int ok = dao.eliminar(codigo);
		
		if(ok==0) {
			mensaje+=" <script> alert('"+" Error al eliminar los datos" +"') </script>";
			 
		}else {
			mensaje+=" <script> alert('"+"Eliminación del paciente con ID: "+codigo+"." +"') </script>";
		 
		}
		
		request.setAttribute("mensaje", mensaje);
		listar(request, response);
		
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		PacienteDAO dao = fabrica.getPacienteDAO();
		List<PacienteDTO> lista = dao.listar(); System.out.println(lista.size());
		
		
		//salida
		request.setAttribute("lstPacientes", lista);
		request.getRequestDispatcher("paciente/listarPacientes.jsp").forward(request, response);
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mensaje = "";
		
		//entradas
		int codigo = Integer.parseInt(request.getParameter("txtCodigo"));
		String nombre = request.getParameter("txtNombres");
		String apePaterno = request.getParameter("txtApePat");
		String apeMaterno = request.getParameter("txtApeMat");
		String fechaNacString = request.getParameter("txtFechaNac"); /* <-- ahi esta el atributo fecha como STRING, y no se como cambiarlo a DATE */
		
		//convertir la cadena en un objeto de tipo date
		Date fechaNac = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			fechaNac = sdf.parse(fechaNacString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		int sexo = Integer.parseInt(request.getParameter("cboSexo"));
		String email = request.getParameter("txtEmail");
		int numCel = Integer.parseInt(request.getParameter("txtNumCel"));
		String userName = request.getParameter("txtUserName");
		String contrasena = request.getParameter("txtContrasena");
		
		PacienteDTO objPaciente = new PacienteDTO(codigo, nombre, apePaterno, apeMaterno, fechaNac, sexo, email, numCel, userName, contrasena);
		
		MySQLPacienteDAO gestionPaciente = new MySQLPacienteDAO();
		int ok = gestionPaciente.actualizar(objPaciente);
		
		if(ok==0) {
			mensaje+=" <script> alert('"+" Error al registrar los datos" +"') </script>";
			 
		}else {
			mensaje+=" <script> alert('"+"Registro exitoso" +"') </script>";		 
		}
		
		request.setAttribute("mensaje", mensaje);
		
		//invocamos a listar
		listar(request, response);
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mensaje="";
	
		String codigoParam = request.getParameter("txtCodigo");
		int codigo = 0; // Valor predeterminado en caso de que no se pueda analizar el número

		if (codigoParam != null && !codigoParam.isEmpty()) {
		    codigo = Integer.parseInt(codigoParam);
		}
		String nombre = request.getParameter("txtNombres");
		String apePaterno = request.getParameter("txtApePat");
		String apeMaterno = request.getParameter("txtApeMat");
		String fechaNacString = request.getParameter("txtFechaNac"); /* <-- ahi esta el atributo fecha como STRING, y no se como cambiarlo a DATE */
		
		//convertir la cadena en un objeto de tipo date
		Date fechaNac = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			fechaNac = sdf.parse(fechaNacString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		int sexo = Integer.parseInt(request.getParameter("cboSexo"));
		String email = request.getParameter("txtEmail");
		int numCel = Integer.parseInt(request.getParameter("txtNumCel"));
		String userName = request.getParameter("txtUserName");
		String contrasena = request.getParameter("txtContrasena");
		
		PacienteDTO objPaciente = new PacienteDTO(codigo, nombre, apePaterno, apeMaterno, fechaNac, sexo, email, numCel, userName, contrasena);
		
		MySQLPacienteDAO gestionPaciente = new MySQLPacienteDAO();
		int ok = gestionPaciente.registrar(objPaciente);
		
		if(ok==0) {
			mensaje+=" <script> alert('"+" Error al registrar los datos" +"') </script>";
			 
		}else {
			mensaje+=" <script> alert('"+"Registro exitoso" +"') </script>";		 
		}
		
		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher("logeo/logIn.jsp").forward(request, response);
	 
	}

}
