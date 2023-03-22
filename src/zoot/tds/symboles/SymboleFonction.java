package zoot.tds.symboles;

import zoot.arbre.expressions.AppelFonction;
import zoot.tds.TDS;
import zoot.tds.Type;

public class SymboleFonction extends Symbole {
    private String etiquette = "";

    public SymboleFonction(Type type) {
        super(type);
    }

    /**
     * {@inheritDoc}
     */
    public void decorer(AppelFonction a) {
        a.setNiveauImbrication(TDS.getInstance().getNiveauImbricationCourant());
        a.setTailleDisplay(TDS.getInstance().getTailleDisplay());
        a.setEtiquette(etiquette);
    }

    public String getEtiquette() {
        return etiquette;
    }

    /**
     * Attribut l'etiquette au {@link SymboleFonction}.
     *
     * @param etiquette la nouvelle etiquette.
     */
    public void setEtiquette(String etiquette) {
        this.etiquette = etiquette;
    }
}
