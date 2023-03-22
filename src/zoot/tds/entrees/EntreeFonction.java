package zoot.tds.entrees;

import zoot.tds.Type;

import java.util.ArrayList;
import java.util.Collection;

public class EntreeFonction extends Entree {
    private final ArrayList<Type> typeParametres;
    public EntreeFonction(String identifiant, Collection<Type> typeParametres) {
        super(identifiant);
        // L'identifiant d'une fonction est du style "nom_typeParam1_typeParam2_..._typeParamN_"
        StringBuilder sb = new StringBuilder();
        sb.append(identifiant);
        sb.append('_');
        this.typeParametres = new ArrayList<>(typeParametres.size());
        typeParametres.forEach(typeParametre -> {
            sb.append(typeParametre.name())
                    .append('_');
            typeParametres.add(typeParametre);
        });
        this.identifiant = sb.toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object entreeAComparer) {
        boolean memeClasseEtNom = super.equals(entreeAComparer);
        boolean memeSignature = false;
        if (memeClasseEtNom)
            memeSignature = typeParametres.equals(((EntreeFonction) entreeAComparer).typeParametres);
        return memeSignature;
    }

    /**
     * Donne la collection des paramètres de l'entrée dans l'ordre
     * @return la collection des paramètres de l'entrée dans l'ordre
     */
    public Collection<Type> getTypeParametres() {
        return typeParametres;
    }
}
