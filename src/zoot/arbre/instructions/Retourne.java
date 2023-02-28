package zoot.arbre.instructions;

import zoot.arbre.ConteneurDInstructions;
import zoot.arbre.expressions.Expression;
import zoot.tds.Type;

public class Retourne extends Instruction {

    protected Expression exp;

    public Retourne(Expression e, int n)
    {
        super(n);
        this.exp = e;
    }

    public Type getType()
    {
        return exp.getType();
    }

    @Override
    public void verifier() {
        exp.verifier();
    }

    @Override
    public String toMIPS() {
        //TODO
        return null;
    }

    @Override
    public void sAjouter(ConteneurDInstructions c) {
        c.ajouter(this);
    }
}
