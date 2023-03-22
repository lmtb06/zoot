package zoot.arbre.instructions;

import zoot.arbre.ConteneurDInstructions;
import zoot.arbre.expressions.Expression;
import zoot.arbre.expressions.Variable;
import zoot.code_generation.MipsGenerator;
import zoot.code_generation.Registre;
import zoot.exceptions.GestionnaireExceptionsSemantiques;
import zoot.exceptions.LigneDecorator;
import zoot.exceptions.TypeIncompatibleException;

public class Affectation extends Instruction {
    private final Variable variable;
    private final Expression expression;

    public Affectation(Variable v, Expression e, int n) {
        super(n);
        this.variable = v;
        this.expression = e;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void verifier() {
        variable.verifier();
        expression.verifier();
        if (variable.getType() != expression.getType())
            GestionnaireExceptionsSemantiques.getInstance()
                    .ajouter(new LigneDecorator(noLigne,
                            new TypeIncompatibleException(variable.getType(),
                                    expression.getType())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toMIPS() {
        //TODO
        return expression.toMIPS() +
                MipsGenerator.getInstance()
                        .sauvegarderVariableDepuisRegistre(Registre.STOCKAGE_RESULTAT.valeur, variable.getDeplacement());
    }

    /**
     * {@inheritDoc}
     */
    public void sAjouter(ConteneurDInstructions c) {
        c.ajouter(this);
    }
}
