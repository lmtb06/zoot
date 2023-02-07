package zoot.exceptions;

import zoot.tds.Entree;

public class VariableNonDeclarerException extends AnalyseSemantiqueException{
    public VariableNonDeclarerException(Entree v) {
        super("L'entrée " + v + " n'est pas déclarée.");
    }
}
