package zoot.arbre.expressions;

import zoot.arbre.instructions.Ecrire;

public class ConstanteEntiere extends Constante {
    
    public ConstanteEntiere(String texte, int n) {
        super(texte, n) ;
    }

    @Override
    public String toMIPS() {
        return "li $v0, " + this.cste + "\n";
    }

    @Override
    public String getMipsEcriture(Ecrire e) {
        return e.getMips(this);
    }
}
