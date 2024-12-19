package carSharing.entities.utente;

import carSharing.admin.Admin;
import carSharing.entities.noleggio.Noleggio;
import carSharing.entities.veicolo.Veicolo;
import carSharing.exceptions.VeicoloNotAvailable;
import carSharing.exceptions.VeicoloNotFound;
import carSharing.validators.Validator;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    public Utente() {
    }

    public Utente(String nome, String cognome, LocalDate dataDiNascita, String codiceFiscale, Boolean hasCasco) {
        Validator.requireNotBlank(nome);
        Validator.requireNotBlank(cognome);
        Validator.requireDateBefore(dataDiNascita, LocalDate.now());
        Validator.matchingPatterns(codiceFiscale, "^[A-Z]{6}\\d{2}[A-Z]\\d{2}[A-Z]\\d{3}[A-Z]$");
        this.id = ++idTot;
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.codiceFiscale = codiceFiscale;
        this.hasCasco = hasCasco;
        this.credito = 10d;
    }

    public Utente(String nome, String cognome, LocalDate dataDiNascita, String codiceFiscale, Patente patente, Boolean hasCasco) {
        this(nome, cognome, dataDiNascita, codiceFiscale, hasCasco);
        this.id = ++idTot;
        this.patente = patente;
        this.credito = 10d;
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

   public Noleggio attivaNoleggio(Integer id_veicolo) throws VeicoloNotFound, VeicoloNotAvailable {
        Veicolo veicoloDaPrenotare = Admin.getVeicoloById(id_veicolo);
        if(veicoloDaPrenotare  == null) throw new VeicoloNotFound("Il veicolo selezionato è inesistente");
        if(!veicoloDaPrenotare .isDisponibile(LocalDateTime.now())){
            throw new VeicoloNotAvailable("Veicolo non disponibile perchè già prenotato...");
        }
        Noleggio myNoleggio = new Noleggio(veicoloDaPrenotare, this);
        Admin.insertNoleggio(myNoleggio);
        System.out.println("Il noleggio è andato a buon fine");
        return myNoleggio;
   }
   public Noleggio attivaNoleggio(Integer id_veicolo, LocalDateTime start) throws VeicoloNotFound, VeicoloNotAvailable {
       Veicolo veicoloDaPrenotare = Admin.getVeicoloById(id_veicolo);
       if(veicoloDaPrenotare == null) throw new VeicoloNotFound("Il veicolo selezionato è inesistente");
       if(!veicoloDaPrenotare.isDisponibile(start)){
           throw new VeicoloNotAvailable("Veicolo già prenotato...non disponibile");
       }
       Noleggio myNoleggio = new Noleggio(veicoloDaPrenotare, this);
       Admin.insertNoleggio(myNoleggio);
       System.out.println("Il noleggio è andato a buon fine");
       return myNoleggio;
   }

   public Double terminaNoleggio(Noleggio myNoleggio){
        myNoleggio.setEnd(LocalDateTime.now());
        Long durataNoleggio = Duration.between(myNoleggio.getStart(), myNoleggio.getEnd()).toMinutes();
        Double costoNoleggio = durataNoleggio * myNoleggio.getVeicolo().getPrezzoNoleggio();
        System.out.println("Il noleggio è terminato");
        return costoNoleggio;
   }

   public List<Veicolo> getVeicoliDisponibili(LocalDateTime start){
        List<Veicolo> veicoliDisponibili = new ArrayList<>();
        List<Veicolo> allVeicoli = Admin.getAllVeicoli();
        for (Veicolo v : allVeicoli){
            if(v.isDisponibile(start)){
                veicoliDisponibili.add(v);
            }
        }
        return veicoliDisponibili;
   }

    @Override
    public String toString() {
        return "Utente{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataDiNascita=" + dataDiNascita +
                ", codiceFiscale='" + codiceFiscale + '\'' +
                '}';
    }
}
