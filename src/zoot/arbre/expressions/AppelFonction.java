package zoot.arbre.expressions;

import zoot.code_generation.MipsGenerator;
import zoot.code_generation.Registre;
import zoot.exceptions.EntreeNonTrouveException;
import zoot.exceptions.FonctionNonDeclarerException;
import zoot.exceptions.GestionnaireExceptionsSemantiques;
import zoot.exceptions.LigneDecorator;
import zoot.tds.TDS;
import zoot.tds.Type;
import zoot.tds.entrees.EntreeFonction;

import java.util.*;

public class AppelFonction extends Identifiable {
    private int niveauImbrication;
    private int tailleDisplay;
    private int tailleZoneParametres;
    private String etiquette;

    private final ArrayList<Expression> parametres;

    public AppelFonction(String identifiant, int n, Expression... parametres) {
        super(identifiant, n);
        this.parametres = new ArrayList<>(parametres.length);

        Collections.addAll(this.parametres, parametres);
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
     * @return les paramètres de l'appel de fonction dans l'ordre
     */
    public Iterator<Expression> getParametres() {

        return parametres.iterator();
    }

    /**
     * {@inheritDoc}
     * Décore la variable pour la génération de code grâce à son symbole.
     */
    @Override
    public void verifier() {
        ArrayList<Type> typesParametres = new ArrayList<>(parametres.size());

        for (Expression e : parametres) {
            e.verifier();
            Optional<Type> typeOptional = e.getType();
            if (typeOptional.isPresent()) {
                Type type = typeOptional.get();
                tailleZoneParametres += type.taille;
                typesParametres.add(type);
            }
        }

        EntreeFonction entree = new EntreeFonction(identifiant, typesParametres);

        try {
            symbole = TDS.getInstance().identifier(entree);
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

    @Override
    public String toMips(List<String> registres) {
        // TODO
        return "";
    }
}
