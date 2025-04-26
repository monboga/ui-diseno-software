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
public class Categoria {

    int categoriaId;
    String nombreCategoria;
    Date fechaCreacionCategoria;

    // pendiente agregar el valor de activo / inactivo como boolean
    public Categoria() {
    }

    public Categoria(int categoriaId, String nombreCategoria) {
        this.categoriaId = categoriaId;
        this.nombreCategoria = nombreCategoria;
    }

    public Categoria(int categoriaId, String nombreCategoria, Date fechaCreacionCategoria) {
        this.categoriaId = categoriaId;
        this.nombreCategoria = nombreCategoria;
        this.fechaCreacionCategoria = fechaCreacionCategoria;
    }

    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public Date getFechaCreacionCategoria() {
        return fechaCreacionCategoria;
    }

    public void setFechaCreacionCategoria(Date fechaCreacionCategoria) {
        this.fechaCreacionCategoria = fechaCreacionCategoria;
    }

    public Object[] toTableRow(int rowNum) {
        DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        return new Object[]{false, rowNum, this, fechaCreacionCategoria == null ? "" : df.format(fechaCreacionCategoria)};
    }

    @Override
    public String toString() {
        return nombreCategoria;
    }

}
