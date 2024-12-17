package carSharing.entities.veicolo;

import carSharing.entities.patente.TipoPatente;

public class Furgoncino extends VeicoloMotore{


    public Furgoncino(Double prezzoNoleggio, TipoPatente tipoPatente) {
        super(prezzoNoleggio, tipoPatente);
    }

    @Override
    public Boolean needCasco() {
        return false;
    }
}
