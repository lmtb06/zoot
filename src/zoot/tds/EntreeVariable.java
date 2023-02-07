package zoot.tds;

public class EntreeVariable extends Entree{
    public EntreeVariable(String identifiant) {
        super(identifiant);
    }

    @Override
    public boolean equals(Object entreeAComparer)
    {
        return (this.getClass() == entreeAComparer.getClass()
                && identifiant.equals(((Entree) entreeAComparer).getIdentifiant()));
    }
}
