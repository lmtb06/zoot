package zoot.arbre;

import zoot.code_generation.MipsGenerator;

public abstract class ArbreAbstrait {
    
    // numéro de ligne du début de l'instruction
    protected int noLigne ;
    protected MipsGenerator mipsGenerator = MipsGenerator.getInstance();
    
    protected ArbreAbstrait(int n) {
        noLigne = n ;
    }
    
    public int getNoLigne() {
            return noLigne ;
    }

    public abstract void verifier() ;
    public abstract String toMIPS();

}
