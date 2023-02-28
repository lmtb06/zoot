package zoot.arbre;

import zoot.arbre.instructions.Affectation;
import zoot.arbre.instructions.Ecrire;
import zoot.arbre.instructions.Retourne;

public interface ConteneurDInstructions {
    void ajouter(Ecrire e);
    void ajouter(Affectation a);
    void ajouter(Retourne e);
}
