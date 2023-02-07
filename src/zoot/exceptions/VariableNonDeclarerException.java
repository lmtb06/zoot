package zoot.exceptions;

import zoot.tds.EntreeVariable;

public class VariableNonDeclarerException extends AnalyseSemantiqueException{
    public VariableNonDeclarerException(EntreeVariable v) {
        super("La variable " + v + " n'est pas déclarée.");
    }
}
