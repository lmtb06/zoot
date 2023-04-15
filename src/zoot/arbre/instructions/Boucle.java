package zoot.arbre.instructions;

import zoot.arbre.BlocDInstructions;
import zoot.arbre.ConteneurDInstructions;
import zoot.arbre.expressions.Expression;
import zoot.exceptions.GestionnaireExceptionsSemantiques;
import zoot.exceptions.LigneDecorator;
import zoot.exceptions.TypeConditionBoucleException;
import zoot.tds.Type;

import java.util.Optional;

public class Boucle extends Instruction {
    private final Expression condition;
    private final BlocDInstructions instructions;

    public Boucle(Expression condition, BlocDInstructions instructionsBoucle, int n) {
        super(n);
        this.condition = condition;
        this.instructions = instructionsBoucle;
    }

    @Override
    public void verifier() {
        condition.verifier();
        Optional<Type> typeCondition = condition.getType();

        if (typeCondition.isPresent() && typeCondition.get() != Type.BOOLEEN) // Déclenche l'exception seulement dans le cass où la condition n'est pas booléene
            GestionnaireExceptionsSemantiques.getInstance()
                    .ajouter(new LigneDecorator(noLigne,
                            new TypeConditionBoucleException(typeCondition.get())));

        instructions.verifier();
    }

    @Override
    public String toMIPS() {
        return null;
    }

    @Override
    public void sAjouter(ConteneurDInstructions c) {
        c.ajouter(this);
    }
}
