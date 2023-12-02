/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cypherstudios.ad03.interfaces;

import com.cypherstudios.ad03.exceptions.Ad03Exception;
import com.cypherstudios.ad03.model.FlightModel;
import com.cypherstudios.ad03.view.OptionsPanel;
import java.sql.SQLException;

/**
 *
 * @author Victor
 */
public interface IFlightDAO {

    /**
     * Listar los vuelos existentes en la base de datos
     *
     * @param run
     * @throws SQLException
     * @throws Ad03Exception
     */
    public abstract void listFlights(OptionsPanel run) throws SQLException, Ad03Exception;

    /**
     * Dar de alta un nuevo vuelo con todos sus valores. (Ej 5)
     *
     * @param run
     * @throws SQLException
     * @throws com.cypherstudios.ad03.exceptions.Ad03Exception
     */
    public abstract void createNewFlight(FlightModel fly) throws SQLException, Ad03Exception;

    /**
     * Eliminar un vuelo existente en la base de datos. (Ej 6)
     *
     * @param run
     * @throws SQLException
     * @throws com.cypherstudios.ad03.exceptions.Ad03Exception
     */
    public void deleteFlight(String codVuelo) throws SQLException, Ad03Exception;

    /**
     * Extrae el Destino y el código de todos los vuelos, para poder añadirlos a
     * un desplegable en el formulario
     *
     * @throws SQLException
     */
    //public abstract void listCodVueloFlight() throws SQLException;
}
