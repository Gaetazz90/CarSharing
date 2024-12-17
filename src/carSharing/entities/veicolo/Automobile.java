package carSharing.entities.veicolo;

import carSharing.entities.patente.TipoPatente;

public class Automobile extends VeicoloMotore {

    public Automobile(Double prezzoNoleggio, TipoPatente tipoPatente) {
        super(prezzoNoleggio, tipoPatente);
    }

    @Override
    public Boolean needCasco() {
        return false;
    }
}
