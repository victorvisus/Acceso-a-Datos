
package dao;

import Ppal.Clientes;
import static Ppal.Ppal.conex;
import static Ppal.Ppal.resulset;
import static Ppal.Ppal.sta;
import Ppal.Ventas;
import interfaces.DAOClientes;
import java.beans.Statement;
import java.sql.ResultSet;
import java.util.List;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class DAOClientesImpl implements DAOClientes {

    @Override
    public void insertar_registros(Clientes cli) throws Exception {
        try{
        sta = conex.createStatement();
        PreparedStatement presta = null;
        presta = conex.prepareStatement("INSERT INTO clientes (IDCLIENTE, NOMBRE, DIRECCION, POBLACION, CODPOSTAL, PROVINCIA, NIF, TELEFONO1, TELEFONO2, TELEFONO3) VALUES (?,?,?,?,?,?,?,?,?,?)");
        presta.setInt(1, cli.getIdcliente());
        presta.setString(2, cli.getNombre());
        presta.setString(3, cli.getDireccion());
        presta.setString(4, cli.getPoblacion());
        presta.setInt(5, cli.getCodpostal());
        presta.setString(6, cli.getProvincia());
        presta.setString(7, cli.getNif());
        presta.setInt(8, cli.getTelefono1());
        presta.setInt(9, cli.getTelefono2());
        presta.setInt(10, cli.getTelefono3());
        presta.executeQuery();
        
        }catch(Exception e){
            System.out.println("Error.");
        }    
        
        
    }

    @Override
    public List<Clientes> obtenerClientes() throws Exception {
        List<Clientes> listaClientes = new ArrayList(); 
        sta = conex.createStatement();
        ResultSet resu = sta.executeQuery("SELECT * FROM CLIENTES");
        while(resu.next()){
            Clientes cliente = new Clientes();
            cliente.setIdcliente(resu.getInt("IDCLIENTE"));
            cliente.setNombre(resu.getString("NOMBRE"));
            cliente.setDireccion(resu.getString("DIRECCION"));
            cliente.setPoblacion(resu.getString("POBLACION"));
            listaClientes.add(cliente);
            }
        return listaClientes;
    }


   
    
    
    
}
