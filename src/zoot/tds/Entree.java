package zoot.tds;

public abstract class Entree {
    protected String identifiant;

    public Entree(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    /**
     * Vérifie si deux entrées sont égales
     *
     * @param entreeAComparer l'entrée à comparer avec this.entree
     * @return true si les deux objets sont de mêmes classes et les identifiants sont égaux, faux sinon
     */
    @Override
    public boolean equals(Object entreeAComparer) {
        return (this.getClass() == entreeAComparer.getClass()
                && identifiant.equals(((Entree) entreeAComparer).getIdentifiant()));
    }
}
