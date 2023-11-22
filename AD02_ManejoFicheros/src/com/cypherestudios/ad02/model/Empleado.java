package com.cypherestudios.ad02.model;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * Clase Empleado - attr: CODEMP (int), NOMBRE (string), APELLIDOS(string),
 * DIRECCION (string), POBLACION (string), CP (int), SALARIO (float) y
 * ANTIGUEDAD (int).
 *
 * @author Víctor Visús García
 */
public class Empleado {

    private int codEmp;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String poblacion;
    private int cp;
    private float salario;
    private int antiguedad;

    /*
     * Constante para el tamaño total de un registro de empleado en bytes, ayuda
     * a representar el tamaño total en bytes que ocupa un registro de Empleado en
     * un archivo: 4 byte para int; 2 bytes por caracter de un String y 4 bytes por float
     */
    public static final int TAMANIO_REGISTRO = 4 + (20 * 2) + (40 * 2) + (80 * 2) + (30 * 2) + 4 + 4 + 4;


    public Empleado() {
    }

    public Empleado(int codEmp, String nombre, String apellidos, String direccion, String poblacion, int cp, float salario, int antiguedad) {
        this.codEmp = codEmp;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.poblacion = poblacion;
        this.cp = cp;
        this.salario = salario;
        this.antiguedad = antiguedad;
    }

    // Getter & Setter *********************************************************
    public int getCodEmp() {
        return this.codEmp;
    }

    public void setCodEmp(int codEmp) {
        this.codEmp = codEmp;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPoblacion() {
        return this.poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public int getCp() {
        return this.cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public float getSalario() {
        return this.salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public int getAntiguedad() {
        return this.antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    @Override
    public String toString() {
        return "Empleado{" + "codEmp=" + codEmp + ", nombre=" + nombre + ", apellidos=" + apellidos + ", direccion=" + direccion + ", poblacion=" + poblacion + ", cp=" + cp + ", salario=" + salario + ", antiguedad=" + antiguedad + '}';
    }

    // *************************************************************************/
    // ***** Metodos de clase **************************************************/
    // *************************************************************************/
    /**
     * Método para escribir un registro de empleado en el archivo
     *
     * @param archivo
     * @throws IOException
     */
    public void escribirEmpleado(RandomAccessFile archivo) throws IOException {
        archivo.writeInt(this.codEmp);
        escribirCadena(archivo, this.nombre, 20);
        escribirCadena(archivo, this.apellidos, 40);
        escribirCadena(archivo, this.direccion, 80);
        escribirCadena(archivo, this.poblacion, 30);
        archivo.writeInt(this.cp);
        archivo.writeFloat(this.salario);
        archivo.writeInt(this.antiguedad);
    }

    /**
     * Método auxiliar para escribir cadenas en el archivo con longitud fija
     *
     * @param archivo
     * @param cadena
     * @param longitud
     * @throws IOException
     */
    private void escribirCadena(RandomAccessFile archivo, String cadena, int longitud) throws IOException {
        StringBuilder sb = new StringBuilder(longitud);
        sb.append(cadena);
        sb.setLength(longitud);
        archivo.writeChars(sb.toString());
    }

    /**
     * Método para leer un registro de empleado desde el archivo
     *
     * @param archivo
     * @param posicion
     * @throws IOException
     */
    public void leerEmpleado(RandomAccessFile archivo, int posicion) throws IOException {
        archivo.seek(posicion);
        this.codEmp = archivo.readInt();
        this.nombre = leerCadena(archivo, 20);
        this.apellidos = leerCadena(archivo, 40);
        this.direccion = leerCadena(archivo, 80);
        this.poblacion = leerCadena(archivo, 30);
        this.cp = archivo.readInt();
        this.salario = archivo.readFloat();
        this.antiguedad = archivo.readInt();
    }

    /**
     * Método auxiliar para leer cadenas del archivo
     *
     * @param archivo
     * @param longitud
     * @return
     * @throws IOException
     */
    public String leerCadena(RandomAccessFile archivo, int longitud) throws IOException {
        char[] cadena = new char[longitud];
        for (int i = 0; i < longitud; i++) {
            cadena[i] = archivo.readChar();
        }
        return new String(cadena).replace('\0', ' ').trim();
    }
}
