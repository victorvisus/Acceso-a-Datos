/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cypherstudios.ad03.utils;

import com.cypherstudios.ad03.exceptions.Ad03Exception;
import com.cypherstudios.ad03.view.OptionsPanel;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Victor
 */
public class utils {

    /**
     * Limpiar el formulario
     */
    public static void cleanInputs(OptionsPanel run) {
        run.txtCodVuelo.setText(null);
        run.txtCodVuelo.setEnabled(false);
        run.txtNumPassenger.setText(null);
        run.txtNumPassenger.setEnabled(false);
        run.cbxSeatTypePassenger.setSelectedIndex(0);
        run.cbxSeatTypePassenger.setEnabled(false);
        run.rbtnSmokingNo.setSelected(false);
        run.rbtnSmokingNo.setEnabled(false);
        run.rbtnSmokingYes.setSelected(false);
        run.rbtnSmokingYes.setEnabled(false);

        run.txtCodVueloIn.setText(null);
        //run.dateDepartureIn.setValue(null); -- Quiero resetear este campo
        run.txtFlighDestinationIn.setText(null);
        run.txtFlightOriginIn.setText(null);
        run.txtNumFirstClassSeatIn.setText(null);
        run.txtNumEconomySeatsIn.setText(null);
        run.txtNumNonSmokingSeatIn.setText(null);
        run.txtNumSmokingSeatIn.setText(null);
    }

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

    /**
     * Valida la hora establecida en el formulario
     *
     * @param hour
     * @return
     * @throws Ad03Exception
     */
    public static Boolean checkHour(String hour) throws Ad03Exception {
        boolean flag = false;
        //char[] ch = hour.toCharArray();
        String[] st = hour.split(":");

        try {
            if ((Integer.parseInt(st[0]) > 24) || (Integer.parseInt(st[1]) > 59)) {

                flag = false;
                throw new Ad03Exception(8);
            } else {
                flag = true;
            }
        } catch (NumberFormatException ex) {
//            System.out.println("Error al listar los pasajeros"
//                    + "\nMensaje NumberFormatException: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Introduce una hora numérica", "Gestión de vuelos", JOptionPane.ERROR_MESSAGE);
        }

        return flag;
    }

}
