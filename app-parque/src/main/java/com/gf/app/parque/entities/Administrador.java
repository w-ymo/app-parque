/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gf.app.parque.entities;

/**
 *
 * @author noelp
 */
public class Administrador {

    private String dni_admin;
    private String nombre_admin;
    private String apellidos_admin;
    private String telefono_admin;
    private String correo_admin;
    private String puesto_admin;
    private String userName_admin;
    private String password_admin;

    public String getDni_admin() {
        return dni_admin;
    }

    public void setDni_admin(String dni_admin) {
        this.dni_admin = dni_admin;
    }

    public String getNombre_admin() {
        return nombre_admin;
    }

    public void setNombre_admin(String nombre_admin) {
        this.nombre_admin = nombre_admin;
    }

    public String getApellidos_admin() {
        return apellidos_admin;
    }

    public void setApellidos_admin(String apellidos_admin) {
        this.apellidos_admin = apellidos_admin;
    }

    public String getTelefono_admin() {
        return telefono_admin;
    }

    public void setTelefono_admin(String telefono_admin) {
        this.telefono_admin = telefono_admin;
    }

    public String getCorreo_admin() {
        return correo_admin;
    }

    public void setCorreo_admin(String correo_admin) {
        this.correo_admin = correo_admin;
    }

    public String getPuesto_admin() {
        return puesto_admin;
    }

    public void setPuesto_admin(String puesto_admin) {
        this.puesto_admin = puesto_admin;
    }

    public String getUserName_admin() {
        return userName_admin;
    }

    public void setUserName_admin(String userName_admin) {
        this.userName_admin = userName_admin;
    }

    public String getPassword_admin() {
        return password_admin;
    }

    public void setPassword_admin(String password_admin) {
        this.password_admin = password_admin;
    }

    @Override
    public String toString() {
        return "Administrador(" + userName_admin + "): Nombre y apellidos=" + nombre_admin + " " + apellidos_admin + ", telefono=" + telefono_admin + ", correo=" + correo_admin + ", puesto=" + puesto_admin;
    }

}
