package zoot.arbre;

import zoot.arbre.instructions.Affectation;
import zoot.arbre.instructions.Ecrire;
import zoot.arbre.instructions.Instruction;
import zoot.arbre.instructions.Retourne;

import java.util.Iterator;

public interface ConteneurDInstructions {

    /**
     * Retourne l'iterateur des {@link Instruction} du conteneur d'instruction.
     *
     * @return l'iterateur des {@link Instruction} du conteneur d'instruction.
     */
    Iterator<Instruction> iterator();

    /**
     * Ajoute un {@link Ecrire} au conteneur.
     *
     * @param e l'instruction ecrire à ajouter.
     */
    void ajouter(Ecrire e);

    /**
     * Ajoute une {@link Affectation} au conteneur.
     *
     * @param a l'instruction d'affectation à ajouter.
     */
    void ajouter(Affectation a);

    /**
     * Ajoute un {@link Retourne} au conteneur.
     *
     * @param e l'instruction retourne à ajouter.
     */
    void ajouter(Retourne e);

    /**
     * Ajoute le contenu d'un autre {@link ConteneurDInstructions} à celui-ci.
     *
     * @param c l'autre conteneur
     */
    void ajouter(ConteneurDInstructions c);
}
