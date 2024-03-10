package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class RingTest {

    static Ring ring;
    RuoloAziendale junior;

    @Before
    public void avvio(){
        ring = Ring.getInstance();
        junior = new RuoloAziendale("Junior");
    }

    @Test
    public void testInserimentoContatto(){
        try{
            //il film che si sta inserendo diventa corrente per Metropol
            ring.inserisciNuovoContatto("Mario", "Rossi", 1803045, junior);
            assertNotNull(ring.getcontattoCorrente());
        }catch(Exception e){
        fail("Eccezione");
        }   
    }

    @Test
    public void testConfermaInserimento(){
        try{
            ring.inserisciNuovoContatto("Mario", "Rossi", 1803045, junior);
            ring.confermaInserimento();
            assertEquals(1,ring.getElencoContatti().size());
            assertNotNull(ring.getContatto(1803045));
        }catch(Exception e){
            fail("Eccezione");
        } 
    }

    //
}
