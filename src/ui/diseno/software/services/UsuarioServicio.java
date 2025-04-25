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
import ui.diseno.software.models.Rol;
import ui.diseno.software.models.Usuario;

/**
 *
 * @author Gabriel
 */
public class UsuarioServicio {
    
       public List<Usuario> getAll() throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DatabaseConnection.getInstance().createConnection();
            ps = con.prepareStatement("SELECT r.roles_id, u.usuario_id, u.nombre, u.apellido, u.username, u.contrasena, u.fecha_creacion_usuario, r.nombre AS nombre_rol FROM usuarios u JOIN roles r USING (roles_id) ORDER BY r.nombre, u.nombre");
            rs = ps.executeQuery();

            List<Usuario> list = new ArrayList<>();
            while (rs.next()) {
                int usuarioId = rs.getInt("usuario_id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String nombreUsuario = rs.getString("username");
                String contrasena = rs.getString("contrasena");
                Date fechaCreacionUsuario = rs.getDate("fecha_creacion_usuario");
                int rolId = rs.getInt("roles_id");
                String nombreRol = rs.getString("nombre");
                list.add(new Usuario(usuarioId, nombre, apellido, nombreUsuario, contrasena,new Rol(rolId, nombreRol) ,fechaCreacionUsuario));
            }

            return list;
        } finally {
            DatabaseConnection.getInstance().close(rs, ps, con);
        }
    }

//    public List<Usuario> search(String search) throws SQLException {
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
//            List<Usuario> list = new ArrayList<>();
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

    public void create(Usuario data) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DatabaseConnection.getInstance().createConnection();
            ps = con.prepareStatement("INSERT INTO usuarios (nombre, apellido, contrasena, roles_id) VALUES (?,?,?,?)");
            ps.setString(1, data.getNombre());
            ps.setString(2, data.getApellido());
            ps.setString(3, data.getContrasena());
            ps.setInt(4, data.getUsuarioRol().getRolId());
            ps.execute();

        } finally {
            DatabaseConnection.getInstance().close(ps, con);
        }
    }

//    public void edit(ModelEmployee data) throws SQLException {
//        Connection con = null;
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        try {
//            con = DatabaseConnection.getInstance().createConnection();
//            ps = con.prepareStatement("UPDATE employee SET employee_name=?, location=?, date=?, salary=?, description=?, position_id=? WHERE employee_id=? LIMIT 1");
//            ps.setString(1, data.getName());
//            ps.setString(2, data.getLocation());
//            ps.setDate(3, data.getDate());
//            ps.setDouble(4, data.getSalary());
//            ps.setString(5, data.getDescription());
//            ps.setInt(6, data.getPositions().getPositionsId());
//            ps.setInt(7, data.getEmployeeId());
//            ps.execute();
//
//        } finally {
//            DatabaseConnection.getInstance().close(ps, con);
//        }
//    }
    
//        public void delete(int id) throws SQLException {
//        Connection con = null;
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        try {
//            con = DatabaseConnection.getInstance().createConnection();
//            ps = con.prepareStatement("DELETE FROM employee WHERE employee_id=? LIMIT 1");
//  
//            ps.setInt(1, id);
//            
//            ps.execute();
//
//        } finally {
//            DatabaseConnection.getInstance().close(ps, con);
//        }
//    }
    
    

    public RolServicio getServicePositions() {
        if (rolServicio == null) {
            rolServicio = new RolServicio();
        }

        return rolServicio;
    }

    private RolServicio rolServicio;
    
}
