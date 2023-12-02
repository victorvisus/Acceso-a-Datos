package com.cypherstudios.ad03.model;

import java.util.Date;

/**
 *
 * @author Victor
 */
public class FlightModel {

    private String codVuelo;
    private Date DepartureTime;
    private String FlighDestination;
    private String FlightOrigin;
    private String NumEconomySeats;
    private String NumFirstClassSeat;
    private String NumNonSmokingSeat;
    private String NumSmokingSeat;

    public FlightModel() {
    }
    public FlightModel(String codVuelo) {
        this.codVuelo = codVuelo;
    }

    public FlightModel(String codVuelo, Date DepartureTime, String FlighDestination, String FlightOrigin, String NumEconomySeats, String NumFirstClassSeat, String NumNonSmokingSeat, String NumSmokingSeat) {
        this.codVuelo = codVuelo;
        this.DepartureTime = DepartureTime;
        this.FlighDestination = FlighDestination;
        this.FlightOrigin = FlightOrigin;
        this.NumEconomySeats = NumEconomySeats;
        this.NumFirstClassSeat = NumFirstClassSeat;
        this.NumNonSmokingSeat = NumNonSmokingSeat;
        this.NumSmokingSeat = NumSmokingSeat;
    }

    public String getCodVuelo() {
        return codVuelo;
    }

    public void setCodVuelo(String codVuelo) {
        this.codVuelo = codVuelo;
    }

    public Date getDepartureTime() {
        return DepartureTime;
    }

    public void setDepartureTime(Date DepartureTime) {
        this.DepartureTime = DepartureTime;
    }

    public String getFlighDestination() {
        return FlighDestination;
    }

    public void setFlighDestination(String FlighDestination) {
        this.FlighDestination = FlighDestination;
    }

    public String getFlightOrigin() {
        return FlightOrigin;
    }

    public void setFlightOrigin(String FlightOrigin) {
        this.FlightOrigin = FlightOrigin;
    }

    public String getNumEconomySeats() {
        return NumEconomySeats;
    }

    public void setNumEconomySeats(String NumEconomySeats) {
        this.NumEconomySeats = NumEconomySeats;
    }

    public String getNumFirstClassSeat() {
        return NumFirstClassSeat;
    }

    public void setNumFirstClassSeat(String NumFirstClassSeat) {
        this.NumFirstClassSeat = NumFirstClassSeat;
    }

    public String getNumNonSmokingSeat() {
        return NumNonSmokingSeat;
    }

    public void setNumNonSmokingSeat(String NumNonSmokingSeat) {
        this.NumNonSmokingSeat = NumNonSmokingSeat;
    }

    public String getNumSmokingSeat() {
        return NumSmokingSeat;
    }

    public void setNumSmokingSeat(String NumSmokingSeat) {
        this.NumSmokingSeat = NumSmokingSeat;
    }

    @Override
    public String toString() {
        return "FlightModel{" + "codVuelo=" + codVuelo + ", DepartureTime=" + DepartureTime + ", FlighDestination=" + FlighDestination + ", FlightOrigin=" + FlightOrigin + ", NumEconomySeats=" + NumEconomySeats + ", NumFirstClassSeat=" + NumFirstClassSeat + ", NumNonSmokingSeat=" + NumNonSmokingSeat + ", NumSmokingSeat=" + NumSmokingSeat + '}';
    }

}
