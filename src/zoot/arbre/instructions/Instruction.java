package zoot.arbre.instructions;

import zoot.arbre.ArbreAbstrait;

/**
 * Représente une instruction dans l'arbre abstrait.
 */
public abstract class Instruction extends ArbreAbstrait {

    /**
     * Constructeur.
     * @param n la ligne du début de l'instruction dans le code zoot.
     */
    protected Instruction(int n) {
        super(n);
    }

}
