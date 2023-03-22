package zoot.arbre;

import java.util.ArrayList;

public class BlocDeFonctions extends ArbreAbstrait {
    private final ArrayList<Fonction> fonctions;

    public BlocDeFonctions(int n) {
        super(n);
        fonctions = new ArrayList<>();
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
        for (Fonction f : fonctions) f.verifier();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toMIPS() {
        StringBuilder sb = new StringBuilder();

        for (Fonction f : fonctions) {
            sb.append(f.toMIPS());
        }

        return sb.toString();
    }
}
