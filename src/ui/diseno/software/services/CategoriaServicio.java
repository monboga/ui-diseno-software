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
import ui.diseno.software.models.Rol;

/**
 *
 * @author Gabriel
 */
public class CategoriaServicio {

    public List<Categoria> getCategoryName() throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DatabaseConnection.getInstance().createConnection();
            ps = con.prepareStatement("SELECT categoria_id, nombre_categoria FROM categorias");
            rs = ps.executeQuery();

            List<Categoria> list = new ArrayList<>();
            while (rs.next()) {
                int categoriaId = rs.getInt("categoria_id");
                String nombreCategoria = rs.getString("nombre_categoria");
                list.add(new Categoria(categoriaId, nombreCategoria));
            }

            return list;
        } finally {
            DatabaseConnection.getInstance().close(rs, ps, con);
        }
    }

    public List<Categoria> getAll() throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DatabaseConnection.getInstance().createConnection();
            ps = con.prepareStatement("SELECT categoria_id, nombre_categoria, fecha_creacion_categoria FROM categorias");
            rs = ps.executeQuery();

            List<Categoria> list = new ArrayList<>();
            while (rs.next()) {
                int categoriaId = rs.getInt("categoria_id");
                String nombreCategoria = rs.getString("nombre_categoria");
                Date fechaCreacionCategoria = rs.getDate("fecha_creacion_categoria");
                list.add(new Categoria(categoriaId, nombreCategoria, fechaCreacionCategoria));
            }

            return list;
        } finally {
            DatabaseConnection.getInstance().close(rs, ps, con);
        }
    }

    public void create(Categoria data) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DatabaseConnection.getInstance().createConnection();
            ps = con.prepareStatement("INSERT INTO categorias (nombre_categoria) VALUES (?)");
            ps.setString(1, data.getNombreCategoria());
            ps.execute();

        } finally {
            DatabaseConnection.getInstance().close(ps, con);
        }
    }

    public void edit(Categoria data) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DatabaseConnection.getInstance().createConnection();
            ps = con.prepareStatement("UPDATE categorias SET nombre_categoria=? WHERE categoria_id=? LIMIT 1");
            ps.setString(1, data.getNombreCategoria());
            ps.setInt(2, data.getCategoriaId());
            ps.execute();

        } finally {
            DatabaseConnection.getInstance().close(ps, con, rs);
        }
    }

    public void delete(int id) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DatabaseConnection.getInstance().createConnection();
            ps = con.prepareStatement("DELETE FROM categorias WHERE categoria_id=? LIMIT 1");

            ps.setInt(1, id);

            ps.execute();

        } finally {
            DatabaseConnection.getInstance().close(ps, con);
        }
    }

}
