package carSharing.admin;

import carSharing.database.Database;
import carSharing.dtoUtenteRegisterInput.UtenteRegisterRequest;
import carSharing.entities.utente.Utente;
import carSharing.entities.veicolo.Veicolo;
import carSharing.mappers.UtenteMapper;

public class Admin {

    public static Utente registerUtente(UtenteRegisterRequest request){

        Utente utente = UtenteMapper.toEntity(request);

        Database.addUtente(utente);

        return utente;

    }

    public static Veicolo insertVeicolo(Veicolo veicolo){
        Database.addVeicolo(veicolo);
        return veicolo;
    }

}
