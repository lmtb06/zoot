package zoot.arbre;

/**
 * Représente un arbre abstrait (ou sous arbre d'un plus grand arbre).
 */
public abstract class ArbreAbstrait {

    /**
     * Le numéro de ligne du début de la déclaration dans le code zoot qui a permise de générer cet arbre.
     */
    protected int noLigne;

    /**
     * Constructeur.
     *
     * @param n Le numéro de ligne du début de la déclaration dans le code zoot qui a permise de générer cet arbre.
     */
    protected ArbreAbstrait(int n) {
        noLigne = n;
    }

    /**
     * Retourne le numéro de ligne du début de la déclaration dans le code zoot qui a permise de générer cet arbre.
     *
     * @return Le numéro de ligne du début de la déclaration dans le code zoot qui a permise de générer cet arbre.
     */
    public int getNoLigne() {
        return noLigne;
    }

    /**
     * Permet de faire l'analyse sémantique de l'arbre.
     */
    public abstract void verifier();

    /**
     * Retourne le code MIPS généré à partir de l'arbre abstrait.
     *
     * @return Le code MIPS généré à partir de l'arbre abstrait.
     */
    public abstract String toMIPS();

}
