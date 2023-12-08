package com.cypherstudios.ad03.model;

import java.util.ArrayList;

/**
 *
 * @author Victor
 */
public class PassengersArrayList {

    //Inicializa un atributo con el ArrayList
    private ArrayList<PassengerModel> publicPassengerModelList;

    //Constructor de la Clase
    public PassengersArrayList() {
        publicPassengerModelList = new ArrayList<>();
    }

    /**
     * Agrega un objeto a la lista. Este método permite añadir vuelos a la
     * lista.
     *
     * @param pass
     */
    public void attach(PassengerModel pass) {
        //Agrega un elemento al ArrayList
        publicPassengerModelList.add(pass);
    }

    /**
     * Recibe un índice como parámetro y devuelve el objeto que se encuentra en
     * esa posición dentro de la lista. Esto proporciona la capacidad de acceder
     * a un objeto específico en función de su posición en la lista.
     *
     * @param pos
     * @return
     */
    public PassengerModel getPassengerModel(int pos) {
        //Lee la posición de un elemento en el ArrayList
        return publicPassengerModelList.get(pos);
    }

    /**
     * Devuelve el tamaño de la lista. Proporciona información sobre la cantidad
     * total de objetos almacenados en la lista.
     *
     * @return
     */
    public int passengerCount() {
        //Devuelve el tamaño del ArrayList
        return publicPassengerModelList.size();
    }

}
