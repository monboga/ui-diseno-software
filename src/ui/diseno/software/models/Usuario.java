/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.diseno.software.models;

import java.sql.Date;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author Gabriel
 */
public class Usuario {
    
    int usuarioId;
    String nombre;
    String apellido;
    String nombreUsuario;
    String contrasena;
    Rol usuarioRol;
    Date fechaCreacionUsuario;

    public Usuario() {
    }
    
    
    public Usuario(int usuarioId, String nombre, String apellido, String contrasena, Rol usuarioRol) {
        this.usuarioId = usuarioId;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrasena = contrasena;
        this.usuarioRol = usuarioRol;
    }

    public Usuario(int usuarioId, String nombre, String apellido, String nombreUsuario, String contrasena, Rol usuarioRol, Date fechaCreacionUsuario) {
        this.usuarioId = usuarioId;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.usuarioRol = usuarioRol;
        this.fechaCreacionUsuario = fechaCreacionUsuario;
    }
    
    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Rol getUsuarioRol() {
        return usuarioRol;
    }

    public void setUsuarioRol(Rol usuarioRol) {
        this.usuarioRol = usuarioRol;
    }

    public Date getFechaCreacionUsuario() {
        return fechaCreacionUsuario;
    }

    public void setFechaCreacionUsuario(Date fechaCreacionUsuario) {
        this.fechaCreacionUsuario = fechaCreacionUsuario;
    }
    
    public Object[] toTableRow(int rowNum) {
        DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        return new Object[]{false,rowNum,this,apellido,nombreUsuario,contrasena,usuarioRol,fechaCreacionUsuario==null?"":df.format(fechaCreacionUsuario)};
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    
}
