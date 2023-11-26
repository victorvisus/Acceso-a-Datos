package com.cypherstudios.ad03.exceptions;

/**
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
                msjError = "mensaje no implementado";
                break;
            case 4:
                msjError = "mensaje no implementado";
                break;
            case 5:
                msjError = "mensaje no implementado";
                break;
            case 6:
                msjError = "mensaje no implementado";
                break;
            case 7:
                msjError = "mensaje no implementado";
                break;
            case 8:
                msjError = "mensaje no implementado";
                break;
            case 9:
                msjError = "mensaje no implementado";
                break;
            case 10:
                msjError = "mensaje no implementado";
                break;
            default:
                msjError = "Error de ejecución";
                break;
        }

        return msjError;
    }

}
