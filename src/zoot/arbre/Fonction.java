package zoot.arbre;

import zoot.arbre.instructions.*;
import zoot.code_generation.MipsGenerator;
import zoot.exceptions.FonctionSansRetourneException;
import zoot.exceptions.GestionnaireExceptionsSemantiques;
import zoot.exceptions.LigneDecorator;
import zoot.exceptions.TypeIncompatibleException;
import zoot.tds.TDS;
import zoot.tds.Type;
import zoot.tds.entrees.EntreeFonction;
import zoot.tds.symboles.SymboleFonction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

public class Fonction extends ArbreAbstrait implements ConteneurDInstructions {
    private final EntreeFonction entreeFonction;
    private final SymboleFonction symboleFonction;
    private final BlocDInstructions instructions;
    private final ArrayList<Retourne> retournes;
    private int tailleZoneVariables = 0;
    private String etiquette = "";

    public Fonction(EntreeFonction e, SymboleFonction s, int n) {
        super(n);
        this.entreeFonction = e;
        this.symboleFonction = s;
        this.retournes = new ArrayList<>();
        this.instructions = new BlocDInstructions(n);
    }

    public String getEtiquette() {
        return etiquette;
    }

    public int getTailleZoneVariables() {
        return tailleZoneVariables;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void verifier() {
        TDS.getInstance().entreeBloc();

        instructions.verifier();

        if (retournes.isEmpty())
            GestionnaireExceptionsSemantiques.getInstance()
                    .ajouter(new LigneDecorator(noLigne, new FonctionSansRetourneException(this)));

        tailleZoneVariables = TDS.getInstance().getTailleZoneVariables();
        etiquette = symboleFonction.getEtiquette();

        for (Retourne r : retournes) {
            Optional<Type> typeRetourneOptional = r.getType();
            if (typeRetourneOptional.isPresent()) {
                if (symboleFonction.getType() != typeRetourneOptional.get()) {
                    GestionnaireExceptionsSemantiques.getInstance()
                            .ajouter(new LigneDecorator(r.getNoLigne(),
                                    new TypeIncompatibleException(symboleFonction.getType(), typeRetourneOptional.get())));
                } else {
                    r.setTailleZoneVariables(tailleZoneVariables); // On décore les retournes
                }
            }
        }

        TDS.getInstance().sortieBloc();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toMIPS() {
        return MipsGenerator.getInstance().getEnteteFonction(this) + instructions.toMIPS() + "\n";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void ajouter(Ecrire e) {
        instructions.ajouter(e);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void ajouter(Affectation a) {
        instructions.ajouter(a);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void ajouter(Retourne e) {
        instructions.ajouter(e);
        retournes.add(e);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<Instruction> iterator() {
        return instructions.iterator();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void ajouter(ConteneurDInstructions c) {
        Iterator<Instruction> it = c.iterator();
        while (it.hasNext()) {
            Instruction i = it.next();
            i.sAjouter(this);
        }
    }

    @Override
    public void ajouter(Boucle b) {
        instructions.ajouter(b);
        for (Iterator<Instruction> it = b.iterator(); it.hasNext(); ) {
            Instruction i = it.next();
            retournes.add((Retourne) i);
        }
    }

    @Override
    public void ajouter(Condition c) {
        instructions.ajouter(c);
        for (Iterator<Instruction> it = c.iterator(); it.hasNext(); ) {
            Instruction i = it.next();
            retournes.add((Retourne) i);
        }
    }
}
