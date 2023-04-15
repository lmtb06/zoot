package zoot.arbre;

import zoot.arbre.instructions.*;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 21 novembre 2018
 * Représente un bloc d'instruction dans l'arbre abstrait.
 *
 * @author brigitte wrobel-dautcourt
 */

public class BlocDInstructions extends ArbreAbstrait implements ConteneurDInstructions {

    protected ArrayList<Instruction> instructions;

    /**
     * Constructeur.
     *
     * @param n la ligne du début du bloc d'instruction dans le code zoot.
     */
    public BlocDInstructions(int n) {
        super(n);
        instructions = new ArrayList<>();
    }

    /**
     * Ajoute une instruction au bloc d'instruction.
     *
     * @param i l'instruction à ajouter.
     */
    public void ajouter(Instruction i) {
        instructions.add(i);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void verifier() {
        for (Instruction i : instructions) {
            i.verifier();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toMIPS() {
        StringBuilder sb = new StringBuilder();

        for (Instruction instruction : instructions) {
            sb.append(instruction.toMIPS());
        }

        return sb.toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return instructions.toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void ajouter(Ecrire e) {
        instructions.add(e);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void ajouter(Affectation a) {
        instructions.add(a);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void ajouter(Retourne e) {
        instructions.add(e);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<Instruction> iterator() {
        return instructions.iterator();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void ajouter(ConteneurDInstructions c) {
        Iterator<Instruction> it = c.iterator();
        while (it.hasNext()) {
            Instruction i = it.next();
            i.sAjouter(this);
        }
    }

    @Override
    public void ajouter(Boucle b) {
        instructions.add(b);
    }

    @Override
    public void ajouter(Condition c) {
        instructions.add(c);
    }
}
