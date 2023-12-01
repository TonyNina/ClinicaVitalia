<%@page import="java.util.Comparator"%>
<%@page import="model.CitaDTO"%> 
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Historial de citas</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
<%@ include file="../comun/menu.jsp" %>
<div class="container">
    <br>
    <h1 class="h1 mb-3 font-weight-normal">Historial de Citas</h1>
    <br>
</div> 

<div class="container">     
     <div>
     
            <a href="${pageContext.request.contextPath}/citaServlet?opcion=nue""> <img src="images/anadir.png" alt="Agendar Cita"> </a>
     </div> 
     
    <table class="table table-hover">
     <thead>
        <tr>
            <th>Id</th>
            <th>Fecha</th>
            <th>Hora</th>
            <th>Motivo</th>
            <th>Id Medico</th>
            <th>Id Especialidad</th>
            <th>Tipo Consulta</th>
            <th>Sede</th>
            <th></th>
            <th></th>
        </tr>
     </thead>
    <tbody>
	    <%
	        List<CitaDTO> lstCitas = (List<CitaDTO>) request.getAttribute("lstCitas");
	                if (lstCitas!=null){
	                
	                    for( CitaDTO cit : lstCitas ) {
	    %>
	  
    <tr>
            <td><%=cit.getCodigo()%></td>
            <td><%=cit.getFecha()%></td>
            <td><%=cit.getHora()%></td>
            <td><%=cit.getMotivo()%></td>
            <td><%=cit.getIdMedico().getNombres()%></td>
            <td><%=cit.getIdEspecialidad().getDesTipoEspecialidad()%></td>
            <td><%=cit.getTipoConsulta().getDesTipoConsulta()%></td>
            <td><%=cit.getSede().getDesSede()%></td>

            <td> <a href="${pageContext.request.contextPath}/citaServlet?opcion=bus&cod=<%=cit.getCodigo()%>"> <img src="images/actualizar.png" alt="Actualizar Cita"> </a></td>
            <td><a href="${pageContext.request.contextPath}/citaServlet?opcion=eli&cod=<%=cit.getCodigo()%>"><img src="images/eliminar.png" alt="Eliminar Cita"> </a></td>

    </tr>
    
	    <%
	                }
	            }           
	        %>

    </tbody>
    </table>
</div>

		<%
		    String mensaje = (String)request.getAttribute("mensaje");
		    if (mensaje==null) mensaje="";
		%>  
		<%=mensaje%>   
</body>
</html>
