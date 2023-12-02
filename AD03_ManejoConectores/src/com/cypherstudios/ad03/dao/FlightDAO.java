package com.cypherstudios.ad03.dao;

import com.cypherstudios.ad03.exceptions.Ad03Exception;
import com.cypherstudios.ad03.interfaces.IFlightDAO;
import com.cypherstudios.ad03.view.OptionsPanel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Victor
 */
public class FlightDAO extends Conexion implements IFlightDAO {

    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private Connection con = null;
    private String sql = "";

//    private String codVuelo;

    @Override
    public void listFlights(OptionsPanel run) throws SQLException, Ad03Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void createNewFlight(OptionsPanel run) throws SQLException, Ad03Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteFlight(String codVuelo) throws SQLException, Ad03Exception {
        con = getConexion();

        sql = "DELETE FROM vuelos WHERE (cod_vuelo = '" + codVuelo + "');";

        ps = con.prepareStatement(sql);
        ps.executeUpdate();

        con.close();
//        throw new UnsupportedOperationException("Not supported yet.");
    }

    //@Override
    public static void listCodVueloFlight(OptionsPanel run) throws SQLException {
        //Cargamos datos en el comboBox
        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion conn = new Conexion();
        Connection con = conn.getConexion();

        String sql = "SELECT cod_vuelo FROM vuelos";

        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();

        run.cbxListCodeFlight.addItem("Selecciona un vuelo");
        while (rs.next()) {
            run.cbxListCodeFlight.addItem(rs.getString("cod_vuelo"));
        }
        rs.close();
    }

    public static String listDestinatioFlight(String codVuelo) throws SQLException {
        String dest = "";

        //Cargamos datos en el comboBox
        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion conn = new Conexion();
        Connection con = conn.getConexion();

        String sql = "SELECT destino FROM vuelos WHERE cod_vuelo = " + codVuelo + ";";

        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();

        dest = rs.getString("destino");

        rs.close();

        return dest;
    }

    /**
     * Comprueba, mediante una consulta a la base de datos, si hay algún vuelo
     * que se corresponda con el código enviado, si es afirmativo devuelve true
     *
     * @param codVuelo
     * @return
     * @throws SQLException
     * @throws Ad03Exception
     */
    public void flightExist(String codVuelo) throws SQLException, Ad03Exception {
        if (countFlights(codVuelo) > 0) {
            throw new Ad03Exception(7);
        }
        //throw new Ad03Exception(1);
    }

    /**
     * Comprueba que el vuelo seleccionado tenga pasajeros
     *
     * @param codVuelo
     * @return
     * @throws SQLException
     */
    public int countFlights(String codVuelo) throws SQLException {
        int num = 0;

        con = getConexion();

        //Cuenta los usuario que tiene el mismo nick que el introducido
        sql = "SELECT count(cod_vuelo) FROM vuelos WHERE cod_vuelo = ?";

        ps = con.prepareStatement(sql);
        ps.setString(1, codVuelo);
        rs = ps.executeQuery();

        while (rs.next()) {
            num = rs.getInt("numero");
        }

        con.close();

        return num;
    }
}
