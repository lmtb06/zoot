package zoot.arbre;

import zoot.code_generation.MipsGenerator;
import zoot.tds.TDS;

public class Programme extends ArbreAbstrait {
    private final BlocDeFonctions blocDeFonctions;
    private final BlocDInstructions blocDInstructions;
    private int tailleDisplay;
    private int tailleZoneVariables = 0;

    public Programme(BlocDeFonctions bf, BlocDInstructions b, int n) {
        super(n);
        this.blocDeFonctions = bf;
        this.blocDInstructions = b;
        tailleDisplay = 1;
    }

    public int getTailleDisplay() {
        return tailleDisplay;
    }

    public int getTailleZoneVariables() {
        return tailleZoneVariables;
    }

    /**
     * {@inheritDoc}
     */
    public void verifier() {
        blocDeFonctions.verifier();
        blocDInstructions.verifier();
        this.tailleDisplay = TDS.getInstance().getTailleDisplay();
        this.tailleZoneVariables = TDS.getInstance().getTailleZoneVariables();
    }

    /**
     * {@inheritDoc}
     */
    public String toMIPS() {
        MipsGenerator mg = MipsGenerator.getInstance();
        return mg.getEnteteProgramme(this) + blocDInstructions.toMIPS() + mg.getFinProgramme(this) +
                "\n" + blocDeFonctions.toMIPS();
    }
}
