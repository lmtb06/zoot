package zoot.exceptions;

import zoot.tds.Entree;

public class DoubleDeclarationException extends AnalyseSemantiqueException {
    public DoubleDeclarationException(Entree v) {
        super("L'entrée <" + v.getIdentifiant() + "> a déjà été déclarée.");
    }
}
