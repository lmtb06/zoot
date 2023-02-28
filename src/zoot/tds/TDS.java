package zoot.tds;

import zoot.exceptions.DoubleDeclarationException;
import zoot.exceptions.VariableNonDeclarerException;
import zoot.tds.entrees.Entree;
import zoot.tds.etats.EtatAnalyse;
import zoot.tds.symboles.Symbole;

import java.util.HashMap;

public class TDS {
    private final static TDS instance = new TDS();
    private final HashMap<String, Symbole> tableDesSymboles;
    private int tailleZoneVariables;
    private int niveauImbricationMax;
    private EspaceDeNom EspaceDeNomCourant;
    private EtatAnalyse etatCourant;

    private TDS() {
        // TODO
        tableDesSymboles = new HashMap<>();
        tailleZoneVariables = 0;
    }

    public static TDS getInstance() {
        return instance;
    }

    EspaceDeNom getEspaceDeNomCourant() {
        // TODO
        return new EspaceDeNom();
    }

    void setEspaceDeNomCourant(EspaceDeNom e) {
        // TODO
    }

    void setEtatAnalyse(EtatAnalyse e) {
        // TODO
    }

    void setNiveauImbricationMax(int niveau) {
        // TODO
    }

    int getNiveauImbricationMax() {
        return 0;
    }

    /**
     * Ajoute un symbole à la TDS, identifiable par entree
     *
     * @param entree  l'entree de la TDS
     * @param symbole le symbole associé à l'entrée dans la TDS
     * @throws DoubleDeclarationException si l'entrée existe déjà dans la TDS
     */
    public void ajouter(Entree entree, Symbole symbole) {
        // TODO
        if (tableDesSymboles.containsKey(entree.getIdentifiant()))
            throw new DoubleDeclarationException(entree);

        tableDesSymboles.put(entree.getIdentifiant(), symbole);
    }

    /**
     * Identifie et retourne le symbole associé à l'entrée
     *
     * @param entree l'entree de la TDS
     * @return le symbole associé à l'entrée
     * @throws VariableNonDeclarerException si l'entrée n'existe pas dans la TDS
     */
    public Symbole identifier(Entree entree) throws IllegalStateException {
        // TODO
        Symbole symboleAIdentifier = tableDesSymboles.get(entree.getIdentifiant());

        if (symboleAIdentifier == null)
            throw new VariableNonDeclarerException(entree);

        return symboleAIdentifier;
    }

    /**
     * Retourne la taille de la zone des variables, soit le nombre d'octets alloué (son inverse, donc -nbOctets)
     *
     * @return deplacement, la taille de la zone des variables
     */
    public int getTailleZoneVariables() {
        // TODO
        return tailleZoneVariables;
    }

    /**
     * Alloue (et donc augmente) la taille de la zone des variables
     *
     * @param nbOctets le nombre d'octets à allouer
     */
    public void augmenterTailleZoneVariables(int nbOctets) throws IllegalStateException {
        // TODO
        tailleZoneVariables += nbOctets;
    }

    public int getTailleDisplay() throws IllegalStateException {
        // TODO
        return 0;
    }

    public int getNiveauImbricationCourant() {
        // TODO
        return 0;
    }

    public void entreeBloc() {
        // TODO
    }

    public void sortieBloc() {
        // TODO
    }

    public void allerEtatSuivant() {
        // TODO
    }
}
