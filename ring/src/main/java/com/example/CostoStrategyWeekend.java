package com.example;

import java.util.Date;

public class CostoStrategyWeekend implements CostoStrategyInterface{

    @Override
    public Credito aggiornaCredito(long durata, boolean isChiamata, Credito credito) {
        /* 
        Date dataCorrente = new Date();
        @SuppressWarnings("deprecation")
        int giornoSettimana = dataCorrente.getDay();
        // Se il giorno è sabato (6) o domenica (0) uso il doppio del credito
        if (giornoSettimana == 6 || giornoSettimana == 0) {
            System.out.println("È sabato o domenica");
            numeroMessaggi--;
        } 
        System.out.println("Messaggi rimanenti: "+ numeroMessaggi);
        */


        return credito;
    }
}
