package zoot.arbre.expressions;

import zoot.arbre.ArbreAbstrait;
import zoot.arbre.instructions.Ecrire;

public abstract class Expression extends ArbreAbstrait {
    
    protected Expression(int n) {
        super(n) ;
    }

    public abstract String getMipsEcriture(Ecrire e);
}
