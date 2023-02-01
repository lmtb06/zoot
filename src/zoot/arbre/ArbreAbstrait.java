package zoot.arbre;

import zoot.code_generation.MipsGenerator;

public abstract class ArbreAbstrait {
    
    // numéro de ligne du début de l'instruction
    protected int noLigne ;
    protected MipsGenerator mipsGenerator = MipsGenerator.getInstance();

    protected ArbreAbstrait(int n) {
        noLigne = n ;
    }

    /**
     * Retourne le numéro de la ligne associé au nœud
     * @return noLigne le numéro de la ligne
     */
    public int getNoLigne() {
            return noLigne ;
    }

    public abstract void verifier() ;
    public abstract String toMIPS();

}
