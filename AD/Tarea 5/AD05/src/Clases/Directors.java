
package Clases;

import java.util.Date;


public class Directors {
    
    private String nombre;
    private String apellidos;
    private String nomCom = nombre + " " + apellidos;
    private String ciuNac;
    private Date fecNac;
    private String nacionalidad;

    public Directors() {
    }

    public Directors(String nombre, String apellidos, String ciuNac, Date fecNac, String nacionalidad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.ciuNac = ciuNac;
        this.fecNac = fecNac;
        this.nacionalidad = nacionalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNomCom() {
        return nomCom;
    }

    public void setNomCom(String nomCom) {
        this.nomCom = nomCom;
    }

    public String getCiuNac() {
        return ciuNac;
    }

    public void setCiuNac(String ciuNac) {
        this.ciuNac = ciuNac;
    }

    public Date getFecNac() {
        return fecNac;
    }

    public void setFecNac(Date fecNac) {
        this.fecNac = fecNac;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    @Override
    public String toString() {
        return "Directors{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", nomCom=" + nombre + " " + apellidos + ", ciuNac=" + ciuNac + ", fecNac=" + fecNac + ", nacionalidad=" + nacionalidad + '}';
    }
    
    
    
}
