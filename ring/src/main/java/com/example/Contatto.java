package com.example;

public class Contatto {

	private String nome;
	private String cognome;
	private int numeroTelefono;
	private RuoloAziendale ruolo;
	private Credito credito;

	public void nuovoCredito(){
		String nome = ruolo.getNome();
		//Junior
		if(nome.equals("Junior"))
			this.credito = new Credito(30000, 500);
		//Senior
		if(nome.equals("Senior"))
			this.credito = new Credito(60000, 1000);
		//Manager
		if(nome.equals("Manager"))
			this.credito = new Credito(120000, 2000);
	}

	public Contatto(String nome, String cognome, int numeroTelefono, RuoloAziendale ruolo){
		this.nome = nome;
		this.cognome = cognome;
		this.numeroTelefono = numeroTelefono;
		this.ruolo = ruolo;

		this.nuovoCredito();
	}

	public void inizializzaCredito(){}

	public void setNumero(int numero) {
		this.numeroTelefono = numero;
	}

	public int getNumero() {
		return numeroTelefono;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCognome() {
		return cognome;
	}

	public RuoloAziendale getRuolo() {
		return ruolo;
	}

	public void setRuolo (RuoloAziendale ruolo) {
		this.ruolo = ruolo;
	}

	public Credito getCredito() {
		return credito;
	}

	public void setCredito (Credito credito) {
		this.credito = credito;
	}

	@Override
	public String toString() {
		return nome + " " + cognome + " " + numeroTelefono + " " + ruolo.getNome();
	}
}
