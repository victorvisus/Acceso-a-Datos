package com.cypherstudios.ad03.model;

import java.util.ArrayList;

/**
 *
 * @author Victor
 */
public class FlightArrayList {

    //Inicializa un atributo con el ArrayList
    private ArrayList<FlightModel> publicFlightModelList;

    //Constructor de la Clase
    public FlightArrayList() {
        publicFlightModelList = new ArrayList<>();
    }

    /**
     * Agrega un objeto a la lista. Este método permite añadir vuelos a la
     * lista.
     *
     * @param fly
     */
    public void attach(FlightModel fly) {
        //Agrega un elemento al ArrayList
        publicFlightModelList.add(fly);
    }

    /**
     * Recibe un índice como parámetro y devuelve el objeto que se encuentra en
     * esa posición dentro de la lista. Esto proporciona la capacidad de acceder
     * a un objeto específico en función de su posición en la lista.
     *
     * @param pos
     * @return
     */
    public FlightModel getFlightModel(int pos) {
        //Lee la posición de un elemento en el ArrayList
        return publicFlightModelList.get(pos);
    }

    /**
     * Devuelve el tamaño de la lista. Proporciona información sobre la cantidad
     * total de objetos almacenados en la lista.
     *
     * @return
     */
    public int flightCount() {
        //Devuelve el tamaño del ArrayList
        return publicFlightModelList.size();
    }

}
