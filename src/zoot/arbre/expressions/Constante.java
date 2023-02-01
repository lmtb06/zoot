package zoot.arbre.expressions;

public abstract class Constante extends Expression {

    protected String cste ;
    
    protected Constante(String texte, int n) {
        super(n) ;
        cste = texte ;
    }

    @Override
    public void verifier() {
        //throw new UnsupportedOperationException("fonction verfier non définie ") ;
    }

    /**
     * Donne Constante sous forme de String
     * @return cste la constante
     */
    @Override
    public String toString() {
        return cste;
    }

}
