package zoot.tds;

import zoot.arbre.expressions.Variable;

public class SymboleVariable extends Symbole {
    protected int deplacement = 0;

    public SymboleVariable(Type type) {
        super(type);
    }

    public void setDeplacement(int deplacement) {
        this.deplacement = deplacement;
    }

    /**
     * Décore une variable
     *
     * @param v la variable
     */
    @Override
    public void decorer(Variable v) {
        v.setDeplacement(deplacement);
    }
}
