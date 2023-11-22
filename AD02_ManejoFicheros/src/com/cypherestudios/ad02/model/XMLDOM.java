package com.cypherestudios.ad02.model;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Implementar la funcionalidad que permita visualizar todas las etiquetas del
 * fichero LIBROS.XML utilizando técnicas DOM
 *
 * @author Victor Visús
 */
public class XMLDOM {

    /**
     * Lee el archivo XML que contiene información de libros y muestra los
     * detalles de cada libro.
     *
     * @param filePath Ruta del archivo XML a ser procesado.
     */
    public void printXMLFileDOM(String filePath) {

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(filePath);
            // Normaliza la estructura del documento
            //doc.getDocumentElement().normalize();

            // Obtiene la lista de nodos 'libro'
            NodeList nodeList = doc.getElementsByTagName("libro");

            // Recorre la lista de nodos 'libro'
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) node;
                    System.out.println("Título: " + elemento.getElementsByTagName("titulo").item(0).getTextContent());

                    NodeList autores = elemento.getElementsByTagName("autor");
                    for (int j = 0; j < autores.getLength(); j++) {
                        Node autor = autores.item(j);
                        if (autor.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementoAutor = (Element) autor;
                            System.out.println("Autor: " + elementoAutor.getElementsByTagName("nombre").item(0).getTextContent() + " " + elementoAutor.getElementsByTagName("apellido").item(0).getTextContent());
                        }
                    }

                    System.out.println("Editorial: " + elemento.getElementsByTagName("editorial").item(0).getTextContent());
                    System.out.println("Año: " + elemento.getAttribute("anyo"));
                    System.out.println("Precio: " + elemento.getElementsByTagName("precio").item(0).getTextContent());
                    System.out.println("----------------------------------------------");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
