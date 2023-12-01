package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.CitaDTO;
import model.MedicoDTO;
import model.SedeDTO;
import model.TipoConsultaDTO;
import model.TipoEspecialidadDTO;

import java.io.IOException;
import java.util.List;

import dao.CitaDAO;
import dao.DAOFactory;

@WebServlet("/citaServlet")
public class CitaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CitaServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
        String opcion = request.getParameter("opcion");
        System.out.println("get opcion --->" + opcion);
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String opcion = request.getParameter("opcion");
        System.out.println("get opcion --->" + opcion);

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
        }
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mensaje = "";
        int codigo = Integer.parseInt(request.getParameter("cod"));

        DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        CitaDAO dao = fabrica.getCitaDAO();

        int ok = dao.eliminar(codigo);

        if (ok == 0) {
            mensaje += " <script> alert('" + " Error al eliminar los datos" + "') </script>";
        } else {
            mensaje += " <script> alert('" + "Eliminación de la cita  " + codigo + " OK" + "') </script>";
        }
        request.setAttribute("mensaje", mensaje);
        listar(request, response);
    }

    private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int codigo = Integer.parseInt(request.getParameter("cod"));
        DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        CitaDAO dao = fabrica.getCitaDAO();
        CitaDTO cita = dao.obtenerCita(codigo);
        request.setAttribute("cita", cita);
        request.getRequestDispatcher("cita/actualizarCita.jsp").forward(request, response);
    }

    private void nuevo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("cita/registrarCita.jsp").forward(request, response);
    }

    private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        CitaDAO dao = fabrica.getCitaDAO();
        List<CitaDTO> lista = dao.listar();
        request.setAttribute("lstCitas", lista);
        request.getRequestDispatcher("cita/listarCitas.jsp").forward(request, response);
    }

    private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String mensaje = "";

        int codigo = Integer.parseInt(request.getParameter("txtCodigo"));
        String fecha = request.getParameter("txtFecha");
        String hora = request.getParameter("txtHora");
        String motivo = request.getParameter("txtMotivo");
        int idMedico = Integer.parseInt(request.getParameter("cboMedico"));
        int idEspecialidad = Integer.parseInt(request.getParameter("cboEspecialidad"));
        int tipoConsulta = Integer.parseInt(request.getParameter("cboConsulta"));
        int sede = Integer.parseInt(request.getParameter("cboSede"));
        
        MedicoDTO objMedico = new MedicoDTO();
        objMedico.setCodigo(idMedico);
        TipoEspecialidadDTO objTipoEsp = new TipoEspecialidadDTO();
        objTipoEsp.setCodigo(idEspecialidad);
        TipoConsultaDTO objTipoCon = new TipoConsultaDTO();
        objTipoCon.setCodigo(tipoConsulta);
        SedeDTO objSede = new SedeDTO();
        objSede.setCodigo(sede);
        

        CitaDTO objCita = new CitaDTO(codigo, objMedico, objTipoEsp, fecha, hora, motivo, objTipoCon, objSede);
        DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        CitaDAO dao = fabrica.getCitaDAO();
        int ok = dao.actualizar(objCita);

        if (ok == 0) {
            mensaje += " <script> alert('" + " Error al registrar los datos" + "') </script>";
        } else {
            mensaje += " <script> alert('" + " Actualización exitosa" + "') </script>";
        }
        request.setAttribute("mensaje", mensaje);
        listar(request, response);
    }

    private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String mensaje = "";

        String fecha = request.getParameter("txtFecha");
        String hora = request.getParameter("txtHora");
        String motivo = request.getParameter("txtMotivo");
        int idMedico = Integer.parseInt(request.getParameter("cboMedico"));
        int idEspecialidad = Integer.parseInt(request.getParameter("cboEspecialidad"));
        int tipoConsulta = Integer.parseInt(request.getParameter("cboConsulta"));
        int sede = Integer.parseInt(request.getParameter("cboSede"));
        
        MedicoDTO objMedico = new MedicoDTO();
        objMedico.setCodigo(idMedico);
        TipoEspecialidadDTO objTipoEsp = new TipoEspecialidadDTO();
        objTipoEsp.setCodigo(idEspecialidad);
        TipoConsultaDTO objTipoCon = new TipoConsultaDTO();
        objTipoCon.setCodigo(tipoConsulta);
        SedeDTO objSede = new SedeDTO();
        objSede.setCodigo(sede);
        

        CitaDTO objCita = new CitaDTO(objMedico, objTipoEsp, fecha, hora, motivo, objTipoCon, objSede);
        DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        CitaDAO dao = fabrica.getCitaDAO();
        int ok = dao.registrar(objCita);

        if (ok == 0) {
            mensaje += " <script> alert('" + " Error al registrar los datos" + "') </script>";
        } else {
            mensaje += " <script> alert('" + " Registro exitoso" + "') </script>";
        }
        request.setAttribute("mensaje", mensaje);
        request.getRequestDispatcher("logeo/menuPrincipal.jsp").forward(request, response);
    }
}
