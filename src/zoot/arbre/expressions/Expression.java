package zoot.arbre.expressions;

import zoot.arbre.ArbreAbstrait;

/**
 * Représente une expression dans l'arbre abstrait
 */
public abstract class Expression extends ArbreAbstrait {

    /**
     * {@inheritDoc}
     */
    protected Expression(int n) {
        super(n) ;
    }

    public abstract String getMIPSAffichage();
}
