/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gf.app.parque.logic;

import com.gf.app.parque.dao.AdministradorDAO;
import com.gf.app.parque.entities.Administrador;
import java.sql.SQLException;

/**
 *
 * @author priparno
 */
public class AdministradorLogic {

    private AdministradorDAO adminDAO = new AdministradorDAO();

    //meter de actualizar las movidas
    public boolean update(String dni, String newPass) throws SQLException {
        Administrador a = adminDAO.selectDNI(dni);
        if (newPass.length() < 8){
            return false;
        }
        a.setPassword_admin(newPass); 
        return adminDAO.updateId(a)>0; //lanza false si no se actualiza
    }
    
    
    public Administrador selectDni (String dni) throws SQLException {
        return adminDAO.selectDNI(dni);
    }

}
