package zoot.tds;

import java.util.HashMap;

public class TDS {
    private final static TDS instance = new TDS();
    private HashMap<Entree, Symbole> tableDesSymboles;
    private int deplacement;

    private TDS()
    {
        tableDesSymboles = new HashMap<>();
        deplacement = 0;
    }

    public static TDS getInstance() {
        return instance;
    }

    public void ajouter(Entree entree, Symbole symbole)
    {
        if(tableDesSymboles.containsKey(entree))
            throw new DoubleDeclarationException();

        symbole.setDeplacement(deplacement);
        deplacement -= 4;

        tableDesSymboles.put(entree, symbole);
    }

    public Symbole identifier(Entree entree)
    {
        Symbole symboleAIdentifier = tableDesSymboles.get(entree);

        if(symboleAIdentifier == null)
            throw new VariableNonDeclarerException();

        return symboleAIdentifier;
    }

    public int getTailleZoneVariables()
    {
        return deplacement;
    }
}
