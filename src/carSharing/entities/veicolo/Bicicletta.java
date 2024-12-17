package carSharing.entities.veicolo;

public class Bicicletta extends Veicolo{


    public Bicicletta(Double prezzoNoleggio) {
        super(prezzoNoleggio);
    }

    @Override
    public Boolean needCasco() {
        return true;
    }

}
