package model;

import java.util.Date;

public class PacienteDTO {
    
    private int codigo;
    private String nombre;
    private String apePaterno;
    private String apeMaterno;
    private Date fechaNac; // Cambio aquí
    private int sexo;
    private String email;
    private int numCel;
    private String username;
    private String contrasena;
    
    public PacienteDTO(int codigo, String nombre, String apePaterno, String apeMaterno, Date fechaNac, int sexo,
            String email, int numCel, String username, String contrasena) {
        
        this.codigo = codigo;
        this.nombre = nombre;
        this.apePaterno = apePaterno;
        this.apeMaterno = apeMaterno;
        this.fechaNac = fechaNac;
        this.sexo = sexo;
        this.email = email;
        this.numCel = numCel;
        this.username = username;
        this.contrasena = contrasena;
    }
    
    public PacienteDTO(String nombre, String apePaterno, String apeMaterno, Date fechaNac, int sexo,
            String email, int numCel, String username, String contrasena) {
        
        this.nombre = nombre;
        this.apePaterno = apePaterno;
        this.apeMaterno = apeMaterno;
        this.fechaNac = fechaNac;
        this.sexo = sexo;
        this.email = email;
        this.numCel = numCel;
        this.username = username;
        this.contrasena = contrasena;
    }
    
    public PacienteDTO() {}
    
    // Getters y Setters

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApePaterno() {
        return apePaterno;
    }

    public void setApePaterno(String apePaterno) {
        this.apePaterno = apePaterno;
    }

    public String getApeMaterno() {
        return apeMaterno;
    }

    public void setApeMaterno(String apeMaterno) {
        this.apeMaterno = apeMaterno;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumCel() {
        return numCel;
    }

    public void setNumCel(int numCel) {
        this.numCel = numCel;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
