package zoot.arbre.expressions.operateurs.unaire;

import zoot.arbre.expressions.Expression;
import zoot.code_generation.MipsGenerator;
import zoot.code_generation.Registre;
import zoot.tds.Type;

import java.util.List;
import java.util.Optional;

public class Moins extends Unaire {
    public Moins(Expression expression, int n) {
        super(expression, n);
    }

    @Override
    public Optional<Type> getType() {
        return Optional.of(Type.ENTIER);
    }

    @Override
    public String toMips(List<String> registres) {
        MipsGenerator mg = MipsGenerator.getInstance();

        return expression.toMips(registres)
                + mg.operationMoins(Registre.STOCKAGE_RESULTAT.valeur, Registre.STOCKAGE_RESULTAT.valeur);
    }
}
