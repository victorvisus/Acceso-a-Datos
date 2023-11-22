package com.cypherestudios.ad02.model;

import com.cypherestudios.ad02.apartado01.LaunchApp01;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 * Se encarga de escribir datos de empleados almacenados en un archivo de acceso
 * aleatorio en un formato XML. Convirtiendo los datos de empleados almacenados
 * en un archivo de acceso aleatorio en un archivo XML estructurado.
 *
 * - A partir de los datos del fichero EMPLEADOS.DAT, crear un fichero llamado
 * EMPLEADOS.XML usando DOM. -> Clase: AlmacenarEmpleados
 *
 * @author Victor
 */
public class AlmacenarEmpleados {

    /**
     * Utiliza la API DOM para crear un documento XML que refleje la información
     * de los empleados. Cada empleado se representa como un conjunto de nodos
     * XML con detalles como código, nombre, dirección, salario, etc. Los nodos
     * XML generados se escriben en un archivo XML designado en el sistema de
     * archivos.
     *
     * @param datFileName
     */
    public static void escribirXML(String datFileName) {
        final String xmlFileName = "EMPLEADOS.XML";

        try {
            RandomAccessFile raf = new RandomAccessFile(datFileName, "r");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();

            Document document = implementation.createDocument(null, null, null);
            document.setXmlVersion("1.0");
            document.setXmlStandalone(true);

            Element rootEmpleados = document.createElement("Empleados");
            document.appendChild(rootEmpleados);

            int totalEmpleados = (int) (raf.length() / Empleado.TAMANIO_REGISTRO);

            int i = 0;
            while (i < totalEmpleados) {
                Empleado empleado = new Empleado();
                empleado.leerEmpleado(raf, i * Empleado.TAMANIO_REGISTRO);

                Element empleadoElement = document.createElement("empleado");
                rootEmpleados.appendChild(empleadoElement);

                //crea el nodo xml codigo **************************************
                Element codigoElement = document.createElement("codigo");
                Text txtCodigo = document.createTextNode(String.valueOf(empleado.getCodEmp()));
                codigoElement.appendChild(txtCodigo);
                empleadoElement.appendChild(codigoElement);
                //crea el nodo xml nombre **************************************
                Element nombreElement = document.createElement("nombre");
                Text txtNombre = document.createTextNode(empleado.getNombre());
                nombreElement.appendChild(txtNombre);
                empleadoElement.appendChild(nombreElement);
                //crea el nodo xml apellidos ***********************************
                Element apellidosElement = document.createElement("apellidos");
                Text txtApellidos = document.createTextNode(empleado.getApellidos());
                apellidosElement.appendChild(txtApellidos);
                empleadoElement.appendChild(apellidosElement);
                //crea el nodo xml direccion ***********************************
                Element direccionElement = document.createElement("direccion");
                Text txtDireccion = document.createTextNode(empleado.getDireccion());
                direccionElement.appendChild(txtDireccion);
                empleadoElement.appendChild(direccionElement);
                //crea el nodo xml poblacion ***********************************
                Element poblacionElement = document.createElement("poblacion");
                Text txtPoblacion = document.createTextNode(empleado.getPoblacion());
                poblacionElement.appendChild(txtPoblacion);
                empleadoElement.appendChild(poblacionElement);
                //crea el nodo xml cp ******************************************
                Element cpElement = document.createElement("cp");
                Text txtCp = document.createTextNode(String.valueOf(empleado.getCp()));
                cpElement.appendChild(txtCp);
                empleadoElement.appendChild(cpElement);
                //crea el nodo xml salario *************************************
                Element salarioElement = document.createElement("salario");
                Text txtSalario = document.createTextNode(String.valueOf(empleado.getSalario()));
                salarioElement.appendChild(txtSalario);
                empleadoElement.appendChild(salarioElement);
                //crea el nodo xml antiguedad **********************************
                Element antiguedadElement = document.createElement("antiguedad");
                Text txtAntiguedad = document.createTextNode(String.valueOf(empleado.getAntiguedad()));
                antiguedadElement.appendChild(txtAntiguedad);
                empleadoElement.appendChild(antiguedadElement);

                i++;
            }
            raf.close();

            // Transformar el documento en un archivo XML
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(xmlFileName);
            transformer.transform(source, result);
            System.out.println("Archivo EMPLEADOS.XML creado correctamente, puedes comprobar el archivo en el root de la carpeta del proyecto.");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(LaunchApp01.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException | TransformerException | IOException ex) {
            Logger.getLogger(LaunchApp01.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
