
package Ppal;

import java.util.Date;

public class Productos {
    

    private int idproducto;
    private String descripcion;
    private int pvp;
    private int stockActual;

    public Productos() {
    }

    public Productos(int idventa, String descripcion, int pvp, int stockActual) {
        this.idproducto = idventa;
        this.descripcion = descripcion;
        this.pvp = pvp;
        this.stockActual = stockActual;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idventa) {
        this.idproducto = idventa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPvp() {
        return pvp;
    }

    public void setPvp(int pvp) {
        this.pvp = pvp;
    }

    public int getStockActual() {
        return stockActual;
    }

    public void setStockActual(int stockActual) {
        this.stockActual = stockActual;
    }

    
    
}