package zoot.arbre;

import zoot.arbre.instructions.Instruction;
import zoot.code_generation.MipsGenerator;

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
    
    public void ajouter(Instruction i) {
        programme.add(i) ;
    }

    @Override
    public void verifier() {
        // throw new UnsupportedOperationException("fonction verfier non définie ");
    }
    
    @Override
    public String toMIPS() {
        StringBuilder sb = new StringBuilder();
        sb.append(MipsGenerator.getInstance().enteteProgramme());

        for (Instruction instruction : programme) {
            sb.append(instruction.toMIPS());
        }

        sb.append(MipsGenerator.getInstance().finProgramme());

        return sb.toString();
    }

    @Override
    public String toString() {
        return programme.toString() ;
    }

}
