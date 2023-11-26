package com.cypherstudios.ad03.dao;

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

    @Override
    public void listFlights() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void createNewFlight() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteFlight() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
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

}
