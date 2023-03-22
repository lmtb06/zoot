package zoot.tds.entrees;

import java.util.Objects;

public abstract class Entree {
    protected String identifiant;

    public Entree(String identifiant) {
        this.identifiant = identifiant;
    }

    /**
     * Donne l'identifiant de l'entrée
     *
     * @return l'identifiant de l'entrée
     */
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

    @Override
    public int hashCode() {
        return Objects.hashCode(identifiant);
    }
}
