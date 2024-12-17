package carSharing.entities;

import carSharing.entities.patente.Patente;

import java.time.LocalDate;

public class Utente {

    private static Integer idTot = 0;
    private Integer id;
    private String nome;
    private String cognome;
    private LocalDate dataDiNascita;
    private String codiceFiscale;
    private Patente patente;
    private Boolean hasCasco;
    private Double credito;

    public Utente(){
        this.id = ++idTot;
    };

    public Utente(Integer id, String nome, String cognome, LocalDate dataDiNascita, String codiceFiscale, Boolean hasCasco, Double credito) {
        this.id = ++idTot;
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.codiceFiscale = codiceFiscale;
        this.hasCasco = hasCasco;
        this.credito = 0d;
    }

    public Utente(Integer id, String nome, String cognome, LocalDate dataDiNascita, String codiceFiscale, Patente patente, Boolean hasCasco, Double credito) {
        this(id, nome, cognome, dataDiNascita, codiceFiscale, hasCasco, credito);
        this.hasCasco = hasCasco;
        this.credito = 0d;
    }


    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public Patente getPatente() {
        return patente;
    }

    public void setPatente(Patente patente) {
        this.patente = patente;
    }

    public Boolean getHasCasco() {
        return hasCasco;
    }

    public void setHasCasco(Boolean hasCasco) {
        this.hasCasco = hasCasco;
    }

    public Double getCredito() {
        return credito;
    }

    public void setCredito(Double credito) {
        this.credito = credito;
    }

    public void addCredito(Double credito){
        if(credito > 0){
            this.credito += credito;
        }
        else System.out.println("Il credito da aggiungere non può essere < 0");
    }

   public Double subCredito(Double credito){
       if (credito > this.credito){
         Double result = credito - this.credito;
         this.credito = 0d;
         return result;
        }
        else {
        this.credito -= credito;
        return 0d;
       }
   }

}
