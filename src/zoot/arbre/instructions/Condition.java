package zoot.arbre.instructions;

import zoot.arbre.BlocDInstructions;
import zoot.arbre.ConteneurDInstructions;
import zoot.arbre.expressions.Expression;
import zoot.code_generation.Registre;
import zoot.exceptions.GestionnaireExceptionsSemantiques;
import zoot.exceptions.LigneDecorator;
import zoot.exceptions.TypeConditionConditionException;
import zoot.tds.Type;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

public class Condition extends Instruction implements ConteneurDInstructions {
    private final Expression condition;
    private final ArrayList<Instruction> retournes;
    private final BlocDInstructions blocConditionVerifiee;
    private final BlocDInstructions blocConditionNonVerifiee;

    public Condition(Expression condition, BlocDInstructions blocConditionVerifiee, BlocDInstructions blocConditionNonVerifiee, int n) {
        super(n);

        retournes = new ArrayList<>();

        for (Iterator<Instruction> it = blocConditionVerifiee.iterator(); it.hasNext(); ) {
            Instruction i = it.next();
            i.sAjouter(this);
        }

        for (Iterator<Instruction> it = blocConditionNonVerifiee.iterator(); it.hasNext(); ) {
            Instruction i = it.next();
            i.sAjouter(this);
        }

        this.condition = condition;
        this.blocConditionVerifiee = blocConditionVerifiee;
        this.blocConditionNonVerifiee = blocConditionNonVerifiee;
    }

    @Override
    public void verifier() {
        condition.verifier();
        Optional<Type> typeCondition = condition.getType();

        if (typeCondition.isPresent() && typeCondition.get() != Type.BOOLEEN) // Déclenche l'exception seulement dans le cass où la condition n'est pas booléene
            GestionnaireExceptionsSemantiques.getInstance()
                    .ajouter(new LigneDecorator(noLigne,
                            new TypeConditionConditionException(typeCondition.get())));

        blocConditionVerifiee.verifier();
        blocConditionNonVerifiee.verifier();
    }

    @Override
    public String toMIPS() {
        StringBuilder sb = new StringBuilder();
        String labelSinon = "Sinon" + hashCode();
        String labelFinSi = "Finsi" + hashCode();
        sb.append(condition.toMIPS()).append("beq ").append(Registre.STOCKAGE_RESULTAT.valeur).append(", $zero, ").append(labelSinon).append("\n")
                .append(blocConditionVerifiee.toMIPS())
                .append("j ").append(labelFinSi).append("\n")
                .append(labelSinon).append(" :\n")
                .append(blocConditionNonVerifiee.toMIPS())
                .append("j ").append(labelFinSi).append("\n")
                .append(labelFinSi).append(" :\n")
        ;
        return sb.toString();
    }

    @Override
    public void sAjouter(ConteneurDInstructions c) {
        c.ajouter(this);
    }

    /**
     * Tous les retournes contenus dans le corps de la condition (sinon y compris)
     *
     * @return les retournes contenus dans le corps de la condition (sinon y compris)
     */
    @Override
    public Iterator<Instruction> iterator() {

        return retournes.iterator();
    }

    @Override
    public void ajouter(Ecrire e) {

    }

    @Override
    public void ajouter(Affectation a) {

    }

    @Override
    public void ajouter(Retourne e) {
        retournes.add(e);
    }

    @Override
    public void ajouter(ConteneurDInstructions c) {

    }

    @Override
    public void ajouter(Boucle b) {
        for (Iterator<Instruction> it = b.iterator(); it.hasNext(); ) {
            Instruction i = it.next();
            i.sAjouter(this);
        }
    }

    @Override
    public void ajouter(Condition c) {
        for (Iterator<Instruction> it = c.iterator(); it.hasNext(); ) {
            Instruction i = it.next();
            i.sAjouter(this);
        }
    }
}
