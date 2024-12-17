package carSharing.entities.veicolo;

public class MonopattinoElettrico extends Veicolo {

    private Double livelloBatteria;

    public MonopattinoElettrico(Double prezzoNoleggio) {
        super(prezzoNoleggio);
        this.livelloBatteria = 1d;
    }

    @Override
    public Boolean needCasco() {
        return true;
    }

    public Double getLivelloBatteria() {
        return livelloBatteria;
    }

    public void setLivelloBatteria(Double livelloBatteria) {
        this.livelloBatteria = livelloBatteria;
    }

}
