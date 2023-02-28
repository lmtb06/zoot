package zoot.arbre.expressions;

import zoot.tds.entrees.Entree;
import zoot.tds.symboles.Symbole;

public abstract class Identifiable extends Expression {
    protected Entree entree;
    protected Symbole symbole;

    public Identifiable(Entree e, int n) {
        super(n);
        this.entree = e;
    }

    public abstract void setSymbole(Symbole s);
}
