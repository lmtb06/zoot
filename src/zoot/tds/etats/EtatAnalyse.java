package zoot.tds.etats;

import zoot.tds.TDS;
import zoot.tds.entrees.Entree;
import zoot.tds.symboles.Symbole;

public abstract class EtatAnalyse {
    protected TDS tds;
    protected EtatAnalyse(TDS tds) {
        this.tds = tds;
    }

    public void ajouter(Entree entree, Symbole symbole) throws IllegalStateException {
        throw new IllegalStateException("Opération non-permise à cette étape de la compilation");
    }

    public Symbole identifier(Entree entree) throws IllegalStateException {
        throw new IllegalStateException("Opération non-permise à cette étape de la compilation");
    }

    public int getTailleZoneVariables() {
        return tds.getEspaceDeNomCourant().getTailleZoneVariables();
    }

    public void augmenterTailleZoneVariables(int nbOctets) throws IllegalStateException {
        throw new IllegalStateException("Opération non-permise à cette étape de la compilation");
    }

    public int getTailleDisplay() throws IllegalStateException {
        throw new IllegalStateException("Opération non-permise à cette étape de la compilation");
    }

    public int getNiveauImbricationCourant() {
        return tds.getEspaceDeNomCourant().getNiveauImbrication();
    }

    public void entreeBloc() {
    }

    public void sortieBloc() {
    }

    public void allerEtatSuivant() {
    }
}
