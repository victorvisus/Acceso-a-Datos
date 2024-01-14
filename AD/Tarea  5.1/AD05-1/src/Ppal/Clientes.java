
package Ppal;

public class Clientes {
    
    private int idcliente;
    private String nombre;
    private String direccion;
    private String poblacion;
    private int codpostal;
    private String provincia;
    private String nif;
    private int telefono1;
    private int telefono2;
    private int telefono3;

    public Clientes() {
    }

    public Clientes(int idcliente, String nombre, String direccion, String poblacion, int codpostal, String provincia, String nif, int telefono1, int telefono2, int telefono3) {
        this.idcliente = idcliente;
        this.nombre = nombre;
        this.direccion = direccion;
        this.poblacion = poblacion;
        this.codpostal = codpostal;
        this.provincia = provincia;
        this.nif = nif;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
        this.telefono3 = telefono3;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public int getCodpostal() {
        return codpostal;
    }

    public void setCodpostal(int codpostal) {
        this.codpostal = codpostal;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public int getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(int telefono1) {
        this.telefono1 = telefono1;
    }

    public int getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(int telefono2) {
        this.telefono2 = telefono2;
    }

    public int getTelefono3() {
        return telefono3;
    }

    public void setTelefono3(int telefono3) {
        this.telefono3 = telefono3;
    }
    
}
