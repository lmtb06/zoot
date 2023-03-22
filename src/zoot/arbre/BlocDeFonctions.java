package zoot.arbre;

import java.util.ArrayList;

public class BlocDeFonctions extends ArbreAbstrait{
    private ArrayList<Fonction> fonctions;

    public BlocDeFonctions(int n)
    {
        super(n);
    }

    /**
     * {@inheritDoc}
     */
    public void ajouter(Fonction f) {
        fonctions.add(f);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void verifier() {
        for(Fonction f : fonctions) f.verifier();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toMIPS() {
        //TODO
        return null;
    }
}
