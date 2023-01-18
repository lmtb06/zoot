package zoot.arbre.instructions;

import org.junit.jupiter.api.Test;
import zoot.arbre.expressions.ConstanteEntiere;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EcrireTest {

    @Test
    void toMIPS_positif() {
        String attendu =  "# Ecrire\nli $v0, 42\nmove $a0, $v0\nli $v0, 1\nsyscall\n";
        Ecrire ecrire = new Ecrire(new ConstanteEntiere("42", 0), 0);

        assertEquals(ecrire.toMIPS(), attendu);
    }

    @Test
    void toMIPS_zero() {
        String attendu =  "# Ecrire\nli $v0, 0\nmove $a0, $v0\nli $v0, 1\nsyscall\n";
        Ecrire ecrire = new Ecrire(new ConstanteEntiere("0", 0), 0);

        assertEquals(ecrire.toMIPS(), attendu);
    }

    @Test
    void toMIPS_negatif() {
        String attendu =  "# Ecrire\nli $v0, -42\nmove $a0, $v0\nli $v0, 1\nsyscall\n";
        Ecrire ecrire = new Ecrire(new ConstanteEntiere("-42", 0), 0);

        assertEquals(ecrire.toMIPS(), attendu);
    }
}