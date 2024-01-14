
package dao;

import static Ppal.Ppal.conex;
import Ppal.Productos;
import interfaces.DAOProductos;
import java.util.List;
import java.sql.PreparedStatement;
import static Ppal.Ppal.resulset;
import static Ppal.Ppal.sta;
import Ppal.Ventas;
import java.beans.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class DAOProductosImpl implements DAOProductos {

    @Override
    public void insertar_registros(Productos pro) throws Exception {
        try{
        sta = conex.createStatement();
        PreparedStatement presta = null;
        presta = conex.prepareStatement("INSERT INTO productos (IDPRODUCTO, DESCRIPCION, PVP, STOCKACTUAL) VALUES (?,?,?,?)");
        presta.setInt(1, pro.getIdproducto());
        presta.setString(2, pro.getDescripcion());
        presta.setInt(3, pro.getPvp());
        presta.setInt(4, pro.getStockActual());
        presta.executeQuery();
        
        }catch(Exception e){
            System.out.println("Error al insertar los registros.");
        }    
        
        
    }
    
    
}
