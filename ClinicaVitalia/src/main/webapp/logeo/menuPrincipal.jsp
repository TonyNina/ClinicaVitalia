<%@page import="java.util.Comparator"%>
<%@page import="model.CitaDTO"%> 
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Bienvenido al Sistema</title>
    <!-- Agrega tus estilos CSS aquí -->
    <style>
        .content {
            text-align: center;
        }
        .banner {
        
            border: 2px solid #e6f6f9;
            background-color: #e6f6f9;
            border-radius: 20px;
            padding: 20px;
            margin: 4px auto 20px auto; /* Margen inferior y centralización */
            width: 75%; /* Ancho del cuadro al 75% de la pantalla */
        }
        .banner h2 {
            color: #009ab2;
            text-align: left;
        }
        .banner h3 {
            color: #009ab2;
            text-align: left;
        }
        .image-container {
            margin-bottom: 20px;
        }
        .image-container img {
            max-width: 200px; /* Tamaño máximo para la imagen */
            height: auto;
            margin: 0 auto; /* Centrar la imagen */
            display: block;
        }
        .btn-space {
		    padding: 20px;
		}
      

    </style>
</head>
<body>
<%@ include file="../comun/menu.jsp" %>
<div class="content">
    <div class="banner">
        <!-- Nombre de usuario en la esquina derecha -->
        <h2><strong>¡Hola ${dataPaciente.nombre}!</strong></h2> 
        <h3>Estamos aquí para cuidarte.</h3>
    </div>

    <div class="image-container">
        <img src="${pageContext.request.contextPath}/images/agendarCita.png" alt="Agendar Cita">
            <h2><strong>Todavía no tienes citas.</strong></h2>
            <h3>¿Te gustaría agendar una?</h3>
        <div class="form-group">
            <a class="btn btn-primary mt-3 rounded-pill" href="${pageContext.request.contextPath}/citaServlet?opcion=nue"> Agendar una cita </a>	    	
        </div>
       
    </div>
</div>

</body>
</html>
