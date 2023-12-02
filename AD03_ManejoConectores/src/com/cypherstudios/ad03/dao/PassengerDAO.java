/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cypherstudios.ad03.dao;

import com.cypherstudios.ad03.exceptions.Ad03Exception;
import com.cypherstudios.ad03.interfaces.IPassengerDAO;
import com.cypherstudios.ad03.view.OptionsPanel;
import java.awt.event.MouseEvent;
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

            if (countPassengers(codVuelo) > 0) {
                //Mando a "pintar la tabla"
                writePassengersOnTable(run, rs);
            } else {
                throw new Ad03Exception(2);
            }

            //Cierro la conexión
            con.close();
        } else {
            throw new Ad03Exception(3);
        }
    }

    @Override
    public void modifyPassengers(OptionsPanel run) throws SQLException, Ad03Exception {
        if (run.cbxListCodeFlight.getSelectedIndex() != 0) {
            displayFlightPassengers(run);

            run.txtCodVuelo.setEnabled(true);
            run.labelCodVuelo.setEnabled(true);

            run.txtNumPassenger.setEnabled(true);
            run.labelNumPassenger.setEnabled(true);

//            run.cbxSeatTypePassenger.setEnabled(true);
            run.labelTipoPlazaPassenger.setEnabled(true);

            run.rbtnSmokingNo.setEnabled(true);
            run.rbtnSmokingYes.setEnabled(true);
            run.labelFumadorPassenger.setEnabled(true);

            /*
            Cuando seleccion un pasajero de la tabla tiene que pintar los datos
            en los campos correspondientes
             */
//            getSelectedPasseger(run);
        } else {
            throw new Ad03Exception(3);
        }
    }

    /**
     * Elimina los pasajeros de un vuelo
     *
     * @param codVuelo
     * @throws SQLException
     * @throws Ad03Exception
     */
    @Override
    public void deletePassengers(String codVuelo) throws SQLException, Ad03Exception {
        //Preparo la consulta
        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion conn = new Conexion();
        Connection con = conn.getConexion();

        String sql = "DELETE FROM pasajeros WHERE (cod_vuelo = '" + codVuelo + "');";

        ps = con.prepareStatement(sql);
        ps.executeUpdate();

        con.close();
//        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Escribe/Modifica el campo fumador en la tabla pasajeros de la base de
     * datos
     *
     * @param run
     * @throws SQLException
     * @throws Ad03Exception
     */
    public void savePassengers(OptionsPanel run) throws SQLException, Ad03Exception {
        if (run.cbxListCodeFlight.getSelectedItem().equals(run.txtCodVuelo.getText())) {
            //Preparo la consulta
            PreparedStatement ps = null;
            Conexion conn = new Conexion();
            Connection con = conn.getConexion();

            String sql = "UPDATE pasajeros SET fumador = ? WHERE num = ? AND cod_vuelo = ?;";

            ps = con.prepareStatement(sql);
            if (run.rbtnSmokingYes.isSelected()) {
                ps.setString(1, "SI");
            } else {
                ps.setString(1, "NO");
            }
            ps.setString(2, run.txtNumPassenger.getText());
            ps.setString(3, run.txtCodVuelo.getText());

            ps.executeUpdate();

            //Cierro la conexión
            con.close();

        } else {
            throw new Ad03Exception(6);
        }

    }

    /**
     * Imprime los datos recibidos de la consulta en la tabla, crea un objeto
     * resulset para poder leer el núm de columans que despues utilizaremos para
     * recorrer los datos y guardarlo en un Objetc, que después sera el que se
     * imprima en la tabña
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

    public void getSelectedPasseger(OptionsPanel run, MouseEvent e) {
        if (e.getClickCount() == 1) {
            run.btnSavePassenger.setEnabled(true);

            //Coge los valores de la tabla y los coloca en los campos de "edición"
            run.txtCodVuelo.setText(run.jtPassengersList.getValueAt(run.jtPassengersList.getSelectedRow(), 1).toString());
            run.txtNumPassenger.setText(run.jtPassengersList.getValueAt(run.jtPassengersList.getSelectedRow(), 0).toString());

            //Relleno los datos referentes al tipo de asiento
            String seatPass = run.jtPassengersList.getValueAt(run.jtPassengersList.getSelectedRow(), 2).toString();
            if (seatPass.equals("TU")) {
                run.cbxSeatTypePassenger.setSelectedItem("Turista");
            } else if (seatPass.equals("PR")) {
                run.cbxSeatTypePassenger.setSelectedItem("Primera");
            }
            //Datos referentes a Fumador
            String smoking = run.jtPassengersList.getValueAt(run.jtPassengersList.getSelectedRow(), 3).toString();
            if (smoking.equals("NO")) {
                run.rbtnSmokingNo.setSelected(true);
            } else {
                run.rbtnSmokingYes.setSelected(true);
            }
        }
    }

    /**
     * Comprueba que el vuelo seleccionado tenga pasajeros
     *
     * @param codVuelo
     * @return
     * @throws SQLException
     */
    public int countPassengers(String codVuelo) throws SQLException {
        int num = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion conn = new Conexion();
        Connection con = conn.getConexion();
        con = getConexion();

        //Cuenta los usuario que tiene el mismo nick que el introducido
        String sql = "SELECT count(cod_vuelo) AS num_pass FROM pasajeros WHERE cod_vuelo = ?";

        ps = con.prepareStatement(sql);
        ps.setString(1, codVuelo);
        rs = ps.executeQuery();

        while (rs.next()) {
            num = rs.getInt("num_pass");
        }

        con.close();

        return num;
    }
}
