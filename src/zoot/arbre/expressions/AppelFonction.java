package zoot.arbre.expressions;

import zoot.tds.Type;
import zoot.tds.entrees.Entree;
import zoot.tds.symboles.Symbole;

import java.util.Collection;

public class AppelFonction extends Identifiable{
    private int niveauImbrication;
    private int tailleDisplay;
    private String etiquette;

    //TODO Remplacer Entree par EntreeFonction
    public AppelFonction(Entree e, int n) {
        super(e, n);
    }

    @Override
    public void verifier() {
        //TODO
    }

    @Override
    public String toMIPS() {
        //TODO
        return null;
    }

    @Override
    public Type getType() {
        return symbole.getType();
    }

    @Override
    public void setSymbole(Symbole s) {
        this.symbole = s;
    }

    public void setNiveauImbrication(int niveauImbrication) {
        this.niveauImbrication = niveauImbrication;
    }

    public int getNiveauImbrication() {
        return niveauImbrication;
    }

    public void setTailleDisplay(int tailleDisplay)
    {
        this.tailleDisplay = tailleDisplay;
    }

    public int getTailleDisplay()
    {
        return tailleDisplay;
    }

    public void getTailleZoneParametres()
    {
        //TODO
    }
}
