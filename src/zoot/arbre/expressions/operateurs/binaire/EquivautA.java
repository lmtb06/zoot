package zoot.arbre.expressions.operateurs.binaire;

import zoot.arbre.expressions.Expression;
import zoot.code_generation.MipsGenerator;
import zoot.code_generation.Registre;
import zoot.exceptions.GestionnaireExceptionsSemantiques;
import zoot.exceptions.LigneDecorator;
import zoot.exceptions.TypeIncompatibleAvecBinaireException;
import zoot.tds.Type;

import java.util.List;
import java.util.Optional;

public class EquivautA extends Binaire {
    public EquivautA(Expression gauche, Expression droite, int n) {
        super(gauche, droite, n);
    }

    @Override
    public Optional<Type> getType() {
        return Optional.of(Type.BOOLEEN);
    }

    @Override
    public void verifier() {
        gauche.verifier();
        droite.verifier();
        Type monType = Type.BOOLEEN;
        Optional<Type> gaucheTypeOptional = gauche.getType();
        Optional<Type> droiteTypeOptional = droite.getType();

        if (gaucheTypeOptional.isPresent() && droiteTypeOptional.isPresent()
                && gaucheTypeOptional.get() != droiteTypeOptional.get()) // Déclenche l'exception seulement dans le cas où les deux partie de l'expression sont valides mais pas du même type
            GestionnaireExceptionsSemantiques.getInstance()
                    .ajouter(new LigneDecorator(noLigne,
                            new TypeIncompatibleAvecBinaireException(monType, gaucheTypeOptional.get(),
                                    droiteTypeOptional.get())));
    }

    @Override
    public String toMips(List<String> registres) {
        MipsGenerator mg = MipsGenerator.getInstance();

        return gauche.toMips(registres)
                + mg.empilerContenuRegistre(Registre.STOCKAGE_RESULTAT.valeur)
                + droite.toMips(registres)
                + mg.depilerVersRegistre(Registre.STOCKAGE_TEMPORAIRE.valeur)
                + mg.operationEquivaut(Registre.STOCKAGE_RESULTAT.valeur, Registre.STOCKAGE_TEMPORAIRE.valeur, Registre.STOCKAGE_RESULTAT.valeur);
    }
}
