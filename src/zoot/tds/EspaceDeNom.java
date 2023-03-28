package zoot.tds;

import zoot.exceptions.DoubleDeclarationException;
import zoot.exceptions.EntreeNonTrouveException;
import zoot.tds.entrees.Entree;
import zoot.tds.symboles.Symbole;
import zoot.tds.symboles.SymboleVariable;

import java.util.ArrayList;
import java.util.HashMap;

public class EspaceDeNom {
    private final ArrayList<SymboleVariable> symbolesParametres;
    private int tailleZoneVariables = 0;
    private int noSousEspaceDeNomCourant;
    private final int niveauImbrication;
    private EspaceDeNom parent;
    private final ArrayList<EspaceDeNom> enfants;
    private final HashMap<Entree, Symbole> tableDesSymboles;
    private int tailleZoneParametres = 0;

    public EspaceDeNom(int niveauImbrication) {
        this.niveauImbrication = niveauImbrication;
        enfants = new ArrayList<>();
        tableDesSymboles = new HashMap<>();
        symbolesParametres = new ArrayList<>();
    }

    /**
     * Ajoute le couple entree symbole dans cet espace de nom
     *
     * @param entree  l'entree
     * @param symbole le symbole associé à l'entrée
     * @throws DoubleDeclarationException si l'entrée existe déjà dans cet espace de nom
     */
    public void ajouter(Entree entree, Symbole symbole) throws DoubleDeclarationException {
        if (tableDesSymboles.containsKey(entree))
            throw new DoubleDeclarationException(entree);
        tableDesSymboles.put(entree, symbole);
    }

    /**
     * Identifie et retourne le symbole associé à l'entrée
     * l'entrée peut-être dans cet espace de nom ou dans l'un de ses parents
     * (exemple: parent de son parent, ou dans son parent, etc).
     *
     * @param entree l'entree de la TDS.
     * @return le symbole associé à l'entrée.
     * @throws EntreeNonTrouveException si l'entrée n'existe pas.
     */
    public Symbole identifier(Entree entree) throws EntreeNonTrouveException {
        Symbole symboleAIdentifier = tableDesSymboles.get(entree);

        boolean entreeInconnue = symboleAIdentifier == null;
        if (entreeInconnue) {
            boolean jaiUnParent = parent != null;
            if (jaiUnParent) {
                symboleAIdentifier = parent.identifier(entree);
            } else {
                throw new EntreeNonTrouveException(entree);
            }
        }

        return symboleAIdentifier;
    }

    public int getTailleZoneVariables() {
        return tailleZoneVariables;
    }

    public void augmenterTailleZoneVariables(int nbOctets) {
        tailleZoneVariables += nbOctets;
    }

    public int getTailleZoneParametres() {
        return tailleZoneParametres;
    }

    public void augmenterTailleZoneParametres(int nbOctets) {
        tailleZoneParametres += nbOctets;
    }

    public void ajouterSymboleParametre(SymboleVariable p) {
        symbolesParametres.add(p);
    }

    public void ajouterDeplacementDisplayAuxParametres(int tailleDisplayEnOctets) {

        for (SymboleVariable s : symbolesParametres) {
            s.setDeplacement(s.getDeplacement() + tailleDisplayEnOctets + 8);
        }

        for (EspaceDeNom e : enfants) {
            e.ajouterDeplacementDisplayAuxParametres(tailleDisplayEnOctets);
        }
    }

    /**
     * Defini l'espace de nom e comme etant le parent de cet espace de nom
     *
     * @param e le parent
     */
    public void setEspaceDeNomParent(EspaceDeNom e) {
        parent = e;
    }

    /**
     * Ajoute un enfant e à sa collection d'enfant et set le parent de e comme etant lui
     *
     * @param e l'{@link EspaceDeNom} enfant
     */
    public void ajouterSousEspaceDeNom(EspaceDeNom e) {
        enfants.add(e);
        e.setEspaceDeNomParent(this);
    }

    public EspaceDeNom getEspaceDeNomParent() {
        return parent;
    }

    /**
     * Donne le prochain espace de nom enfant du parcours de ses enfants
     *
     * @return le prochain espace de nom du parcours de ses enfants
     * @throws IndexOutOfBoundsException s'il n'y a pas de prochain enfant
     */
    public EspaceDeNom getProchainSousEspaceDeNom() {
        noSousEspaceDeNomCourant += 1;
        return enfants.get(noSousEspaceDeNomCourant - 1);
    }

    /**
     * Reset le parcours de ses enfants et le parcours des enfants de toute sa descendance
     */
    public void resetParcoursSousEspaceDeNom() {
        noSousEspaceDeNomCourant = 0;
        for (EspaceDeNom e : enfants) e.resetParcoursSousEspaceDeNom();
    }

    public int getNiveauImbricationMax() {
        int output = niveauImbrication;

        for (EspaceDeNom e : enfants)
            output = Math.max(e.getNiveauImbricationMax(), output);

        return output;
    }

    public int getNiveauImbrication() {
        return niveauImbrication;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        StringBuilder tabs = new StringBuilder();
        tabs.append("\t".repeat(niveauImbrication));

        sb.append(tabs).append(niveauImbrication).append("++\n").append(tabs).append("- Entrées : ");

        for (Entree e : tableDesSymboles.keySet()) {
            sb.append(e.getIdentifiant()).append(" | ");
        }

        sb.append('\n').append(tabs).append("- Enfants :\n");

        for (EspaceDeNom e :
                enfants) {
            sb.append(e).append('\n');
        }
        sb.append(tabs).append(niveauImbrication).append("--");

        return sb.toString();
    }
}
