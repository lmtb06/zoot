package zoot.arbre.instructions;

import zoot.arbre.ArbreAbstrait;
import zoot.arbre.ConteneurDInstructions;

/**
 * Représente une instruction dans l'arbre abstrait.
 */
public abstract class Instruction extends ArbreAbstrait {

    /**
     * Constructeur.
     *
     * @param n la ligne du début de l'instruction dans le code zoot.
     */
    protected Instruction(int n) {
        super(n);
    }

    /**
     * Permet à une instruction de décider de la façon dont le {@link ConteneurDInstructions} va l'ajouter.
     * Equivalent à la fonction accept du design pattern Visitor.
     *
     * @param c le conteneur d'instruction.
     */
    public abstract void sAjouter(ConteneurDInstructions c);
}
