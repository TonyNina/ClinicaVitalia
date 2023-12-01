<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Iniciar Sesión</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <style>
        body {
            background: url('images/fondoMedico.png') no-repeat center center fixed;
            -webkit-background-size: cover;
            -moz-background-size: cover;
            -o-background-size: cover;
            background-size: cover;
            color: grey;
        }
        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            width: 3000px;
            height: 90vh;
        }
        .logo img {
            max-width: 180px;
           
        }
        .titulo {
            font-size: 1.5rem; 
            text-align: center;
            margin-top: 30px;
            margin-bottom: 30px;
        }
        /* Ajustar el ancho de los campos del formulario */
        #txtUsuario,
        #txtContrasena {
            width: 100%; /* Ocupar todo el ancho disponible */
        }
    </style>
</head>
<body>
   <div class="container">
        <div class="row justify-content-center align-items-center">
            <div class="col-md-16 text-center">
                <div class="logo">
                    <img src="images/logoVitaliaLg.png">
                </div>
                <div class="titulo">
                    Iniciar Sesión
                </div>
                <div class="row">
                    <div class="col-12">
                        <form id="loginForm" action="loginServlet" method="post">
                            <div class="mb-3">
                                <label for="txtUsuario" class="form-label">Usuario:</label>
                                <input type="text" class="form-control" id="txtUsuario" name="txtUsuario">
                                <div id="usuarioError" class="text-primary" style="font-weight: bold;"></div>
                            </div>
                            <div class="mb-3">
                                <label for="txtContrasena" class="form-label">Contraseña:</label>
                                <input type="password" class="form-control" id="txtContrasena" name="txtContrasena">
                                <div id="contrasenaError" class="text-primary" style="font-weight: bold;"></div>
                            </div>
                            <button type="submit" name="opcion" value="log"  class="btn btn-primary">Iniciar Sesión</button>
                            <br>
                            <div>
                                ¿No tienes una cuenta? <a href="${pageContext.request.contextPath}/pacienteServlet?opcion=nue"> Registrate </a>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="${mensaje != null ? 'alert alert-danger text-center mt-3' : ''}">
                    ${mensaje}
                </div>
            </div>
        </div>
    </div>
    
</body>
</html>
