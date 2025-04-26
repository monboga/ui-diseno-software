/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.diseno.software.models;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author Gabriel
 */
public class Marca {

    int marcaId;
    String nombreMarca;
    Date fechaCreacionMarca;

    public Marca() {
    }

    public Marca(int marcaId, String nombreMarca) {
        this.marcaId = marcaId;
        this.nombreMarca = nombreMarca;
    }

    public Marca(int marcaId, String nombreMarca, Date fechaCreacionMarca) {
        this.marcaId = marcaId;
        this.nombreMarca = nombreMarca;
        this.fechaCreacionMarca = fechaCreacionMarca;
    }

    public int getMarcaId() {
        return marcaId;
    }

    public void setMarcaId(int marcaId) {
        this.marcaId = marcaId;
    }

    public String getNombreMarca() {
        return nombreMarca;
    }

    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }

    public Date getFechaCreacionMarca() {
        return fechaCreacionMarca;
    }

    public void setFechaCreacionMarca(Date fechaCreacionMarca) {
        this.fechaCreacionMarca = fechaCreacionMarca;
    }

    public Object[] toTableRow(int rowNum) {
        DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        return new Object[]{false, rowNum, this, fechaCreacionMarca == null ? "" : df.format(fechaCreacionMarca)};
    }

    @Override
    public String toString() {
        return nombreMarca;
    }

}
