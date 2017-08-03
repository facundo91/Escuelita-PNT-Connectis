package com.dosideas.service;

public class Calculadora {

    public int sumar(int a, int b) {
        if (a == -b) {
            throw new IllegalArgumentException();
        }        
        return a + b;
    }
}
