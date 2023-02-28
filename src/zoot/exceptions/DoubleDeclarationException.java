package zoot.exceptions;

import zoot.tds.entrees.Entree;

public class DoubleDeclarationException extends AnalyseSemantiqueException {
    public DoubleDeclarationException(Entree v) {
        super("L'entrée <" + v.getIdentifiant() + "> a déjà été déclarée.");
    }
}
