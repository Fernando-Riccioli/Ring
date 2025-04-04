# Ring - Progetto Ingegneria del Software 2023-2024

Ring è un software progettato per la gestione delle comunicazioni aziendali. Include chiamate, messaggi, una rubrica centralizzata e funzionalità avanzate per la gestione dei contatti e dei piani di abbonamento aziendali.

## Funzionalità Principali

- Gestione Contatti: Ogni utente dispone di una rubrica personale sincronizzata con un database centrale, aggiornato periodicamente dall'amministratore.
- Chiamate e Messaggi: Gli utenti possono effettuare chiamate, inviare messaggi singoli o broadcast, e visualizzare lo storico delle comunicazioni.
- Piani di Abbonamento: Ogni utente è associato a un piano aziendale basato sul proprio ruolo:
  - Junior: 500 minuti di chiamate e 500 messaggi mensili.
  - Senior: 1000 minuti di chiamate e 1000 messaggi mensili.
  - Manager: 2000 minuti di chiamate e 2000 messaggi mensili.
- Strategie di Consumo: Il sistema utilizza strategie per aggiornare il credito residuo in base al giorno della settimana (ad esempio, consumo doppio nei weekend).
- Gestione Gruppi: Creazione di gruppi di contatti per l'invio di messaggi broadcast.
- Amministrazione: L'amministratore può modificare, eliminare contatti e aggiornare i piani di abbonamento in base ai cambiamenti aziendali.

## Caratteristiche Tecniche

- Architettura: Implementazione basata sul pattern Singleton per la gestione centralizzata dell'istanza principale.
- Design Pattern: Utilizzo del pattern Strategy per la gestione del consumo di credito.
- Limiti Messaggi: I messaggi hanno un limite massimo di 144 caratteri.
- Persistenza Dati: I dati dei contatti e dei ruoli sono gestiti tramite strutture dati in memoria.