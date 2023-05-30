/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gf.app.parque.logic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author priparno
 */
public class LogicaValidaciones {
    
    //hacer una logica por cada movida??
    private boolean comprobarDatos(String dni) {
        if (!validateDni(dni)) {
            JOptionPane.showMessageDialog(null, "Has metido un dni que no cumple el formato.", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {

        }
        return true;
    }

    private boolean validateDni(String dni) {
        Pattern pat = Pattern.compile("[0-9]{8}[A-Za-z]");
        Matcher mat = pat.matcher(dni);
        if (mat.matches()) {
            
        }
        return true;
    }

    private boolean modulo23(String dni){
        int num = Integer.parseInt(dni.substring(0, dni.length() - 2));
        char letra = 'A';
        return true;
    }
    
}
