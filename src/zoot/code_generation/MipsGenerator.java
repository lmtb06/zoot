package zoot.code_generation;

/**
 * Singleton utilisé pour centraliser la gestion du code MIPS
 * Chaque fonction se chargera de mettre les sauts à la ligne, dernière ligne comprise
 */
public class MipsGenerator {
    private static MipsGenerator singleton = null;
    private MipsGenerator() {

    }

    public MipsGenerator getInstance() {
        if (singleton == null)
            singleton = new MipsGenerator();

        return singleton;
    }

    /**
     * Retourne le code MIPS pour le chargement immédiat de valeur dans registre
     * @param registre Le registre cible
     * @param valeur La valeur à charger
     * @ return Le code MIPS pour le chargement immédiat
     */
    public String chargementImmediat(String registre, String valeur) {
        return "li " + registre + ", " + valeur + "\n";
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
     * Retourne le code MIPS pour afficher le contenu d’un registre sous la forme
     * d’un entier
     * @param registre Le registre
     * @return Le code MIPS pour afficher le contenu d’un registre sous la forme
     * d’un entier
     */
    public String afficherEntierRegistre(String registre) {
        return copieRegistreRegistre("$a0", registre)+
                chargementImmediat("$v0", "1")+
                "syscall\n";
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
     * Retourne le code MIPS pour la fin du programme MIPS
     * @return Le code MIPS pour la fin du programme MIPS
     */
    public String finProgramme() {
        return "end :\n" +
                "# fin du programme\n" +
                chargementImmediat("$v0", "0") +
                "syscall\n";
    }
}
