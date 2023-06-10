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
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 * ReservaController:
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

    private int errorMsg;

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
                        JOptionPane.showMessageDialog(vista, "Error al insertar.", "ERROR", JOptionPane.ERROR_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(vista, "Insertado.", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(vista, "Error de sintaxis.", "ERROR", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            } else {
                showMessage();
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

    /**
     * validateInputs: es un metodo que valida los inputs del usuario en la
     * ventana de reserva.
     *
     * @see GUIReserva
     *
     * @return true -> si es valido, false -> si no lo es
     */
    private boolean validateInputs() {
        if (vista.getNombreEvento().getText().isEmpty()) {
            errorMsg = 1;
            return false;
        }
        if (vista.getModelo().getValue() == null) {
            errorMsg = 2;
            return false;
        }
        if (vista.getModelo().getValue().before(new Date(System.currentTimeMillis()))) {
            errorMsg = 3;
            return false;
        }
        if (vista.getNumeroParticipantes().getText().isEmpty()) {
            errorMsg = 4;
            return false;
        } else {
            int num;
            try {
                num = Integer.parseInt(vista.getNumeroParticipantes().getText());
                if (num <= 0) {
                    errorMsg = 5;
                    return false;
                }
            } catch (NumberFormatException ex) {
                errorMsg = 6;
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
        evento.setNombre_evento(nombre);
        evento.setFecha_evento(fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
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
        if (vista.getOpcionesMenu().getSelectedIndex() > 1) {
            String selected = (String) vista.getOpcionesSala().getSelectedItem();
            String[] partes = selected.split("\\.");
            numero = Integer.valueOf(partes[0]);
        }
        return numero;
    }

    private void setInfoMenu() {
        Menu noSeleccionado = new Menu();
        noSeleccionado.setNombre_menu("No seleccionado");
        this.vista.getOpcionesMenu().addItem(noSeleccionado);
        try {
            for (Menu menu : mLogic.select()) {
                this.vista.getOpcionesMenu().addItem(menu);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(vista, "Error de sintaxis", "ERROR", JOptionPane.ERROR_MESSAGE);
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

    private void showMessage() {
        switch (errorMsg) {
            case 1 -> {
                JOptionPane.showMessageDialog(vista, "Error. Nombre del evento vacío.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            case 2 -> {
                JOptionPane.showMessageDialog(vista, "Error. Fecha no introducida.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            case 3 -> {
                JOptionPane.showMessageDialog(vista, "Error. Fecha anterior al día de hoy.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            case 4 -> {
                JOptionPane.showMessageDialog(vista, "Error. No has introducido número de participantes.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            case 5 -> {
                JOptionPane.showMessageDialog(vista, "Error. Has introducido un número negativo de participantes.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            case 6 -> {
                JOptionPane.showMessageDialog(vista, "Error. No has introducido un número válido de participantes.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            default -> {
                System.err.println("No hay ningun error.");
            }
        }
    }

    private void launchView() {
        vista.setVisible(true);
    }

}
