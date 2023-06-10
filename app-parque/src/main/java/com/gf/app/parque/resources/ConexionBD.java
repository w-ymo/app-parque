/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gf.app.parque.resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author noelp
 */
public class ConexionBD {

    private static Connection con;

    private static final String URL = "jdbc:mysql://localhost:3306/parque_bolas";
    private static final String USER = "root";
    private static final String PASSWD = "";

    public static Connection getConnection() throws SQLException {
        con = DriverManager.getConnection(URL, USER, PASSWD);
        return con;
    }

    /**
     * isValid: si no permite la conexion con la base de datos no permite lanzar
     * la aplicacion.
     *
     * @return true -> la conexion es valida, false -> la conexion no es valida
     */
    public static boolean isValid() {
        try {
            getConnection();
            if (con != null) {
                return true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

}
