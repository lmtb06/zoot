package zoot.tds;

public enum Type {
    ENTIER(4),
    BOOLEEN(4);

    /**
     * Taille en octets du Type
     */
    public final int taille;

    Type(int taille) {
        this.taille = taille;
    }

    public static Type fromString(String str) {
        if (str.equalsIgnoreCase("entier")) {
            return ENTIER;
        } else if (str.equalsIgnoreCase("booleen")) {
            return BOOLEEN;
        } else {
            throw new IllegalArgumentException("Valeur enum invalide: " + str);
        }
    }
}
