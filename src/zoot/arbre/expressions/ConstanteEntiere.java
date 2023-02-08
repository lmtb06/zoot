package zoot.arbre.expressions;

import zoot.code_generation.MipsGenerator;
import zoot.code_generation.Registre;
import zoot.tds.Type;

/**
 * Représente une constante entière dans l'arbre abstrait
 */
public class ConstanteEntiere extends Constante {

    /**
     * Constructeur.
     *
     * @param texte la valeur de la constante entière.
     * @param n     le numéro de ligne de la déclaration dans le code zoot.
     */
    public ConstanteEntiere(String texte, int n) {
        super(texte, n);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toMIPS() {
        return MipsGenerator.getInstance().chargementImmediat(Registre.STOCKAGE_RESULTAT.valeur, cste);
    }

    @Override
    public Type getType() {
        return Type.ENTIER;
    }
}
