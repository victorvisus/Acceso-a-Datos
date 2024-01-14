package PruebaMatricula;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Ppal {

    public static void main(String[] args) {

        AccedeBD gestion = new AccedeBD();

        gestion.listado();

        try {
            gestion.listadoDNI("12345678A");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Ppal.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }
}


