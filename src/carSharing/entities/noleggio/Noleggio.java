package carSharing.entities.noleggio;

import carSharing.entities.Utente;
import carSharing.entities.veicolo.Veicolo;

import java.time.LocalDateTime;

public class Noleggio {

    private  static Integer idTot = 0;
    private Integer id;
    private Veicolo veicolo;
    private Utente utente;
    private LocalDateTime start;
    private LocalDateTime end;

    public Noleggio (Veicolo veicolo, Utente utente) {
        this.id = ++idTot;
        this.veicolo = veicolo;
        this.utente = utente;
        this.start = LocalDateTime.now();

    }

    public Noleggio(Veicolo veicolo, Utente utente,LocalDateTime start) {
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


}
