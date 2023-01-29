package zoot.arbre.expressions;

import zoot.code_generation.MipsGenerator;
import zoot.code_generation.Registre;

public class ConstanteEntiere extends Constante {
    
    public ConstanteEntiere(String texte, int n) {
        super(texte, n) ;
    }

    @Override
    public void verifier() {

    }

    @Override
    public String toMIPS() {
        return MipsGenerator.getInstance().chargementImmediat(Registre.STOCKAGE_RESULTAT.valeur, cste);
    }
}
