package zoot.tds;

import zoot.exceptions.DoubleDeclarationException;
import zoot.exceptions.VariableNonDeclarerException;

import java.util.HashMap;

public class TDS {
    private final static TDS instance = new TDS();
    private final HashMap<String, Symbole> tableDesSymboles;
    private int deplacement;

    private TDS()
    {
        tableDesSymboles = new HashMap<>();
        deplacement = 0;
    }

    public static TDS getInstance() {
        return instance;
    }

    /**
     * Ajoute un symbole à la TDS, identifiable par entree
     * @param entree l'entree de la TDS
     * @param symbole le symbole associé à l'entrée dans la TDS
     * @throws DoubleDeclarationException si l'entrée existe déjà dans la TDS
     */
    public void ajouter(Entree entree, Symbole symbole)
    {
        if(tableDesSymboles.containsKey(entree.getIdentifiant()))
            throw new DoubleDeclarationException(entree);

        tableDesSymboles.put(entree.getIdentifiant(), symbole);
    }

    /**
     * Identifie et retourne le symbole associé à l'entrée
     * @param entree l'entree de la TDS
     * @throws VariableNonDeclarerException si l'entrée n'existe pas dans la TDS
     * @return le symbole associé à l'entrée
     */
    public Symbole identifier(Entree entree)
    {
        Symbole symboleAIdentifier = tableDesSymboles.get(entree.getIdentifiant());

        if(symboleAIdentifier == null)
            throw new VariableNonDeclarerException(entree);

        return symboleAIdentifier;
    }

    /**
     * Retourne la taille de la zone des variables, soit le nombre d'octets alloué (son inverse, donc -nbOctets)
     * @return deplacement, la taille de la zone des variables
     */
    public int getTailleZoneVariables()
    {
        return deplacement;
    }

    /**
     * Alloue (et donc augmente) la taille de la zone des variables
     * @param nbOctets le nombre d'octets à allouer
     */
    public void augmenterTailleZoneVariables(int nbOctets) {
        deplacement -= nbOctets;
    }
}
