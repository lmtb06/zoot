package zoot.arbre.expressions;

import zoot.tds.TDS;
import zoot.tds.Type;
import zoot.tds.entrees.Entree;
import zoot.tds.symboles.Symbole;

public abstract class Identifiable extends Expression {
    protected Entree entree;
    protected Symbole symbole;

    public Identifiable(Entree e, int n) {
        super(n);
        this.entree = e;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Type getType() {
        return symbole.getType();
    }

    /**
     * {@inheritDoc}
     * Récupère le {@link Symbole} associé et ajoute une exception au gestionnaire d'exception
     * s'il n'y a pas de {@link Symbole} associé à son {@link Entree}.
     */
    @Override
    public void verifier() {
        symbole = TDS.getInstance().identifier(entree);
    }
}
