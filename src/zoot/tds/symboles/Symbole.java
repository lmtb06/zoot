package zoot.tds.symboles;

import zoot.arbre.expressions.AppelFonction;
import zoot.arbre.expressions.Variable;
import zoot.tds.Type;

public abstract class Symbole {
    protected Type type;


    public Symbole(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }


    /**
     * Décore une variable, ici il ne fait rien, il est à redéfinir si besoin
     *
     * @param v un variable
     */
    public void decorer(Variable v) {
        //IT DOES NOTHING
    }

    /**
     * Décore une appel de fonction, ici il ne fait rien, il est à redéfinir si besoin
     *
     * @param a un appel de fonction
     */
    public void decorer(AppelFonction a) {
        //IT DOES NOTHING
    }
}