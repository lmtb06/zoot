package zoot.arbre.expressions.operateurs.unaire;

import zoot.arbre.expressions.Expression;
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
        return null;
    }
}
