package zoot.exceptions;

public class AnalyseSemantiqueDecorator extends AnalyseSemantiqueException {
    protected AnalyseSemantiqueException exception;
    public AnalyseSemantiqueDecorator(AnalyseSemantiqueException e) {
        super("");
        this.exception = e;
    }

    @Override
    public String getMessage() {
        return exception.getMessage();
    }

    @Override
    public String getLocalizedMessage() {
        return exception.getLocalizedMessage();
    }
}
