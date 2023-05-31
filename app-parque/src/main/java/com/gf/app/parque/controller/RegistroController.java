/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gf.app.parque.controller;

import com.gf.app.parque.dao.AdministradorDAO;
import com.gf.app.parque.entities.Administrador;
import com.gf.app.parque.logic.AdministradorLogic;
import com.gf.app.parque.resources.Validaciones;
import com.gf.app.parque.view.GUIInicio;
import com.gf.app.parque.view.GUILogin;
import com.gf.app.parque.view.GUIPrincipal;
import com.gf.app.parque.view.GUIRegistro;
import java.awt.Color;
import java.awt.event.ActionListener;
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

    private int cod_error; //va a ser el código de error para imprimir el mensaje correspondiente

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
                    JOptionPane.showMessageDialog(vista, "Pues te has confundido");
                    vista.getTextFdni().setBackground(Color.red);
                    vista.getTextFPassword().setBackground(Color.red);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(vista, "Error al acceder a la base de datos.");
            }
        }

    };

    private boolean comprobarDatos() throws SQLException {
        if (Validaciones.validateDni(dni)) {
            Administrador admin = adminLogic.selectDni(dni);
            if (admin != null) {
                if (admin.getPassword_admin().isEmpty()) {
                    if (password.equals(passwordB)) {
                        if (password.length() > 4) {
                            return adminLogic.update(dni, password);
                        }
                    }
                }
            }
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
    }

    private void launchView() {
        vista.setVisible(true);
    }
}
