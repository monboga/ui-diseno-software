/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.diseno.software.models;

import java.sql.Date;
/**
 *
 * @author Gabriel
 */
public class Rol {
    
    int rolId;
    String nombreRol;
    Date fechaCreacionRol;

    public Rol() {
    }

    public Rol(int rolId, String nombreRol) {
        this.rolId = rolId;
        this.nombreRol = nombreRol;
    }
    
    

    public Rol(int rolId, String nombreRol, Date fechaCreacionRol) {
        this.rolId = rolId;
        this.nombreRol = nombreRol;
        this.fechaCreacionRol = fechaCreacionRol;
    }

    public int getRolId() {
        return rolId;
    }

    public void setRolId(int rolId) {
        this.rolId = rolId;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public Date getFechaCreacionRol() {
        return fechaCreacionRol;
    }

    public void setFechaCreacionRol(Date fechaCreacionRol) {
        this.fechaCreacionRol = fechaCreacionRol;
    }

    @Override
    public String toString() {
        return nombreRol;
    }
    
    
    
}
