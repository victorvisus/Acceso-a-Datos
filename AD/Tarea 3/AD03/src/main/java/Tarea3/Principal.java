
package Tarea3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Principal {
    
    public static void main(String[]args) throws SQLException{
        
        try {
            Scanner sc = new Scanner(System.in);
            sc.useDelimiter("\n");
            
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            Connection conex = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "pch1ld77");
            
            boolean salir = false;
            int opcion;
            Statement statement;
            ResultSet resulset;
            String codVuelo;
            
            while(!salir){            
                
                System.out.println("1.Introducir datos iniciales.");
                System.out.println("2.Eliminar todos los datos.");
                System.out.println("3.Mostrar la información de todos los pasajeros.");
                System.out.println("4.Mostrar información de pasajeros de un vuelo específico.");
                System.out.println("5.Dar de alta un nuevo vuelo.");
                System.out.println("6.Eliminar un vuelo existente.");
                System.out.println("7.Modificar pasajeros de un vuelo determinado.");
                System.out.println("8.Salir.");
                
                opcion = sc.nextInt();
                
                switch(opcion){
                    case 1:
                        
                        statement = conex.createStatement();
                        resulset = statement.executeQuery("INSERT INTO VUELOS VALUES('IB-SP-4567','27/03/22-10:30','PARIS','MADRID',100,100,160,40)");
                        resulset = statement.executeQuery("INSERT INTO VUELOS VALUES('IB-BA-46DC','28/03/22-12:30','ROMA','MADRID',90,100,160,30)");
                        resulset = statement.executeQuery("INSERT INTO VUELOS VALUES('FR-DC-4667','28/03/22-13:30','BRUSELAS','SEVILLA',90,100,160,30)");
                        resulset = statement.executeQuery("INSERT INTO VUELOS VALUES('AV-DC-347','29/03/22-13:35','VALENCIA','ROMA',100,200,210,90)");
                        resulset = statement.executeQuery("INSERT INTO VUELOS VALUES('SP-DC-438','30/03/22-09:20','MOSCU','SEVILLA',90,100,160,30)");
                        resulset = statement.executeQuery("INSERT INTO VUELOS VALUES('AI-D7-347','30/03/22-13:35','BILBAO','MOSCU',100,200,210,90)");
                        resulset = statement.executeQuery("INSERT INTO VUELOS VALUES('IB-D5-347','01/04/22-13:35','ZARAGOZA','PARIS',100,200,210,90)");
                        resulset = statement.executeQuery("INSERT INTO VUELOS VALUES('FR-DC7-247','01/04/22-15:35','CORDOBA','COMPOSTELA',100,100,100,100)");
                        resulset = statement.executeQuery("INSERT INTO VUELOS VALUES('AV-DC9-233','01/04/22-17:35','VALENCIA','BRUSELAS',100,100,100,100)");
                        resulset = statement.executeQuery("INSERT INTO VUELOS VALUES('FR-DC2-269','01/04/22-19:00','BILBAO','BUENOS AIRES',100,100,180,20)");
                        resulset = statement.executeQuery("INSERT INTO VUELOS VALUES('IB-98779','02/04/22-08:00','MADRID','NEW YORK',200,100,250,50)");
                        resulset = statement.executeQuery("INSERT INTO VUELOS VALUES('AV-DC2-269','02/04/22-12:00','MADRID','LA HABANA',100,100,180,20)");
                        resulset = statement.executeQuery("INSERT INTO VUELOS VALUES('AI-1289-9','02/04/22-14:30','BARCELONA','MOSCU',150,100,180,70)");
                        
                        System.out.println("Introducidos los datos referentes a los vuelos.");
                        
                        resulset = statement.executeQuery("INSERT INTO PASAJEROS VALUES(123,'IB-SP-4567','TU','SI')");
                        resulset = statement.executeQuery("INSERT INTO PASAJEROS VALUES(124,'IB-SP-4567','PR','SI')");
                        resulset = statement.executeQuery("INSERT INTO PASAJEROS VALUES(125,'IB-SP-4567','PR','NO')");
                        resulset = statement.executeQuery("INSERT INTO PASAJEROS VALUES(126,'IB-BA-46DC','TU','SI')");
                        resulset = statement.executeQuery("INSERT INTO PASAJEROS VALUES(127,'IB-BA-46DC','PR','SI')");
                        resulset = statement.executeQuery("INSERT INTO PASAJEROS VALUES(128,'FR-DC-4667','TU','NO')");
                        resulset = statement.executeQuery("INSERT INTO PASAJEROS VALUES(129,'FR-DC-4667','TU','SI')");
                        resulset = statement.executeQuery("INSERT INTO PASAJEROS VALUES(130,'AV-DC9-233','TU','SI')");
                        resulset = statement.executeQuery("INSERT INTO PASAJEROS VALUES(131,'AV-DC9-233','TU','NO')");
                        resulset = statement.executeQuery("INSERT INTO PASAJEROS VALUES(132,'AV-DC9-233','PR','SI')");
                        resulset = statement.executeQuery("INSERT INTO PASAJEROS VALUES(133,'IB-D5-347','PR','SI')");
                        resulset = statement.executeQuery("INSERT INTO PASAJEROS VALUES(134,'IB-D5-347','PR','SI')");
                        resulset = statement.executeQuery("INSERT INTO PASAJEROS VALUES(135,'IB-D5-347','TU','NO')");
                        resulset = statement.executeQuery("INSERT INTO PASAJEROS VALUES(136,'IB-D5-347','TU','SI')");
                        resulset = statement.executeQuery("INSERT INTO PASAJEROS VALUES(137,'FR-DC-4667','TU','SI')");
                        resulset = statement.executeQuery("INSERT INTO PASAJEROS VALUES(138,'FR-DC-4667','TU','NO')");
                        resulset = statement.executeQuery("INSERT INTO PASAJEROS VALUES(139,'FR-DC-4667','PR','SI')");
                        resulset = statement.executeQuery("INSERT INTO PASAJEROS VALUES(126,'FR-DC-4667','PR','SI')");
                        resulset = statement.executeQuery("INSERT INTO PASAJEROS VALUES(130,'AV-DC2-269','TU','SI')");
                        resulset = statement.executeQuery("INSERT INTO PASAJEROS VALUES(131,'AV-DC2-269','TU','NO')");
                        resulset = statement.executeQuery("INSERT INTO PASAJEROS VALUES(132,'AV-DC2-269','PR','SI')");
                        resulset = statement.executeQuery("INSERT INTO PASAJEROS VALUES(133,'AI-1289-9','PR','SI')");
                        resulset = statement.executeQuery("INSERT INTO PASAJEROS VALUES(134,'AI-1289-9','PR','SI')");
                        resulset = statement.executeQuery("INSERT INTO PASAJEROS VALUES(135,'AI-1289-9','TU','NO')");
                        resulset = statement.executeQuery("INSERT INTO PASAJEROS VALUES(136,'AI-1289-9','TU','SI')");
                        resulset = statement.executeQuery("INSERT INTO PASAJEROS VALUES(137,'SP-DC-438','TU','SI')");
                        resulset = statement.executeQuery("INSERT INTO PASAJEROS VALUES(138,'SP-DC-438','TU','NO')");
                        resulset = statement.executeQuery("INSERT INTO PASAJEROS VALUES(139,'SP-DC-438','PR','SI')");
                        resulset = statement.executeQuery("INSERT INTO PASAJEROS VALUES(140,'SP-DC-438','PR','SI')");
                        resulset = statement.executeQuery("INSERT INTO PASAJEROS VALUES(141,'FR-DC7-247','PR','SI')");
                        resulset = statement.executeQuery("INSERT INTO PASAJEROS VALUES(142,'FR-DC7-247','TU','NO')");
                        resulset = statement.executeQuery("INSERT INTO PASAJEROS VALUES(143,'FR-DC7-247','TU','SI')");
                                  
                        System.out.println("Introducidos los datos referentes a los pasajeros.\n");
                        
                        break;
                        
                    case 2:
                        
                        statement = conex.createStatement();
                        resulset = statement.executeQuery("DELETE FROM PASAJEROS");
                        resulset = statement.executeQuery("DELETE FROM VUELOS");
                        
                        System.out.println("La BBDD esta vacia, todos los datos han sido eliminados.\n");
                        
                        break;
                        
                    case 3:
                        
                        statement = conex.createStatement();
                        resulset = statement.executeQuery("select * from pasajeros");
                        
                        System.out.println("NUM\tCOD_VUELO\tTIPO_PLAZA\tFUMADOR\t");
                        
                        while(resulset.next()){
                            System.out.print(resulset.getInt("NUM")+"\t");
                            System.out.print(resulset.getString("COD_VUELO")+"\t");
                            System.out.print(resulset.getString("TIPO_PLAZA")+"\t\t");
                            System.out.print(resulset.getString("FUMADOR")+"\t");
                            System.out.println();
                        }
                        
                        resulset.close();
                        statement.close();
                        
                        System.out.println("");
                        
                        break;
                        
                    case 4:
                        
                        System.out.println("Introduce el código del vuelo: ");
                        codVuelo = sc.next();
                        
                        statement = conex.createStatement();
                        
                        resulset = statement.executeQuery("select * from pasajeros WHERE cod_vuelo = '" + codVuelo + "'");
                        
                        System.out.println("NUM\tCOD_VUELO\tTIPO_PLAZA\tFUMADOR\t");
                        
                        while(resulset.next()){
                            System.out.print(resulset.getInt("NUM")+"\t");
                            System.out.print(resulset.getString("COD_VUELO")+"\t");
                            System.out.print(resulset.getString("TIPO_PLAZA")+"\t\t");
                            System.out.print(resulset.getString("FUMADOR")+"\t");
                            System.out.println();
                        }
                        
                        resulset.close();
                        statement.close();
                        
                        System.out.println("");
                        
                        break;
                        
                    case 5:
                        
                        System.out.println("Bienvenido. Va a dar de alta un nuevo vuelo.");
                        
                        System.out.println("Introduzca el código del vuelo: ");
                        codVuelo = sc.next();
                        
                        System.out.println("Introduzca la hora de salida del vuelo: ");
                        String horaSalida = sc.next();
                        
                        System.out.println("Introduzcca el destino del vuelo: ");
                        String destiny = sc.next();
                        
                        System.out.println("Introduzca la procedencia del vuelo: ");
                        String proced = sc.next();
                        
                        System.out.println("Introduzca el número de plazas para fumadores: ");
                        int fumi = sc.nextInt();
                        
                        System.out.println("Introduzca el número de plazas para no fumadores: ");
                        int nofumi = sc.nextInt();
                        
                        System.out.println("Introduzca el número de plazas en Turista: ");
                        int turista = sc.nextInt();
                        
                        System.out.println("Introduzca el número de plazas en Primera Clase: ");
                        int primera = sc.nextInt();
                        
                        statement = conex.createStatement();
                        
                        resulset = statement.executeQuery("INSERT INTO vuelos VALUES ('" + codVuelo + "', '" + horaSalida + "', '" + destiny + "', '" + proced + "', " + fumi + ", " + nofumi + ", " + turista + ", " + primera + ")");
                        
                        System.out.println("El vuelo ha sido creado.\n");
                        
                        resulset.close();
                        statement.close();
                        
                        break;
                        
                    case 6:
                        
                        statement = conex.createStatement();
                        
                        resulset = statement.executeQuery("select COD_VUELO,HORA_SALIDA,DESTINO from vuelos");
                        
                        System.out.println("COD_VUELO\tHORA_SALIDA\tDESTINO");
                        
                        while(resulset.next()){
                            System.out.print(resulset.getString("COD_VUELO")+"\t");
                            System.out.print(resulset.getString("HORA_SALIDA")+"\t");
                            System.out.print(resulset.getString("DESTINO"));
                            System.out.println();
                        }
                        
                        System.out.println("Seleccione el código del vuelo que desea eliminar:");
                        codVuelo = sc.next();
                        
                        resulset = statement.executeQuery("DELETE FROM vuelos WHERE COD_VUELO = '" + codVuelo + "'");
                        
                        System.out.println("El vuelo con código " + codVuelo + " ha sido eliminado.\n");
                        
                        resulset.close();
                        statement.close();
                        
                        break;
                        
                    case 7:
                        
                        System.out.println("Introduzca el código del vuelo para acceder a los pasajeros:");
                        codVuelo = sc.next();
                        
                        break;
                        
                    case 8:
                        
                        System.out.println("Gracias por utilizar el programa del aeropuerto.");
                        salir = true;
                        
                        break;
                    default:
                        System.out.println("La opción debe estar entre 1 y 8.\n");
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
