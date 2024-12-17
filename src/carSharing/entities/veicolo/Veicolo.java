package carSharing.entities.veicolo;

import java.time.LocalDateTime;

public abstract class Veicolo implements Casco{

    protected static Integer idTot = 0;
    protected Integer id;
    protected Double prezzoNoleggio;
    protected Coordinate coordinate;


    public Veicolo(Double prezzoNoleggio) {
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
        return true;
    }



}
