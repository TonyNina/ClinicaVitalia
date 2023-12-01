<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Agendar Cita</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <style>
        .container {
            margin-top: 50px;
        }
        .form-group {
            margin-bottom: 20px;
        }
        .btn-primary {
            margin-top: 20px;
        }
    </style>
</head>
<body>
<%@ include file="../comun/menu.jsp" %>

<div class="container">
    <h1 class="mb-3 font-weight-normal text-center">Agendar Cita</h1>
    
    <form id="frmAgendarCita" action="citaServlet" method="post">
        <div class="row">
            <div class="col-md-6 offset-md-3">
                <div class="form-group">
                    <label for="txtFecha">Fecha:</label>
                    <input type="date" id="txtFecha" name="txtFecha" class="form-control" required>
                </div>
                <div class="form-group">
                    <label for="txtHora">Hora:</label>
                    <input type="time" id="txtHora" name="txtHora" class="form-control" required>
                </div>
                <div class="form-group">
                    <label for="txtMotivo" class="form-label">Motivo:</label>
                    <textarea id="txtMotivo" name="txtMotivo" class="form-control" rows="3" required></textarea>
                </div>
                <div class="form-group">
                    <label for="cboMedico" class="form-label">Médico:</label>
                    <select class="form-control" id="cboMedico" name="cboMedico" required>
                        <option value="">--Seleccionar médico--</option>
                        <option value="1">Juan de la Torre</option>
                        <option value="2">Fernando Herrera</option>
                        <option value="2">Alonso Bernardo</option>
                       
                    </select>
                </div>
                <div class="form-group">
                    <label for="cboEspecialidad" class="form-label">Especialidad:</label>
                    <select class="form-control" id="cboEspecialidad" name="cboEspecialidad" required>
                        <option value="">--Seleccionar especialidad--</option>
                        <option value="1">Cardiología</option>
                        <option value="2">Dermatología</option>
                        <option value="3">Endocrinología</option>
                        <option value="4">Geriatria</option>
                        <option value="5">Mamografía</option>
                        
                    </select>
                </div>
                <div class="form-group">
                    <label for="cboConsulta" class="form-label">Tipo de Consulta:</label>
                    <select class="form-control" id="cboConsulta" name="cboConsulta" required>
                    	<option value="">--Seleccionar sede--</option>
                    	<option value="1">Presencial</option>
                    	<option value="2">Virtual</option>
                    	
                    </select>
                </div>
                <div class="form-group">
                    <label for="cboSede" class="form-label">Sede:</label>
                    <select class="form-control" id="cboSede" name="cboSede" required>
                        <option value="">--Seleccionar sede--</option>
                        <option value="1">Arequipa</option>
                        <option value="2">Tacna</option>
                        <option value="3">Lima</option>
                        
                    </select>
                </div>
                <div class="form-group">
                    <button type="submit" name="opcion" value="reg" class="btn btn-primary mt-3">Agendar Cita</button>
                    <a class="btn btn-secondary mt-3" href="${pageContext.request.contextPath}/citaServlet?opcion=lis">Cancelar</a>
                </div>
                <% 
                    String mensaje = (String)request.getAttribute("mensaje");
                    if (mensaje == null) mensaje = "";
                %>
                <%=mensaje%> 
            </div>
        </div>
    </form>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"></script>
<script type="text/javascript">
    $(document).ready(function() {
        // Validación del formulario
        $.validator.addMethod("numericOnly", function(value, element) {
            return this.optional(element) || /^[0-9]+$/.test(value);
        }, "Ingrese solo números.");

        $("#frmAgendarCita").validate({
            rules: {
                txtFecha: "required",
                txtHora: "required",
                cboMedico: "required",
                cboEspecialidad: "required", 
                txtMotivo: "required",
                txtTipoConsulta: "required", 
                cboSede: "required" 
            },
            messages: {
                txtFecha: "Ingrese la fecha",
                txtHora: "Ingrese la hora",
                cboMedico: "Seleccione un médico",
                cboEspecialidad: "Seleccione una especialidad", 
                txtMotivo: "Ingrese el motivo",
                txtTipoConsulta: "Ingrese el tipo de consulta", 
                cboSede: "Seleccione una sede"
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
