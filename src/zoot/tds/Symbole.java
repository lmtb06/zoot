package zoot.tds;

import zoot.arbre.expressions.Variable;

public abstract class Symbole {
    protected Type type;


    public Symbole(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }


    /**
     * Décore un identifiable, ici il ne fait rien, il est à redéfinir si besoin
     *
     * @param i un Identifiable
     */
    public void decorer(Variable i) {
        //IT DOES NOTHING
    }
}
