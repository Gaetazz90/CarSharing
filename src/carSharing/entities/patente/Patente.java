package carSharing.entities.patente;

import carSharing.entities.Utente;

import java.time.LocalDate;

public class Patente {

    private static Integer idTot = 0;
    private Integer id;
    private String numeroPatente;
    private TipoPatente tipoPatente;
    private Utente nomeUtente;
    private LocalDate dataDiScadenza;


    public Patente(Integer id, String numeroPatente, TipoPatente tipoPatente, Utente nomeUtente, LocalDate dataDiScadenza) {
        this.id = ++id;
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
