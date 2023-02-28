package zoot.arbre.instructions;

import zoot.arbre.ConteneurDInstructions;
import zoot.arbre.expressions.Expression;

public class Retourne extends Instruction {

    protected Expression exp;

    public Retourne(Expression e, int n)
    {
        super(n);
        this.exp = e;
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
