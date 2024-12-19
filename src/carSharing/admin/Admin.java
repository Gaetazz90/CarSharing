package carSharing.admin;

import carSharing.database.Database;
import carSharing.dtoUtenteRegisterInput.UtenteRegisterRequest;
import carSharing.entities.noleggio.Noleggio;
import carSharing.entities.utente.Utente;
import carSharing.entities.veicolo.Veicolo;
import carSharing.mappers.UtenteMapper;

import java.util.List;

//Singleton
public class Admin {

    private static Admin instance;

    private Admin(){};

    public static Admin getInstance(){
        if(instance != null)
            return instance;
        else{
            instance = new Admin();
            return instance;
        }
    }

    public static Utente registerUtente(UtenteRegisterRequest request){
        Utente utente = UtenteMapper.toEntity(request);
        Database.addUtente(utente);
        return utente;
    }

    public static Veicolo insertVeicolo(Veicolo veicolo){
        Database.addVeicolo(veicolo);
        return veicolo;
    }

    public static Veicolo getVeicoloById(Integer id){
        return Database.getVeicoloById(id);
    }

    public static Noleggio insertNoleggio(Noleggio noleggio){
        Database.addNoleggio(noleggio);
        return noleggio;
    }

    public static List<Noleggio> getNoleggioByVeicoloId(Integer id_veicolo){
        return Database.getNoleggiByVeicoloID(id_veicolo);
    }

    public static List<Veicolo> getAllVeicoli(){
        return Database.getAllVeicoli();
    }

}
