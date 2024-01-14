
package Clases;

public class Dptos {
    
    private String nombre;
    private String ciudad;
    private int cp;
    private String provincia;
    private String director;
    private String area;
    private int anoCreacion;
    private boolean funcional;

    public Dptos() {
    }

    public Dptos(String nombre, String ciudad, int cp, String provincia, String director, String area, int anoCreacion) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.cp = cp;
        this.provincia = provincia;
        this.director = director;
        this.area = area;
        this.anoCreacion = anoCreacion;
       
    }
    
    public Dptos(String nombre, String ciudad, int cp, String provincia, String director, String area, int anoCreacion,boolean funcional) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.cp = cp;
        this.provincia = provincia;
        this.director = director;
        this.area = area;
        this.anoCreacion = anoCreacion;
        this.funcional = funcional;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getAnoCreacion() {
        return anoCreacion;
    }

    public void setAnoCreacion(int anoCreacion) {
        this.anoCreacion = anoCreacion;
    }

    public boolean isFuncional() {
        return funcional;
    }

    public void setFuncional(boolean funcional) {
        this.funcional = funcional;
    }

    @Override
    public String toString() {
        return "Dptos{" + "nombre=" + nombre + ", ciudad=" + ciudad + ", cp=" + cp + ", provincia=" + provincia + ", director=" + director + ", area=" + area + ", anoCreacion=" + anoCreacion + ", funcional=" + funcional + '}';
    }

    
    
}
