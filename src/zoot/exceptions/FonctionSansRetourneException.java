package zoot.exceptions;

import zoot.arbre.Fonction;

public class FonctionSansRetourneException extends AnalyseSemantiqueException {
    public FonctionSansRetourneException(Fonction f) {
        super("La fonction n'a pas d'instruction retourne");
    }
}
