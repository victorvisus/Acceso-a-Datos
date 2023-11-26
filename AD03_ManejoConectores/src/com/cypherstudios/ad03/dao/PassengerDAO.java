/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cypherstudios.ad03.dao;

import com.cypherstudios.ad03.exceptions.Ad03Exception;
import com.cypherstudios.ad03.interfaces.IPassengerDAO;
import com.cypherstudios.ad03.utils.utils;
import com.cypherstudios.ad03.view.OptionsPanel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Victor
 */
public class PassengerDAO extends Conexion implements IPassengerDAO {

    @Override
    public void showPassengers(OptionsPanel run) throws SQLException, Ad03Exception {
        //throw new UnsupportedOperationException("Not supported yet.");

        DefaultTableModel modelo = new DefaultTableModel();
        run.jtPassengersList.setModel(modelo);

        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion conn = new Conexion();
        Connection con = conn.getConexion();

        String sql = "SELECT num, cod_vuelo, tipo_plaza, fumador FROM pasajeros;";

        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        //Creo un resulset para la tabla
        ResultSetMetaData rsMeta = rs.getMetaData();
        //Vemos la cantidad de datos que devuelve la consulta
        int numColumns = rsMeta.getColumnCount();
        //Evaluo si la consulta trae resultados, si no es asi lanza una Exception
        utils.evaluteResult(numColumns);

        //Añadimos las columnas al modelo
        modelo.addColumn("Num");
        modelo.addColumn("Cód. de Vuelo");
        modelo.addColumn("Tipo de asiento");
        modelo.addColumn("Fumador");

        //Cambiamos el tamaño de las columnas
        int[] anchos = {50, 50, 50, 50};
        for (int x = 0; x < numColumns; x++) {
            run.jtPassengersList.getColumnModel().getColumn(x).setPreferredWidth(anchos[x]);
        }

        //recorro los datos de la consulta
        while (rs.next()) {
            //necesitamos guardar los datos en un objeto
            Object[] rowsPass = new Object[numColumns];

            for (int i = 0; i < numColumns; i++) {
                rowsPass[i] = rs.getObject(i + 1);
            }
            //Llenamos la tabla
            modelo.addRow(rowsPass);
        }

    }

    @Override
    public void displayFlightPassengers() throws SQLException, Ad03Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void ModifyPassengers() throws SQLException, Ad03Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
