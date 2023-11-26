/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cypherstudios.ad03.utils;

import com.cypherstudios.ad03.exceptions.Ad03Exception;

/**
 *
 * @author Victor
 */
public class utils {

    /**
     * Evalua si la consulta trae resultados
     *
     * @param num
     * @return
     * @throws Ad03Exception
     */
    public static int evaluteResult(int num) throws Ad03Exception {
        if (num == 0) {
            throw new Ad03Exception(2);
        }
        return num;
    }
}
