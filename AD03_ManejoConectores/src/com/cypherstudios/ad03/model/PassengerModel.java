package com.cypherstudios.ad03.model;

/**
 *
 * @author Victor
 */
public class PassengerModel {

    private int num;
    private String codVuelo;
    private String seatPass;
    private String smoking;

    public PassengerModel() {
    }
    public PassengerModel(int num, String codVuelo) {
        this.num = num;
        this.codVuelo = codVuelo;
    }

    public PassengerModel(int num, String codVuelo, String seatPass, String smoking) {
        this.num = num;
        this.codVuelo = codVuelo;
        this.seatPass = seatPass;
        this.smoking = smoking;
    }

    public int getNum() {
        return this.num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getCodVuelo() {
        return this.codVuelo;
    }

    public void setCodVuelo(String codVuelo) {
        this.codVuelo = codVuelo;
    }

    public String getSeatPass() {
        return this.seatPass;
    }

    public void setSeatPass(String seatPass) {
        this.seatPass = seatPass;
    }

    public String getSmoking() {
        return this.smoking;
    }

    public void setSmoking(String smoking) {
        this.smoking = smoking;
    }

    @Override
    public String toString() {
        return "PassengerModel{" + "num=" + num + ", codVuelo=" + codVuelo + ", seatPass=" + seatPass + ", smoking=" + smoking + '}';
    }


}
