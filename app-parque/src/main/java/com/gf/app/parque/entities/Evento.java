/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gf.app.parque.entities;

import java.time.LocalDate;

/**
 *
 * @author noelp
 */
public class Evento {

    private Integer id_evento;
    private String nombre_evento;
    private LocalDate fecha_evento;
    private Integer numero_sala;
    private boolean es_cumple;
    private Integer id_menu;

    public Integer getId_evento() {
        return id_evento;
    }

    public void setId_evento(Integer id_evento) {
        this.id_evento = id_evento;
    }

    public String getNombre_evento() {
        return nombre_evento;
    }

    public void setNombre_evento(String nombre_evento) {
        this.nombre_evento = nombre_evento;
    }

    public LocalDate getFecha_evento() {
        return fecha_evento;
    }

    public void setFecha_evento(LocalDate fecha_evento) {
        this.fecha_evento = fecha_evento;
    }

    public Integer getNumero_sala() {
        return numero_sala;
    }

    public void setNumero_sala(Integer numero_sala) {
        this.numero_sala = numero_sala;
    }

    public boolean isEs_cumple() {
        return es_cumple;
    }

    public void setEs_cumple(boolean es_cumple) {
        this.es_cumple = es_cumple;
    }

    public Integer getId_menu() {
        return id_menu;
    }

    public void setId_menu(Integer id_menu) {
        this.id_menu = id_menu;
    }
    
    @Override
    public String toString() {
        return "Evento(" + id_evento + "): Nombre=" + nombre_evento + ", fecha=" + fecha_evento + ", numero sala=" + numero_sala;
    }

}
