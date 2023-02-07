package zoot.arbre.instructions;

import zoot.arbre.expressions.Expression;
import zoot.code_generation.MipsGenerator;

/**
 * {@inheritDoc}
 * Représente une instruction d'ecriture du résultat d'une expression.
 */
public class Ecrire extends Instruction {

    /**
     * L'expression dont il faut écrire le résultat.
     */
    protected Expression exp ;

    /**
     *
     * @param e L'expression dont il faut écrire le résultat.
     * @param n La ligne du début de l'instruction dans le code zoot.
     */
    public Ecrire (Expression e, int n) {
        super(n) ;
        exp = e ;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void verifier() {
        throw new UnsupportedOperationException("fonction verifier non définie ");
    }

    /**
     * {@inheritDoc}
     * Fait un saut à la ligne une fois le résultat affiché.
     */
    @Override
    public String toMIPS() {
        return
                MipsGenerator.getInstance().afficherRetourLigne();
    }

}
