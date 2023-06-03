/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gf.app.parque.dao;

import com.gf.app.parque.entities.Menu;
import com.gf.app.parque.resources.ConexionBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author priparno
 */
public class MenuDAO {

    public List<Menu> selectAll() throws SQLException {
        List<Menu> fullList = new ArrayList<>();
        try ( Connection con = ConexionBD.getConnection()) {
            String sql = "SELECT * FROM menu";
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                Menu menu = new Menu();
                menu.setId_menu(rs.getInt("id_menu"));
                menu.setNombre_menu(rs.getString("nombre_menu"));
                menu.setPrecio_menu(rs.getDouble("precio_menu"));
                fullList.add(menu);
            }
        }
        return fullList;
    }

}
