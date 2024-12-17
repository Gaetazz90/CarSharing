package carSharing.mappers;

import carSharing.dtoUtenteRegisterInput.UtenteRegisterRequest;
import carSharing.entities.Utente;

public class UtenteMapper {

    public static Utente toEntity(UtenteRegisterRequest request){

        Utente utente = new Utente();

        utente.setNome(request.nome());
        utente.setCognome(request.cognome());
        utente.setDataDiNascita(request.dataDiNascita());
        utente.setCodiceFiscale(request.codiceFiscale());

        return utente;
    }

}
