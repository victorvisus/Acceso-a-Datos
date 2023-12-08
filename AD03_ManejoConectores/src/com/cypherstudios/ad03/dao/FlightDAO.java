package com.cypherstudios.ad03.dao;

import com.cypherstudios.ad03.exceptions.Ad03Exception;
import com.cypherstudios.ad03.interfaces.IFlightDAO;
import com.cypherstudios.ad03.model.FlightArrayList;
import com.cypherstudios.ad03.model.FlightModel;
import com.cypherstudios.ad03.view.OptionsPanel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Clase que implementa operaciones relacionadas con la gestión de vuelos en la
 * base de datos MySQL.
 *
 * @author Victor
 */
public class FlightDAO extends Conexion implements IFlightDAO {

    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private Connection con = null;
    private String sql = "";

    /**
     * Inserta vuelos en la base de datos a partir de objetos recibidos en un
     * ArrayList.
     *
     * @param frl : ArrayList que contiene los objetos que se quieren insertar
     * @throws SQLException
     * @throws Ad03Exception
     */
    @Override
    public void insertFlights(FlightArrayList frl) throws SQLException, Ad03Exception {
        if (createTableVuelos()) {
            con = getConexion();

            for (int i = 0; i < frl.flightCount(); i++) {
                FlightModel fly = frl.getFlightModel(i);

                sql = "INSERT INTO vuelos(cod_vuelo, hora_salida, destino, procedencia, plazas_fumador, plazas_no_fumador, plazas_turista, plazas_primera )"
                        + " VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

                ps = con.prepareStatement(sql);

                ps.setString(1, fly.getCodVuelo());
                ps.setString(2, fly.getDepartureTime());
                ps.setString(3, fly.getFlighDestination());
                ps.setString(4, fly.getFlightOrigin());
                ps.setInt(5, fly.getNumSmokingSeat());
                ps.setInt(6, fly.getNumNonSmokingSeat());
                ps.setInt(7, fly.getNumEconomySeats());
                ps.setInt(8, fly.getNumFirstClassSeat());

                ps.executeUpdate();

                System.out.println("Vuelo " + i + " Insertado : " + fly.toString());
            }
            con.close();

        }
    }

    /**
     * Lista los vuelos existentes en la base de datos.
     *
     * @param run OptionsPanel donde se mostrarán los resultados.
     * @throws SQLException
     * @throws Ad03Exception
     */
    @Override
    public void listFlights(OptionsPanel run) throws SQLException, Ad03Exception {
        throw new Ad03Exception(1);
    }

    /**
     * Crea un nuevo vuelo en la base de datos.
     *
     * @param fly Objeto FlightModel que representa el vuelo a crear.
     * @throws SQLException
     * @throws Ad03Exception
     */
    @Override
    public void createNewFlight(FlightModel fly) throws SQLException, Ad03Exception {
        System.out.println(fly.toString());
        con = getConexion();

        sql = "INSERT INTO vuelos(cod_vuelo, hora_salida, destino, procedencia, plazas_fumador, plazas_no_fumador, plazas_turista, plazas_primera )"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

        ps = con.prepareStatement(sql);

        ps.setString(1, fly.getCodVuelo());
        ps.setString(2, fly.getDepartureTime());
        ps.setString(3, fly.getFlighDestination());
        ps.setString(4, fly.getFlightOrigin());
        ps.setInt(5, fly.getNumSmokingSeat());
        ps.setInt(6, fly.getNumNonSmokingSeat());
        ps.setInt(7, fly.getNumEconomySeats());
        ps.setInt(8, fly.getNumFirstClassSeat());

        ps.executeUpdate();

        con.close();

    }

    /**
     * Elimina todos los vuelos, o el que reciba por parámetro
     *
     * @param codVuelo Código del vuelo a eliminar.
     * @throws SQLException
     * @throws Ad03Exception
     */
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
    }

    /**
     * Escribe los vuelos en el combo Box, o lista desplegable
     *
     * @param run
     * @throws SQLException
     */
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

    /**
     * Se usaria para escribir en un campo para ello el destino del vuelo (no lo
     * uso en este programa)
     *
     * @param codVuelo
     * @return
     * @throws SQLException
     */
//    public String listDestinatioFlight(String codVuelo) throws SQLException {
//        String dest = "";
//
//        con = getConexion();
//        sql = "SELECT destino FROM vuelos WHERE cod_vuelo = " + codVuelo + ";";
//
//        ps = con.prepareStatement(sql);
//        rs = ps.executeQuery();
//
//        dest = rs.getString("destino");
//
//        rs.close();
//
//        return dest;
//    }
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

    /**
     * Crea la table vuelos
     *
     * @return
     */
    private boolean createTableVuelos() {
        con = getConexion();

        String sql = "CREATE TABLE IF NOT EXISTS VUELOS ( COD_VUELO VARCHAR(10) PRIMARY KEY, HORA_SALIDA VARCHAR(20), DESTINO VARCHAR(20), PROCEDENCIA VARCHAR(15), PLAZAS_FUMADOR INT(3), PLAZAS_NO_FUMADOR INT(3), PLAZAS_TURISTA INT(3), PLAZAS_PRIMERA INT(3) );";
        try {
            ps = con.prepareStatement(sql);
            ps.execute();

            return true;

        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Error al crear la tabla", "Crear", JOptionPane.ERROR_MESSAGE);

            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    }

    /**
     * Comprueba que la tabla vuelos exista
     *
     * @return
     */
    public boolean checkTableVuelos() {
        con = getConexion();

        String sql = "SELECT * FROM vuelos;";
        try {
            ps = con.prepareStatement(sql);
            ps.execute();

            return true;

        } catch (SQLException ex) {
            System.out.println(ex);

            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    }

}
