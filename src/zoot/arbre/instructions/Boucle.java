package zoot.arbre.instructions;

import zoot.arbre.BlocDInstructions;
import zoot.arbre.ConteneurDInstructions;
import zoot.arbre.expressions.Expression;
import zoot.code_generation.Registre;
import zoot.exceptions.GestionnaireExceptionsSemantiques;
import zoot.exceptions.LigneDecorator;
import zoot.exceptions.TypeConditionBoucleException;
import zoot.tds.Type;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

public class Boucle extends Instruction implements ConteneurDInstructions {
    private final Expression condition;
    private final ArrayList<Instruction> retournes;
    private final BlocDInstructions instructions;

    public Boucle(Expression condition, BlocDInstructions instructionsBoucle, int n) {
        super(n);
        this.condition = condition;
        this.instructions = instructionsBoucle;
        retournes = new ArrayList<>();
    }

    @Override
    public void verifier() {
        condition.verifier();
        Optional<Type> typeCondition = condition.getType();

        if (typeCondition.isPresent() && typeCondition.get() != Type.BOOLEEN) // Déclenche l'exception seulement dans le cass où la condition n'est pas booléene
            GestionnaireExceptionsSemantiques.getInstance()
                    .ajouter(new LigneDecorator(noLigne,
                            new TypeConditionBoucleException(typeCondition.get())));

        instructions.verifier();
    }

    @Override
    public String toMIPS() {
        StringBuilder sb = new StringBuilder();
        String identifiant = Integer.toString(hashCode());
        sb.append("boucle").append(identifiant).append(":\n");
        sb.append(instructions.toMIPS()).append(condition.toMIPS())
                .append("beq ").append(Registre.STOCKAGE_RESULTAT.valeur).append(", $zero, boucle").append(identifiant).append("\n");
        return sb.toString();
    }

    @Override
    public void sAjouter(ConteneurDInstructions c) {
        c.ajouter(this);
    }

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
