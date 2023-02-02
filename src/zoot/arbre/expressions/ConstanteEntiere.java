package zoot.arbre.expressions;

import zoot.code_generation.MipsGenerator;
import zoot.code_generation.Registre;

/**
 * Représente une constante entière dans l'arbre abstrait
 */
public class ConstanteEntiere extends Constante {

    /**
     * Constructeur.
     * @param texte la valeur de la constante entière.
     * @param n le numéro de ligne de la déclaration dans le code zoot.
     */
    public ConstanteEntiere(String texte, int n) {
        super(texte, n) ;
    }

    /**
     * {@inheritDoc}
     */
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
