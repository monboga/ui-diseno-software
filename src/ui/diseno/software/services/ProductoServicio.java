/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.diseno.software.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ui.diseno.software.connection.DatabaseConnection;
import ui.diseno.software.models.Categoria;
import ui.diseno.software.models.Marca;
import ui.diseno.software.models.Producto;

/**
 *
 * @author Gabriel
 */
public class ProductoServicio {

    public List<Producto> getAll() throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DatabaseConnection.getInstance().createConnection();
            ps = con.prepareStatement("SELECT p.producto_id,m.marca_id,c.categoria_id,p.nombre_producto,p.descripcion_producto,p.modelo,p.precio_unitario,p.costo_unitario,p.stock,m.nombre_marca,c.nombre_categoria,p.fecha_creacion_producto FROM productos p JOIN marcas m ON p.marca_id = m.marca_id JOIN categorias c ON p.categoria_id = c.categoria_id");
            rs = ps.executeQuery();

            List<Producto> list = new ArrayList<>();
            while (rs.next()) {
                int productoId = rs.getInt("producto_id");
                String nombreProducto = rs.getString("nombre_producto");
                String descripcion = rs.getString("descripcion_producto");
                String modelo = rs.getString("modelo");
                double precioProducto = rs.getDouble("precio_unitario");
                double costoProducto = rs.getDouble("costo_unitario");
                int stock = rs.getInt("stock");
                int marcaId = rs.getInt("marca_id");
                String marcaNombre = rs.getString("nombre_marca");
                int categoriaId = rs.getInt("categoria_id");
                String categoriaNombre = rs.getString("nombre_categoria");
                Date fechaCreacionProducto = rs.getDate("fecha_creacion_producto");
                list.add(new Producto(productoId, nombreProducto, descripcion, modelo, precioProducto, costoProducto, stock, new Marca(marcaId, marcaNombre), new Categoria(categoriaId, categoriaNombre), fechaCreacionProducto));
            }

            return list;
        } finally {
            DatabaseConnection.getInstance().close(rs, ps, con);
        }
    }

//    public List<Producto> search(String search) throws SQLException {
//        Connection con = null;
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        try {
//            con = DatabaseConnection.getInstance().createConnection();
//            ps = con.prepareStatement("SELECT * FROM employee JOIN positions USING (position_id) WHERE (position_name LIKE ? OR employee_name LIKE ? OR description LIKE ? OR location LIKE ?) ORDER BY position_name, employee_name ");
//
//            ps.setString(1, "%" + search + "%");
//            ps.setString(2, "%" + search + "%");
//            ps.setString(3, "%" + search + "%");
//            ps.setString(4, "%" + search + "%");
//
//            rs = ps.executeQuery();
//
//            List<ModelEmployee> list = new ArrayList<>();
//            while (rs.next()) {
//                int employeeId = rs.getInt("employee_id");
//                String name = rs.getString("employee_name");
//                String location = rs.getString("location");
//                Date date = rs.getDate("date");
//                double salary = rs.getDouble("salary");
//                String description = rs.getString("description");
//                int positionId = rs.getInt("position_id");
//                String positionName = rs.getString("position_name");
//                list.add(new ModelEmployee(employeeId, name, location, date, salary, description, new ModelPositions(positionId, positionName)));
//            }
//
//            return list;
//        } finally {
//            DatabaseConnection.getInstance().close(rs, ps, con);
//        }
//    }
    public void create(Producto data) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DatabaseConnection.getInstance().createConnection();
            ps = con.prepareStatement("INSERT INTO productos (nombre_producto, descripcion_producto, modelo, precio_unitario, costo_unitario, stock, marca_id, categoria_id) VALUES (?,?,?,?,?,?,?,?)");
            ps.setString(1, data.getNombreProducto());
            ps.setString(2, data.getDescripcionProducto());
            ps.setString(3, data.getModeloProducto());
            ps.setDouble(4, data.getPrecioProducto());
            ps.setDouble(5, data.getCostoProducto());
            ps.setInt(6, data.getStock());
            ps.setInt(7, data.getMarcas().getMarcaId());
            ps.setInt(8, data.getCategorias().getCategoriaId());

            ps.execute();

        } finally {
            DatabaseConnection.getInstance().close(ps, con);
        }
    }

    public void edit(Producto data) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DatabaseConnection.getInstance().createConnection();
            ps = con.prepareStatement("UPDATE productos SET nombre_producto=?, descripcion_producto=?, modelo=?, precio_unitario=?, costo_unitario=?, stock=?, marca_id=?, categoria_id=? WHERE producto_id=? LIMIT 1");
            ps.setString(1, data.getNombreProducto());
            ps.setString(2, data.getDescripcionProducto());
            ps.setString(3, data.getModeloProducto());
            ps.setDouble(4, data.getPrecioProducto());
            ps.setDouble(5, data.getCostoProducto());
            ps.setInt(6, data.getStock());
            ps.setInt(7, data.getMarcas().getMarcaId());
            ps.setInt(8, data.getCategorias().getCategoriaId());
            ps.setInt(9, data.getProductoId());
            ps.execute();

        } finally {
            DatabaseConnection.getInstance().close(ps, con);
        }
    }

    public void delete(int id) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DatabaseConnection.getInstance().createConnection();
            ps = con.prepareStatement("DELETE FROM productos WHERE producto_id=? LIMIT 1");

            ps.setInt(1, id);

            ps.execute();

        } finally {
            DatabaseConnection.getInstance().close(ps, con);
        }
    }

    public MarcaServicio getServiceBrand() {
        if (serviceBrands == null) {
            serviceBrands = new MarcaServicio();
        }

        return serviceBrands;
    }

    public CategoriaServicio getServiceCategory() {
        if (serviceCategory == null) {
            serviceCategory = new CategoriaServicio();
        }

        return serviceCategory;
    }

    private CategoriaServicio serviceCategory;
    private MarcaServicio serviceBrands;

}
