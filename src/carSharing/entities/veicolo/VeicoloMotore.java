package carSharing.entities.veicolo;

import carSharing.entities.utente.TipoPatente;
import carSharing.validators.Validator;

public abstract class VeicoloMotore extends Veicolo {

    protected String targa;
    protected TipoPatente tipoPatente;
    protected Double livelloCarburante;

    public VeicoloMotore(Double prezzoNoleggio, TipoPatente tipoPatente, String targa) {
        super(prezzoNoleggio);
        Validator.requireNotNull(tipoPatente);
        Validator.matchingPatterns(targa, "^[A-Z]{2}\\d{3}[A-Z]{2}$");
        this.tipoPatente = tipoPatente;
        this.livelloCarburante = 1d;
        this.targa = targa;
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        targa = targa;
    }

    public TipoPatente getTipoPatente() {
        return tipoPatente;
    }

    public void setTipoPatente(TipoPatente tipoPatente) {
        this.tipoPatente = tipoPatente;
    }

    public Double getLivelloCarburante() {
        return livelloCarburante;
    }

    public void setLivelloCarburante(Double livelloCarburante) {
        this.livelloCarburante = livelloCarburante;
    }

    @Override
    public String toString() {
        return "VeicoloMotore{" +
                "targa='" + targa + '\'' +
                ", tipoPatente=" + tipoPatente +
                '}';
    }
}
