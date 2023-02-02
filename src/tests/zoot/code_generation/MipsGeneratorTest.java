package zoot.code_generation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MipsGeneratorTest {

    @Test
    void chargementImmediat_positif() {
        MipsGenerator generator = MipsGenerator.getInstance();
        assertEquals("li $v0, 15\n", generator.chargementImmediat("$v0", "15"));
    }

    @Test
    void chargementImmediat_negatif() {
        MipsGenerator generator = MipsGenerator.getInstance();
        assertEquals("li $v0, -15\n", generator.chargementImmediat("$v0", "-15"));
    }

    @Test
    void chargementImmediat_zero() {
        MipsGenerator generator = MipsGenerator.getInstance();
        assertEquals("li $v0, 0\n", generator.chargementImmediat("$v0", "0"));
    }

    @Test
    void copieRegistreRegistre() {
        MipsGenerator generator = MipsGenerator.getInstance();
        assertEquals("move $t4, $v0\n", generator.copieRegistreRegistre("$v0", "$t4"));
    }

    @Test
    void reserverOctetsPile() {
        MipsGenerator generator = MipsGenerator.getInstance();
        String attendu = "addi " + Registre.POINTEUR_PILE.valeur + ", " + Registre.POINTEUR_PILE.valeur +
                ", -4\n"; // reservation de 4 octets
        assertEquals(attendu, generator.reserverOctetsPile(4));
    }

    @Test
    void libererOctetsPile() {
        MipsGenerator generator = MipsGenerator.getInstance();
        String attendu = "addi " + Registre.POINTEUR_PILE.valeur + ", " + Registre.POINTEUR_PILE.valeur +
                ", 4\n"; // libération de 4 octets
        assertEquals(attendu, generator.libererOctetsPile(4));
    }

    @Test
    void afficherEntierRegistre() {
        MipsGenerator generator = MipsGenerator.getInstance();
        String attendu = "move $a0, $v0\n" +
                "li $v0, 1\n" +
                "syscall\n"; // affichage du contenu de $v0
        assertEquals(attendu, generator.afficherEntierRegistre("$v0"));
    }

    @Test
    void enteteProgramme() {
        MipsGenerator generator = MipsGenerator.getInstance();
        String attendu = ".text\n" +
                "main :\n" +
                "# début du programme\n" +
                "move " + Registre.POINTEUR_DEBUT_ZONE_PILE.valeur +
                ", " + Registre.POINTEUR_PILE.valeur + "\n";
        assertEquals(attendu, generator.enteteProgramme());
    }

    @Test
    void finProgramme() {
        MipsGenerator generator = MipsGenerator.getInstance();
        String attendu = "end :\n" +
                "# fin du programme\n" +
                "li $v0, 10\n" +
                "syscall\n";
        assertEquals(attendu, generator.finProgramme());
    }

    @Test
    void afficherCaractere() {
        // Afficher A : ASCII = 65
        MipsGenerator generator = MipsGenerator.getInstance();
        String attendu = "li $a0, 65\n" +
                "li $v0, 11\n" +
                "syscall\n";
        assertEquals(attendu, generator.afficherCaractere("65"));
    }

    @Test
    void afficherRetourLigne() {
        // Afficher saut à la ligne (\n) : ASCII = 10
        MipsGenerator generator = MipsGenerator.getInstance();
        String attendu = "li $a0, 10\n" +
                "li $v0, 11\n" +
                "syscall\n";
        assertEquals(attendu, generator.afficherRetourLigne());
    }

    @Test
    void chargementImmediat() {
    }

    @Test
    void chargementAdresse() {
    }

    @Test
    void testCopieRegistreRegistre() {
    }

    @Test
    void sauvegarderRegistre() {
    }

    @Test
    void testReserverOctetsPile() {
    }

    @Test
    void testLibererOctetsPile() {
    }

    @Test
    void testAfficherCaractere() {
    }

    @Test
    void testAfficherEntierRegistre() {
    }

    @Test
    void afficherBooleenRegistre() {
    }

    @Test
    void testAfficherRetourLigne() {
    }

    @Test
    void testEnteteProgramme() {
    }

    @Test
    void testFinProgramme() {
    }
}