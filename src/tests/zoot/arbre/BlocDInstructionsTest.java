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

        String attendu = "# Ecrire\nli $v0, 42\nmove $a0, $v0\nli $v0, 1\nsyscall\n# Ecrire\nli $v0, 0\nmove $a0, $v0\nli $v0, 1\nsyscall\n# Ecrire\nli $v0, -42\nmove $a0, $v0\nli $v0, 1\nsyscall\n";

        assertEquals(attendu, blocDInstructions.toMIPS());
    }

    @Test
    void toMIPS_vide() {
        BlocDInstructions blocDInstructions = new BlocDInstructions(0);

        String attendu = "";

        assertEquals(attendu, blocDInstructions.toMIPS());
    }

    @Test
    void toMIPS_un() {
        BlocDInstructions blocDInstructions = new BlocDInstructions(0);

        blocDInstructions.ajouter(new Ecrire(new ConstanteEntiere("42", 1), 1));

        String attendu = "# Ecrire\nli $v0, 42\nmove $a0, $v0\nli $v0, 1\nsyscall\n";

        assertEquals(attendu, blocDInstructions.toMIPS());
    }
}