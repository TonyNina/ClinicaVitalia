<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bienvenido al Sistema</title>
<!-- Agrega enlaces a los archivos CSS de Bootstrap -->
 	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
 	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.min.js"></script>
   <style>
    nav {
        padding-top: 5px;
        padding-bottom: 5px;
        margin-bottom: 0;
    }

    .navbar-brand img {
        max-height: 60px; /* Ajusta el valor según tus necesidades */
    }
</style>



</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg.light">
	<div>
		
		<a class="navbar-brand" href="loginServlet?opcion=ini" style="font-weight: bold;"><img src="images/logoVitaBanner.png"></a>
	</div>
	
	
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
             	<li class="nav-item active">
                    <a class="nav-link" href="loginServlet?opcion=ini">Inicio</a>
                </li>
                <li class="nav-item">
                	<a class="nav-link" href="${pageContext.request.contextPath}/citaServlet?opcion=lis"> Mis Citas </a>	    
                          
                </li>
                
                <li class="nav-item">
                	<a class="nav-link" href="${pageContext.request.contextPath}/citaServlet?opcion=nue"> Nueva Cita </a>	    
                           
                </li>
                
                <li class="nav-item">
                    <a class="nav-link" href="https://www.youtube.com/watch?v=PKY1eMoA6IY" target="_blank"> Whatsapp</a>
                </li>
                
                <li class="nav-item">
                    <a class="nav-link" href="loginServlet?opcion=cer">Cerrar Sesión</a>
                </li>
                
                
            </ul>
        </div>
         <!-- Nombre de usuario en la esquina derecha -->
            <span class="navbar-text ml-auto">
            	<img src="images/usuario.png" alt="Agendar Cita"><strong>   ${dataPaciente.nombre}   ${dataPaciente.apePaterno} </strong>
        	</span>

     </nav>

</body>
</html>