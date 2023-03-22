package zoot.arbre.instructions;

import zoot.arbre.ConteneurDInstructions;
import zoot.arbre.expressions.Expression;
import zoot.tds.Type;

public class Retourne extends Instruction {

    protected Expression exp;

    public Retourne(Expression e, int n)
    {
        super(n);
        this.exp = e;
    }

    /**
     * Donne le {@link Type} de renvoyé par le retourne.
     *
     * @return le {@link Type} de renvoyé par le retourne.
     */
    public Type getType() {
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
        //TODO
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void sAjouter(ConteneurDInstructions c) {
        c.ajouter(this);
    }
}
