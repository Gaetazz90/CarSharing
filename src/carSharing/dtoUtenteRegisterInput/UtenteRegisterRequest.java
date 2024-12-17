package carSharing.dtoUtenteRegisterInput;

import java.time.LocalDate;

public record UtenteRegisterRequest
        (
        String nome,
        String cognome,
        LocalDate dataDiNascita,
        String codiceFiscale
        )
{


}
