/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gf.app.parque.dao;

import com.gf.app.parque.entities.Administrador;
import com.gf.app.parque.resources.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * AdministradorDAO: es la clase de acceso a datos de la base de datos, en
 * concreto la tabla 'administrador'.
 *
 * @author priparno
 */
public class AdministradorDAO {

    /**
     * 
     */
    public AdministradorDAO() {
    }

    /**
     * 
     * @param dni
     * @return
     * @throws SQLException 
     */
    public Administrador selectDNI(String dni) throws SQLException {
        Administrador admin = null;
        try ( Connection con = ConexionBD.getConnection()) {
            String sql = "SELECT * FROM administrador WHERE dni_admin=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                admin = new Administrador();
                admin.setDni_admin(rs.getString("dni_admin"));
                admin.setNombre_admin(rs.getString("nombre_admin"));
                admin.setApellidos_admin(rs.getString("apellidos_admin"));
                admin.setTelefono_admin(rs.getString("telefono_admin"));
                admin.setCorreo_admin(rs.getString("correo_admin"));
                admin.setPuesto_admin(rs.getString("puesto_admin"));
                admin.setPassword_admin(rs.getString("password_admin"));
            }
        }
        return admin;
    }

    /**
     * 
     * @param a
     * @return
     * @throws SQLException 
     */
    public int updateId(Administrador a) throws SQLException {
        String sql = "UPDATE administrador SET nombre_admin=?,apellidos_admin=?,telefono_admin=?,correo_admin=?,puesto_admin=?,password_admin=? WHERE dni_admin=?";
        try ( Connection con = ConexionBD.getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, a.getNombre_admin());
            ps.setString(2, a.getApellidos_admin());
            ps.setString(3, a.getTelefono_admin());
            ps.setString(4, a.getCorreo_admin());
            ps.setString(5, a.getPuesto_admin());
            ps.setString(6, a.getPassword_admin());
            ps.setString(7, a.getDni_admin());
            return ps.executeUpdate();
        }
    }

}
