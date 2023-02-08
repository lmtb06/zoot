package zoot.exceptions;

import zoot.tds.Entree;

public class VariableNonDeclarerException extends AnalyseSemantiqueException {
    public VariableNonDeclarerException(Entree v) {
        super("L'entrée <" + v.getIdentifiant() + "> n'est pas déclarée.");
    }
}
