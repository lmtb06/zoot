package zoot.arbre.instructions;

import zoot.arbre.expressions.Expression;
import zoot.code_generation.MipsGenerator;

public class Ecrire extends Instruction {

    protected Expression exp ;

    public Ecrire (Expression e, int n) {
        super(n) ;
        exp = e ;
    }

    @Override
    public void verifier() {
        throw new UnsupportedOperationException("fonction verfier non définie ");
    }

    @Override
    public String toMIPS() {
        return exp.getMIPSAffichage() +
                MipsGenerator.getInstance().afficherRetourLigne();
    }

}
