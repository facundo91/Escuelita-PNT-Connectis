package com.dosideas.service;

import static org.junit.Assert.*;
import org.junit.Test;

public class CalculadoraTest {
    
    @Test
    public void sumar_dosPositivos_retornaSumaPositiva() {
        Calculadora calc = new Calculadora();
        int sumar = calc.sumar(4, 5);
        assertEquals(9, sumar);
    }
    
    @Test
    public void sumar_dosNegativos_retornaSumaNegativa() {
        Calculadora calc = new Calculadora();
        int sumar = calc.sumar(-4, -5);
        assertEquals(-9, sumar);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void sumar_dosValoresQueSumenCero_lanzaExcepcion() {
        Calculadora calc = new Calculadora();
        int sumar = calc.sumar(5, -5);        
    }
    
}
