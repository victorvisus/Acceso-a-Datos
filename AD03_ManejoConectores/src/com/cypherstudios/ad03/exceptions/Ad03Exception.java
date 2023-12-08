package com.cypherstudios.ad03.exceptions;

/**
 * Clase de excepción personalizada para manejar errores específicos en la
 * aplicación Ad03. Extiende la clase Exception e incluye un código de error
 * para identificar el tipo de error. Además, proporciona mensajes descriptivos
 * para diferentes códigos de error.
 *
 * @author Victor
 */
public class Ad03Exception extends Exception {

    private int errorCode;

    public Ad03Exception() {
    }

    /**
     *
     * @param codigoError
     */
    public Ad03Exception(int codigoError) {
        super();
        this.errorCode = codigoError;
    }

    /**
     * Dependiendo del número de error recibido lanza un mensaje u otro
     *
     * @return mensaje de error
     */
    public String getMessage() {
        String msjError = "";
        System.out.println(errorCode);
        switch (errorCode) {

            case 1:
                msjError = "Funcionalidad no implementada";
                break;
            case 2:
                //Si la consulta no trae resultados
                msjError = "No se ha encontrado ningún pasajero";
                break;
            case 3:
                msjError = "Por favor, selecciona un vuelo";
                break;
            case 4:
                msjError = "No hay pasajeros para este vuelo";
                break;
            case 5:
                msjError = "Selecciona un pasajero de la tabla";
                break;
            case 6:
                msjError = "El vuelo del pasajero seleccionado no corresponde con el vuelo seleccionado para modificar.\n"
                        + "Elije un pasajero del vuelo seleccionado";
                break;
            case 7:
                msjError = "El vuelo que intentas dar de alta ya existe";
                break;
            case 8:
                msjError = "La hora no es correcta";
                break;
            case 9:
                msjError = "No se ha encontrado ningún pasajero, para el vuelo seleccionado";
                break;
            case 10:
                msjError = "No existen datos sobre los vuelos en la Base de datos.\n"
                        + "Por favor inserta los datos.";
                break;
            default:
                msjError = "Error de ejecución";
                break;
        }

        return msjError;
    }

}
