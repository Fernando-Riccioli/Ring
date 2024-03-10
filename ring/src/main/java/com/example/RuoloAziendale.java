package com.example;

public class RuoloAziendale {

	private String nome;

	public RuoloAziendale (String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	//opt
	@Override
	public String toString() {
		return "Ruolo=" + nome;
	}

}
