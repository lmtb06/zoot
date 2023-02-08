package zoot.arbre.expressions;

import zoot.tds.Entree;
import zoot.tds.Symbole;

public abstract class Identifiable extends Expression {
    protected Entree entree;
    protected Symbole symbole;

    public Identifiable(Entree e, int n) {
        super(n);
        this.entree = e;
    }
}
