package zoot.code_generation;

/**
 * Enum permettant de centraliser les nom des registres
 */
public enum Registre {
    /**
     * Le registre contenant la position dans la pile
     */
    POINTEUR_PILE("$sp"),
    /**
     * Le registre contenant la position du début du contexte actuelle
     */
    POINTEUR_DEBUT_ZONE_PILE("$s7"),
    /**
     * Registre utiliser pour un stockage temporaire
     */
    STOCKAGE_TEMPORAIRE("$t8"),
    /**
     * Registre où sont stockés les résultats après une opération
     */
    STOCKAGE_RESULTAT("$v0"),
    POINTEUR_DEBUT_ZONE_DISPLAY("$s3"),
    ADRESSE_RETOUR("$ra");

    public final String valeur;

    Registre(String valeur) {
        this.valeur = valeur;
    }
}
