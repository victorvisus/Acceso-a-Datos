
package Ppal;

import java.util.Date;

public class Ventas {
    
    private int venta;
    private int idclient;
    private Date fechaVenta;

    public Ventas() {
    }

    public Ventas(int venta, int idclient, Date fechaVenta) {
        this.venta = venta;
        this.idclient = idclient;
        this.fechaVenta = fechaVenta;
    }

    public int getVenta() {
        return venta;
    }

    public void setVenta(int idventa) {
        this.venta = idventa;
    }

    public int getIdclient() {
        return idclient;
    }

    public void setIdclient(int idclient) {
        this.idclient = idclient;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }
    
    
}
