package zoot.arbre.expressions.operateurs.binaire;

import zoot.arbre.expressions.Expression;
import zoot.code_generation.MipsGenerator;
import zoot.code_generation.Registre;
import zoot.tds.Type;

import java.util.List;
import java.util.Optional;

public class Somme extends Binaire {
    public Somme(Expression gauche, Expression droite, int n) {
        super(gauche, droite, n);
    }

    public String toMips(List<String> registres) {
        MipsGenerator mg = MipsGenerator.getInstance();

        return gauche.toMips(registres)
                + mg.empilerContenuRegistre(Registre.STOCKAGE_RESULTAT.valeur)
                + droite.toMips(registres)
                + mg.depilerVersRegistre(Registre.STOCKAGE_TEMPORAIRE.valeur)
                + mg.somme(Registre.STOCKAGE_RESULTAT.valeur, Registre.STOCKAGE_TEMPORAIRE.valeur, Registre.STOCKAGE_RESULTAT.valeur);
    }

    @Override
    public Optional<Type> getType() {
        return Optional.of(Type.ENTIER);
    }


}
