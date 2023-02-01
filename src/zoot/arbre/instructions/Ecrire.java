package zoot.arbre.instructions;

import zoot.arbre.expressions.Expression;
import zoot.code_generation.Registre;

public class Ecrire extends Instruction {

    protected Expression exp ;

    public Ecrire (Expression e, int n) {
        super(n) ;
        exp = e ;
    }

    @Override
    public void verifier() {
        //throw new UnsupportedOperationException("fonction verfier non définie ");
    }

    /**
     * Génère le code MIPS pour afficher notre Expression exp et sauter à la ligne
     * @return Génère le code MIPS pour afficher notre Expression exp et sauter à la ligne
     */
    @Override
    public String toMIPS() {
        return mipsGenerator.chargementImmediat(Registre.STOCKAGE_RESULTAT.valeur, exp.toMIPS())
                + mipsGenerator.afficherEntierRegistre(Registre.STOCKAGE_RESULTAT.valeur);
    }
}
