package zoot.arbre.instructions;

import zoot.arbre.expressions.Expression;
import zoot.arbre.expressions.Variable;
import zoot.exceptions.GestionnaireExceptionsSemantiques;
import zoot.exceptions.TypeIncompatibleException;
import zoot.exceptions.VariableNonDeclarerException;

public class Affectation extends Instruction {
    private final Variable variable;
    private final Expression expression;
    public Affectation(Variable v, Expression e, int n) {
        super(n);
        this.variable = v;
        this.expression = e;
    }

    @Override
    public void verifier() {
        try{
            variable.instancier();
            variable.verifier();
            expression.verifier();
            if (variable.getType() != expression.getType())
                GestionnaireExceptionsSemantiques.getInstance()
                        .ajouter(new TypeIncompatibleException(variable.getType(),
                                expression.getType()));
        }
        catch (VariableNonDeclarerException variableNonDeclarerException)
        {
            GestionnaireExceptionsSemantiques.getInstance()
                    .ajouter(variableNonDeclarerException);
        }
    }

    @Override
    public String toMIPS() {
        return expression.toMIPS() +
                "sw $v0, " + variable.getDeplacement() + "($s7)\n";
    }
}
