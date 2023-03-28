package zoot.tds;

import zoot.exceptions.DoubleDeclarationException;
import zoot.exceptions.EntreeNonTrouveException;
import zoot.tds.entrees.Entree;
import zoot.tds.etats.EtatAnalyse;
import zoot.tds.etats.EtatEnCoursAnalyseSyntaxique;
import zoot.tds.symboles.Symbole;
import zoot.tds.symboles.SymboleVariable;

public class TDS {
    private final static TDS instance = new TDS();
    private int niveauImbricationMax;
    private EspaceDeNom espaceDeNomCourant;
    private EtatAnalyse etatCourant;

    private TDS() {
        niveauImbricationMax = 0;
        espaceDeNomCourant = new EspaceDeNom(0);
        etatCourant = new EtatEnCoursAnalyseSyntaxique(this);
    }

    public static TDS getInstance() {
        return instance;
    }

    public EspaceDeNom getEspaceDeNomCourant() {
        return espaceDeNomCourant;
    }

    public void setEspaceDeNomCourant(EspaceDeNom e) {
        espaceDeNomCourant = e;
    }

    public void setEtatAnalyse(EtatAnalyse e) {
        etatCourant = e;
    }

    public void setNiveauImbricationMax(int niveau) {
        niveauImbricationMax = niveau;
    }

    public int getNiveauImbricationMax() {
        return niveauImbricationMax;
    }

    /**
     * Ajoute un symbole à la TDS, identifiable par entree
     *
     * @param entree  l'entree de la TDS
     * @param symbole le symbole associé à l'entrée dans la TDS
     * @throws DoubleDeclarationException si l'entrée existe déjà dans la TDS
     */
    public void ajouter(Entree entree, Symbole symbole) throws IllegalStateException, DoubleDeclarationException {
        etatCourant.ajouter(entree, symbole);
    }

    /**
     * Identifie et retourne le symbole associé à l'entrée.
     *
     * @param entree l'entree de la TDS.
     * @return le symbole associé à l'entrée.
     * @throws EntreeNonTrouveException si l'entrée n'existe pas dans la TDS.
     */
    public Symbole identifier(Entree entree) throws IllegalStateException, EntreeNonTrouveException {
        return etatCourant.identifier(entree);
    }

    /**
     * Retourne la taille de la zone des variables, soit le nombre d'octets alloué (son inverse, donc -nbOctets)
     *
     * @return deplacement, la taille de la zone des variables
     */
    public int getTailleZoneVariables() {
        return etatCourant.getTailleZoneVariables();
    }

    /**
     * Alloue (et donc augmente) la taille de la zone des variables
     *
     * @param nbOctets le nombre d'octets à allouer
     */
    public void augmenterTailleZoneVariables(int nbOctets) throws IllegalStateException {
        etatCourant.augmenterTailleZoneVariables(nbOctets);
    }

    public int getTailleZoneParametres() {
        return etatCourant.getTailleZoneParametres();
    }

    public void augmenterTailleZoneParametres(int nbOctets) throws IllegalStateException {
        etatCourant.augmenterTailleZoneParametres(nbOctets);
    }

    public void ajouterSymboleParametre(SymboleVariable p) throws IllegalStateException {
        etatCourant.ajouterSymboleParametre(p);
    }

    public int getTailleDisplay() throws IllegalStateException {
        return etatCourant.getTailleDisplay();
    }

    public int getNiveauImbricationCourant() {
        return etatCourant.getNiveauImbricationCourant();
    }

    public void entreeBloc() {
        etatCourant.entreeBloc();
    }

    public void sortieBloc() {
        etatCourant.sortieBloc();
    }

    public void allerEtatSuivant() {
        etatCourant.allerEtatSuivant();
    }
}
