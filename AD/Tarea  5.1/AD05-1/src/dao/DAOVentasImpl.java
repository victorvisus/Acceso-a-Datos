
package dao;

import Ppal.Ventas;
import interfaces.DAOVentas;
import java.util.List;
import static Ppal.Ppal.conex;
import java.sql.PreparedStatement;
import static Ppal.Ppal.resulset;
import static Ppal.Ppal.sta;
import java.beans.Statement;
import java.util.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;


public class DAOVentasImpl implements DAOVentas {
    
    Scanner sc = new Scanner (System.in);

    @Override
    public void insertar_registros(Ventas ven) throws Exception {
     
        try{
        sta = conex.createStatement();
        PreparedStatement presta = null;
        presta = conex.prepareStatement("INSERT INTO ventas (VENTA, IDCLIENTE, FECHAVENTA) VALUES (?,?,?)");
        presta.setInt(1, ven.getVenta());
        presta.setInt(2, ven.getIdclient());
        presta.setDate(3, (java.sql.Date) ven.getFechaVenta());
        presta.executeQuery();
        
        
        }catch(Exception e){
            System.out.println("Error al insertar los registros de las VENTAS.");
        }    
        
    }    
    
    @Override
    public List<Ventas> obtenerVentasConId() throws Exception {
        List<Ventas> listaClientes = new ArrayList(); 
        sta = conex.createStatement();
        System.out.println("Introduzca la ID del cliente para conocer sus ventas: ");
        int id = sc.nextInt();
        ResultSet resu = sta.executeQuery("SELECT * FROM VENTAS WHERE IDCLIENTE = " + id);
        while(resu.next()){
            Ventas venta = new Ventas();
            venta.setVenta(resu.getInt("VENTA"));
            venta.setIdclient(resu.getInt("IDCLIENTE"));
            venta.setFechaVenta(resu.getDate("FECHAVENTA"));
            listaClientes.add(venta);
            }
        return listaClientes;
    }
    
    
    
}
