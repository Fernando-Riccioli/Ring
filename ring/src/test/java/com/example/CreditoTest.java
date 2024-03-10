package com.example;

import java.util.Date;

import org.junit.After;
import org.junit.Before;

public class CreditoTest {

    Credito credito;
    Date dataCorrente;
    int giornoSettimana;
    boolean isWeekend = false;

    @SuppressWarnings("deprecation")
    @Before
    public void avvio(){
        credito = new Credito(30000, 500);
        dataCorrente = new Date();
        giornoSettimana = dataCorrente.getDay();
        if (giornoSettimana == 6 || giornoSettimana == 0) {
            isWeekend = true;
        } 
    }

    @After
    public void clear(){
        credito = null;
    }

    /* 
    @Test
    public void testAggiornaCreditoMessaggi(){
        credito.aggiornaCredito(50);
        //Il weekend consuma il doppio
        if (isWeekend)
            assertEquals(29900, credito.getMinuti());
        if (!isWeekend)
            assertEquals(29950, credito.getMinuti());
    }

    @Test
    public void testAggiornaCreditoChiamate(){
        credito.aggiornaCredito();
        if (isWeekend)
            assertEquals(498, credito.getNumeroMessaggi());
        if (!isWeekend)
            assertEquals(499, credito.getNumeroMessaggi());
    }
    */
}
