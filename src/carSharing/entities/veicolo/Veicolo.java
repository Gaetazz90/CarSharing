package carSharing.entities.veicolo;

import carSharing.admin.Admin;
import carSharing.database.Database;
import carSharing.entities.noleggio.Noleggio;
import carSharing.validators.Validator;

import java.time.LocalDateTime;
import java.util.List;

public abstract class Veicolo implements Casco{

    protected static Integer idTot = 0;
    protected Integer id;
    protected Double prezzoNoleggio;
    protected Coordinate coordinate;


    public Veicolo(Double prezzoNoleggio) {
        Validator.requireGreaterThan(prezzoNoleggio, 0d);
        this.prezzoNoleggio = prezzoNoleggio;
        this.coordinate = new Coordinate(0d, 0d);
    }

    public Integer getId() {
        return id;
    }

    public Double getPrezzoNoleggio() {
        return prezzoNoleggio;
    }

    public void setPrezzoNoleggio(Double prezzoNoleggio) {
        this.prezzoNoleggio = prezzoNoleggio;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Boolean isDisponibile(LocalDateTime time){
        List<Noleggio> noleggiVeicolo = Admin.getNoleggioByVeicoloId(this.id);
        for (Noleggio n : noleggiVeicolo ){
            if(n.isNoleggioAttivo(time)){
                return false;
            }
        }
        return true;
    }




}
