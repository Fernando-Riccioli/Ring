package com.example;

import java.util.List;

public class App {
	public static void main(String[] args) {
		Ring ring = Ring.getInstance();
		List<RuoloAziendale> ruoli = ring.getRuoli();
		//Test contatti
		System.out.println("Inserimento Nuovo Contatto");
		Contatto c1 = ring.inserisciNuovoContatto("Mario", "Rossi", 1803045, ruoli.get(0));
		ring.confermaInserimento();
		System.out.println("Inserimento Nuovo Contatto");
		Contatto c2 = ring.inserisciNuovoContatto("Luigi", "Verdi", 6708530, ruoli.get(1));
		ring.confermaInserimento();
		System.out.println(ring.getElencoContatti());
		
		//Test ruoli
		System.out.println(c1.getRuolo());
		System.out.println(c2.getRuolo());

		// c1.setCredito(new Credito(0, 0));

		//Test chiamata
		ring.avviaChiamata(1803045, 6708530);
		try{
			Thread.sleep(4000);
		} catch (Exception e){
			System.out.println(e);
		}
		ring.chiudiChiamata();
		System.out.println(ring.getElencoChiamate());

		// c1.setCredito(new Credito(0, 0));

		//test messaggio
		ring.inviaMessaggio(1803045, 6708530);
		ring.aggiornaCredito();
		System.out.println(ring.getElencoMessaggi());

		//visualizza chiamate e messaggi
		ring.visualizzaChiamate(1803045);
		ring.visualizzaMessaggi(1803045);

		//modifica contatto
		System.out.println("Modifica contatto");
		ring.modificaContatto(1803045);

		//modifica piano contatto
		System.out.println("Modifica Piano contatto");
		ring.modificaPianoContatto(1803045);

		//elimina contatto
		//System.out.println("Elimina contatto");
		//ring.eliminaContatto(1803045);

		System.out.println(c1);
		
		//visualizza piano residuo
		System.out.println("Visualizza Piano Residuo");
		ring.visualizzaPianoResiduo(1803045);

		//crea Gruppo Utenti
		System.out.println("Crea Gruppo Utenti");
		ring.creaGruppoUtenti();

		//Invia messaggio broadcast
		ring.inviaMessaggioBroadcast(1803045, "colleghi");

		//visualizza messaggi broadcast
		ring.visualizzaMessaggiBroadcast("colleghi");
	}
}