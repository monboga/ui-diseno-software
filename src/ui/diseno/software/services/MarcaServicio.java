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
import ui.diseno.software.models.Marca;
import ui.diseno.software.models.Rol;

/**
 *
 * @author Gabriel
 */
public class MarcaServicio {
    
    public List<Marca> getMarcaName() throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DatabaseConnection.getInstance().createConnection();
            ps = con.prepareStatement("SELECT marca_id, nombre_marca FROM marcas");
            rs = ps.executeQuery();

            List<Marca> list = new ArrayList<>();
            while (rs.next()) {
                int marcaId = rs.getInt("marca_id");
                String nombreMarca = rs.getString("nombre_marca");
                list.add(new Marca(marcaId, nombreMarca));
            }

            return list;
        } finally {
            DatabaseConnection.getInstance().close(rs, ps, con);
        }
    }

    public List<Marca> getAll() throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DatabaseConnection.getInstance().createConnection();
            ps = con.prepareStatement("SELECT marca_id, nombre_marca, fecha_creacion_marca FROM marcas");
            rs = ps.executeQuery();

            List<Marca> list = new ArrayList<>();
            while (rs.next()) {
                int marcaId = rs.getInt("marca_id");
                String nombreMarca = rs.getString("nombre_marca");
                Date fechaCreacionMarca = rs.getDate("fecha_creacion_marca");
                list.add(new Marca(marcaId, nombreMarca, fechaCreacionMarca));
            }

            return list;
        } finally {
            DatabaseConnection.getInstance().close(rs, ps, con);
        }
    }

    public void create(Marca data) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DatabaseConnection.getInstance().createConnection();
            ps = con.prepareStatement("INSERT INTO marcas (nombre_marca) VALUES (?)");
            ps.setString(1, data.getNombreMarca());
            ps.execute();

        } finally {
            DatabaseConnection.getInstance().close(ps, con);
        }
    }
    
    // revisar funcionamiento de edicion **

    public void edit(Marca data) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DatabaseConnection.getInstance().createConnection();
            ps = con.prepareStatement("UPDATE marcas SET nombre_marca=? WHERE roles_id=? LIMIT 1");
            ps.setString(1, data.getNombreMarca());
            ps.setInt(5, data.getMarcaId());
            ps.execute();

        } finally {
            DatabaseConnection.getInstance().close(ps, con,rs);
        }
    }

    public void delete(int id) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DatabaseConnection.getInstance().createConnection();
            ps = con.prepareStatement("DELETE FROM marcas WHERE marca_id=? LIMIT 1");

            ps.setInt(1, id);

            ps.execute();

        } finally {
            DatabaseConnection.getInstance().close(ps, con);
        }
    }
    
}
