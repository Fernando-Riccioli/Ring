package com.example;

public class Context {
    private Strategy strategy;

    public void setStrategy(Strategy strategy){
        this.strategy = strategy;
    }

    public Credito aggiornaCredito(long durata, Credito credito){
        return strategy.aggiornaCredito(durata, credito);
    }
}
