/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gf.app.parque.controller;

import com.gf.app.parque.dao.AdministradorDAO;
import com.gf.app.parque.entities.Administrador;
import com.gf.app.parque.resources.Validaciones;
import com.gf.app.parque.view.GUIInicio;
import com.gf.app.parque.view.GUILogin;
import com.gf.app.parque.view.GUIPrincipal;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author noelp
 */
public class LoginController {

    private GUIInicio vistaPadre;

    private GUILogin vista;

    private AdministradorDAO adminDAO;

    private String dni;
    private String password;

    private ActionListener al = (e) -> {
        JButton but = (JButton) e.getSource();
        if (but.equals(vista.getCancelarBut())) {
            vista.dispose();
            vistaPadre.setVisible(true);
        } else {
            dni = vista.getTextFdni().getText();
            char[] passwordChar = vista.getTextFPassword().getPassword();
            for (char c : passwordChar) {
                password += c;
            }
            try {
                if (comprobarDatos()) {
                    //lanza al menu principal
                    vista.dispose();
                    GUIPrincipal principal = new GUIPrincipal();
                    //meterla en el controlador
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
            Administrador admin = adminDAO.selectDNI(dni);
            if (admin != null) {
                if (admin.getPassword_admin().equals(this.password)) {
                    return true;
                }
            }
        }
        return false;
    }

    public LoginController(GUILogin vista, GUIInicio parent) {
        this.vistaPadre = parent;
        this.vista = vista;
        this.adminDAO = new AdministradorDAO();
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
