package zoot.tds.entrees;

import zoot.tds.Type;

import java.util.ArrayList;
import java.util.Collection;

public class EntreeFonction extends Entree {
    private ArrayList<Type> typeParametres;
    public EntreeFonction(String identifiant, Collection<Type> typeParametres) {
        super(identifiant);
        this.typeParametres = new ArrayList<>(typeParametres.size());
        this.typeParametres.addAll(typeParametres);
    }

    @Override
    public boolean equals(Object entreeAComparer) {
        boolean memeClasseEtNom = super.equals(entreeAComparer);
        boolean memeSignature = false;
        if (memeClasseEtNom)
            memeSignature = typeParametres.equals(((EntreeFonction) entreeAComparer).typeParametres);
        return memeSignature;
    }

    /**
     * Retourne l'etiquette de l'entree
     * @return l'etiquette de l'entree
     */
    public String getEtiquette() {
        StringBuilder sb = new StringBuilder();
        sb.append(identifiant);
        for (Type t : typeParametres) {
            sb.append(t.name());
        }
        return sb.toString();
    }

    /**
     * Donne la collection des paramètres de l'entrée dans l'ordre
     * @return la collection des paramètres de l'entrée dans l'ordre
     */
    public Collection<Type> getTypeParametres() {
        return typeParametres;
    }
}
