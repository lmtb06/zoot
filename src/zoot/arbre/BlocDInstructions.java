package zoot.arbre;

import zoot.arbre.instructions.Instruction;
import zoot.code_generation.MipsGenerator;
import zoot.tds.TDS;

import java.util.ArrayList;

/**
 * 21 novembre 2018
 * Représente un bloc d'instruction dans l'arbre abstrait.
 *
 * @author brigitte wrobel-dautcourt
 */

public class BlocDInstructions extends ArbreAbstrait {

    protected ArrayList<Instruction> programme;
    private int tailleZoneVariables;

    /**
     * Constructeur.
     *
     * @param n la ligne du début du bloc d'instruction dans le code zoot.
     */
    public BlocDInstructions(int n) {
        super(n);
        programme = new ArrayList<>();
    }

    /**
     * Ajoute une instruction au bloc d'instruction.
     *
     * @param i l'instruction à ajouter.
     */
    public void ajouter(Instruction i) {
        programme.add(i);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void verifier() {
        for (Instruction i :
                programme) {
            i.verifier();
        }
        tailleZoneVariables = TDS.getInstance().getTailleZoneVariables();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toMIPS() {
        StringBuilder sb = new StringBuilder();
        sb.append(MipsGenerator.getInstance().enteteProgramme(tailleZoneVariables));

        for (Instruction instruction : programme) {
            sb.append(instruction.toMIPS());
        }

        sb.append(MipsGenerator.getInstance().finProgramme());

        return sb.toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return programme.toString();
    }

}
