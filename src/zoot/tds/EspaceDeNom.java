package zoot.tds;

import zoot.exceptions.DoubleDeclarationException;
import zoot.exceptions.VariableNonDeclarerException;
import zoot.tds.entrees.Entree;
import zoot.tds.symboles.Symbole;

import java.util.ArrayList;
import java.util.HashMap;

public class EspaceDeNom {
    private int tailleZoneVariables;
    private int noSousEspaceDeNomCourant;
    private int niveauImbrication;
    private EspaceDeNom parent;
    private ArrayList<EspaceDeNom> enfants;
    private final HashMap<String, Symbole> tableDesSymboles;

    public EspaceDeNom(int niveauImbrication) {
        this.niveauImbrication = niveauImbrication;
        enfants = new ArrayList<>();
        tableDesSymboles = new HashMap<>();
    }

    public void ajouter(Entree entree, Symbole symbole) {
        if (tableDesSymboles.containsKey(entree.getIdentifiant()))
            throw new DoubleDeclarationException(entree);

        tableDesSymboles.put(entree.getIdentifiant(), symbole);
    }

    public Symbole identifier(Entree entree) {
        Symbole symboleAIdentifier = tableDesSymboles.get(entree.getIdentifiant());

        if (symboleAIdentifier == null)
            throw new VariableNonDeclarerException(entree);

        return symboleAIdentifier;
    }

    public int getTailleZoneVariables() {
        return tailleZoneVariables;
    }

    public void augmenterTailleZoneVariables(int nbOctets) {
        tailleZoneVariables += nbOctets;
    }

    public void setEspaceDeNomParent(EspaceDeNom e) {
        parent = e;
    }

    public void ajouterSousEspaceDeNom(EspaceDeNom n) {
        enfants.add(n);
        n.setEspaceDeNomParent(this);
    }

    public EspaceDeNom getEspaceDeNomParent() {
        return parent;
    }

    public EspaceDeNom getProchainSousEspaceDeNom() {
        noSousEspaceDeNomCourant += 1;
        return enfants.get(noSousEspaceDeNomCourant-1);
    }

    public void resetParcoursSousEspaceDeNom() {
        noSousEspaceDeNomCourant = 0;
        for(EspaceDeNom e : enfants) e.resetParcoursSousEspaceDeNom();
    }

    public int getNiveauImbricationMax() {
        int output = niveauImbrication;

        for(EspaceDeNom e : enfants) output = Math.max(e.getNiveauImbricationMax(), output);

        return output;
    }

    public int getNiveauImbrication() {
        return niveauImbrication;
    }
}
