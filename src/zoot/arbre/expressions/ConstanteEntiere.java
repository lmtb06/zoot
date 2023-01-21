package zoot.arbre.expressions;

import zoot.code_generation.MipsGenerator;
import zoot.code_generation.Registre;

public class ConstanteEntiere extends Constante {
    
    public ConstanteEntiere(String texte, int n) {
        super(texte, n) ;
    }

    @Override
    public String toMIPS() {
        return MipsGenerator.getInstance().chargementImmediat(Registre.STOCKAGE_RESULTAT.valeur, cste);
    }

    @Override
    public String getMIPSAffichage() {
        // évalue son code dans v0 avant de l’afficher
        return toMIPS() +
                MipsGenerator.getInstance().afficherEntierRegistre(Registre.STOCKAGE_RESULTAT.valeur);
    }
}
