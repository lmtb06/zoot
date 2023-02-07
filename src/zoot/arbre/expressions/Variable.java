package zoot.arbre.expressions;

import zoot.exceptions.GestionnaireExceptionsSemantiques;
import zoot.exceptions.LigneDecorator;
import zoot.exceptions.VariableNonDeclarerException;
import zoot.tds.Entree;
import zoot.tds.SymboleVariable;
import zoot.tds.TDS;
import zoot.tds.Type;

public class Variable extends Identifiable {
    private int deplacement = 1;
    private SymboleVariable symboleVariable;

    public Variable(Entree e, int n) {
        super(e, n);
    }

    @Override
    public void verifier() {
        try {
            TDS.getInstance().identifier(entree);
        }
        catch (VariableNonDeclarerException variableNonDeclarerException)
        {
            GestionnaireExceptionsSemantiques.getInstance()
                    .ajouter(new LigneDecorator(this.noLigne, variableNonDeclarerException));
        }
    }

    @Override
    public String toMIPS() {
        return null;
    }

    @Override
    public Type getType() {
        return TDS.getInstance().identifier(entree).getType();
    }

    public void setDeplacement(int deplacement) {
        this.deplacement = deplacement;
    }
}
