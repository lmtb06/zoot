package zoot.tds;

import zoot.arbre.expressions.Identifiable;

public abstract class Symbole {
    protected Type type;

    protected boolean estInit = false;

    public Symbole(Type type)
    {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public boolean estInstancie()
    {
        return estInit;
    }

    public void instancier()
    {
        estInit = true;
    }

    /**
     * Décore un identifiable, ici il ne fait rien, il est à redéfinir si besoin
     * @param i un Identifiable
     */
    public void decorer(Identifiable i) {
        //IT DOES NOTHING
    }
}
