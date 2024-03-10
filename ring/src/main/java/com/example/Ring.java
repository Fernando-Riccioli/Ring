package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.BufferedReader ;

public class Ring {

	private static Ring ring;
	private Contatto contattoCorrente;
	private Map<Integer, Contatto> elencoContatti;
	private Map<String, RuoloAziendale> ruoli;
	private Chiamata chiamataCorrente;
	private List<Chiamata> elencoChiamate;

	private Messaggio messaggioCorrente;
	private List<Messaggio> elencoMessaggi;
	private Map<String, Messaggio> elencoMessaggiBroadcast;

	private Map<String,List<Contatto>> listaGruppi;

	//Strategy
	Context context = new Context();

	//Singleton
	private Ring() {
		this.listaGruppi = new HashMap<>();
		this.elencoContatti = new HashMap<>();
		this.ruoli = new HashMap<>();
		this.elencoMessaggiBroadcast = new HashMap<>();

		this.elencoChiamate = new ArrayList<>();
		this.elencoMessaggi = new ArrayList<>();

		loadRuoli();
	}

	public static Ring getInstance() {
		if (ring == null)
			ring = new Ring();
		else
			System.out.println("Istanza già creata");
		return ring;
	}

	public List<RuoloAziendale> getRuoli() {
		List<RuoloAziendale> listaRuoli = new ArrayList<>();
		listaRuoli.addAll(ruoli.values());
		return listaRuoli;
	}

	public Contatto inserisciNuovoContatto(String nome, String cognome, int numeroTelefono, RuoloAziendale ruolo) {
		this.contattoCorrente = new Contatto(nome, cognome, numeroTelefono, ruolo);
		System.out.println("Contatto Inserito");
		return contattoCorrente;
	}

	public void confermaInserimento() {
		if (contattoCorrente != null) {
			this.elencoContatti.put(contattoCorrente.getNumero(), contattoCorrente);
			System.out.println("Operazione Conferma Contatto Conclusa");
		}
	}

	public void loadRuoli() {
		RuoloAziendale r1 = new RuoloAziendale("Junior");
		RuoloAziendale r2 = new RuoloAziendale("Senior");
		RuoloAziendale r3 = new RuoloAziendale("Manager");
		this.ruoli.put("Junior", r1);
		this.ruoli.put("Senior", r2);
		this.ruoli.put("Manager", r3);
		System.out.println("Caricamento Ruoli Completato");
	}


	public List<Contatto> getElencoContatti() {
		List<Contatto> listContatto = new ArrayList<>();
		listContatto.addAll(elencoContatti.values());
		return listContatto;
	}

	public List<Chiamata> getElencoChiamate() {
		return elencoChiamate;
	}

	public List<Messaggio> getElencoMessaggi() {
		return elencoMessaggi;
	}

	public Contatto getcontattoCorrente() {
		return contattoCorrente;
	}

	public Contatto getContatto(int numeroTelefono) {
		return elencoContatti.get(numeroTelefono);
	}

	public void avviaChiamata(int numeroMittente, int numeroDestinatario) {
		Contatto mittente = elencoContatti.get(numeroMittente);
		Contatto destinatario = elencoContatti.get(numeroDestinatario);
		chiamataCorrente = new Chiamata(mittente, destinatario);
	}

	public void chiudiChiamata() {
		//Chiudo la chiamata
		chiamataCorrente.chiusura();

		//Aggiorno il credito tramite strategy
		Contatto mittente = chiamataCorrente.getMittente();
		Credito credito = mittente.getCredito();
		long durata = chiamataCorrente.getDurata();
		context.setStrategy(new StrategyChiamate());
		Credito nuovoCredito = context.aggiornaCredito(durata, credito);
		mittente.setCredito(nuovoCredito);
		elencoChiamate.add(chiamataCorrente);
	}

	public void inviaMessaggio(int numeroMittente, int numeroDestinatario) {
		Contatto mittente = elencoContatti.get(numeroMittente);
		Contatto destinatario = elencoContatti.get(numeroDestinatario);
		messaggioCorrente = new Messaggio(mittente, destinatario);
		messaggioCorrente.scriviTesto();
	}

	//Messaggio
	public void aggiornaCredito() {
		//Aggiorno il credito tramite Strategy
		Contatto mittente = messaggioCorrente.getMittente();
		Credito credito = mittente.getCredito();
		context.setStrategy(new StrategyMessaggi());
		Credito nuovoCredito = context.aggiornaCredito(0, credito);
		mittente.setCredito(nuovoCredito);

		//Aggiungo il messaggio alla lista messaggi
		elencoMessaggi.add(messaggioCorrente);
	}

	public void visualizzaChiamate(int numeroMittente) {
		for (int i = 0; i < elencoChiamate.size(); i++) {
			Chiamata chiamata = elencoChiamate.get(i);
			Contatto mittente = chiamata.getMittente();
			int numero = mittente.getNumero();
			if (numero == numeroMittente) {
				System.out.println(chiamata);
			}
		}
	}

	public void visualizzaMessaggi(int numeroMittente) {
		for (int i = 0; i < elencoMessaggi.size(); i++) {
			Messaggio messaggio = elencoMessaggi.get(i);
			Contatto mittente = messaggio.getMittente();
			int numero = mittente.getNumero();
			if (numero == numeroMittente) {
				System.out.println(messaggio);
			}
		}
	}

