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

    /**
     * Muestra los datos de los pasajeros en una tabla en el panel de opciones
     * especificado.
     *
     * @param run El panel de opciones en el que se mostrarán los datos de los
     * pasajeros.
     * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
     * @throws Ad03Exception Si la consulta no devuelve resultados.
     */
    @Override
    public void showPassengers(OptionsPanel run) throws SQLException, Ad03Exception {

        //Preparo la consulta
        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion conn = new Conexion();
        Connection con = conn.getConexion();

        String sql = "SELECT num, cod_vuelo, tipo_plaza, fumador FROM pasajeros;";

        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();

        //Mando a "pintar la tabla"
        writePassengersOnTable(run, rs);
        //Cierro la conexión
        con.close();
    }

    @Override
    public void displayFlightPassengers(OptionsPanel run) throws SQLException, Ad03Exception {
        String codVuelo = run.cbxListCodeFlight.getSelectedItem().toString();

        //if (codVuelo != "Selecciona un vuelo") {
        if (run.cbxListCodeFlight.getSelectedIndex() != 0) {
            //Preparo la consulta
            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion conn = new Conexion();
            Connection con = conn.getConexion();

            String sql = "SELECT p.num, p.cod_vuelo, p.tipo_plaza, p.fumador FROM pasajeros AS p JOIN vuelos AS v ON v.COD_VUELO = p.COD_VUELO WHERE v.cod_vuelo = ?;";

            ps = con.prepareStatement(sql);
            ps.setString(1, codVuelo);

            rs = ps.executeQuery();

            //Mando a "pintar la tabla"
            writePassengersOnTable(run, rs);
            //Cierro la conexión
            con.close();
        } else {
            throw new Ad03Exception(3);
        }
    }

    @Override
    public void ModifyPassengers() throws SQLException, Ad03Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Método que se encarga de colocar los datos recibidos de la consulta en la
     * tabla, crea un objeto resulset para poder leer el núm de columans que
     * despues utilizaremos para recorrer los datos y guardarlo en un Objetc,
     * que después sera el que se imprima en la tabña
     *
     * @param run El panel de opciones asociado al método.
     * @param rs El ResultSet que contiene los datos a ser escritos en la tabla.
     * @throws SQLException Si ocurre un error al acceder a los datos en el
     * ResultSet.
     * @throws Ad03Exception Si la consulta no devuelve resultados.
     */
    private static void writePassengersOnTable(OptionsPanel run, ResultSet rs) throws SQLException, Ad03Exception {

        //Preparo el modelo de la tabla, donde se escribiran los resultados
        DefaultTableModel modelTable = new DefaultTableModel();
        run.jtPassengersList.setModel(modelTable);

        //Creo un resulset para la tabla
        ResultSetMetaData rsMeta = rs.getMetaData();
        //Vemos la cantidad de datos que devuelve la consulta
        int numColumns = rsMeta.getColumnCount();
        //Evaluo si la consulta trae resultados, si no es asi lanza una Exception
        utils.evaluteResult(numColumns);

        //Añadimos las columnas al modelTable
        modelTable.addColumn("Num");
        modelTable.addColumn("Cód. de Vuelo");
        modelTable.addColumn("Tipo de asiento");
        modelTable.addColumn("Fumador");

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
            modelTable.addRow(rowsPass);
        }
    }
}
