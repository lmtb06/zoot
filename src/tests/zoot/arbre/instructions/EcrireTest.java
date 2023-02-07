package zoot.arbre.instructions;

import org.junit.jupiter.api.Test;
import zoot.arbre.expressions.ConstanteBooleene;
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

    @Test
    void toMIPS_vrai() {
        Ecrire ecrire = new Ecrire(new ConstanteBooleene("vrai", 13), 14);
        String attendu = "li $v0, 1\n" +
                "move $v0, $v0\n" +
                "jal selection_label_booleen\n" +
                "move $a0, $v0\n" +
                "li $v0, 4\n" +
                "syscall\n" +
                "li $a0, 10\n" +
                "li $v0, 11\n" +
                "syscall\n";

        assertEquals(attendu, ecrire.toMIPS());
    }

    @Test
    void toMIPS_faux() {
        Ecrire ecrire = new Ecrire(new ConstanteBooleene("faux", 13), 14);
        String attendu = "li $v0, 0\n" +
                "move $v0, $v0\n" +
                "jal selection_label_booleen\n" +
                "move $a0, $v0\n" +
                "li $v0, 4\n" +
                "syscall\n" +
                "li $a0, 10\n" +
                "li $v0, 11\n" +
                "syscall\n";

        assertEquals(attendu, ecrire.toMIPS());
    }
}