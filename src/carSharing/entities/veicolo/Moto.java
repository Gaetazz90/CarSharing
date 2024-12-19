package carSharing.entities.veicolo;

import carSharing.entities.utente.TipoPatente;

public class Moto extends VeicoloMotore{

    public Moto(Double prezzoNoleggio, TipoPatente tipoPatente, String targa) {
        super(prezzoNoleggio, tipoPatente, targa);
    }

    @Override
    public Boolean needCasco() {
        return true;
    }

}
