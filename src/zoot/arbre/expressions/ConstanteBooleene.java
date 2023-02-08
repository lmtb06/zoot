package zoot.arbre.expressions;

import zoot.code_generation.MipsGenerator;
import zoot.code_generation.Registre;
import zoot.tds.Type;

public class ConstanteBooleene extends Constante {

    public ConstanteBooleene(String texte, int n) {
        super(texte, n);
    }

    @Override
    public String toMIPS() {
        StringBuilder sb = new StringBuilder();
        MipsGenerator mg = MipsGenerator.getInstance();
        switch (cste) {
            case "vrai":
                sb.append(mg.chargementImmediat(Registre.STOCKAGE_RESULTAT.valeur, "1"));
                break;
            case "faux":
                sb.append(mg.chargementImmediat(Registre.STOCKAGE_RESULTAT.valeur, "0"));
                break;
        }
        return sb.toString();
    }

    @Override
    public Type getType() {
        return Type.BOOLEEN;
    }
}
