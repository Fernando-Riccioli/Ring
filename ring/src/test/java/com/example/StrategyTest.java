package com.example;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StrategyTest {

    Credito credito = new Credito(1000, 100);
    Context context;
    boolean isWeekend = false;

    @Before
    public void avvio(){
        context = new Context();

        //Ottengo il giorno corrente
        Date dataCorrente = new Date();
        @SuppressWarnings("deprecation")
        int giornoSettimana = dataCorrente.getDay();
        if (giornoSettimana == 6 || giornoSettimana == 0)
            isWeekend = true;
    }

    @After
    public void clear(){
        isWeekend = false;
        credito = null;
    }

    //Test messaggi
    @Test 
    public void testAggiornaCreditoMessaggi(){
        context.setStrategy(new StrategyMessaggi());
        credito = context.aggiornaCredito(0, credito);
        if (isWeekend)
            assertEquals(98, credito.getNumeroMessaggi());
        if (!isWeekend)
            assertEquals(99, credito.getNumeroMessaggi());
    }
    
    //Test chiamate
    @Test 
    public void testAggiornaCreditoChiamate(){
        context.setStrategy(new StrategyChiamate());
        credito = context.aggiornaCredito(50, credito);
        if (isWeekend)
            assertEquals(900, credito.getMinuti());
        if (!isWeekend)
            assertEquals(950, credito.getMinuti());
    }
}
