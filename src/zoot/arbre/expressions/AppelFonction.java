package zoot.arbre.expressions;

import zoot.tds.TDS;
import zoot.tds.Type;
import zoot.tds.entrees.EntreeFonction;
import zoot.tds.symboles.Symbole;

public class AppelFonction extends Identifiable{
    private int niveauImbrication;
    private int tailleDisplay;
    private int tailleZoneParametres;
    private String etiquette;

    public AppelFonction(EntreeFonction e, int n) {
        super(e, n);
        tailleZoneParametres = e.getTypeParametres().size()*4;
        etiquette = e.getEtiquette();
    }

    @Override
    public void verifier() {
        TDS.getInstance().identifier(entree);
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

    public int getTailleZoneParametres()
    {
        return tailleZoneParametres;
    }
}
