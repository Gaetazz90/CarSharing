package carSharing.admin;

import carSharing.database.Database;
import carSharing.dtoUtenteRegisterInput.UtenteRegisterRequest;
import carSharing.entities.Utente;
import carSharing.entities.veicolo.Veicolo;
import carSharing.mappers.UtenteMapper;

public class Admin {

    public static Utente register(UtenteRegisterRequest request){

        Utente utente = UtenteMapper.toEntity(request);
        Database.addUtente(utente);

        return utente;

    }

    public static Veicolo insertVeicolo(Veicolo veicolo){

        Database.addVeicolo(veicolo);
        return veicolo;
    }

}
