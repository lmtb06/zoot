package zoot.code_generation;

import zoot.arbre.Fonction;
import zoot.arbre.Programme;
import zoot.arbre.expressions.AppelFonction;
import zoot.arbre.expressions.Variable;

/**
 * Singleton utilisé pour centraliser la gestion du code MIPS
 * Chaque fonction se chargera de mettre les sauts à la ligne, dernière ligne comprise
 */
public class MipsGenerator {
    private static final MipsGenerator singleton = new MipsGenerator();

    private MipsGenerator() {

    }

    /**
     * Permet de récuperer l'instance du singleton
     *
     * @return l'instance du singleton
     */
    public static MipsGenerator getInstance() {
        return singleton;
    }

    /**
     * Retourne le code MIPS pour le chargement immédiat de valeur dans registre
     *
     * @param registre Le registre cible
     * @param valeur   La valeur à charger
     * @return Le code MIPS pour le chargement immédiat
     */
    public String chargementImmediat(String registre, String valeur) {
        return "li " + registre + ", " + valeur + "\n";
    }

    /**
     * Retourne le code MIPS pour le chargement d'adresse d'un registre
     *
     * @param registreDst Le registre cible
     * @param valeur       la valeur à charger (registre ou string présent dans le .data)
     * @return Le code MIPS pour le chargement par adresse
     */
    public String chargementAdresseRegistre(String registreDst, String valeur) {
        return "la " + registreDst + ", " + valeur + "\n";
    }

    /**
     * Retourne le code MIPS pour copier le contenu d’un registre vers un autre
     *
     * @param registreSource      Le registre à copier
     * @param registreDestination La destination
     * @return Le code MIPS pour copier le contenu d’un registre vers un autre
     */
    public String copieRegistreRegistre(String registreSource, String registreDestination) {
        return "move " + registreDestination + ", " + registreSource + "\n";
    }

    //TODO Supprimer
    public String recupererVariableDepuisPile(String registreDestination, int deplacementVariable) {
        return "lw " + registreDestination + ", "
                + deplacementVariable + "(" + Registre.POINTEUR_DEBUT_ZONE_PILE.valeur + ")\n";
    }

    //TODO Supprimer
    public String sauvegarderVariableDepuisRegistre(String registreSource, int deplacementVariable) {
        return "sw " + registreSource + ", "
                + deplacementVariable + "(" + Registre.POINTEUR_DEBUT_ZONE_PILE.valeur + ")\n";
    }

    public String chargerContenuVariableDansRegistre(Variable variableSource, String registreDestination) {
        // TODO
        return "";
    }

    public String sauvegarderContenuRegistreDansVariable(String registreSource, Variable variableDestination) {
        // TODO
        return "";
    }

    public String executerFonction(AppelFonction a) {
        // TODO
        return "";
    }

    public String getDefinitionFonction(Fonction f) {
        // TODO
        return "";
    }

    /**
     * Retourne le code MIPS pour réserver des octets dans la pile
     *
     * @param nbOctets Le nombre d’octets à réserver
     * @return Le code MIPS pour réserver des octets dans la pile
     */
    public String reserverOctetsPile(int nbOctets) {
        return "addi " + Registre.POINTEUR_PILE.valeur + ", " + Registre.POINTEUR_PILE.valeur + ", " + (-nbOctets) + "\n";
    }

    /**
     * Retourne le code MIPS pour libérer des octets de la pile
     *
     * @param nbOctets Le nombre d’octets à libérer
     * @return Le code MIPS pour libérer des octets dans la pile
     */
    public String libererOctetsPile(int nbOctets) {
        return "addi " + Registre.POINTEUR_PILE.valeur + ", " + Registre.POINTEUR_PILE.valeur + ", " + (nbOctets) + "\n";
    }

    /**
     * Retourne le code MIPS pour afficher un caractère
     *
     * @param valeur le code ASCII du caractère
     * @return le code MIPS pour afficher un caractère
     */
    public String afficherCaractere(String valeur) {
        return chargementImmediat("$a0", valeur) +
                chargementImmediat("$v0", "11") +
                "syscall\n";
    }

    /**
     * Retourne le code MIPS pour afficher le contenu d’un registre sous la forme
     * d’un entier
     *
     * @param registre Le registre
     * @return Le code MIPS pour afficher le contenu d’un registre sous la forme
     * d’un entier
     */
    public String afficherEntierRegistre(String registre) {
        return copieRegistreRegistre(registre, "$a0") +
                chargementImmediat("$v0", "1") +
                "syscall\n";
    }

    /**
     * Retourne le code MIPS pour afficher le contenu d’un registre sous la forme
     * d’une chaîne de caractères
     *
     * @param registre Le registre
     * @return Le code MIPS pour afficher le contenu d’un registre sous la forme
     * d’une chaine de caractères
     */
    public String afficherChaineDeCaracteresRegistre(String registre) {
        return copieRegistreRegistre(registre, "$a0") +
                chargementImmediat("$v0", "4") +
                "syscall\n";
    }

    /**
     * Retourne le code MIPS pour faire un saut à la ligne
     *
     * @return Le code MIPS pour faire un saut à la ligne
     */
    public String afficherRetourLigne() {
        return afficherCaractere("10");
    }

    public String afficherBooleenRegistre(String registre) {
        return copieRegistreRegistre(registre, "$a0") +
                "jal selection_label_booleen\n" +
                afficherChaineDeCaracteresRegistre(Registre.STOCKAGE_RESULTAT.valeur);
    }

    //TODO Supprimer
    /**
     * Retourne le code MIPS pour l’entête du programme MIPS
     *
     * @param deplacementTotal a.k.a. le nombre d'octets à allouer dans la stack
     * @return le code MIPS pour l’entête du programme MIPS
     */
    public String enteteProgramme(int deplacementTotal) {
        return ".data\n" +
                "vrai: .asciiz \"vrai\"\n" +
                "faux: .asciiz \"faux\"\n" +
                ".text\n" +
                "main :\n" +
                "# début du programme\n" +
                copieRegistreRegistre(Registre.POINTEUR_PILE.valeur, Registre.POINTEUR_DEBUT_ZONE_PILE.valeur) +
                reserverOctetsPile(deplacementTotal);
    }

    public String getEnteteProgramme(Programme p) {
        //TODO
        return null;
    }

    public String getFinProgramme(Programme p) {
        //TODO
        return null;
    }

    /**
     * Retourne le code MIPS pour la fin du programme MIPS
     *
     * @return Le code MIPS pour la fin du programme MIPS
     */
    public String finProgramme() {
        return "end :\n" +
                "# fin du programme\n" +
                chargementImmediat("$v0", "10") +
                "syscall\n" +
                "# fonctions utilitaires zoot\n" +
                "selection_label_booleen:\n" +
                chargementImmediat(Registre.STOCKAGE_TEMPORAIRE.valeur, "0") +
                "beq $a0," + Registre.STOCKAGE_TEMPORAIRE.valeur + ", sinon_label_booleen\n" +
                chargementAdresseRegistre(Registre.STOCKAGE_RESULTAT.valeur, "vrai") +
                "j fin_label_booleen\n" +
                "sinon_label_booleen:\n" +
                chargementAdresseRegistre(Registre.STOCKAGE_RESULTAT.valeur, "faux") +
                "fin_label_booleen:\n" +
                "jr $ra\n";
    }
}
