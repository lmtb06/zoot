package zoot.tds.etats;

import zoot.tds.TDS;
import zoot.tds.Type;
import zoot.tds.entrees.Entree;
import zoot.tds.symboles.Symbole;
import zoot.tds.symboles.SymboleFonction;

public class EtatEnCoursAnalyseSemantique extends EtatAnalyse {
    public EtatEnCoursAnalyseSemantique(TDS tds) {
        super(tds);
    }

    public Symbole identifier(Entree entree){
        // TODO
        return new SymboleFonction(Type.BOOLEEN);
    }

    public int getTailleDisplay() {
        // TODO
        return 0;
    }

    public void entreeBloc() {
        // TODO
    }

    public void sortieBloc() {
        // TODO
    }
}
