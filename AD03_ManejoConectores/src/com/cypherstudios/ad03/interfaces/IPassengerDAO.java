/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cypherstudios.ad03.interfaces;

import com.cypherstudios.ad03.exceptions.Ad03Exception;
import com.cypherstudios.ad03.view.OptionsPanel;
import java.sql.SQLException;

/**
 *
 * @author Victor
 */
public interface IPassengerDAO {

    /**
     * Listar/Mostrar la información de todos los pasajeros. (3)
     *
     * @param run
     * @throws SQLException
     * @throws com.cypherstudios.ad03.exceptions.Ad03Exception
     */
    public abstract void showPassengers(OptionsPanel run) throws SQLException, Ad03Exception;

    /**
     * Listar la información de los pasajeros de un vuelo, que el usuario pueda
     * seleccionar. (4)
     *
     * @param run
     * @throws SQLException
     * @throws com.cypherstudios.ad03.exceptions.Ad03Exception
     */
    public void displayFlightPassengers(OptionsPanel run) throws SQLException, Ad03Exception;

    /**
     * Modificar los pasajeros de un vuelo (seleccionado desde un desplegable)
     * permitiendo cambiar de fumadores a no fumadores. (7)
     *
     * @param run
     * @throws SQLException
     * @throws com.cypherstudios.ad03.exceptions.Ad03Exception
     */
    public abstract void modifyPassengers(OptionsPanel run) throws SQLException, Ad03Exception;

    /**
     * Elimina los pasajeros de un vuelo
     *
     * @param codVuelo
     * @throws SQLException
     * @throws Ad03Exception
     */
    public void deletePassengers(String codVuelo) throws SQLException, Ad03Exception;
}
