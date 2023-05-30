/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gf.app.parque.resources;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author priparno
 */
public class Validaciones {

    private static String letrasDNI = "TRWAGMYFPDXBNJZSQVHLCKE";

    public static boolean validateDni(String dni) {
        Pattern pat = Pattern.compile("[0-9]{8}[A-Za-z]");
        Matcher mat = pat.matcher(dni);
        if (mat.matches()) {
            return modulo23(dni);
        }
        return false;
    }

    private static boolean modulo23(String dni) {
        int num = Integer.parseInt(dni.substring(0, dni.length() - 2));
        char letra = dni.substring(dni.length() - 2).charAt(0);
        int resto = num % 23;
        if (letrasDNI.charAt(resto) == letra) {
            return true;
        }
        return false;
    }

}
