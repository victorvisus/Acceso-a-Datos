/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cypherstudios.ad03.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Victor
 */
public class utils {

    /**
     * Evalua si la consulta trae resultados
     *
     * @param rs
     * @return
     * @throws SQLException
     */
    public static int countResults(ResultSet rs) throws SQLException {
        int resultsCount = 0;
        while (rs.next()) {
            //Obtienes la data que necesitas...
            resultsCount++;
        }

        return resultsCount;
    }
}
