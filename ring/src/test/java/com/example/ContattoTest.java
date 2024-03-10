package com.example;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ContattoTest {

    Contatto mario;
    RuoloAziendale junior = new RuoloAziendale("Junior");
    RuoloAziendale senior = new RuoloAziendale("Senior");

    @Before
    public void avvio(){
        mario = new Contatto("Mario", "Rossi", 1803045, junior);
    }

    @After
    public void clear(){
        mario.setCredito(null);
    }

    @Test
    public void testNuovoCredito(){
        mario.setRuolo(senior);
        mario.nuovoCredito();
        Credito creditoMario = mario.getCredito();
        
        assertEquals(60000, creditoMario.getMinuti());
        assertEquals(1000, creditoMario.getNumeroMessaggi());
    }
}
