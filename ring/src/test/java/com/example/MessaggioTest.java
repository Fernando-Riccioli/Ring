package com.example;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MessaggioTest {

    Messaggio messaggio;

    @Before
    public void avvio(){
        RuoloAziendale junior = new RuoloAziendale("Junior");
        RuoloAziendale senior = new RuoloAziendale("Senior");
        Contatto mario = new Contatto("Mario", "Rossi", 1803045, junior);
        Contatto luigi = new Contatto("Luigi", "Verdi", 6708530, senior);
        messaggio = new Messaggio(mario, luigi);
    }

    @After
    public void clear(){
        messaggio.setMittente(null);
        messaggio.setDestinatario(null);
    }

    /* System.in
    @Test
    public void testMessaggio(){
        messaggio.scriviTesto();
        assertNotNull(messaggio.getTesto());
    }
    */

    @Test
    public void testMessaggioBroadcast(){
        messaggio.scriviTestoBroadcast("Messaggio broadcast.");
        assertEquals("Messaggio broadcast.", messaggio.getTesto());
    }
}
