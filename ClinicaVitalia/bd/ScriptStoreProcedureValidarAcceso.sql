delimiter //

create procedure usp_validarAcceso(IN usuario VARCHAR(50), IN contrasena VARCHAR(50))
begin
	select id, nombre, apePaterno, apeMaterno, fechaNac, sexo, email, numCel, userName, contrasena 
    FROM tb_paciente WHERE userName = usuario AND contrasena = contrasena;
end
//
call usp_validarAcceso('carlitos', 'c123');
