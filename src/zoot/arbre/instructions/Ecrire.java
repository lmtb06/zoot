package zoot.arbre.instructions;

import zoot.arbre.expressions.ConstanteEntiere;
import zoot.arbre.expressions.Expression;
import zoot.arbre.expressions.Variable;
import zoot.code_generation.MipsGenerator;
import zoot.code_generation.Registre;

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
        exp.verifier();
    }

    /**
     * {@inheritDoc}
     * Fait un saut à la ligne une fois le résultat affiché.
     */
    @Override
    public String toMIPS() {
        StringBuilder sb = new StringBuilder();
        MipsGenerator mg = MipsGenerator.getInstance();
        sb.append(exp.toMIPS());
        switch (exp.getType()) {
            case ENTIER:
                sb.append(mg.afficherEntierRegistre(Registre.STOCKAGE_RESULTAT.valeur));
                break;
            case BOOLEEN:
                sb.append(mg.afficherBooleenRegistre(Registre.STOCKAGE_RESULTAT.valeur));
                break;
        }
        sb.append(mg.afficherRetourLigne());
        return sb.toString();
    }

}
