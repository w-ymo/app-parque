/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gf.app.parque.controller;

import com.gf.app.parque.entities.Administrador;
import com.gf.app.parque.logic.AdministradorLogic;
import com.gf.app.parque.resources.Colors;
import com.gf.app.parque.resources.Validaciones;
import com.gf.app.parque.view.GUIInicio;
import com.gf.app.parque.view.GUIPrincipal;
import com.gf.app.parque.view.GUIRegistro;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author noelp
 */
public class RegistroController {

    private GUIInicio vistaPadre;

    private GUIRegistro vista;

    private AdministradorLogic adminLogic;

    private String dni;
    private String password;
    private String passwordB;

    private int errorMsg;

    private ActionListener al = (e) -> {
        JButton but = (JButton) e.getSource();
        if (but.equals(vista.getCancelarBut())) {
            vista.dispose();
            vistaPadre.setVisible(true);
        } else {
            dni = vista.getTextFdni().getText();
            password = "";
            char[] passwordChar = vista.getTextFPassword().getPassword();
            for (char c : passwordChar) {
                password += c;
            }
            passwordB = "";
            for (char c : vista.getConfirmPassword().getPassword()) {
                passwordB += c;
            }
            try {
                if (comprobarDatos()) {
                    vista.dispose();
                    GUIPrincipal principal = new GUIPrincipal();
                    PrincipalController pc = new PrincipalController(vistaPadre, principal);
                } else {
                    showMessage();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(vista, "Error de sintaxis.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }

    };

    private KeyAdapter ka1 = new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                vista.getTextFPassword().requestFocus();
            }
        }

    };

    private KeyAdapter ka2 = new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                vista.getConfirmPassword().requestFocus();
            }
        }
    };

    private KeyAdapter ka3 = new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                vista.getAceptarBut().doClick();
            }
        }
    };

    private boolean comprobarDatos() throws SQLException {
        if (Validaciones.validateDni(dni)) {
            Administrador admin = adminLogic.selectDni(dni);
            if (admin != null) {
                if (admin.getPassword_admin().isEmpty()) {
                    if (password.equals(passwordB)) {
                        if (password.length() > 8) {
                            return adminLogic.update(dni, password);
                        } else {
                            errorMsg = 5;
                        }
                    } else {
                        errorMsg = 4;
                    }
                } else {
                    errorMsg = 3;
                }
            } else {
                errorMsg = 2;
            }
        } else {
            errorMsg = 1;
        }
        return false;
    }

    public RegistroController(GUIRegistro vista, GUIInicio parent) {
        this.vistaPadre = parent;
        this.vista = vista;
        this.adminLogic = new AdministradorLogic();
        addActionListener();
        launchView();
    }

    private void addActionListener() {
        vista.getAceptarBut().addActionListener(al);
        vista.getCancelarBut().addActionListener(al);
        vista.getTextFdni().addKeyListener(ka1);
        vista.getTextFPassword().addKeyListener(ka2);
        vista.getConfirmPassword().addKeyListener(ka3);
    }

    private void showMessage() {
        setWhite();
        switch (errorMsg) {
            case 1 -> {
                JOptionPane.showMessageDialog(vista, "Error. Formato de dni inválido. Debe tener 8 números y 1 letra.", "ERROR", JOptionPane.ERROR_MESSAGE);
                vista.getTextFdni().setBackground(Colors.RED_BACKGROUND);
            }
            case 2 -> {
                JOptionPane.showMessageDialog(vista, "Error. No se ha encontrado el usuario.", "ERROR", JOptionPane.ERROR_MESSAGE);
                vista.getTextFdni().setBackground(Colors.RED_BACKGROUND);
            }
            case 3 -> {
                JOptionPane.showMessageDialog(vista, "Error. El administrador ya tiene una contraseña asociada.", "ERROR", JOptionPane.ERROR_MESSAGE);
                vista.getTextFPassword().setBackground(Colors.RED_BACKGROUND);
            }
            case 4 -> {
                JOptionPane.showMessageDialog(vista, "Error. Las contraseñas no coinciden.", "ERROR", JOptionPane.ERROR_MESSAGE);
                vista.getTextFPassword().setBackground(Colors.RED_BACKGROUND);
                vista.getConfirmPassword().setBackground(Colors.RED_BACKGROUND);
            }
            case 5 -> {
                JOptionPane.showMessageDialog(vista, "Error. Las contraseñas no cumplen el formato de seguridad (8 caracteres).", "ERROR", JOptionPane.ERROR_MESSAGE);
                vista.getTextFPassword().setBackground(Colors.RED_BACKGROUND);
                vista.getConfirmPassword().setBackground(Colors.RED_BACKGROUND);
            }
            default ->
                throw new AssertionError();
        }
    }

    private void setWhite() {
        vista.getTextFdni().setBackground(Color.white);
        vista.getTextFPassword().setBackground(Color.white);
        vista.getConfirmPassword().setBackground(Color.white);
    }

    private void launchView() {
        vista.setVisible(true);
    }
}
