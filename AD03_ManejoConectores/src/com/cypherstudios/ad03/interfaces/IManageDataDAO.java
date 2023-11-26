/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cypherstudios.ad03.interfaces;

import java.sql.SQLException;

/**
 *
 * @author Victor
 */
public interface IManageDataDAO {

    /**
     * de alta los datos de ejemplo en la base de datos. (1)
     *
     * @throws SQLException
     */
    public abstract void enterAllData() throws SQLException;

    /**
     * Eliminar todos los datos de la base de datos. (2)
     *
     * @throws SQLException
     */
    public abstract void deleteAllData() throws SQLException;
}
