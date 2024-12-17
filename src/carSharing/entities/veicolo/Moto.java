package carSharing.entities.veicolo;

import carSharing.entities.patente.TipoPatente;

public class Moto extends VeicoloMotore{


    public Moto(Double prezzoNoleggio, TipoPatente tipoPatente) {
        super(prezzoNoleggio, tipoPatente);
    }

    @Override
    public Boolean needCasco() {
        return true;
    }

}
