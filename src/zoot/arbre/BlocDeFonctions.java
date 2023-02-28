package zoot.arbre;

import java.util.ArrayList;

public class BlocDeFonctions extends ArbreAbstrait{
    private ArrayList<Fonction> fonctions;

    public BlocDeFonctions(int n)
    {
        super(n);
    }

    public void ajouter(Fonction f)
    {
        fonctions.add(f);
    }

    @Override
    public void verifier() {
        for(Fonction f : fonctions) f.verifier();
    }

    @Override
    public String toMIPS() {
        //TODO
        return null;
    }
}
