package zoot.exceptions;

import zoot.tds.Type;

public class TypeIncompatibleException extends AnalyseSemantiqueException {
    public TypeIncompatibleException(Type destination, Type source) {
        super("Types incompatible : " + destination + " <- " + source);
    }
}
