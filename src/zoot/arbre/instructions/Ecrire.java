package zoot.arbre.instructions;

import zoot.arbre.expressions.Expression;
import zoot.code_generation.MipsGenerator;
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
     * Retourne le code MIPS pour afficher le résultat de l’évaluation d’une expression et sauter à la ligne
     * @return Le code MIPS pour afficher le résultat de l’evaluation d’une expression et sauter à la ligne
     */
    @Override
    public String toMIPS() {
        return exp.toMIPS()
                + MipsGenerator.getInstance().afficherEntierRegistre(Registre.STOCKAGE_RESULTAT.valeur);
    }

}
