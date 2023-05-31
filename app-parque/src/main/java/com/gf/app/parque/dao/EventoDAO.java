/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gf.app.parque.dao;

import com.gf.app.parque.entities.Evento;
import com.gf.app.parque.resources.ConexionBD;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author priparno
 */
public class EventoDAO {

    public int insert(Evento e) throws SQLException {
        String sql = "INSERT INTO sintomas (nombre_evento, fecha_evento, numero_sala, es_cumple, id_menu) VALUES (?,?,?,?,?)";
        try ( Connection con = ConexionBD.getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, e.getNombre_evento());
            ps.setDate(2, Date.valueOf(e.getFecha_evento()));
            ps.setInt(3, e.getNumero_sala());
            ps.setBoolean(4, e.isEs_cumple());
            ps.setInt(5, e.getId_menu());
            return ps.executeUpdate();
        }
    }

    public List<Evento> selectAll() throws SQLException {
        return null;
    }
    
    public Evento selectId(int id) throws SQLException {
        return null;
    }
    
    public List<Evento> selectDate(Date fecha) throws SQLException {
        return null;
    }
    
}
