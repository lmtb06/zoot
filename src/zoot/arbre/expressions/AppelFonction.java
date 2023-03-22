package zoot.arbre.expressions;

import zoot.code_generation.MipsGenerator;
import zoot.code_generation.Registre;
import zoot.exceptions.EntreeNonTrouveException;
import zoot.exceptions.FonctionNonDeclarerException;
import zoot.exceptions.GestionnaireExceptionsSemantiques;
import zoot.exceptions.LigneDecorator;
import zoot.tds.entrees.EntreeFonction;

public class AppelFonction extends Identifiable {
    private int niveauImbrication;
    private int tailleDisplay;
    private final int tailleZoneParametres;
    private String etiquette;

    public AppelFonction(EntreeFonction e, int n) {
        super(e, n);
        tailleZoneParametres = e.getTypeParametres().size() * 4;
    }

    public int getTailleZoneParametres() {
        return tailleZoneParametres;
    }

    public int getTailleDisplay() {
        return tailleDisplay;
    }

    /**
     * Set la taille du display pour la génération de code.
     *
     * @param tailleDisplay la taille du display du programme.
     */
    public void setTailleDisplay(int tailleDisplay) {
        this.tailleDisplay = tailleDisplay;
    }

    public int getNiveauImbrication() {
        return niveauImbrication;
    }

    /**
     * Set le niveau d'imbrication de l'appel fonction.
     *
     * @param niveauImbrication le niveau d'imbrication de l'appel fonction dans le programme
     *                          pour savoir quelle partie du display mettre à jour.
     */
    public void setNiveauImbrication(int niveauImbrication) {
        this.niveauImbrication = niveauImbrication;
    }

    public String getEtiquette() {
        return etiquette;
    }

    /**
     * Set l'etiquette de l'appel de fonction.
     *
     * @param etiquette l'étiquette qui a été attribué lors de la définition de la fonction.
     */
    public void setEtiquette(String etiquette) {
        this.etiquette = etiquette;
    }

    /**
     * {@inheritDoc}
     * Décore la variable pour la génération de code grâce à son symbole.
     */
    @Override
    public void verifier() {
        try {
            super.verifier();
            symbole.decorer(this);
        } catch (EntreeNonTrouveException e) {
            GestionnaireExceptionsSemantiques.getInstance()
                    .ajouter(new LigneDecorator(this.noLigne, new FonctionNonDeclarerException(entree)));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toMIPS() {
        return MipsGenerator.getInstance().executerFonctionEtMettreResultatDansRegistre(this, Registre.STOCKAGE_RESULTAT.valeur);
    }
}
