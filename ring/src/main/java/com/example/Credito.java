package com.example;

public class Credito {

	private long minuti;
    private int numeroMessaggi;
    
    public Credito(long minuti, int numeroMessaggi){
        this.minuti = minuti;
        this.numeroMessaggi = numeroMessaggi;
    }

    public void setMinuti(long minuti){
        this.minuti = minuti;
    }

    public long getMinuti() {
		return minuti;
	}

    public void setNumeroMessaggi(int numeroMessaggi){
        this.numeroMessaggi = numeroMessaggi;
    }

    public int getNumeroMessaggi(){
        return numeroMessaggi;
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