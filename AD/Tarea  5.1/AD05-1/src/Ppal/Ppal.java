
package Ppal;

import dao.DAOClientesImpl;
import dao.DAOProductosImpl;
import dao.DAOVentasImpl;
import interfaces.DAOClientes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Ppal{
    
    public static Statement sta;
    public static PreparedStatement presta;
    public static ResultSet resulset;
    public static Connection conex = null;
    
    
    public static void main (String[]args) throws ClassNotFoundException, SQLException{
        
        DAOClientesImpl daocli = new DAOClientesImpl();
        DAOProductosImpl daopro = new DAOProductosImpl();
        DAOVentasImpl daoven = new DAOVentasImpl();
        
        Class.forName("oracle.jdbc.driver.OracleDriver");
            
        conex = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##tarea51", "tarea51");
        
        Scanner sc = new Scanner(System.in);
        
            System.out.println("Introduzca una opción: ");
        
            sc.useDelimiter("\n");
            
            boolean salir = false;
            int opcion;
          
            while(!salir){            
                
            try {
                System.out.println("1.Eliminar la BBDD.");
                System.out.println("2.Crear la estructua de la BBDD.");
                System.out.println("3.Crear las tablas de la BBDD.");
                System.out.println("4.Insertar los datos de ejemplo.");
                System.out.println("5.Obtener los clientes.");
                System.out.println("6.Obtener las ventas.");
                System.out.println("7.Salir.");
                
                opcion = sc.nextInt();
                
                switch(opcion){
                    case 1:
                        
                        drop_schema();
                        
                        break;
                        
                    case 2:
                        
                        crear_tipos();
                        
                        break;
                        
                    case 3:
                        
                        crear_tablas();
                        
                        break;
                        
                    case 4:
                        
                        try{
                            
                        Clientes cliente1 = new Clientes(55,"Juan","C/Mariano 5","Zaragoza",50007,"Aragon","44488873S",666666666,666666444,666555444);
                        Clientes cliente2 = new Clientes(17,"Maria","C/Pez 12","Madrid",36778,"Madrid","44679233S",633966666,666666474,623655444);
                        Clientes cliente3 = new Clientes(13,"Perico","C/Gato 51","Lugo",28554,"Galicia","94488873S",665666666,666766444,666555444);
                        daocli.insertar_registros(cliente1);
                        daocli.insertar_registros(cliente2);
                        daocli.insertar_registros(cliente3);
                        Productos pro1 = new Productos(11,"Manguera roja",800,8000);
                        Productos pro2 = new Productos(17,"Manguera rosa",250,10000);
                        Productos pro3 = new Productos(8,"Manguera verde",620,10000);
                        daopro.insertar_registros(pro1);
                        daopro.insertar_registros(pro2);
                        daopro.insertar_registros(pro3);
                        
                        /*
                        Ventas ven1 = new Ventas(1,55,new Date("05/09/1989"));
                        Ventas ven2 = new Ventas(2,13,new Date("11/02/1999"));
                        Ventas ven3 = new Ventas(3,17,new Date("12/05/2009"));
                        daoven.insertar_registros(ven1);
                        daoven.insertar_registros(ven2);
                        daoven.insertar_registros(ven3);
                        */
                        
                        System.out.println("Datos insertados.");
                        
                        }catch (Exception e){
                            System.out.println("Los datos iniciales ya existen.");
                        }
                        
                        break;
                        
                    case 5:
                        
                        List<Clientes> listaMostrar = daocli.obtenerClientes();
                        /*
                        if(listaMostrar != null){
                        */
                        for(Clientes cli:listaMostrar){
                            System.out.println(cli.getIdcliente() + " " + cli.getNombre() + " " + cli.getDireccion() + " " + cli.getPoblacion());
                        }
                        
                        System.out.println("Todos los clientes mostrados.");
                        /*
                        }else{
                            
                            System.out.println("No existen clientes para mostrar.");
                            
                        }
                        */
                        
                        break;
                        
                    case 6:
                        
                        List<Ventas> listaMuestra = daoven.obtenerVentasConId();
                        
                        for(Ventas ven:listaMuestra) {
                            System.out.println(ven.getVenta() + " " + ven.getIdclient() + " " + ven.getFechaVenta());
                        }
                        
                        System.out.println("Todas las ventas mostradas.");
                        
                        break;
                        
                    case 7:
                        
                        System.out.println("Gracias por utilizar el programa.");
                        salir = true;
                        
                }            
            } catch (Exception ex) {
                Logger.getLogger(Ppal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                
    }
    
    public static void drop_schema() throws SQLException{
        sta = conex.createStatement();
                        try{    
                            resulset = sta.executeQuery("DROP TYPE telefono FORCE");
                            resulset = sta.executeQuery("DROP TYPE direccion FORCE");
                            resulset = sta.executeQuery("DROP TYPE cliente FORCE");
                            resulset = sta.executeQuery("DROP TYPE producto FORCE");
                            resulset = sta.executeQuery("DROP TYPE lineaventa FORCE");
                            System.out.println("Todos los tipos han sido eliminados.");
                        }catch (Exception e){
                                System.out.println("El esquema de la BBDD no contiene Tipos definidos, debe inicializarlos primero.");
                        }
                        
                        try{    
                            resulset = sta.executeQuery("DROP TABLE clientes CASCADE CONSTRAINTS");
                            resulset = sta.executeQuery("DROP TABLE ventas CASCADE CONSTRAINTS");
                            resulset = sta.executeQuery("DROP TABLE productos CASCADE CONSTRAINTS");
                            System.out.println("Todas las tablas y su información ha sido eliminada.");
                        }catch (Exception e){
                                System.out.println("El esquema de la BBDD no contiene tablas, debe inicializarlas primero.");
                        }

    }
    
    public static void crear_tipos() throws SQLException{
        sta = conex.createStatement();
                            try{
                            resulset = sta.executeQuery("DROP TYPE telefono FORCE");
                            resulset = sta.executeQuery("DROP TYPE direccion FORCE");
                            resulset = sta.executeQuery("DROP TYPE cliente FORCE");
                            resulset = sta.executeQuery("DROP TYPE producto FORCE");
                            resulset = sta.executeQuery("DROP TYPE lineaventa FORCE");
                            System.out.println("Los tipos ya existian, pero han sido reseteados.");
                            }catch (Exception e){
                                System.out.println("Iniciando...");
                            }
                            resulset = sta.executeQuery("CREATE TYPE telefono AS VARRAY (3) OF VARCHAR2(15)");
                            
                            resulset = sta.executeQuery("CREATE TYPE direccion AS OBJECT(\n" +
                                                            "    calle       VARCHAR2(50),\n" +
                                                            "    poblacion   VARCHAR2(50),\n" +
                                                            "    codpostal   NUMBER(5),\n" +
                                                            "    provincia   VARCHAR2(40)\n" +
                                                            ");");
                            
                            resulset = sta.executeQuery("CREATE TYPE cliente AS OBJECT(\n" +
                                                            "    idcliente   NUMBER,\n" +
                                                            "    nombre      VARCHAR2(50),\n" +
                                                            "    direccion_t direccion,\n" +
                                                            "    nif         VARCHAR2(50),\n" +
                                                            "    telefono_t  telefono\n" +
                                                            ");");
                            
                            resulset = sta.executeQuery("CREATE TYPE producto AS OBJECT(\n" +
                                                            "    idproducto   NUMBER,\n" +
                                                            "    descripcion  VARCHAR2(80),\n" +
                                                            "    pvp          NUMBER,\n" +
                                                            "    stockactual  NUMBER\n" +
                                                            ");");
                            
                            resulset = sta.executeQuery("CREATE TYPE lineaventa AS OBJECT(\n" +
                                                            "    numerolinea   NUMBER,\n" +
                                                            "    producto_t    REF producto,\n" +
                                                            "    cantidad      NUMBER\n" +
                                                            ");");

                            System.out.println("Tipos creados.");
    }
    
    public static void crear_tablas () throws SQLException{
        sta = conex.createStatement();
                            try{
                            resulset = sta.executeQuery("CREATE TABLE CLIENTES(IDCLIENTE NUMBER PRIMARY KEY, NOMBRE VARCHAR2(50),DIRECCION VARCHAR2(50),POBLACION VARCHAR2(50),CODPOSTAL NUMBER(5),PROVINCIA VARCHAR2(40),NIF VARCHAR2(9) UNIQUE,TELEFONO1 VARCHAR2(15),TELEFONO2 VARCHAR2(15),TELEFONO3 VARCHAR2(15))");
                            resulset = sta.executeQuery("CREATE TABLE PRODUCTOS(IDPRODUCTO NUMBER PRIMARY KEY, DESCRIPCION VARCHAR2(80), PVP NUMBER, STOCKACTUAL NUMBER)");
                            resulset = sta.executeQuery("CREATE TABLE VENTAS(VENTA NUMBER PRIMARY KEY, IDCLIENTE NUMBER NOT NULL REFERENCES CLIENTES, FECHAVENTA DATE)");
                            /*resulset = sta.executeQuery("CREATE TABLE LINEASVENTAS(IDVENTA NUMBER, NUMEROLINEA NUMBER, IDPRODUCTO NUMBER, CANTIDAD NUMBER, FOREIGN KEY (IDVENTA) REFERENCES VENTAS (IDVENTA), FOREIGN KEY (IDPRODUCTO) REFERENCES PRODUCTOS (IDPRODUCTO), PRIMARY KEY (IDVENTA, NUMEROLINEA))");
                            System.out.println("Creado4.");
                            */
                            System.out.println("Tablas creadas.");
                            
                            }catch(Exception w){
                                System.out.println("Las tablas ya existen.");
                            }
                            
        
    }
    
   
    
}

            
       
    

