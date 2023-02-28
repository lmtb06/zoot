package zoot.arbre;

public class Programme extends ArbreAbstrait {
    private BlocDeFonctions blocDeFonctions ;
    private BlocDInstructions blocDInstructions ;

    public Programme(BlocDeFonctions bf, BlocDInstructions b, int n)
    {
        super(n);
        this.blocDeFonctions = bf;
        this.blocDInstructions = b;
    }
    public void verifier()
    {
        blocDeFonctions.verifier();
        blocDInstructions.verifier();
    }

    public String toMIPS()
    {
        //TODO
        return null;
    }
}
