package zoot.arbre.expressions;

import zoot.code_generation.MipsGenerator;
import zoot.code_generation.Registre;
import zoot.exceptions.GestionnaireExceptionsSemantiques;
import zoot.exceptions.LigneDecorator;
import zoot.exceptions.VariableNonDeclarerException;
import zoot.tds.EntreeVariable;
import zoot.tds.TDS;
import zoot.tds.Type;

public class Variable extends Identifiable {
    private int deplacement = 0;

    public Variable(EntreeVariable e, int n) {
        super(e, n);
    }

    @Override
    public void verifier() {
        try {
            symbole = TDS.getInstance().identifier(entree);
            symbole.decorer(this);
        } catch (VariableNonDeclarerException variableNonDeclarerException) {
            GestionnaireExceptionsSemantiques.getInstance()
                    .ajouter(new LigneDecorator(this.noLigne, variableNonDeclarerException));
        }
    }

    @Override
    public String toMIPS() {
        return MipsGenerator.getInstance()
                .recupererVariableDepuisPile(Registre.STOCKAGE_RESULTAT.valeur, deplacement);
    }

    @Override
    public Type getType() {
        return symbole.getType();
    }

    public int getDeplacement() {
        return deplacement;
    }

    public void setDeplacement(int deplacement) {
        this.deplacement = deplacement;
    }
}
