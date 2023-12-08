package com.cypherstudios.ad03.model;

import java.util.Date;

/**
 *
 * @author Victor
 */
public class FlightModel {

    private String codVuelo;
    private String departureTime;
    private String flighDestination;
    private String flightOrigin;
    private int numEconomySeats;
    private int numFirstClassSeat;
    private int numNonSmokingSeat;
    private int numSmokingSeat;

    public FlightModel() {
    }
    public FlightModel(String codVuelo) {
        this.codVuelo = codVuelo;
    }

    public FlightModel(String codVuelo, String DepartureTime, String FlighDestination, String FlightOrigin, int NumEconomySeats, int NumFirstClassSeat, int NumNonSmokingSeat, int NumSmokingSeat) {
        this.codVuelo = codVuelo;
        this.departureTime = DepartureTime;
        this.flighDestination = FlighDestination;
        this.flightOrigin = FlightOrigin;
        this.numEconomySeats = NumEconomySeats;
        this.numFirstClassSeat = NumFirstClassSeat;
        this.numNonSmokingSeat = NumNonSmokingSeat;
        this.numSmokingSeat = NumSmokingSeat;
    }

    public String getCodVuelo() {
        return codVuelo;
    }

    public void setCodVuelo(String codVuelo) {
        this.codVuelo = codVuelo;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date dateDeparture, String hourDeparture) {
        String departure = "";

        Date date = dateDeparture;
        long d = date.getTime();
        java.sql.Date format = new java.sql.Date(d);

        departure = format + "-" + hourDeparture;

        this.departureTime = departure;
    }

    public void setDepartureTime(String departure) {
        this.departureTime = departure;
    }

    public String getFlighDestination() {
        return flighDestination;
    }

    public void setFlighDestination(String FlighDestination) {
        this.flighDestination = FlighDestination;
    }

    public String getFlightOrigin() {
        return flightOrigin;
    }

    public void setFlightOrigin(String FlightOrigin) {
        this.flightOrigin = FlightOrigin;
    }

    public int getNumEconomySeats() {
        return numEconomySeats;
    }

    public void setNumEconomySeats(int NumEconomySeats) {
        this.numEconomySeats = NumEconomySeats;
    }

    public int getNumFirstClassSeat() {
        return numFirstClassSeat;
    }

    public void setNumFirstClassSeat(int NumFirstClassSeat) {
        this.numFirstClassSeat = NumFirstClassSeat;
    }

    public int getNumNonSmokingSeat() {
        return numNonSmokingSeat;
    }

    public void setNumNonSmokingSeat(int NumNonSmokingSeat) {
        this.numNonSmokingSeat = NumNonSmokingSeat;
    }

    public int getNumSmokingSeat() {
        return numSmokingSeat;
    }

    public void setNumSmokingSeat(int NumSmokingSeat) {
        this.numSmokingSeat = NumSmokingSeat;
    }

    @Override
    public String toString() {
        return "Datos del vuelo\n" + "codVuelo: " + codVuelo + ", DepartureTime: " + departureTime + ", FlighDestination: " + flighDestination + ", FlightOrigin: " + flightOrigin + "\nNumEconomySeats: " + numEconomySeats + ", NumFirstClassSeat: " + numFirstClassSeat + ", NumNonSmokingSeat: " + numNonSmokingSeat + ", NumSmokingSeat: " + numSmokingSeat + '}';
    }

}
