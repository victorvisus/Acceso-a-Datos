/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut3_accesodatos;
import java.sql.*;

public class UT3_AccesoDatos {
    
    public static int i = 1;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
           try {
                
            Class.forName("com.mysql.jdbc.Driver"); // Para comprobar la clase
                
            Connection conexion  = null;
                     
            // Conectamos con la base de datos
            
            conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/vuelosypasajeros","root","");
            
           // Selecciono toda la información de la base de datos
           
           Statement sentencia = conexion.createStatement(); 
           String sqlTodo = "SELECT * FROM vuelos, pasajeros";
           ResultSet resultadoTodo = sentencia.executeQuery(sqlTodo);
           
           // Mostrar y pedir información de la base de datos en general.
           // Muestra las 3 primeras columnas de 2 filas de la tabla vuelos       
     
           System.out.println("Mostrar y pedir información de la base de datos en general.");

           while (resultadoTodo.next() && i < 3) {
                           
		String COD_VUELO = resultadoTodo.getString(1);// 1
	        String HORA = resultadoTodo.getString(2); // 2
		String DESTINO = resultadoTodo.getString(3); // 3
	        System.out.printf("COD_VUELO: %s, HORA: %s, DESTINO: %s .", COD_VUELO, HORA, DESTINO);
                
                i++;
                
	   }
                      
                  
           // Mostrar la información de la tabla pasajeros.
           
           i = 1; // Reset i
           
           String sqlPasajeros = "SELECT * FROM pasajeros";
           ResultSet resultadoPasajeros = sentencia.executeQuery(sqlPasajeros);
           
           System.out.println("Mostrar la información de la tabla pasajeros.");
           
           while (resultadoPasajeros.next()) {
                           
		String NUM = resultadoPasajeros.getString(1);// 1
	        String COD_VUELO = resultadoPasajeros.getString(2); // 2
		String TIPO_PLAZA = resultadoPasajeros.getString(3); // 3
                String FUMADOR = resultadoPasajeros.getString(4); // 3
                
	        System.out.printf("NUM: %s, COD_VUELO: %s, TIPO_PLAZA: %s, FUMADOR: %s . ", NUM, COD_VUELO, TIPO_PLAZA, FUMADOR);
                
                i++;
                
	   }
           
           // Ver la información de los pasajeros de un vuelo, pasando el código de vuelo como parámetro.
           
           PreparedStatement queryCOD_VUELO = conexion.prepareStatement("SELECT * FROM pasajeros WHERE COD_VUELO = ?");
           
           queryCOD_VUELO.setString(1,"FR-DC-4667"); // Query FR-DC-4667
           
           ResultSet resultadoQueryCOD_VUELO = queryCOD_VUELO.executeQuery();
           
           System.out.println("Ver la información de los pasajeros de un vuelo, pasando el código de vuelo como parámetro.");
           
           resultadoQueryCOD_VUELO.next();
           
           System.out.printf("NUM: %s, COD_VUELO: %s, TIPO_PLAZA: %s, FUMADOR: %s . ", resultadoQueryCOD_VUELO.getString(1), resultadoQueryCOD_VUELO.getString(2), resultadoQueryCOD_VUELO.getString(3), resultadoQueryCOD_VUELO.getString(4));
           
           // Insertar un vuelo cuyos valores se pasan como parámetros.
           
           System.out.println("Insertar un vuelo cuyos valores se pasan como parámetros.");
           
           PreparedStatement insertVUELO = conexion.prepareStatement("INSERT INTO vuelos VALUES (?,?,?,?,?,?,?,?)");
           
           insertVUELO.setString(1,"FR-PR-5000"); // COD_VUELO
           insertVUELO.setString(2,"21/05/99 15:30"); // HORA
           insertVUELO.setString(3,"Madrid"); // DESTINO
           insertVUELO.setString(4,"Paris"); // PROCEDENCIA
           insertVUELO.setInt(5,30); // PLAZAS FUMADOR
           insertVUELO.setInt(6,120); // PLAZAS NO FUMADOR
           insertVUELO.setInt(7,90); // PLAZAS TURISTA
           insertVUELO.setInt(8,60); // PLAZAS PRIMERA
            
           insertVUELO.executeUpdate();
           
           // Borrar el vuelo que se metió anteriormente en el que se pasa por parámetro su número de vuelo.

           System.out.println("Borrar el vuelo que se metió anteriormente en el que se pasa por parámetro su número de vuelo.");
           
           PreparedStatement borrarVUELO = conexion.prepareStatement("DELETE FROM vuelos WHERE COD_VUELO = ?");
           
           borrarVUELO.setString(1,"FR-PR-5000"); // COD_VUELO
           
           borrarVUELO.executeUpdate();
           
           // Modificar los vuelos de fumadores a no fumadores.
           
           System.out.println("Modificar los vuelos de fumadores a no fumadores.");
           
           PreparedStatement cambiarFumadores = conexion.prepareStatement("UPDATE vuelos SET vuelos.PLAZAS_FUMADOR = vuelos.PLAZAS_NO_FUMADOR");
           
           cambiarFumadores.executeUpdate();
         
               
           } catch (SQLException se) {
                
	        System.out.println("SQL Excepcion " + se);

	   } catch (ClassNotFoundException exc) {
               
                System.out.println("No clase " + exc);
                
            }
             
    }
    
}
