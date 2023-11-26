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
public interface IFlightDAO {

    public abstract void listFlights() throws SQLException;

    /**
     * Dar de alta un nuevo vuelo con todos sus valores. (5)
     *
     * @throws SQLException
     */
    public abstract void createNewFlight() throws SQLException;

    /**
     * Eliminar un vuelo existente en la base de datos. (6)
     *
     * @throws SQLException
     */
    public abstract void deleteFlight() throws SQLException;

    /**
     * Extrae el Destino y el código de todos los vuelos, para poder añadirlos a
     * un desplegable en el formulario
     *
     * @throws SQLException
     */
    public abstract void listCodVueloFlight() throws SQLException;
}
