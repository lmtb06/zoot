package zoot.arbre.instructions;

import org.junit.jupiter.api.Test;
import zoot.arbre.expressions.ConstanteEntiere;
import zoot.code_generation.Registre;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EcrireTest {

    @Test
    void toMIPS_positif() {
        // Afficher 42 et sauter à la ligne
        String attendu =  "li $v0, 42\nmove $a0, " + Registre.STOCKAGE_RESULTAT.valeur + "\nli $v0, 1\nsyscall\n" +
                "li $a0, 10\n" + "li $v0, 11\n" + "syscall\n";
        Ecrire ecrire = new Ecrire(new ConstanteEntiere("42", 0), 0);

        assertEquals(attendu, ecrire.toMIPS());
    }

    @Test
    void toMIPS_zero() {
        // Afficher 0 et sauter à la ligne
        String attendu =  "li $v0, 0\nmove $a0, " + Registre.STOCKAGE_RESULTAT.valeur + "\nli $v0, 1\nsyscall\n" +
                "li $a0, 10\n" + "li $v0, 11\n" + "syscall\n";
        Ecrire ecrire = new Ecrire(new ConstanteEntiere("0", 0), 0);

        assertEquals(attendu, ecrire.toMIPS());
    }

    @Test
    void toMIPS_negatif() {
        // Afficher -42 et sauter à la ligne
        String attendu =  "li $v0, -42\nmove $a0, " + Registre.STOCKAGE_RESULTAT.valeur + "\nli $v0, 1\nsyscall\n" +
                "li $a0, 10\n" + "li $v0, 11\n" + "syscall\n";
        Ecrire ecrire = new Ecrire(new ConstanteEntiere("-42", 0), 0);

        assertEquals(attendu, ecrire.toMIPS());
    }
}