package zoot.arbre.expressions;

/**
 * Représente une constante dans l'arbre abstrait
 */
public abstract class Constante extends Expression {

    /**
     * La valeur de la constante
     */
    protected String cste ;

    /**
     * Constructeur
     * @param valeur la valeur de la constante
     * @param n le numéro de la ligne de la déclaration dans le code zoot
     */
    protected Constante(String valeur, int n) {
        super(n) ;
        cste = valeur ;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void verifier() {
        throw new UnsupportedOperationException("fonction verfier non définie ");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return cste;
    }

}
