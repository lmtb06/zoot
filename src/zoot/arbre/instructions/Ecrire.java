package zoot.arbre.instructions;

import zoot.arbre.expressions.ConstanteEntiere;
import zoot.arbre.expressions.Expression;

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
        return exp.getMipsEcriture(this) + "# Affichage saut\n" +
                "li $a0,  10\n" +
                "li $v0,    11          # code 11 syscall pour affichage caractère\n" +
                "syscall";
    }

    public String getMips(ConstanteEntiere ce){
        return "# Ecrire\n" +
                ce.toMIPS() +
                "move $a0, $v0\n" +
                "li $v0, 1\n" +
                "syscall\n";
    }
}
