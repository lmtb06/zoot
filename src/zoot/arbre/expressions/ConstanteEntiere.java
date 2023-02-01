package zoot.arbre.expressions;

public class ConstanteEntiere extends Constante {
    
    public ConstanteEntiere(String texte, int n) {
        super(texte, n) ;
    }

    @Override
    public void verifier() {
        //throw new UnsupportedOperationException("fonction verfier non définie ") ;
    }

    /**
     * Donne le code MIPS associé à ConstanteEntiere
     * @return la constante
     */
    @Override
    public String toMIPS() {
        return cste;
    }
}
