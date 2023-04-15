package zoot.arbre.expressions.operateurs.unaire;

import zoot.arbre.expressions.Expression;
import zoot.code_generation.MipsGenerator;
import zoot.code_generation.Registre;
import zoot.tds.Type;

import java.util.List;
import java.util.Optional;

public class Non extends Unaire {
    public Non(Expression expression, int n) {
        super(expression, n);
    }

    @Override
    public Optional<Type> getType() {
        return Optional.of(Type.BOOLEEN);
    }

    @Override
    public String toMips(List<String> registres) {

        MipsGenerator mg = MipsGenerator.getInstance();

        return expression.toMips(registres)
                + mg.operationNon(Registre.STOCKAGE_RESULTAT.valeur, Registre.STOCKAGE_RESULTAT.valeur);
    }
}