	public void modificaContatto(int numeroTelefono) {
		String scelta = null;
		String nuovoValore = null;
		Contatto contatto = elencoContatti.get(numeroTelefono);

		//Ottengo il parametro da modificare da tastiera
		System.out.println("Cosa vuoi modificare del contatto " + contatto.getNome() + "?");
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		try {
			scelta = input.readLine();

		} catch (Exception e) {
			System.out.println(e);
		}

		//Ottengo il nuovo valore da tastiera
		System.out.println("Inserisci il nuovo valore:");
		try {
			nuovoValore = input.readLine();

		} catch (Exception e) {
			System.out.println(e);
		}

		//Switch in base al parametro da modificare
		switch (scelta) {
			case "nome":
				contatto.setNome(nuovoValore);
				break;
			case "cognome":
				contatto.setCognome(nuovoValore);
				break;
			case "numero":
				contatto.setNumero(Integer.parseInt(nuovoValore));
				break;
			case "ruolo":
				contatto.getRuolo().setNome(nuovoValore);
				break;
			default:
				System.out.println("L'utente ha inserito una scelta errata");
		}
	}

	public void eliminaContatto(int numeroTelefono) {
		Contatto contatto = elencoContatti.get(numeroTelefono);
		for (Integer key : elencoContatti.keySet()) {
			contatto = elencoContatti.get(key);
			if (contatto.getNumero() == numeroTelefono) {
				elencoContatti.remove(key);
			}
		}
	}

	public void modificaPianoContatto(int numeroTelefono) {
		String testo=null;

		//Ottengo il nuovo ruolo da tastiera
		System.out.println("Inserire il nuovo ruolo");
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		Contatto contatto = elencoContatti.get(numeroTelefono);
		try {
			testo= input.readLine();

		} catch (Exception e) {
			System.out.println(e);
		}

		//Aggiorno il ruolo del contatto
		RuoloAziendale ruolo = ruoli.get(testo);
		contatto.setRuolo(ruolo);
		contatto.nuovoCredito();
	}

	public void visualizzaPianoResiduo(int numeroTelefono){
		Contatto contatto = elencoContatti.get(numeroTelefono);
		contatto.getCredito().pianoResiduo();
	}

	public void creaGruppoUtenti(){
		int numUtenti=0;
		int numTelefono=0;
		String nomeGruppo=null;

		//Ottengo il nome gruppo da tastiera
		System.out.println("Inserire il nome del gruppo");
		BufferedReader input0 = new BufferedReader(new InputStreamReader(System.in));
		try {
			nomeGruppo= input0.readLine();

		} catch (Exception e) {
			System.out.println(e);
		}
		List<Contatto> gruppoContatti = new ArrayList<>();

		//Ottengo il numero di utenti del gruppo da tastiera
		System.out.println("Inserire il numero di utenti del gruppo");
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		try {
			numUtenti= Integer.parseInt(input.readLine());

		} catch (Exception e) {
			System.out.println(e);
		}

		//Per ogni utente inserisco il numero di telefono
		for(int i=0;i<numUtenti;i++){
			System.out.println("Inserire il numero di telefono utente");
			BufferedReader input1 = new BufferedReader(new InputStreamReader(System.in));
			try {
				numTelefono=Integer.parseInt(input1.readLine());
				Contatto contatto = elencoContatti.get(numTelefono);
				gruppoContatti.add(contatto);

			} catch (Exception e) {
				System.out.println(e);
			}
		}

		//Inserisco il gruppo nella lista dei gruppi
		this.listaGruppi.put(nomeGruppo,gruppoContatti);
	}

	public void inviaMessaggioBroadcast(int numeroMittente, String nomeGruppo){

		//Prendo il gruppo contatti dalla lista
		Contatto mittente = elencoContatti.get(numeroMittente);
		List<Contatto> gruppoContatti = new ArrayList<>();
		gruppoContatti = listaGruppi.get(nomeGruppo);

		//Prendo il messaggio da tastiera
		Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci un messaggio di massimo 144 caratteri:");
        String input = scanner.nextLine();

		//Controllo la lunghezza del messaggio
        if (input.length() > 144) {
            System.out.println("Il testo supera i 144 caratteri.");
            input = input.substring(0, 144);
        }
        scanner.close();

		//Per ogni contatto invio un messaggio singolo
		for(int i=0;i<gruppoContatti.size();i++){
			Contatto destinatario = gruppoContatti.get(i);
			messaggioCorrente = new Messaggio(mittente, destinatario);
			messaggioCorrente.scriviTestoBroadcast(input);
		}

		//Aggiorno il credito tramite Strategy
		Credito creditoMittente = mittente.getCredito();
		context.setStrategy(new StrategyMessaggi());
		Credito nuovoCredito = context.aggiornaCredito(0, creditoMittente);
		mittente.setCredito(nuovoCredito);
		
		//Aggiungo il messaggio alla lista Messaggi Broadcast
		messaggioCorrente.setDestinatario(null);
		elencoMessaggiBroadcast.put(nomeGruppo, messaggioCorrente);
	}

	public void visualizzaMessaggiBroadcast(String nomeGruppo){
		//Visualizza l'ultimo messaggio broadcast di un gruppo
		Messaggio messaggio = elencoMessaggiBroadcast.get(nomeGruppo);
		System.out.println(messaggio);
	}
}
