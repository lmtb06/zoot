package zoot.arbre.instructions;

import zoot.arbre.ConteneurDInstructions;
import zoot.arbre.expressions.Expression;
import zoot.arbre.expressions.Variable;
import zoot.code_generation.MipsGenerator;
import zoot.code_generation.Registre;
import zoot.exceptions.GestionnaireExceptionsSemantiques;
import zoot.exceptions.LigneDecorator;
import zoot.exceptions.TypeIncompatibleException;
import zoot.tds.Type;

import java.util.Optional;

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
        // TODO Revoir la vérification
        Optional<Type> typeVariableOptional = variable.getType();
        Optional<Type> typeExpressionOptional = expression.getType();

        if (typeVariableOptional.isPresent() && typeExpressionOptional.isPresent()
                && typeVariableOptional.get() != typeExpressionOptional.get()) // Déclenche l'exception seulement dans le cas où les deux partie de l'instruction sont valides mais pas du même type
            GestionnaireExceptionsSemantiques.getInstance()
                    .ajouter(new LigneDecorator(noLigne,
                            new TypeIncompatibleException(typeVariableOptional.get(),
                                    typeExpressionOptional.get())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toMIPS() {
        return expression.toMIPS() +
                MipsGenerator.getInstance()
                        .sauvegarderContenuRegistreDansVariable(Registre.STOCKAGE_RESULTAT.valeur, variable);
    }

    /**
     * {@inheritDoc}
     */
    public void sAjouter(ConteneurDInstructions c) {
        c.ajouter(this);
    }
}
