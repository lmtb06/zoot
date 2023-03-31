package zoot.arbre.instructions;

import zoot.arbre.ConteneurDInstructions;
import zoot.arbre.expressions.Expression;
import zoot.code_generation.MipsGenerator;
import zoot.tds.Type;

import java.util.Optional;

public class Retourne extends Instruction {
    private int tailleZoneVariables = 0;
    protected Expression exp;

    public Retourne(Expression e, int n) {
        super(n);
        this.exp = e;
    }

    /**
     * Donne le {@link Type} de renvoyé par le retourne.
     *
     * @return le {@link Type} de renvoyé par le retourne.
     */
    public Optional<Type> getType() {
        return exp.getType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void verifier() {
        exp.verifier();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toMIPS() {
        return exp.toMIPS() + MipsGenerator.getInstance().appelRetourFonction(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void sAjouter(ConteneurDInstructions c) {
        c.ajouter(this);
    }

    public int getTailleZoneVariables() {
        return tailleZoneVariables;
    }

    public void setTailleZoneVariables(int tailleZoneVariables) {
        this.tailleZoneVariables = tailleZoneVariables;
    }
}
