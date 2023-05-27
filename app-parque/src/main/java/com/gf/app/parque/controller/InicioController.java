/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gf.app.parque.controller;

import com.gf.app.parque.view.GUIInicio;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author noelp
 */
public class InicioController {

    private GUIInicio vista;

    public InicioController(GUIInicio vista) {
        this.vista = vista;
        setActionListener();
    }
    
    private ActionListener al = (e) -> {
        JButton opt = (JButton) (e.getSource());
        if (opt.equals(vista.getOptButtons().get(0))) {
            //pasa a la ventana login
            System.out.println("Login");
        } else if (opt.equals(vista.getOptButtons().get(1))) {
            //pasa a la ventana register
            System.out.println("register");
        } else {
            System.out.println("ERROR");
        }
    };

    private void setActionListener(){
        for (JButton opt : vista.getOptButtons()) {
            opt.addActionListener(al);
        }
    }
    
    public void launch(){
        vista.setVisible(true);
    }
    
}
