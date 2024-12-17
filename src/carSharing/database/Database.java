package carSharing.database;

import carSharing.entities.utente.Utente;
import carSharing.entities.noleggio.Noleggio;
import carSharing.entities.veicolo.Veicolo;

import java.util.HashMap;

public class Database {

    public static HashMap<Integer, Utente> utenti;
    public static HashMap<Integer, Veicolo> veicoli;
    public static HashMap<Integer, Noleggio> noleggi;

    public static void addUtente(Utente utente){
        utenti.put(utente.getId(), utente);
    }

    public static void addVeicolo(Veicolo veicolo){
        veicoli.put(veicolo.getId(), veicolo);
    }

    public static Veicolo getVeicolo(Veicolo veicolo){
        if(veicolo == null){
            System.out.println("Veicolo selezionato non disponbibile");
            return null;
        }
        Veicolo veicoloSelezionato = veicoli.get(veicolo.getId());
        return veicoloSelezionato;
    }

    public static void addNoleggio(Noleggio noleggio){
        noleggi.put(noleggio.getId(), noleggio);
    }


}
