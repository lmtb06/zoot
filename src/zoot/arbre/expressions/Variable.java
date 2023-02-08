package zoot.arbre.expressions;

import zoot.code_generation.MipsGenerator;
import zoot.code_generation.Registre;
import zoot.exceptions.GestionnaireExceptionsSemantiques;
import zoot.exceptions.LigneDecorator;
import zoot.exceptions.VariableNonDeclarerException;
import zoot.tds.*;

public class Variable extends Identifiable {
    private int deplacement = 0;
    private SymboleVariable symboleVariable;

    public Variable(EntreeVariable e, int n) {
        super(e, n);
    }

    public void instancier()
    {
        symboleVariable = (SymboleVariable) TDS.getInstance().identifier(entree);
        symboleVariable.instancier();
    }

    @Override
    public void verifier() {
        try {
            symboleVariable = (SymboleVariable) TDS.getInstance().identifier(entree);
            if(!symboleVariable.estInstancie()) throw new VariableNonDeclarerException(entree);
            symboleVariable.decorer(this);
        }
        catch (VariableNonDeclarerException variableNonDeclarerException)
        {
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
        return TDS.getInstance().identifier(entree).getType();
    }

    public void setDeplacement(int deplacement) {
        this.deplacement = deplacement;
    }

    public int getDeplacement() {
        return deplacement;
    }
}
