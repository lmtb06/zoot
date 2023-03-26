package zoot.tds.symboles;

import zoot.arbre.expressions.Variable;
import zoot.tds.EspaceDeNom;
import zoot.tds.Type;

public class SymboleVariable extends Symbole {
    protected int deplacement = 0;

    public SymboleVariable(Type type, EspaceDeNom espaceDeNom) {
        super(type, espaceDeNom);
    }

    /**
     * Set le déplacement du {@link SymboleVariable}.
     *
     * @param deplacement le déplacement de la variable dans la pile relatif à son espace de nom.
     */
    public void setDeplacement(int deplacement) {
        this.deplacement = deplacement;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void decorer(Variable v) {
        v.setDeplacement(deplacement);
        v.setNiveauImbrication(espaceDeNom.getNiveauImbrication());
    }
}
