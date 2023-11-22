package com.cypherestudios.ad02.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Implementar la funcionalidad que permita visualizar todas las etiquetas del
 * fichero LIBROS.XML utilizando las técnicas SAX
 *
 * Procesa eventos SAX para analizar un archivo XML que contiene información
 * sobre libros. La implementación hereda de la clase DefaultHandler
 * proporcionada por SAX para manejar eventos como la apertura de etiquetas, el
 * cierre de etiquetas y la lectura de texto entre ellas.
 *
 * @author Victor Visús
 */
public class XMLSAX extends DefaultHandler {

    private String currentElement;
    private String titulo;
    private List<String> autores;
    private String editorial;
    private String anyo;
    private String precio;

    /**
     * Invocado cuando se encuentra una etiqueta de apertura, almacena el nombre
     * de la etiqueta actual e inicializa la lista de autores si la etiqueta
     * actual es "libro".
     *
     * @param uri
     * @param localName
     * @param qName
     * @param attributes
     * @throws SAXException
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;

        if ("libro".equals(qName)) {
            autores = new ArrayList<>();
        }
    }

    /**
     * Se ejecuta cuando se encuentra texto entre etiquetas. Según cual sea la
     * etiqueta, almacena la información en el atributo de clase
     * correspondiente.
     *
     * @param ch
     * @param start
     * @param length
     * @throws SAXException
     */
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String texto = new String(ch, start, length).trim();

        if (!texto.isEmpty()) {
            switch (currentElement) {
                case "titulo":
                    titulo = texto;
                    break;
                case "apellido":
                    if (autores != null) {
                        autores.add(texto);
                    }
                    break;
                case "nombre":
                    if (autores != null && !autores.isEmpty()) {
                        String ultimoAutor = autores.get(autores.size() - 1);
                        autores.set(autores.size() - 1, ultimoAutor + " " + texto);
                    }
                    break;
                case "editorial":
                    editorial = texto;
                    break;
                case "anyo":
                    anyo = texto;
                    break;
                case "precio":
                    precio = texto;
                    break;
            }
        }
    }

    /**
     * Cuando se encuentra una etiqueta de cierre, si la etiqueta es "libro",
     * imprime la información del libro en un formato específico y reinicia las
     * variables.
     *
     * @param uri
     * @param localName
     * @param qName
     * @throws SAXException
     */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("libro".equals(qName)) {
            // Imprimir el formato deseado
            System.out.println("Título: " + titulo);
            System.out.print("Autor: ");
            for (int i = 0; i < autores.size(); i++) {
                System.out.print(autores.get(i));
                if (i < autores.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
            System.out.println("Editorial: " + editorial);
            System.out.println("Año: " + anyo);
            System.out.println("Precio: " + precio);
            System.out.println("----------------------------------------------");

            // Restablecer las variables para el próximo libro
            titulo = null;
            autores = null;
            editorial = null;
            anyo = null;
            precio = null;
        }
    }

    /**
     * Imprime el contenido del archivo XML libros, creando instancias de
     * SAXParserFactory y SAXParser para procesar el archivo, y analizar su
     * contenido.
     *
     * @param filePath
     */
    public void printXMLFileSAX(String filePath) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse(new File(filePath), this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
