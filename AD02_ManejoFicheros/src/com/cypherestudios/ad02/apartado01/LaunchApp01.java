package com.cypherestudios.ad02.apartado01;

import com.cypherestudios.ad02.model.AlmacenarEmpleados;
import com.cypherestudios.ad02.model.Empleado;
import com.cypherestudios.ad02.model.GestionEmpleados;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * * Tarea AD02 - Acceso a Datos - Apartado 1
 *
 * Utilizando Netbeans, realizar una aplicación java que permita ejecutar al
 * usuario la siguiente funcionalidad:
 * -----------------------------------------------------------------------------
 * - Crear un fichero EMPLEADOS.DAT de acceso aleatorio, que inicialmente
 * contenga al menos ocho empleados. Dicho fichero tendrá la siguiente
 * estructura de campos para cada registro: CODEMP (int), NOMBRE (string),
 * APELLIDOS(string), DIRECCION (string), POBLACION (string), CP (int), SALARIO
 * (float) y ANTIGUEDAD (int). -> Clase: GestionEmpleados
 * -----------------------------------------------------------------------------
 * - A partir de los datos del fichero EMPLEADOS.DAT, crear un fichero llamado
 * EMPLEADOS.XML usando DOM. -> Clase: AlmacenarEmpleados
 *
 * @author Victor
 */
public class LaunchApp01 {

    public static void main(String[] args) {
        try {
            String fileName = "EMPLEADOS.DAT";

            /*
             * Seccion 1 - Crear fichero DAT con ocho empleados
             */
            ArrayList<Empleado> empleados = GestionEmpleados.crearEmpleados();
            GestionEmpleados.escribirEmpleadosEnArchivo(fileName, empleados);

            /*
             * Seccion 2- Crear ficher XML, usando DOM, a partir del fichero DAT
             * creado anteriormente
             */
            AlmacenarEmpleados.escribirXML(fileName);

        } catch (IOException ex) {
            Logger.getLogger(LaunchApp01.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
