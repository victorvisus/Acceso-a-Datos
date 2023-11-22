package com.cypherestudios.ad02.model;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase para gestionar la creación de empleados y escribirlos en un archivo.
 *
 * Crear un fichero EMPLEADOS.DAT de acceso aleatorio, que inicialmente contenga
 * al menos ocho empleados. Dicho fichero tendrá la siguiente estructura de
 * campos para cada registro: CODEMP (int), NOMBRE (string), APELLIDOS(string),
 * DIRECCION (string), POBLACION (string), CP (int), SALARIO (float) y
 * ANTIGUEDAD (int). -> Clase: GestionEmpleados
 *
 * @author Victor Visús
 */
public class GestionEmpleados {

    /**
     * Crea una lista de ocho empleados.
     *
     * @return ArrayList de empleados
     * @throws IOException Si hay un problema al crear empleados.
     */
    public static ArrayList<Empleado> crearEmpleados() throws IOException {
        ArrayList<Empleado> empleados = new ArrayList<>();

        // Creamos los ocho empleados, y se almacenan en el ArrayList
        empleados.add(new Empleado(1, "Antonio", "Rogriguez Menda", "Calle de A. Rodriguez, 3", "Albacete", 02002, 1500, 3));
        empleados.add(new Empleado(2, "Aitor", "Erastegui Mujica", "Calle de A. E. Mujica, 34", "Bilbao", 48007, 1700, 1));
        empleados.add(new Empleado(3, "Miguel Angel", "Garcia Fijinoca", "Calle de M.A. Garcia, 5", "Cuenca", 16004, 1200, 1));
        empleados.add(new Empleado(4, "Isabela", "de la Palma", "Calle de Isabelina, 6", "Segovia", 40002, 1780, 5));
        empleados.add(new Empleado(5, "Ana Maria", "Ferrer Bernad", "Calle de A. Bernad Perez, 65", "Gijón", 33207, 1400, 2));
        empleados.add(new Empleado(6, "Victor", "García Yo", "Calle de Victor, 18", "Zaragoza", 50002, 1700, 5));
        empleados.add(new Empleado(7, "Jesus", "Villaplana Lahoz", "Calle de Jesus Lahoz, 3", "Teruel", 44002, 2500, 8));
        empleados.add(new Empleado(8, "Marta", "Ballester Rubio", "Calle de Martita, 96", "Madrid", 28080, 1500, 3));

        return empleados;
    }

    /**
     * Escribe la lista de empleados en un archivo de acceso aleatorio.
     *
     * @param fileName Nombre del archivo.
     * @param empleados Lista de empleados.
     * @throws IOException Si hay un problema al escribir empleados en el
     * archivo.
     */
    public static void escribirEmpleadosEnArchivo(String fileName, ArrayList<Empleado> empleados) throws IOException {
        File file = new File(fileName);

        try (RandomAccessFile raf = new RandomAccessFile(file, "rw")) {
            for (Empleado emp : empleados) {
                emp.escribirEmpleado(raf);
            }
        } catch (IOException ex) {
            Logger.getLogger(GestionEmpleados.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }

    }
}
