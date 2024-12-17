package carSharing.entities.veicolo;

import carSharing.entities.utente.TipoPatente;

public abstract class VeicoloMotore extends Veicolo {

    protected String Targa;
    protected TipoPatente tipoPatente;
    protected Double livelloCarburante;

    public VeicoloMotore(Double prezzoNoleggio, TipoPatente tipoPatente) {
        super(prezzoNoleggio);
        this.tipoPatente = tipoPatente;
        this.livelloCarburante = 1d;
    }

    public String getTarga() {
        return Targa;
    }

    public void setTarga(String targa) {
        Targa = targa;
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


}
