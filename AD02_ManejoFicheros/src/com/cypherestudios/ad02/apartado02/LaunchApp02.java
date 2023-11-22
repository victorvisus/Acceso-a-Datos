package com.cypherestudios.ad02.apartado02;

import com.cypherestudios.ad02.model.XMLDOM;
import com.cypherestudios.ad02.model.XMLSAX;

/**
 * Tarea AD02 - Acceso a Datos - Apartado 2
 *
 * Implementar la funcionalidad que permita visualizar todas las etiquetas del
 * fichero LIBROS.XML utilizando las técnicas DOM y SAX.
 *
 * @author Victor Visús
 */
public class LaunchApp02 {

    public static void main(String[] args) {
        String nomFile = "libros.xml";

        /**
         * Técnicas DOM ********************************************************
         */
        System.out.println("LIBROS.XML - Técnicas DOM --------------------\n");

        XMLDOM verXMLDom = new XMLDOM();
        verXMLDom.printXMLFileDOM(nomFile);

        System.out.println("\nFIN LIBROS.XML - Técnicas DOM ----------------\n");

        System.out.println("/--------------------------------------------/\n");

        /**
         * Técnicas SAX ********************************************************
         */
        System.out.println("LIBROS.XML - Técnicas SAX --------------------\n");

        XMLSAX saxHandler = new XMLSAX();
        saxHandler.printXMLFileSAX(nomFile);

        System.out.println("\nFIN LIBROS.XML - Técnicas SAX ----------------\n");

    }

}
