package zoot.arbre;

import zoot.arbre.instructions.Instruction;

import java.util.ArrayList;

/**
 * 21 novembre 2018
 *
 * @author brigitte wrobel-dautcourt
 */

public class BlocDInstructions extends ArbreAbstrait {
    
    protected ArrayList<Instruction> programme ;

    public BlocDInstructions(int n) {
        super(n) ;
        programme = new ArrayList<>() ;
    }

    /**
     * Ajoute une instruction au BlocDInstruction
     * @param i une Instruction
     */
    public void ajouter(Instruction i) {
        programme.add(i) ;
    }

    @Override
    public void verifier() {
        // throw new UnsupportedOperationException("fonction verfier non définie ");
    }

    /**
     * Génère le code MIPS de notre BlocDInstruction
     * @return Le code MIPS associé à notre BlocDInstruction
     */
    @Override
    public String toMIPS() {
        StringBuilder sb = new StringBuilder();
        sb.append(mipsGenerator.enteteProgramme());

        for (Instruction instruction : programme) {
            sb.append(instruction.toMIPS());
        }

        sb.append(mipsGenerator.finProgramme());

        return sb.toString();
    }

    /**
     * Retourne une String associé à BlocDInstruction
     * @return la String associé programme
     */
    @Override
    public String toString() {
        return programme.toString() ;
    }

}
