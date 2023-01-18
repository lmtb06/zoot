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
    
    public void ajouter(Instruction i) {
        programme.add(i) ;
    }

    @Override
    public void verifier() {

    }
    
    @Override
    public String toMIPS() {
        StringBuilder sb = new StringBuilder();
        sb.append(".text\n" +
                "main :\n" +
                "    # initialiser s7 avec sp (initialisation de la base des variables)\n" +
                "    move $s7, $sp\n");
        for (Instruction instruction : programme) {
            sb.append(instruction.toMIPS());
        }
        sb.append("end :\n" +
                "    # fin du programme\n" +
                "    li $v0, 10      # retour au syst�me\n" +
                "    syscall ");

        return sb.toString();
    }

    @Override
    public String toString() {
        return programme.toString() ;
    }

}
