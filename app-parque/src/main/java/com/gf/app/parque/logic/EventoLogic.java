/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gf.app.parque.logic;

import com.gf.app.parque.dao.EventoDAO;
import com.gf.app.parque.entities.Evento;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author priparno
 */
public class EventoLogic {
 
    private EventoDAO evDAO = new EventoDAO();
    
    public boolean insert(Evento e) throws SQLException{
        
        evDAO.insert(e);
    } 
 
    
    private boolean validateInputs() {
        if (vista.getNombreEvento().getText().isEmpty()) {
            return false;
        }
        if (vista.getModelo().getValue() == null || vista.getModelo().getValue().before(new Date(LocalDate.now().toEpochDay()))) {
            return false;
        }

        if (vista.getNumeroParticipantes().getText().isEmpty()) {
            return false;
        } else {
            int num;
            try {
                num = Integer.parseInt(vista.getNumeroParticipantes().getText());
                if (num <= 0) {
                    return false;
                }
            } catch (NumberFormatException ex) {
                return false;
            }
        }
        return true;
    }
    
}
