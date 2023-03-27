package zoot.tds.symboles;

import zoot.arbre.expressions.AppelFonction;
import zoot.arbre.expressions.Variable;
import zoot.tds.EspaceDeNom;
import zoot.tds.Type;

public abstract class Symbole {
    protected Type type;
    protected EspaceDeNom espaceDeNom;

    public Symbole(Type type) {
        this.type = type;
    }

    /**
     * Retourne le {@link Type} du symbole.
     *
     * @return le {@link Type} du symbole.
     */
    public Type getType() {
        return type;
    }

    public void setEspaceDeNom(EspaceDeNom espaceDeNom) {
        this.espaceDeNom = espaceDeNom;
    }

    /**
     * Décore une {@link Variable}.
     *
     * @param v une {@link Variable}.
     */
    public void decorer(Variable v) {
        //IT DOES NOTHING
    }

    /**
     * Décore un {@link AppelFonction}.
     *
     * @param a l'{@link AppelFonction}.
     */
    public void decorer(AppelFonction a) {
        //IT DOES NOTHING
    }
}
