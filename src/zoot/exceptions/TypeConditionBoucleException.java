package zoot.exceptions;

import zoot.tds.Type;

public class TypeConditionBoucleException extends AnalyseSemantiqueException {
    public TypeConditionBoucleException(Type typeObtenu) {
        super("La condition d'une boucle doit être de type " + Type.BOOLEEN + ", pas " + typeObtenu);
    }
}
