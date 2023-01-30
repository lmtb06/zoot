package zoot.arbre.expressions;

import zoot.code_generation.Registre;

public class ConstanteEntiere extends Constante {
    
    public ConstanteEntiere(String texte, int n) {
        super(texte, n) ;
    }

    @Override
    public void verifier() {
        //throw new UnsupportedOperationException("fonction verfier non définie ") ;
    }

    @Override
    public String toMIPS() {
        return mipsGenerator.chargementImmediat(Registre.STOCKAGE_RESULTAT.valeur, cste);
    }
}
