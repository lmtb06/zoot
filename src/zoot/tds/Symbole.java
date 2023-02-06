package zoot.tds;

public abstract class Symbole {
    protected Type type;
    protected int deplacement = 1;

    public Symbole(Type type)
    {
        this.type = type;
    }

    protected Type getType() {
        return type;
    }

    protected int getDeplacement()
    {
        return deplacement;
    }

    protected void setDeplacement(int deplacement) {
        this.deplacement = deplacement;
    }

    @Override
    public boolean equals(Object entreeAComparer)
    {
        return (this.getClass() == entreeAComparer.getClass()
                && type == ((Symbole) entreeAComparer).getType());
    }
}
