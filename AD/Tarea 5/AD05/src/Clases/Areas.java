
package Clases;


public class Areas {
    
    private String nombre;
    private int presupuesto;

    public Areas() {
    }

    public Areas(String nombre, int presupuesto) {
        this.nombre = nombre;
        this.presupuesto = presupuesto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(int presupuesto) {
        this.presupuesto = presupuesto;
    }

    @Override
    public String toString() {
        return "Areas{" + "nombre=" + nombre + ", presupuesto=" + presupuesto + '}';
    }
    
    
    
}
