package com.example;

import java.util.Date;

public class Credito {

	private long minuti;
    private int numeroMessaggi;
    
    public Credito(long minuti, int numeroMessaggi){
        this.minuti = minuti;
        this.numeroMessaggi = numeroMessaggi;
    }

    public long getMinuti() {
		return minuti;
	}

    public int getNumeroMessaggi(){
        return numeroMessaggi;
    }

    public void aggiornaCredito(long durata){
        this.minuti -= durata;
        Date dataCorrente = new Date();
        @SuppressWarnings("deprecation")
        int giornoSettimana = dataCorrente.getDay();
        // Se il giorno è sabato (6) o domenica (0) uso il doppio del credito
        if (giornoSettimana == 6 || giornoSettimana == 0) {
            System.out.println("È sabato o domenica");
            this.minuti -= durata;
        } 
        System.out.println("Minuti (secondi) rimanenti: "+ minuti);
    }

    public void aggiornaCredito(){
        numeroMessaggi--;
        Date dataCorrente = new Date();
        @SuppressWarnings("deprecation")
        int giornoSettimana = dataCorrente.getDay();
        // Se il giorno è sabato (6) o domenica (0) uso il doppio del credito
        if (giornoSettimana == 6 || giornoSettimana == 0) {
            System.out.println("È sabato o domenica");
            numeroMessaggi--;
        } 
        System.out.println("Messaggi rimanenti: "+ numeroMessaggi);
    }

    public void addCredit(long minuti, int messaggi ){
        this.minuti+=minuti;
        this.numeroMessaggi+=messaggi;
    }

    /*public void annullaCredito(){
        this.minuti=(long)0;
        this.numeroMessaggi=0;
    }*/

    public void pianoResiduo() {
        System.out.println("Minuti rimanenti: "+ this.minuti);
        System.out.println("Messaggi rimanenti: "+ this.numeroMessaggi);
    }
}