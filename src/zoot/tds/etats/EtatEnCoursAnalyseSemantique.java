package zoot.tds.etats;

import zoot.tds.EspaceDeNom;
import zoot.tds.TDS;
import zoot.tds.entrees.Entree;
import zoot.tds.symboles.Symbole;

public class EtatEnCoursAnalyseSemantique extends EtatAnalyse {
    public EtatEnCoursAnalyseSemantique(TDS tds) {
        super(tds);
    }

    /**
     * {@inheritDoc}
     */
    public Symbole identifier(Entree entree) {
        return tds.getEspaceDeNomCourant().identifier(entree);
    }

    /**
     * {@inheritDoc}
     */
    public int getTailleDisplay() {
        return tds.getNiveauImbricationMax() + 1;
    }

    /**
     * {@inheritDoc}
     */
    public void entreeBloc() {
        EspaceDeNom ancien = tds.getEspaceDeNomCourant();
        EspaceDeNom nouveau = ancien.getProchainSousEspaceDeNom();
        tds.setEspaceDeNomCourant(nouveau);
    }

    /**
     * {@inheritDoc}
     */
    public void sortieBloc() {
        EspaceDeNom ancien = tds.getEspaceDeNomCourant();
        EspaceDeNom nouveau = ancien.getEspaceDeNomParent();
        tds.setEspaceDeNomCourant(nouveau);
    }
}
