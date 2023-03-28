package zoot.arbre.expressions;

import zoot.tds.Type;
import zoot.tds.symboles.Symbole;

public abstract class Identifiable extends Expression {
    protected String identifiant;
    protected Symbole symbole;

    public Identifiable(String identifiant, int n) {
        super(n);
        this.identifiant = identifiant;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Type getType() {
        return symbole.getType();
    }
}
