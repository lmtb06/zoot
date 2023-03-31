package zoot.arbre.expressions;

import zoot.tds.Type;
import zoot.tds.symboles.Symbole;

import java.util.Optional;

public abstract class Identifiable extends Expression {
    protected String identifiant;
    protected Symbole symbole;

    public Identifiable(String identifiant, int n) {
        super(n);
        this.identifiant = identifiant;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Type> getType() {
        Optional<Type> type = Optional.empty();

        if (symbole != null)
            type = Optional.of(symbole.getType());

        return type;
    }
}
