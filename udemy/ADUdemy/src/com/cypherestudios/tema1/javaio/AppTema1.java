package com.cypherestudios.tema1.javaio;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Victor
 */
public class AppTema1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Crea el directorio
        File directorio = new File("fichero");
        if (!directorio.mkdir() & !directorio.exists()) {
            System.err.println("No se ha podido crear el directorio");
            System.exit(-1);
        }

        //Crea el fichero
        File fichero = new File(directorio, "fichero.txt");

        try {
            fichero.createNewFile();

        } catch (IOException ex) {
            //Logger.getLogger(AppTema1.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("No se ha podido crear el fichero" + "\n"
                    + ex.getMessage());
            System.exit(-1);
        }
    }

}
