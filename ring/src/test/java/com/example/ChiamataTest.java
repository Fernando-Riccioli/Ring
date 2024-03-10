package com.example;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ChiamataTest {

    Chiamata chiamata;

    @Before
    public void avvio(){
        RuoloAziendale junior = new RuoloAziendale("Junior");
        RuoloAziendale senior = new RuoloAziendale("Senior");
        Contatto mario = new Contatto("Mario", "Rossi", 1803045, junior);
        Contatto luigi = new Contatto("Luigi", "Verdi", 6708530, senior);
        chiamata = new Chiamata(mario, luigi);
    }

    @After
    public void clear(){
        chiamata = null;
    }

    @Test
    public void testChiusura(){
        try{
            //La chiamata dura 5 secondi
			Thread.sleep(5000);
		} catch (Exception e){
			System.out.println(e);
		}
        chiamata.chiusura();
        assertEquals(5, chiamata.getDurata());
    }
    
}
