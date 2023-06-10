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

/**
 *
 * @author priparno
 */
public class EventoDAO {

    public int insert(Evento e) throws SQLException {
        String sql = "INSERT INTO evento (nombre_evento, fecha_evento, numero_integrantes, numero_sala, es_cumple, id_menu) VALUES (?,?,?,?,?,?)";
        try ( Connection con = ConexionBD.getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, e.getNombre_evento());
            ps.setDate(2, Date.valueOf(e.getFecha_evento()));
            ps.setInt(3, e.getNumero_participantes());
            ps.setInt(4, e.getNumero_sala());
            ps.setBoolean(5, e.isEs_cumple());
            ps.setInt(6, e.getId_menu());
            return ps.executeUpdate();
        }
    }

    public int insertWOIdMenu(Evento e) throws SQLException {
        String sql = "INSERT INTO evento (nombre_evento, fecha_evento, numero_integrantes, numero_sala, es_cumple) VALUES (?,?,?,?,?)";
        try ( Connection con = ConexionBD.getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, e.getNombre_evento());
            ps.setDate(2, Date.valueOf(e.getFecha_evento()));
            ps.setInt(3, e.getNumero_participantes());
            ps.setInt(4, e.getNumero_sala());
            ps.setBoolean(5, e.isEs_cumple());
            return ps.executeUpdate();
        }
    }

    public int insertWONumSala(Evento e) throws SQLException {
        String sql = "INSERT INTO evento (nombre_evento, fecha_evento, numero_integrantes, es_cumple, id_menu) VALUES (?,?,?,?,?)";
        try ( Connection con = ConexionBD.getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, e.getNombre_evento());
            ps.setDate(2, Date.valueOf(e.getFecha_evento()));
            ps.setInt(3, e.getNumero_participantes());
            ps.setBoolean(4, e.isEs_cumple());
            ps.setInt(5, e.getId_menu());
            return ps.executeUpdate();
        }
    }

    public int insertWONumSalaIdMenu(Evento e) throws SQLException {
        String sql = "INSERT INTO evento (nombre_evento, fecha_evento, numero_integrantes, es_cumple) VALUES (?,?,?,?)";
        try ( Connection con = ConexionBD.getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, e.getNombre_evento());
            ps.setDate(2, Date.valueOf(e.getFecha_evento()));
            ps.setInt(3, e.getNumero_participantes());
            ps.setBoolean(4, e.isEs_cumple());
            return ps.executeUpdate();
        }
    }

}
