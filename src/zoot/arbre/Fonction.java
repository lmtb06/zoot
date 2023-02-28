package zoot.arbre;

import zoot.arbre.instructions.Affectation;
import zoot.arbre.instructions.Ecrire;
import zoot.arbre.instructions.Retourne;
import zoot.exceptions.GestionnaireExceptionsSemantiques;
import zoot.exceptions.LigneDecorator;
import zoot.exceptions.TypeIncompatibleException;
import zoot.tds.entrees.EntreeFonction;
import zoot.tds.symboles.SymboleFonction;

import java.util.ArrayList;

public class Fonction extends ArbreAbstrait implements ConteneurDInstructions{
    private EntreeFonction entreeFonction;
    private SymboleFonction symboleFonction;
    private int tailleZoneVariables;
    private String etiquette;

    private BlocDInstructions instructions;
    private ArrayList<Retourne> retourneArrayList;

    public Fonction(EntreeFonction e, SymboleFonction s, int n) {
        super(n);

        this.entreeFonction = e;
        this.symboleFonction = s;
    }

    @Override
    public void verifier() {
        for (Retourne r : retourneArrayList)
        {
            r.verifier();

            if(symboleFonction.getType() != r.getType())
                GestionnaireExceptionsSemantiques.getInstance()
                        .ajouter(new LigneDecorator(noLigne,
                                new TypeIncompatibleException(r.getType(),
                                        symboleFonction.getType())));
        }

        instructions.verifier();
    }

    @Override
    public String toMIPS() {
        //TODO
        return null;
    }

    @Override
    public void ajouter(Ecrire e) {
        instructions.ajouter(e);
    }

    @Override
    public void ajouter(Affectation a) {
        instructions.ajouter(a);
    }

    @Override
    public void ajouter(Retourne e) {
        instructions.ajouter(e);
        retourneArrayList.add(e);
    }
}
