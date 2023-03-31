package zoot.arbre.instructions;

import zoot.arbre.ConteneurDInstructions;
import zoot.arbre.expressions.Expression;
import zoot.code_generation.MipsGenerator;
import zoot.code_generation.Registre;
import zoot.tds.Type;

import java.util.Optional;

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
        Optional<Type> typeOptional = exp.getType();
        if (typeOptional.isPresent()) { // Le cas contraire ne devrait pas arriver techniquement vu que toMIPS n'est appelé que si la compilation s'est bien passée
            Type type = typeOptional.get();
            sb.append(exp.toMIPS());

            switch (type) {
                case ENTIER -> sb.append(mg.afficherEntierRegistre(Registre.STOCKAGE_RESULTAT.valeur));
                case BOOLEEN -> sb.append(mg.afficherBooleenRegistre(Registre.STOCKAGE_RESULTAT.valeur));
            }
            sb.append(mg.afficherRetourLigne());
        }
        return sb.toString();
    }

    /**
     * {@inheritDoc}
     */
    public void sAjouter(ConteneurDInstructions c) {
        c.ajouter(this);
    }
}
