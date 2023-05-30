/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gf.app.parque.controller;

import com.gf.app.parque.view.GUIInicio;
import com.gf.app.parque.view.GUILogin;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author noelp
 */
public class LoginController {

    private GUIInicio vistaPadre;

    private GUILogin vista;

    private String dni;
    private char[] password;

    private ActionListener al = (e) -> {
        JButton but = (JButton) e.getSource();
        if (but.equals(vista.getCancelarBut())) {
            vista.dispose();
            vistaPadre.setVisible(true);
        } else {
            dni = vista.getTextFdni().getText();
            password = vista.getTextFPassword().getPassword();
            //if (comprobarDatos()) {

            //}
        }

    };

    public LoginController(GUILogin vista, GUIInicio parent) {
        this.vistaPadre = parent;
        this.vista = vista;
        addActionListener();
        launchView();
    }
    
    private void addActionListener() {
        vista.getAceptarBut().addActionListener(al);
        vista.getCancelarBut().addActionListener(al);
    }

    private void launchView() {
        vista.setVisible(true);
    }

}
