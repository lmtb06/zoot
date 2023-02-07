package zoot.arbre.expressions;

import zoot.tds.Type;

public class ConstanteBooleene extends Constante{

    public ConstanteBooleene(String texte, int n) {
        super(texte, n);
    }

    @Override
    public String toMIPS() {
        return null;
    }

    @Override
    public Type getType() {
        return Type.BOOLEEN;
    }
}
