/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gf.app.parque.resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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

    public static void quitConnection() throws SQLException {
        if (con != null) {
            con.close();
        }
    }

}
