package com.example;

import java.util.Date;

public class StrategyMessaggi implements Strategy{

    @Override
    public Credito aggiornaCredito(long durata, Credito credito) {
        int numeroMessaggi = credito.getNumeroMessaggi();
        numeroMessaggi--;
        Date dataCorrente = new Date();
        
        @SuppressWarnings("deprecation")
        int giornoSettimana = dataCorrente.getDay();
        // Se il giorno è sabato (6) o domenica (0) uso il doppio del credito
        if (giornoSettimana == 6 || giornoSettimana == 0) {
            numeroMessaggi--;
        } 
        System.out.println("Messaggi rimanenti: "+ numeroMessaggi);
        credito.setNumeroMessaggi(numeroMessaggi);
        return credito;
    }
}
