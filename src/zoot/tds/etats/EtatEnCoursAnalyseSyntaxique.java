package zoot.tds.etats;

import zoot.tds.EspaceDeNom;
import zoot.tds.TDS;
import zoot.tds.entrees.Entree;
import zoot.tds.symboles.Symbole;
import zoot.tds.symboles.SymboleVariable;

public class EtatEnCoursAnalyseSyntaxique extends EtatAnalyse {
    public EtatEnCoursAnalyseSyntaxique(TDS tds) {
        super(tds);
    }

    /**
     * {@inheritDoc}
     */
    public void ajouter(Entree entree, Symbole symbole) {
        tds.getEspaceDeNomCourant().ajouter(entree, symbole);
    }

    /**
     * {@inheritDoc}
     */
    public void augmenterTailleZoneVariables(int nbOctets) {
        tds.getEspaceDeNomCourant().augmenterTailleZoneVariables(nbOctets);
    }

    @Override
    public void augmenterTailleZoneParametres(int nbOctets) throws IllegalStateException {
        tds.getEspaceDeNomCourant().augmenterTailleZoneParametres(nbOctets);
    }

    @Override
    public void ajouterSymboleParametre(SymboleVariable p) {
        tds.getEspaceDeNomCourant().ajouterSymboleParametre(p);
    }

    /**
     * {@inheritDoc}
     */
    public void entreeBloc() {
        EspaceDeNom ancien = tds.getEspaceDeNomCourant();
        EspaceDeNom nouveau = new EspaceDeNom(ancien.getNiveauImbrication() + 1);
        ancien.ajouterSousEspaceDeNom(nouveau);
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

    /**
     * {@inheritDoc}
     */
    public void allerEtatSuivant() {
        tds.setEtatAnalyse(new EtatEnCoursAnalyseSemantique(tds));
        EspaceDeNom espaceDeNom = tds.getEspaceDeNomCourant();
        espaceDeNom.resetParcoursSousEspaceDeNom();
        tds.setNiveauImbricationMax(espaceDeNom.getNiveauImbricationMax());
        espaceDeNom.ajouterDeplacementDisplayAuxParametres(tds.getTailleDisplay() * 4);
    }
}
