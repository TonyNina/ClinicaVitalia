package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.PacienteDTO;

import java.io.IOException;
import java.text.SimpleDateFormat;

import dao.DAOFactory;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String opcion=request.getParameter("opcion");
		System.out.println("get opcion --->" +opcion);
		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion = request.getParameter("opcion");
		System.out.println("Valor del boton :" + opcion);
		
		switch (opcion) {
		case "log":  
					validarUsuario(request,response); 
					break;
		case "ini":  
					irAInicio(request,response); 
					break;
					
		case "cer":  
					cerrarSesion(request,response); 
					break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + opcion);
		}
		
		
	}

	private void cerrarSesion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 HttpSession session = request.getSession(false); // Obtenemos la sesión actual sin crear una nueva si no existe

		    if (session != null) {
		        session.invalidate(); // Invalida la sesión actual si existe
		    }

		    request.getRequestDispatcher("logeo/logIn.jsp").forward(request, response);
	}

	private void irAInicio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("logeo/menuPrincipal.jsp").forward(request, response);
		
	}

	private void validarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		//Variables
		 String mensaje="", url="";
		
		
		//Entrada de datos
		String usuario = request.getParameter("txtUsuario");
		String contrasena = request.getParameter("txtContrasena");

		
		//Proceso
		DAOFactory fabrica=  DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		PacienteDTO objPaci = fabrica.getPacienteDAO().validarUsuario(usuario, contrasena);
		
		if (objPaci!=null) {
			
			HttpSession miSession = request.getSession();
			System.out.println("ID Session: "+ miSession.getId());
			System.out.println("Fecha-----: "+ new SimpleDateFormat().format(miSession.getCreationTime()));
			System.out.println("Duración--: "+ miSession.getMaxInactiveInterval());
			
			request.getSession().setAttribute("dataPaciente", objPaci);
			url="logeo/menuPrincipal.jsp";
			
		}else {
			mensaje+="Usuario o clave incorrecto";
			url="logeo/logIn.jsp";
			request.setAttribute("mensaje",mensaje);
			
		}
		
		//Salida a la página principal  
		request.getRequestDispatcher(url).forward(request, response);
		
	

		
	}

}
