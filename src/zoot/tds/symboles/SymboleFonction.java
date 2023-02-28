package zoot.tds.symboles;

import zoot.arbre.expressions.AppelFonction;
import zoot.tds.TDS;
import zoot.tds.Type;

public class SymboleFonction extends Symbole {
    public SymboleFonction(Type type) {
        super(type);
    }

    public void decorer(AppelFonction a) {
        a.setNiveauImbrication(TDS.getInstance().getNiveauImbricationCourant());
        a.setTailleDisplay(TDS.getInstance().getTailleDisplay());
    }
}
