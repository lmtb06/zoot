package zoot.exceptions;

import zoot.tds.entrees.Entree;

public class EntreeNonTrouveException extends AnalyseSemantiqueException {
    public EntreeNonTrouveException(Entree e) {
        super("L'entree <" + e.getIdentifiant() + "> n'a pas été trouvé.");
    }
}
