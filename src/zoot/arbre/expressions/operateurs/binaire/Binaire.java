package zoot.arbre.expressions.operateurs.binaire;

import zoot.arbre.expressions.Expression;
import zoot.code_generation.Registre;
import zoot.exceptions.GestionnaireExceptionsSemantiques;
import zoot.exceptions.LigneDecorator;
import zoot.exceptions.TypeIncompatibleAvecBinaireException;
import zoot.tds.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class Binaire extends Expression {
    protected Expression gauche;
    protected Expression droite;

    public Binaire(Expression gauche, Expression droite, int n) {
        super(n);
        this.gauche = gauche;
        this.droite = droite;
    }

    @Override
    public int getNombreDePlaces() {
        int nbPlacesGauche = gauche.getNombreDePlaces();
        int nbPlacesDroite = droite.getNombreDePlaces();
        int nbPlaces = nbPlacesGauche + 1;

        if (nbPlacesDroite != nbPlacesGauche)
            nbPlaces = Math.max(nbPlacesGauche, nbPlacesDroite);

        return nbPlaces;

    }

    @Override
    public void verifier() {
        gauche.verifier();
        droite.verifier();
        Optional<Type> monTypeOptional = getType();
        Type monType = monTypeOptional.orElseThrow();
        Optional<Type> gaucheTypeOptional = gauche.getType();
        Optional<Type> droiteTypeOptional = droite.getType();

        if (gaucheTypeOptional.isPresent() && droiteTypeOptional.isPresent()
                && (gaucheTypeOptional.get() != monType || droiteTypeOptional.get() != monType)) // Déclenche l'exception seulement dans le cas où les deux partie de l'expression sont valide mais pas du meme type que l'operateur
            GestionnaireExceptionsSemantiques.getInstance()
                    .ajouter(new LigneDecorator(noLigne,
                            new TypeIncompatibleAvecBinaireException(monType, gaucheTypeOptional.get(),
                                    droiteTypeOptional.get())));
    }

    @Override
    public String toMIPS() {
        List<String> registreDisponibles = new ArrayList<>(2);
        registreDisponibles.add(Registre.STOCKAGE_RESULTAT.valeur);
        registreDisponibles.add(Registre.STOCKAGE_TEMPORAIRE.valeur);
        return toMips(registreDisponibles);
    }
}
