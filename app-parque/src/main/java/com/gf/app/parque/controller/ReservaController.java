/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gf.app.parque.controller;

import com.gf.app.parque.entities.Evento;
import com.gf.app.parque.entities.Reserva;
import com.gf.app.parque.view.GUIPrincipal;
import com.gf.app.parque.view.GUIReserva;

import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

import javax.swing.JButton;

/**
 *
 * @author noelp
 */
public class ReservaController {

    private GUIPrincipal vistaPadre;

    private GUIReserva vista;

    private Evento evento;

    private ActionListener al = (e) -> {
        JButton but = (JButton) e.getSource();
        if (but.equals(vista.getCancelarBut())) {
            vista.dispose();
            vistaPadre.setVisible(true);
        } else {
            if (validateInputs()) {
                getContentInputFields();
            }
        }
    };

    public ReservaController(GUIPrincipal vistaPadre, GUIReserva vista) {
        this.vistaPadre = vistaPadre;
        this.vista = vista;
        addActionListenerButton();
        launchView();
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
            int num = 0;
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

    private void getContentInputFields() {
        evento = new Evento();
        String nombre = vista.getNombreEvento().getText();
        Date fecha = vista.getModelo().getValue();
        int numParticipantes = Integer.parseInt(vista.getNumeroParticipantes().getText());
        int idMenu = 0;
        int numSala = 0;
        boolean esCumple = vista.getCheckIsCumple().isSelected();
        evento.setNombre_evento(nombre);
        evento.setFecha_evento(LocalDate.ofEpochDay(fecha.getTime()));
        //falta numero de participantes
        evento.setId_menu(idMenu);
        evento.setNumero_sala(numSala);
        evento.setEs_cumple(esCumple);
    }

    private void addActionListenerButton() {
        vista.getCancelarBut().addActionListener(al);
        vista.getAceptarBut().addActionListener(al);
    }

    private void launchView() {
        vista.setVisible(true);
    }

}
