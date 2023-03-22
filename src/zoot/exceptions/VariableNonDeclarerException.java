package zoot.exceptions;

import zoot.tds.entrees.Entree;

public class VariableNonDeclarerException extends AnalyseSemantiqueException {
    public VariableNonDeclarerException(Entree v) {
        super("La variable <" + v.getIdentifiant() + "> n'est pas déclarée.");
    }
}
