package carSharing.dtoUtenteRegisterInput;

import carSharing.validators.Validator;

import java.time.LocalDate;

public record UtenteRegisterRequest
        (
        String nome,
        String cognome,
        LocalDate dataDiNascita,
        String codiceFiscale
        )
{
        public UtenteRegisterRequest
        {
                Validator.requireNotBlank(nome);
                Validator.requireNotBlank(cognome);
                Validator.requireDateBefore(dataDiNascita, LocalDate.now());
                Validator.matchingPatterns(codiceFiscale, "^[A-Z]{6}\\d{2}[A-Z]\\d{2}[A-Z]\\d{3}[A-Z]$");
        }

}
