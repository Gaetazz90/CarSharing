package carSharing.entities.utente;

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

    public Utente(String nome, String cognome, LocalDate dataDiNascita, String codiceFiscale, Boolean hasCasco) {
        this.id = ++idTot;
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.codiceFiscale = codiceFiscale;
        this.hasCasco = hasCasco;
        this.credito = 0d;
    }

    public Utente(String nome, String cognome, LocalDate dataDiNascita, String codiceFiscale, Patente patente, Boolean hasCasco) {
        this(nome, cognome, dataDiNascita, codiceFiscale, hasCasco);
        this.id = ++idTot;
        this.patente = patente;
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

    public void addCredito(Double creditoAggiunto){
        if(creditoAggiunto > 0){
            this.credito += creditoAggiunto;
        }
        else System.out.println("Il credito da aggiungere non può essere < 0");
    }

   public Double subCredito(Double creditoDetratto){
       if (creditoDetratto > this.credito){
         Double restoDaPagare = creditoDetratto - this.credito;
         this.credito = 0d;
         return restoDaPagare;
       }
        else {
        this.credito -= creditoDetratto;
        return this.credito;
       }
   }

}
