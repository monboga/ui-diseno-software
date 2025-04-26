/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.diseno.software.models;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.sql.Date;

/**
 *
 * @author Gabriel
 */
public class Producto {

    int productoId;
    String nombreProducto;
    String descripcionProducto;
    String modeloProducto;
    double precioProducto;
    double costoProducto;
    int stock;
    Marca marcas;
    Categoria categorias;
    Date fechaCreacionProducto;

    public Producto() {
    }

    public Producto(int productoId, String nombreProducto, String descripcionProducto, String modeloProducto, double precioProducto, double costoProducto, int stock, Marca marcas, Categoria categorias) {
        this.productoId = productoId;
        this.nombreProducto = nombreProducto;
        this.descripcionProducto = descripcionProducto;
        this.modeloProducto = modeloProducto;
        this.precioProducto = precioProducto;
        this.costoProducto = costoProducto;
        this.stock = stock;
        this.marcas = marcas;
        this.categorias = categorias;
    }

    
    
    public Producto(int productoId, String nombreProducto, String descripcionProducto, String modeloProducto, double precioProducto, double costoProducto, int stock, Marca marcas, Categoria categorias, Date fechaCreacionProducto) {
        this.productoId = productoId;
        this.nombreProducto = nombreProducto;
        this.descripcionProducto = descripcionProducto;
        this.modeloProducto = modeloProducto;
        this.precioProducto = precioProducto;
        this.costoProducto = costoProducto;
        this.stock = stock;
        this.marcas = marcas;
        this.categorias = categorias;
        this.fechaCreacionProducto = fechaCreacionProducto;
    }

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public String getModeloProducto() {
        return modeloProducto;
    }

    public void setModeloProducto(String modeloProducto) {
        this.modeloProducto = modeloProducto;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public double getCostoProducto() {
        return costoProducto;
    }

    public void setCostoProducto(double costoProducto) {
        this.costoProducto = costoProducto;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Marca getMarcas() {
        return marcas;
    }

    public void setMarcas(Marca marcas) {
        this.marcas = marcas;
    }

    public Categoria getCategorias() {
        return categorias;
    }

    public void setCategorias(Categoria categorias) {
        this.categorias = categorias;
    }

    public Date getFechaCreacionProducto() {
        return fechaCreacionProducto;
    }

    public void setFechaCreacionProducto(Date fechaCreacionProducto) {
        this.fechaCreacionProducto = fechaCreacionProducto;
    }



    public Object[] toTableRow(int rowNum) {
        DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        NumberFormat nf = new DecimalFormat("$ #,##0.##");
        return new Object[]{false, rowNum, this, descripcionProducto, modeloProducto, nf.format(precioProducto), nf.format(costoProducto),stock, marcas,categorias,fechaCreacionProducto == null ? "" : df.format(fechaCreacionProducto)};
    }

    @Override
    public String toString() {
        return nombreProducto;
    }

}
