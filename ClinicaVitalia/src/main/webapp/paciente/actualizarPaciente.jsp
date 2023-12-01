<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Actualizar Paciente</title>
 	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
<%@ include file="../comun/menu.jsp" %>
	
	<div class="container mt-5">
	<div class="container">
		    <br>
		    <h1 class="h1 mb-3 font-weight-normal text-center">Actualizar Paciente</h1>
	</div> 
	    <div class="row">
	        <div class="col-md-10 offset-md-3">   
				<form id="frmRegistrarPaciente" action="pacienteServlet" method="post" >
					<div class="row">
				            <div class="col-md-6">
				            
				            	<div class="form-group">
				                    <label for="txtCodigo">Código</label>
				                    <input type="text" class="form-control" id="txtCodigo" name="txtCodigo" readonly="readonly" value="${paciente.codigo}">
				                </div>
								
					            <div class="form-group">
					                <label for="txtNombres" class="form-label">Nombre:</label>
					                <input type="text" class="form-control" id="txtNombres" name="txtNombres" value="${paciente.nombre}">
					            </div>
					            <div class="form-group">
					                <label for="txtApePat" class="form-label">Apellido Paterno:</label>
					                <input type="text" class="form-control" id="txtApePat" name="txtApePat" value="${paciente.apePaterno}">
					            </div>
					            <div class="form-group">
					                <label for="txtApeMat" class="form-label">Apellido Materno:</label>
					                <input type="text" class="form-control" id="txtApeMat" name="txtApeMat" value="${paciente.apeMaterno}">
					            </div>
					            <div class="form-group">
					                <label for="txtFechaNac" class="form-label">Fecha de Nacimiento:</label>
					                <input type="date" class="form-control" id="txtFechaNac" name="txtFechaNac" value="${paciente.fechaNac}">
					            </div>
					            <div class="form-group">
								    <label for="cboSexo" class="form-label">Sexo:</label>
								    <select class="form-control" id="cboSexo" name="cboSexo">
								        <option value="1" ${paciente.sexo == 1 ? 'selected' : ''}>Masculino</option>
								        <option value="2" ${paciente.sexo == 2 ? 'selected' : ''}>Femenino</option>
								    </select>
								</div>

					            <div class="form-group">
					                <label for="txtEmail" class="form-label">Email:</label>
					                <input type="email" class="form-control" id="txtEmail" name="txtEmail" value="${paciente.email}">
					            </div>
					            <div class="form-group">
					                <label for="txtNumCel" class="form-label">Número de Celular:</label>
					                <input type="text" class="form-control" id="txtNumCel" name="txtNumCel" value="${paciente.numCel}">
					            </div>
					            <div class="form-group">
					                <label for="txtUserName" class="form-label">Nombre de Usuario:</label>
					                <input type="text" class="form-control" id="txtUserName" name="txtUserName"  value="${paciente.username}">
					            </div>
					            <div class="form-group">
					                <label for="txtContrasena" class="form-label">Contraseña:</label>
					                <input type="password" class="form-control" id="txtContrasena" name="txtContrasena"  value="${paciente.contrasena}">
					            </div>
					            <div class="form-group">
					    	        <button type="submit" name="opcion" value="act" class="btn btn-primary mt-3">Actualizar</button>          		        
									<a class="btn btn-secondary mt-3" href="${pageContext.request.contextPath}/pacienteServlet?opcion=lis"> Regresar a Listar </a>
					            </div>
					            
					            <%
					            	String mensaje = (String)request.getAttribute("mensaje");
					            	if (mensaje==null) mensaje="";
					            %>
					            
					            <%=mensaje%>
					            
				            </div>
				        </div>		
				</form>
	        </div>
	    </div>
	</div>
	
	
	
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"></script>
    <script type="text/javascript">
    $(document).ready(function() {
        $.validator.addMethod("numericOnly", function(value, element) {
            return this.optional(element) || /^[0-9]+$/.test(value);
        }, "Ingrese solo números.");

        $("#frmRegistrarPaciente").validate({
            rules: {
                txtNombres: "required",
                txtApePat: "required",
                txtApeMat: "required",
                txtEmail: {
                    required: true,
                    email: true
                },
                txtNumCel: {
                    required: true,
                    numericOnly: true
                },
                txtUserName: "required",
                txtContrasena: "required"
            },
            messages: {
                txtNombres: "Ingrese el nombre del paciente",
                txtApePat: "Ingrese el apellido paterno",
                txtApeMat: "Ingrese el apellido materno",
                txtEmail: {
                    required: "Ingrese el correo electrónico",
                    email: "Ingrese un correo electrónico válido"
                },
                txtNumCel: {
                    required: "Ingrese el número de celular",
                    numericOnly: "Ingrese solo números para el número de celular"
                },
                txtUserName: "Ingrese el nombre de usuario",
                txtContrasena: "Ingrese la contraseña"
            },
            errorElement: "span",
            errorPlacement: function(error, element) {
                error.addClass("invalid-feedback");
                element.closest(".form-group").append(error);
            },
            highlight: function(element, errorClass, validClass) {
                $(element).addClass("is-invalid").removeClass("is-valid");
            },
            unhighlight: function(element, errorClass, validClass) {
                $(element).removeClass("is-invalid").addClass("is-valid");
            },
            submitHandler: function(form) {
                form.submit();
            }
        });
    });
</script>

</body>
</html>
 		
 		
 		