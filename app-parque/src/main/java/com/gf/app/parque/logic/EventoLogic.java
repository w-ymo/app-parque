/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gf.app.parque.logic;

import com.gf.app.parque.dao.EventoDAO;
import com.gf.app.parque.entities.Evento;
import java.sql.SQLException;

/**
 *
 * @author priparno
 */
public class EventoLogic {

    private EventoDAO evDAO = new EventoDAO();

    public boolean insert(Evento e) throws SQLException {
        if (e.getNumero_sala() == null && e.getId_evento() == null) {
            return evDAO.insertWONumSalaIdMenu(e) > 0;
        } else if (e.getNumero_sala() == null) {
            return evDAO.insertWONumSala(e) > 0;
        } else if (e.getId_menu() == null) {
            return evDAO.insertWOIdMenu(e) > 0;
        }
        return evDAO.insert(e) > 0;
    }

}
