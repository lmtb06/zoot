package zoot.arbre.expressions.operateurs.unaire;

import zoot.arbre.expressions.Expression;
import zoot.code_generation.Registre;
import zoot.exceptions.GestionnaireExceptionsSemantiques;
import zoot.exceptions.LigneDecorator;
import zoot.exceptions.TypeIncompatibleException;
import zoot.tds.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

abstract class Unaire extends Expression {
    protected Expression expression;

    public Unaire(Expression expression, int n) {
        super(n);
        this.expression = expression;
    }

    @Override
    public void verifier() {
        expression.verifier();
        Optional<Type> monTypeOptional = getType();
        Type monType = monTypeOptional.orElseThrow();
        Optional<Type> typeExpOpt = expression.getType();

        if (typeExpOpt.isPresent() && typeExpOpt.get() != monType) // Déclenche l'exception seulement dans le cas où l'expression n'est pas du même type que l'unaire
            GestionnaireExceptionsSemantiques.getInstance()
                    .ajouter(new LigneDecorator(noLigne,
                            new TypeIncompatibleException(monType, typeExpOpt.get())));
    }

    @Override
    public String toMIPS() {
        List<String> registreDisponibles = new ArrayList<>(2);
        registreDisponibles.add(Registre.STOCKAGE_RESULTAT.valeur);
        registreDisponibles.add(Registre.STOCKAGE_TEMPORAIRE.valeur);
        return toMips(registreDisponibles);
    }

    @Override
    public int getNombreDePlaces() {
        return expression.getNombreDePlaces();
    }
}
