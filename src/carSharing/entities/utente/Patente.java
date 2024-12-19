package carSharing.entities.utente;

import carSharing.validators.Validator;

import java.time.LocalDate;

public class Patente {

    private static Integer idTot = 0;
    private Integer id;
    private String numeroPatente;
    private TipoPatente tipoPatente;
    private Utente nomeUtente;
    private LocalDate dataDiScadenza;


    public Patente(String numeroPatente, TipoPatente tipoPatente, Utente nomeUtente, LocalDate dataDiScadenza) {
        Validator.matchingPatterns(numeroPatente, "^[A-Z]{2}\\d{6}[A-Z]\\d{3}$\n");
        Validator.requireDateAfter(dataDiScadenza, LocalDate.now());
        Validator.requireNotNull(tipoPatente);
        Validator.requireNotNull(nomeUtente);
        this.id = ++idTot;
        this.numeroPatente = numeroPatente;
        this.tipoPatente = tipoPatente;
        this.nomeUtente = nomeUtente;
        this.dataDiScadenza = dataDiScadenza;
    }

    public Integer getId() {
        return id;
    }

    public String getNumeroPatente() {
        return numeroPatente;
    }

    public void setNumeroPatente(String numeroPatente) {
        this.numeroPatente = numeroPatente;
    }

    public TipoPatente getTipoPatente() {
        return tipoPatente;
    }

    public void setTipoPatente(TipoPatente tipoPatente) {
        this.tipoPatente = tipoPatente;
    }

    public Utente getNomeUtente() {
        return nomeUtente;
    }

    public void setNomeUtente(Utente nomeUtente) {
        this.nomeUtente = nomeUtente;
    }

    public LocalDate getDataDiScadenza() {
        return dataDiScadenza;
    }

    public void setDataDiScadenza(LocalDate dataDiScadenza) {
        this.dataDiScadenza = dataDiScadenza;
    }


}
