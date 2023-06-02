/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gf.app.parque.controller;

import com.gf.app.parque.view.GUIInicio;
import com.gf.app.parque.view.GUIPrincipal;
import com.gf.app.parque.view.GUIReserva;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author noelp
 */
public class PrincipalController {

    private GUIInicio vistaPadre;

    private GUIPrincipal vista;

    private ActionListener al = (e) -> {
        if (((JButton) e.getSource()).equals(vista.getBotonReserva())) {
            GUIReserva gr = new GUIReserva();
            ReservaController rs = new ReservaController(vista, gr);
        }
    };

    public PrincipalController(GUIInicio padre, GUIPrincipal vista) {
        this.vistaPadre = padre;
        this.vista = vista;
        addActionListener();
        launchView();
    }
    
    private void addActionListener() {
        vista.getBotonReserva().addActionListener(al);
    }

    private void launchView() {
        vista.setVisible(true);
    }
    
}
