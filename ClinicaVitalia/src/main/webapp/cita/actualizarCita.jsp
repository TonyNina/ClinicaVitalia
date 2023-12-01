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
				    <label for="txtCodigo">Código</label>
				    <input type="text" class="form-control" id="txtCodigo" name="txtCodigo" readonly="readonly" value="${cita.codigo}">
				</div>
                <div class="form-group">
                    <label for="txtFecha">Fecha:</label>
                    <input type="date" id="txtFecha" name="txtFecha" class="form-control" required value="${cita.fecha}">
                </div>
                <div class="form-group">
                    <label for="txtHora">Hora:</label>
                    <input type="time" id="txtHora" name="txtHora" class="form-control" required value="${cita.hora}">
                </div>
                <div class="form-group">
                    <label for="txtMotivo" class="form-label">Motivo:</label>
                    <textarea id="txtMotivo" name="txtMotivo" class="form-control" rows="3" required value="${cita.motivo}"></textarea>
                </div>
                <div class="form-group">
                    <label for="cboMedico" class="form-label">Médico:</label>
                    <select class="form-control" id="cboMedico" name="cboMedico" required>
                        <option value="">--Seleccionar médico--</option>
                        <option value="1" ${cita.idMedico.codigo == 1 ? 'selected' : ''}>Juan de la Torre</option>
                        <option value="2" ${cita.idMedico.codigo == 2 ? 'selected' : ''}>Pedro Novoa</option>
                        <option value="3" ${cita.idMedico.codigo == 3 ? 'selected' : ''}>Alonso Bernardo </option>
                        <!-- Aquí cargarías los médicos desde la base de datos -->
                    </select>
                </div>
                <div class="form-group">
                    <label for="cboEspecialidad" class="form-label">Especialidad:</label>
                    <select class="form-control" id="cboEspecialidad" name="cboEspecialidad" required>
                        <option value="">--Seleccionar especialidad--</option>
                        <option value="1" ${cita.idEspecialidad.codigo == 1 ? 'selected' : ''}>Cardiología</option>
                        <option value="2" ${cita.idEspecialidad.codigo == 2 ? 'selected' : ''}>Dermatología</option>
                        <option value="3" ${cita.idEspecialidad.codigo == 3 ? 'selected' : ''}>Endocrinología</option>
                        <option value="4" ${cita.idEspecialidad.codigo == 4 ? 'selected' : ''}>Geriatria</option>
                        <option value="5" ${cita.idEspecialidad.codigo == 5 ? 'selected' : ''}>Mamografía</option>
                        <!-- Agrega las opciones desde la base de datos -->
                    </select>
                </div>
                <div class="form-group">
                    <label for="cboConsulta" class="form-label">Tipo de Consulta:</label>
                    <select class="form-control" id="cboConsulta" name="cboConsulta" required>
                    	<option value="">--Seleccionar consulta--</option>
                    	<option value="1" ${cita.tipoConsulta.codigo == 1 ? 'selected' : ''}>Presencial</option>
                    	<option value="2" ${cita.tipoConsulta.codigo == 2 ? 'selected' : ''}>Virtual</option>
                    	
                    </select>
                </div>
                <div class="form-group">
                    <label for="cboSede" class="form-label">Sede:</label>
                    <select class="form-control" id="cboSede" name="cboSede" required>
                        <option value="">--Seleccionar sede--</option>
                        <option value="1" ${cita.sede.codigo == 1 ? 'selected' : ''}>Arequipa</option>
                        <option value="2" ${cita.sede.codigo == 2 ? 'selected' : ''}>Tacna</option>
                        <option value="3" ${cita.sede.codigo == 3 ? 'selected' : ''}>Lima</option>
                        <!-- Agrega las opciones desde la base de datos -->
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
                cboEspecialidad: "required", // Validación para el nuevo campo
                txtMotivo: "required",
                txtTipoConsulta: "required", // Validación para el nuevo campo
                cboSede: "required" // Validación para el nuevo campo
            },
            messages: {
                txtFecha: "Ingrese la fecha",
                txtHora: "Ingrese la hora",
                cboMedico: "Seleccione un médico",
                cboEspecialidad: "Seleccione una especialidad", // Mensaje para el nuevo campo
                txtMotivo: "Ingrese el motivo",
                txtTipoConsulta: "Ingrese el tipo de consulta", // Mensaje para el nuevo campo
                cboSede: "Seleccione una sede" // Mensaje para el nuevo campo
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
