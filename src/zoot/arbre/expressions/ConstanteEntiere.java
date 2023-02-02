package zoot.arbre.expressions;

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
    public void verifier() {
        //throw new UnsupportedOperationException("fonction verfier non définie ") ;
    }

    /**
     * Donne le code MIPS associé à ConstanteEntiere
     * @return la constante dans Registre.STOCKAGE_RESULTAT.valeur
     */
    @Override
    public String toMIPS() {
        return mipsGenerator.chargementImmediat(Registre.STOCKAGE_RESULTAT.valeur, cste);
    }
}
