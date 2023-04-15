package zoot.exceptions;

import zoot.tds.Type;

public class TypeIncompatibleAvecBinaireException extends AnalyseSemantiqueException {
    public TypeIncompatibleAvecBinaireException(Type typeOperateur, Type typeGauche, Type typeDroite) {
        super("Types incompatibles avec opérateur : " + typeGauche + " -> " + typeOperateur + " <- " + typeDroite);
    }
}
