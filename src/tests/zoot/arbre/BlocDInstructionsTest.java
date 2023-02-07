package zoot.arbre;

import org.junit.jupiter.api.Test;
import zoot.arbre.expressions.ConstanteEntiere;
import zoot.arbre.instructions.Ecrire;

import static org.junit.jupiter.api.Assertions.*;

class BlocDInstructionsTest {

    @Test
    void toMIPS_trois() {
        BlocDInstructions blocDInstructions = new BlocDInstructions(0);

        blocDInstructions.ajouter(new Ecrire(new ConstanteEntiere("42", 1), 1));
        blocDInstructions.ajouter(new Ecrire(new ConstanteEntiere("0", 1), 1));
        blocDInstructions.ajouter(new Ecrire(new ConstanteEntiere("-42", 1), 1));

        String attendu = ".text\n" +
                "main :\n" +
                "# début du programme\n" +
                "move $s7, $sp\n" +
                "li $v0, 42\n" +
                "move $a0, $v0\n" +
                "li $v0, 1\n" +
                "syscall\n" +
                "li $a0, 10\n" +
                "li $v0, 11\n" +
                "syscall\n" +
                "li $v0, 0\n" +
                "move $a0, $v0\n" +
                "li $v0, 1\n" +
                "syscall\n" +
                "li $a0, 10\n" +
                "li $v0, 11\n" +
                "syscall\n" +
                "li $v0, -42\n" +
                "move $a0, $v0\n" +
                "li $v0, 1\n" +
                "syscall\n" +
                "li $a0, 10\n" +
                "li $v0, 11\n" +
                "syscall\n" +
                "selection_label_booleen:\n" +
                "beq $a0, 0, sinon_label_booleen\n" +
                "la $v0, vrai\n" +
                "sinon_label_booleen:\n" +
                "la $v0, faux\n" +
                "jr $ra\n" +
                "end :\n" +
                "# fin du programme\n" +
                "li $v0, 10\n" +
                "syscall\n";

        assertEquals(attendu, blocDInstructions.toMIPS());
    }

    @Test
    void toMIPS_vide() {
        BlocDInstructions blocDInstructions = new BlocDInstructions(0);

        String attendu = ".text\n" +
                "main :\n" +
                "# début du programme\n" +
                "move $s7, $sp\n" +
                "selection_label_booleen:\n" +
                "beq $a0, 0, sinon_label_booleen\n" +
                "la $v0, vrai\n" +
                "sinon_label_booleen:\n" +
                "la $v0, faux\n" +
                "jr $ra\n" +
                "end :\n" +
                "# fin du programme\n" +
                "li $v0, 10\n" +
                "syscall\n";

        assertEquals(attendu, blocDInstructions.toMIPS());
    }

    @Test
    void toMIPS_un() {
        BlocDInstructions blocDInstructions = new BlocDInstructions(0);

        blocDInstructions.ajouter(new Ecrire(new ConstanteEntiere("42", 1), 1));

        String attendu = ".text\n" +
                "main :\n" +
                "# début du programme\n" +
                "move $s7, $sp\n" +
                "li $v0, 42\n" +
                "move $a0, $v0\n" +
                "li $v0, 1\n" +
                "syscall\n" +
                "li $a0, 10\n" +
                "li $v0, 11\n" +
                "syscall\n" +
                "selection_label_booleen:\n" +
                "beq $a0, 0, sinon_label_booleen\n" +
                "la $v0, vrai\n" +
                "sinon_label_booleen:\n" +
                "la $v0, faux\n" +
                "jr $ra\n" +
                "end :\n" +
                "# fin du programme\n" +
                "li $v0, 10\n" +
                "syscall\n";

        assertEquals(attendu, blocDInstructions.toMIPS());
    }
}