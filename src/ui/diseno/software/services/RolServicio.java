/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.diseno.software.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import ui.diseno.software.connection.DatabaseConnection;
import ui.diseno.software.models.Rol;

/**
 *
 * @author Gabriel
 */
public class RolServicio {
    
    public List<Rol> getAll() throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DatabaseConnection.getInstance().createConnection();
            ps = con.prepareStatement("SELECT roles_id, nombre FROM roles");
            rs = ps.executeQuery();
            
            List<Rol> list = new ArrayList<>();
            while(rs.next()) {
                int rolId = rs.getInt("roles_id");
                String nombreRol = rs.getString("nombre");
                // Date fechaCreacionRol = rs.getDate("fecha_creacion_roles");
                list.add(new Rol(rolId, nombreRol));
            }
            
            return list;
        } finally {
            DatabaseConnection.getInstance().close(rs,ps,con);
        }
    }
    
}
