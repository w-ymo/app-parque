/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gf.app.parque.logic;

import com.gf.app.parque.dao.MenuDAO;
import com.gf.app.parque.entities.Menu;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author priparno
 */
public class MenuLogic {

    private MenuDAO menuDAO = new MenuDAO();

    public List<Menu> select() throws SQLException {
        return menuDAO.selectAll();
    }

}
