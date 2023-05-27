/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.gf.app.parque.application;

import com.gf.app.parque.controller.InicioController;
import com.gf.app.parque.view.GUIInicio;

/**
 *
 * @author noelp
 */
public class AppParque {

    public static void main(String[] args) {
        GUIInicio in = new GUIInicio();
        InicioController ic = new InicioController(in);
        ic.launch();
    }
}
