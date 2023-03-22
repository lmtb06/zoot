package zoot.arbre.expressions;

import zoot.code_generation.MipsGenerator;
import zoot.code_generation.Registre;
import zoot.exceptions.EntreeNonTrouveException;
import zoot.exceptions.GestionnaireExceptionsSemantiques;
import zoot.exceptions.LigneDecorator;
import zoot.exceptions.VariableNonDeclarerException;
import zoot.tds.entrees.EntreeVariable;

public class Variable extends Identifiable {
    private int deplacement = 0;
    private int niveauImbrication;

    public Variable(EntreeVariable e, int n) {
        super(e, n);
    }

    public int getDeplacement() {
        return deplacement;
    }

    /**
     * Set le déplacement de la variable.
     *
     * @param deplacement le déplacement de la variable dans la pile relatif à son espace de nom.
     */
    public void setDeplacement(int deplacement) {
        this.deplacement = deplacement;
    }

    public int getNiveauImbrication() {
        return niveauImbrication;
    }

    /**
     * Set le niveau d'imbrication.
     *
     * @param niveauImbrication le niveau d'imbrication du bloc de déclaration de la variable.
     */
    public void setNiveauImbrication(int niveauImbrication) {
        this.niveauImbrication = niveauImbrication;
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
                    .ajouter(new LigneDecorator(this.noLigne, new VariableNonDeclarerException(entree)));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toMIPS() {
        return MipsGenerator.getInstance()
                .chargerContenuVariableDansRegistre(this, Registre.STOCKAGE_RESULTAT.valeur);
    }
}
