package zoot.arbre.expressions;

import zoot.tds.Entree;

public abstract class Identifiable extends Expression {
    protected Entree entree;

    public Identifiable(Entree e, int n)
    {
        super(n);
        this.entree = e;
    }
}
