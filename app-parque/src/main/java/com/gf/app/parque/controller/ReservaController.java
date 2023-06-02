/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gf.app.parque.controller;

import com.gf.app.parque.entities.Evento;
import com.gf.app.parque.entities.Menu;
import com.gf.app.parque.logic.EventoLogic;
import com.gf.app.parque.logic.MenuLogic;
import com.gf.app.parque.view.GUIPrincipal;
import com.gf.app.parque.view.GUIReserva;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author noelp
 */
public class ReservaController {

    private GUIPrincipal vistaPadre;

    private GUIReserva vista;

    private final static String[] NOMBRES_SALAS = {"No seleccionado", "1. Sala dragones", "2. Sala jungla", "3. Sala deportes", "4. Sala fortnite"};

    private MenuLogic mLogic = new MenuLogic();
    private EventoLogic eLogic = new EventoLogic();

    private Evento evento;

    private ActionListener al = (e) -> {
        JButton but = (JButton) e.getSource();
        if (but.equals(vista.getCancelarBut())) {
            vista.dispose();
            vistaPadre.setVisible(true);
        } else {
            if (validateInputs()) {
                getContentInputFields();
                try {
                    if (!eLogic.insert(evento)) {
                        JOptionPane.showMessageDialog(vista, "Error al insertar.");
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(vista, "Error al acceder a la base de datos.");
                }
            }
        }
    };

    public ReservaController(GUIPrincipal vistaPadre, GUIReserva vista) {
        this.vistaPadre = vistaPadre;
        this.vista = vista;
        addActionListenerButton();
        setInfoMenu();
        setInfoSalas();
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

    private void getContentInputFields() {
        evento = new Evento();
        String nombre = vista.getNombreEvento().getText();
        Date fecha = vista.getModelo().getValue();
        int numParticipantes = Integer.parseInt(vista.getNumeroParticipantes().getText());
        Integer idMenu = getSelectedMenu();
        Integer numSala = getSelectedSala();
        boolean esCumple = vista.getCheckIsCumple().isSelected();
        //evento
        evento.setNombre_evento(nombre);
        evento.setFecha_evento(LocalDate.ofEpochDay(fecha.getTime()));
        evento.setNumero_participantes(numParticipantes);
        evento.setId_menu(idMenu);
        evento.setNumero_sala(numSala);
        evento.setEs_cumple(esCumple);
    }

    private Integer getSelectedMenu() {
        Integer numero = null;
        if (vista.getOpcionesMenu().getSelectedIndex() != 0) {
            Menu menu = (Menu) vista.getOpcionesMenu().getSelectedItem();
            numero = menu.getId_menu();
        }
        return numero;
    }

    private Integer getSelectedSala() {
        Integer numero = null;
        if (vista.getOpcionesMenu().getSelectedIndex() != 0) {
            String selected = (String) vista.getOpcionesSala().getSelectedItem();
            String[] partes = selected.split("\\.");
            numero = Integer.parseInt(partes[0]);
        }
        return numero;
    }

    private void setInfoMenu() {
        Menu noSeleccionado = new Menu();
        noSeleccionado.setNombre_menu("No seleccionado");
        this.vista.getOpcionesMenu().addItem(noSeleccionado);
        try {
            System.out.println(mLogic.select());
            for (Menu menu : mLogic.select()) {
                this.vista.getOpcionesMenu().addItem(menu);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(vista, "Error al acceder a la base de datos");
        }
    }

    private void setInfoSalas() {
        for (String string : NOMBRES_SALAS) {
            this.vista.getOpcionesSala().addItem(string);
        }
    }

    private void addActionListenerButton() {
        vista.getCancelarBut().addActionListener(al);
        vista.getAceptarBut().addActionListener(al);
    }

    private void launchView() {
        vista.setVisible(true);
    }

}
