<%@page import="model.PacienteDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado de Pacientes</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">

</head>
<body>
<%@ include file="../comun/menu.jsp" %>
<div class="container">
		    <br>
		    <h1 class="h1 mb-3 font-weight-normal">Listado de Pacientes</h1>
		    <br>
	</div> 
	<div class="container">	 	
		
		 <div>
		        <a href="${pageContext.request.contextPath}/pacienteServlet?opcion=nue"> Nuevo Paciente </a>
		 </div> 
		 
		<table class="table table-hover">
		 <thead>
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Apellido Paterno</th>
				<th>Apellido Materno</th>
				<th>Fecha Nacimiento</th>
				<th>Sexo</th>
				<th>Email</th>
				<th>Celular</th>
				<th>Usuario</th>
				<th>Contraseña</th>
				<th></th>
				<th></th>
			</tr>
		 </thead>
	      <tbody>
	    <%
	      List<PacienteDTO> lstPacientes = (List<PacienteDTO>) request.getAttribute("lstPacientes");
	      	      		if (lstPacientes!=null){
	      	      			for( PacienteDTO paci : lstPacientes ) {
	      %>
	      
	     	 <tr>
			     	<td><%=paci.getCodigo()%></td>
			      	<td><%=paci.getNombre() %></td>
			      	<td><%=paci.getApePaterno() %></td>
			      	<td><%=paci.getApeMaterno()%></td>
			      	<td><%=paci.getFechaNac() %></td>
			      	<td><%=paci.getSexo() %></td>
			      	<td><%=paci.getEmail() %></td>
			      	<td><%=paci.getNumCel() %></td>
			      	<td><%=paci.getUsername()%></td>
			      	<td><%=paci.getContrasena()%></td>
			      	<td></td>
			      	<td><a href="${pageContext.request.contextPath}/pacienteServlet?opcion=bus&cod=<%=paci.getCodigo()%>"> Actualizar </a></td>
			      	<td><a href="${pageContext.request.contextPath}/pacienteServlet?opcion=eli&cod=<%=paci.getCodigo()%>"> Eliminar </a></td>
			</tr>
		
			<%
	      			}
	      		}			
 			%>
			</tbody>
		</table>
	</div>
	 <%    String mensaje = (String)request.getAttribute("mensaje");
			if (mensaje==null) mensaje="";	
	  %>  
	  		<%=mensaje%>  

</body>
</html>