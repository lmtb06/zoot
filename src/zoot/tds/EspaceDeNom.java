package zoot.tds;

import zoot.tds.entrees.Entree;
import zoot.tds.symboles.Symbole;
import zoot.tds.symboles.SymboleFonction;

import java.util.ArrayList;
import java.util.HashMap;

public class EspaceDeNom {
    private int tailleZoneVariables;
    private int noSousEspaceDeNomCourant;
    private int niveauImbrication;
    private EspaceDeNom parent;
    private ArrayList<EspaceDeNom> enfants;
    private final HashMap<String, Symbole> tableDesSymboles;

    public EspaceDeNom() {
        // TODO
        enfants = null;
        tableDesSymboles = null;
    }

    public void ajouter(Entree entree, Symbole symbole) {
        // TODO
    }

    public Symbole identifier(Entree entree) {
        // TODO
        return new SymboleFonction(Type.BOOLEEN);
    }

    public int getTailleZoneVariables() {
        // TODO
        return 0;
    }

    public void augmenterTailleZoneVariables(int nbOctets) {
        // TODO
    }

    public void setEspaceDeNomParent(EspaceDeNom e) {
        // TODO
    }

    public void ajouterSousEspaceDeNom(EspaceDeNom n) {
        // TODO
    }

    public EspaceDeNom getEspaceDeNomParent() {
        // TODO
        return new EspaceDeNom();
    }

    public EspaceDeNom getProchainSousEspaceDeNom() {
        // TODO
        return new EspaceDeNom();
    }

    public void resetParcoursSousEspaceDeNom() {
        // TODO
    }

    public int getNiveauImbricationMax() {
        // TODO
        return 0;
    }

    public int getNiveauImbrication() {
        return 0;
    }
}
