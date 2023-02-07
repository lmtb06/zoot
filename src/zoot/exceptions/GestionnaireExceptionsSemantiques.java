package zoot.exceptions;

import java.util.ArrayList;

public class GestionnaireExceptionsSemantiques {
    private static final GestionnaireExceptionsSemantiques singleton = new GestionnaireExceptionsSemantiques();
    private final ArrayList<AnalyseSemantiqueException> exceptions = new ArrayList<>();

    private GestionnaireExceptionsSemantiques() {

    }
    public static GestionnaireExceptionsSemantiques getInstance() {
        return singleton;
    }

    public void ajouter(AnalyseSemantiqueException e) {
        exceptions.add(e);
    }

    public int getNbExceptions() {
        return exceptions.size();
    }

    public String getMessagesExceptions() {
        StringBuilder sb = new StringBuilder();
        for (AnalyseSemantiqueException e :
                exceptions) {
            sb.append(e.getMessage());
            sb.append("\n");
        }
        return sb.toString();
    }
}
