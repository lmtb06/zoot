package zoot.exceptions;

import zoot.tds.entrees.Entree;

public class FonctionNonDeclarerException extends AnalyseSemantiqueException {
    public FonctionNonDeclarerException(Entree v) {
        super("La fonction de signature <" + v.getIdentifiant() + "> n'est pas déclarée.");
    }
}
