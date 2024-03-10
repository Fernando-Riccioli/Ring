package com.example;

import java.util.Date;

public class Chiamata {

	private long durata;
    private Date data;
    private Contatto mittente;
    private Contatto destinatario;

    public Chiamata(Contatto mittente, Contatto destinatario) {
		durata = 0;
        data = new Date();

        this.mittente = mittente;
        this.destinatario = destinatario;
        System.out.println("Chiamata iniziata...");
        durata = System.currentTimeMillis();
	}

    public void chiusura(){
        durata = (System.currentTimeMillis() - durata) / 1000;
        System.out.println("Chiamata terminata, durata: " + durata + " secondi.");
        }
    
    public long getDurata(){
        return durata;
    }

    public Contatto getMittente(){
        return mittente;
    }

    @Override
    public String toString() {
        return ("Chiamata da " + mittente.getNome() + " a " + destinatario.getNome() +
                ", durata " + Long.toString(durata) + " secondi, in data " + data.toString());
    }
}