package zoot.tds.etats;

import zoot.tds.TDS;
import zoot.tds.Type;
import zoot.tds.entrees.Entree;
import zoot.tds.symboles.Symbole;
import zoot.tds.symboles.SymboleVariable;

public abstract class EtatAnalyse {
    private TDS tds;
    protected EtatAnalyse(TDS tds) {
        // TODO
    }

    public void ajouter(Entree entree, Symbole symbole) throws IllegalStateException {
        // TODO
    }

    public Symbole identifier(Entree entree) throws IllegalStateException {
        // TODO
        return new SymboleVariable(Type.BOOLEEN);
    }

    public int getTailleZoneVariables() {
        // TODO
        return 0;
    }

    public void augmenterTailleZoneVariables(int nbOctets) throws IllegalStateException {
        // TODO
    }

    public int getTailleDisplay() throws IllegalStateException {
        // TODO
        return 0;
    }

    public int getNiveauImbricationCourant() {
        // TODO
        return 0;
    }

    public void entreeBloc() {
        // TODO
    }

    public void sortieBloc() {
        // TODO
    }

    public void allerEtatSuivant() {
        // TODO
    }
}
