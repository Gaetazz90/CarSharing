package carSharing.entities.noleggio;

import carSharing.entities.utente.Utente;
import carSharing.entities.veicolo.Veicolo;
import carSharing.validators.Validator;

import java.time.LocalDateTime;

public class Noleggio {

    private  static Integer idTot = 0;
    private Integer id;
    private Veicolo veicolo;
    private Utente utente;
    private LocalDateTime start;
    private LocalDateTime end;

    public Noleggio (Veicolo veicolo, Utente utente) {
        Validator.requireNotNull(veicolo);
        Validator.requireNotNull(utente);
        this.id = ++idTot;
        this.veicolo = veicolo;
        this.utente = utente;
        this.start = LocalDateTime.now();
    }

    public Noleggio (Veicolo veicolo, Utente utente,LocalDateTime start) {
        Validator.requireNotNull(veicolo);
        Validator.requireNotNull(utente);
        Validator.requireDateAfter(start, LocalDateTime.now());
        this.id = ++idTot;
        this.veicolo = veicolo;
        this.utente = utente;
        this.start = start;
    }

    public Integer getId() {
        return id;
    }

    public Veicolo getVeicolo() {
        return veicolo;
    }

    public void setVeicolo(Veicolo veicolo) {
        this.veicolo = veicolo;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        if (this.start.isBefore(LocalDateTime.now())){
            this.start = start;
        }
        else System.out.println("Noleggio già iniziato");
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public Boolean isNoleggioAttivo(LocalDateTime time){
        if(this.end == null && this.start.isBefore(time)) return true;
        return false;
    }


}
