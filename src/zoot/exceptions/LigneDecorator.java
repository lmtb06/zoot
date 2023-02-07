package zoot.exceptions;

public class LigneDecorator extends AnalyseSemantiqueDecorator{
    private final int ligne;
    public LigneDecorator(int ligne, AnalyseSemantiqueException e) {
        super(e);
        this.ligne = ligne;
    }

    @Override
    public String getMessage() {
        return "ERREUR SEMANTIQUE : Ligne : " + ligne + " : " + exception.getMessage();
    }

    @Override
    public String getLocalizedMessage() {
        return "ERREUR SEMANTIQUE : Ligne : " + ligne + " : " + exception.getLocalizedMessage();
    }
}
