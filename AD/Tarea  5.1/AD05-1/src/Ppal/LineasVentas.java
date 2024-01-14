
package Ppal;

public class LineasVentas {
    
    private int idproducto;
    private String descripcion;
    private int pvp;
    private int stockActual;

    public LineasVentas() {
    }

    public LineasVentas(int idproducto, String descripcion, int pvp, int stockActual) {
        this.idproducto = idproducto;
        this.descripcion = descripcion;
        this.pvp = pvp;
        this.stockActual = stockActual;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
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
