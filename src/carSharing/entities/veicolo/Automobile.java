package carSharing.entities.veicolo;

import carSharing.entities.utente.TipoPatente;

public class Automobile extends VeicoloMotore {

    public Automobile(Double prezzoNoleggio, TipoPatente tipoPatente, String targa) {
        super(prezzoNoleggio, tipoPatente, targa);
    }

    @Override
    public Boolean needCasco() {
        return false;
    }

}
