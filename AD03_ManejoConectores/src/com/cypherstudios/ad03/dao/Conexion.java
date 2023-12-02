package com.cypherstudios.ad03.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * Esta clase gestiona la conexión a la base de datos MySQL. Utiliza parámetros
 * de configuración para establecer la conexión.
 *
 * @author Víctor Visús García
 */
public class Conexion {

    // Parámetros de configuración para la conexión
    private final String serverPrep = "useServerPrepStmts=true";
    private final String useSSL = "useSSL=false";
    private final String timeZone = "useTimezone=true";
    private final String serverTimeZone = "serverTimezone=UTC";
    private final String allowPublicKey = "allowPublicKeyRetrieval=true";

    // Nombre de la base de datos
    private final String BASE = "flyingdb";

    // URL de conexión JDBC con los parámetros de configuración
    private final String JDBC_URL = "jdbc:mysql://localhost:3306/" + BASE + "?" + serverPrep + "&" + useSSL + "&" + timeZone + "&" + serverTimeZone + "&" + allowPublicKey;

    // Usuario y contraseña para la conexión
    private final String JDBC_USER = "root";
    private final String JDBC_PASSWORD = "WB558929v!ch0-X";

    //Variable para almacenar la conexión
    protected Connection con = null;

    /**
     * Establece la conexión con la base de datos
     *
     * @return conexion
     */
    public Connection getConexion() {

        try {
            // Carga el controlador JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establece la conexión utilizando los parámetros configurados
            con = DriverManager.getConnection(this.JDBC_URL, this.JDBC_USER, this.JDBC_PASSWORD);

        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println(ex);
        }
        return con;
    }

}
