package zoot.code_generation;

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
     * @return l'instance du singleton
     */
    public static MipsGenerator getInstance() {
        return singleton;
    }

    /**
     * Retourne le code MIPS pour le chargement immédiat de valeur dans registre
     * @param registre Le registre cible
     * @param valeur La valeur à charger
     * @return Le code MIPS pour le chargement immédiat
     */
    public String chargementImmediat(String registre, String valeur) {
        return "li " + registre + ", " + valeur + "\n";
    }

    /**
     * Retourne le code MIPS pour le chargement d'adresse d'un registre
     * @param registreDst Le registre cible
     * @param label la valeur à charger (registre ou string présent dans le .data)
     * @return Le code MIPS pour le chargement par adresse
     */
    public String chargementAdresseRegistre(String registreDst, String label)
    {
        return "la " + registreDst + ", " + label + "\n";
    }

    /**
     * Retourne le code MIPS pour copier le contenu d’un registre vers un autre
     * @param registreSource Le registre à copier
     * @param registreDestination La destination
     * @return Le code MIPS pour copier le contenu d’un registre vers un autre
     */
    public String copieRegistreRegistre(String registreSource, String registreDestination) {
        return "move " + registreDestination + ", " + registreSource + "\n";
    }

    /**
     * Retourner le code MIPS associé à la sauvegarder d'un registre dans un autre
     * (Avec ou sans déplacement)
     * @param registreSource le registre de départ
     * @return Le code MIPS associé à la sauvegarder d'un registre dans un autre
     */
    public String sauvegarderRegistreDansPile(String registreSource)
    {
        //Todo : modif pour gérer stack
        //return "sw " + registreSource + ", " + registreDestination + "\n";
        return null;
    }

    /**
     * Retourne le code MIPS pour réserver des octets dans la pile
     * @param nbOctets Le nombre d’octets à réserver
     * @return Le code MIPS pour réserver des octets dans la pile
     */
    public String reserverOctetsPile(int nbOctets) {
        return "addi " + Registre.POINTEUR_PILE.valeur + ", " + Registre.POINTEUR_PILE.valeur + ", " + (-nbOctets) + "\n";
    }

    /**
     * Retourne le code MIPS pour libérer des octets de la pile
     * @param nbOctets Le nombre d’octets à libérer
     * @return Le code MIPS pour libérer des octets dans la pile
     */
    public String libererOctetsPile(int nbOctets) {
        return "addi " + Registre.POINTEUR_PILE.valeur + ", " + Registre.POINTEUR_PILE.valeur + ", " + (nbOctets) + "\n";
    }

    /**
     * Retourne le code MIPS pour afficher un caractère
     * @param valeur le code ASCII du caractère
     * @return le code MIPS pour afficher un caractère
     */
    public String afficherCaractere(String valeur) {
        return chargementImmediat("$a0", valeur) +
                chargementImmediat("$v0", "11")+
                "syscall\n";
    }

    /**
     * Retourne le code MIPS pour afficher le contenu d’un registre sous la forme
     * d’un entier
     * @param registre Le registre
     * @return Le code MIPS pour afficher le contenu d’un registre sous la forme
     * d’un entier
     */
    public String afficherEntierRegistre(String registre) {
        return copieRegistreRegistre(registre, "$a0")+
                chargementImmediat("$v0", "1")+
                "syscall\n";
    }

    /**
     * Retourne le code MIPS pour afficher le contenu d’un registre sous la forme
     * d’une chaîne de caractères
     * @param registre Le registre
     * @return Le code MIPS pour afficher le contenu d’un registre sous la forme
     * d’une chaine de caractères
     */
    public String afficherChaineDeCaracteresRegistre(String registre) {
        return copieRegistreRegistre(registre, "$a0")+
                chargementImmediat("$v0", "4")+
                "syscall\n";
    }

    /**
     * Retourne le code MIPS pour faire un saut à la ligne
     * @return Le code MIPS pour faire un saut à la ligne
     */
    public String afficherRetourLigne() {
        return afficherCaractere("10");
    }

    /**
     * Retourne le code MIPS pour l’entête du programme MIPS
     * @return le code MIPS pour l’entête du programme MIPS
     */
    public String enteteProgramme() {
        return ".text\n" +
                "main :\n" +
                "# début du programme\n" +
                copieRegistreRegistre(Registre.POINTEUR_PILE.valeur, Registre.POINTEUR_DEBUT_ZONE_PILE.valeur);
    }

    /**
     * Retourne le code MIPS pour l’entête du programme MIPS
     * @param deplacementTotal a.k.a. le nombre d'octets à allouer dans la stack (-nbOctets !!!)
     * @return le code MIPS pour l’entête du programme MIPS
     */
    public String enteteProgramme(int deplacementTotal) {
        return ".text\n" +
                ".data\n" +
                "vrai: .asciiz \"vrai\"\n" +
                "faux: .asciiz \"faux\"\n" +
                "main :\n" +
                "# début du programme\n" +
                copieRegistreRegistre(Registre.POINTEUR_PILE.valeur, Registre.POINTEUR_DEBUT_ZONE_PILE.valeur) +
                reserverOctetsPile(-deplacementTotal);
    }

    /**
     * Retourne le code MIPS pour la fin du programme MIPS
     * @return Le code MIPS pour la fin du programme MIPS
     */
    public String finProgramme() {
        return  "selection_label_booleen_dans_a0:" +
                "beq $v0, 0, sinon\n" +
                "la $a0, vrai\n" +
                "sinon:\n" +
                "la $a0, faux\n" +
                "end :\n" +
                "# fin du programme\n" +
                chargementImmediat("$v0", "10") +
                "syscall\n";
    }
}
