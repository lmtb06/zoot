package zoot.tds;

public abstract class Entree {
    protected String identifiant;

    public Entree(String identifiant) {
        this.identifiant = identifiant;
    }

    protected String getIdentifiant()
    {
        return identifiant;
    }

    @Override
    public boolean equals(Object entreeAComparer)
    {
        return (this.getClass() == entreeAComparer.getClass()
                && identifiant.equals(((Entree) entreeAComparer).getIdentifiant()));
    }
}
