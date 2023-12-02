package com.cypherstudios.ad03.dao;

import com.cypherstudios.ad03.exceptions.Ad03Exception;
import com.cypherstudios.ad03.interfaces.IFlightDAO;
import com.cypherstudios.ad03.model.FlightModel;
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
    public void createNewFlight(FlightModel fly) throws SQLException, Ad03Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteFlight(String codVuelo) throws SQLException, Ad03Exception {
        String where = "";

        //Evaluamos que la variable campo no este vacia, si no esta vacia añade la clausula where a la consulta
        if (!"".equals(codVuelo)) {
            where = "WHERE cod_vuelo = '" + codVuelo + "'";
        }

        con = getConexion();

        sql = "DELETE FROM vuelos " + where + ";";

        ps = con.prepareStatement(sql);
        ps.executeUpdate();

        con.close();
//        throw new UnsupportedOperationException("Not supported yet.");
    }

    //@Override
    public void listCodVueloFlight(OptionsPanel run) throws SQLException {
        run.cbxListCodeFlight.removeAllItems();

        con = getConexion();
        sql = "SELECT cod_vuelo FROM vuelos";

        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();

        run.cbxListCodeFlight.addItem("Selecciona un vuelo");
        while (rs.next()) {
            run.cbxListCodeFlight.addItem(rs.getString("cod_vuelo"));
        }
        rs.close();
    }

    public String listDestinatioFlight(String codVuelo) throws SQLException {
        String dest = "";

        con = getConexion();
        sql = "SELECT destino FROM vuelos WHERE cod_vuelo = " + codVuelo + ";";

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
    private int countFlights(String codVuelo) throws SQLException {
        int num = 0;

        con = getConexion();

        //Cuenta los usuario que tiene el mismo nick que el introducido
        sql = "SELECT count(cod_vuelo) AS cuenta FROM vuelos WHERE cod_vuelo = ?";

        ps = con.prepareStatement(sql);
        ps.setString(1, codVuelo);
        rs = ps.executeQuery();

        while (rs.next()) {
            num = rs.getInt("cuenta");
        }

        con.close();

        return num;
    }

}
