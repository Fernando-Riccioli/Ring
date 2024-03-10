package com.example;

import java.util.Date;

public class StrategyChiamate implements Strategy{

    @Override
    public Credito aggiornaCredito(long durata, Credito credito) {
        long minuti = credito.getMinuti();
        minuti -= durata;
        Date dataCorrente = new Date();
        
        @SuppressWarnings("deprecation")
        int giornoSettimana = dataCorrente.getDay();
        // Se il giorno è sabato (6) o domenica (0) uso il doppio del credito
        if (giornoSettimana == 6 || giornoSettimana == 0) {
            System.out.println("È sabato o domenica");
            minuti -= durata;
        } 
        System.out.println("Minuti (secondi) rimanenti: "+ minuti);
        credito.setMinuti(minuti);
        return credito;
    }
}
