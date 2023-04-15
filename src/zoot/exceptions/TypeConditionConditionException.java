package zoot.exceptions;

import zoot.tds.Type;

public class TypeConditionConditionException extends AnalyseSemantiqueException {
    public TypeConditionConditionException(Type typeObtenu) {
        super("La condition d'un si doit être de type " + Type.BOOLEEN + ", pas " + typeObtenu);
    }
}
