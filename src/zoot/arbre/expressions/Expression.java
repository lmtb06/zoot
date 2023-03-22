package zoot.arbre.expressions;

import zoot.arbre.ArbreAbstrait;
import zoot.tds.Type;

/**
 * Représente une expression dans l'arbre abstrait.
 */
public abstract class Expression extends ArbreAbstrait {

    /**
     * {@inheritDoc}
     */
    protected Expression(int n) {
        super(n);
    }

    /**
     * Donne le {@link Type} de l'expression.
     *
     * @return le type de l'expression.
     */
    public abstract Type getType();
}
