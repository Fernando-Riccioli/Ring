package com.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;

public class Messaggio {

    private String testo;
    private Date data;
    private Contatto mittente;
    private Contatto destinatario;

    public Messaggio(Contatto mittente, Contatto destinatario) {
        data = new Date();
        this.mittente = mittente;
        this.destinatario = destinatario;
	}

    public void scriviTesto(){
        System.out.println("Inserire il messaggio.");
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		try {
			testo = input.readLine();

		} catch (Exception e) {
			System.out.println(e);
		}
        //Controllo che il testo sia inferiore a 144 caratteri
        if (testo.length() > 144) {
            System.out.println("Il testo supera i 144 caratteri.");
            testo = testo.substring(0, 144);
        }
        System.out.println("Messaggio inserito");
    }

    public void scriviTestoBroadcast(String testo){
        this.testo = testo;
    }

    public void setMittente(Contatto mittente){
        this.mittente = mittente;
    }

    public Contatto getMittente(){
        return mittente;
    }

    public String getTesto(){
        return testo;
    }

    public void setDestinatario(Contatto destinatario){
        this.destinatario = destinatario;
    }

    @Override
    public String toString() {
        return ("Messaggio da " + mittente.getNome() + " a " + destinatario.getNome() +
                " in data " + data.toString() + ". Testo: " + testo);
    }
}