package zoot.exceptions;

import zoot.tds.EntreeVariable;

public class DoubleDeclarationException extends AnalyseSemantiqueException {
    public DoubleDeclarationException(EntreeVariable v) {
        super("La variable " + v + " a déjà été déclarée.");
    }
}
