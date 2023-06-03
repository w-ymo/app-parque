/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gf.app.parque.entities;

/**
 *
 * @author noelp
 */
public class Menu {
    
    private Integer id_menu;
    private String nombre_menu;
    private Double precio_menu;

    public Integer getId_menu() {
        return id_menu;
    }

    public void setId_menu(Integer id_menu) {
        this.id_menu = id_menu;
    }

    public String getNombre_menu() {
        return nombre_menu;
    }

    public void setNombre_menu(String nombre_menu) {
        this.nombre_menu = nombre_menu;
    }

    public Double getPrecio_menu() {
        return precio_menu;
    }

    public void setPrecio_menu(Double precio_menu) {
        this.precio_menu = precio_menu;
    }

    @Override
    public String toString() {
        return nombre_menu;
    }
    
    
}
