package zoot.tds;

public class SymboleVariable extends Symbole {

    public SymboleVariable(Type type)
    {
        super(type);
    }

    @Override
    public boolean equals(Object entreeAComparer)
    {
        return (this.getClass() == entreeAComparer.getClass()
                && this.type == ((Symbole) entreeAComparer).getType());
    }
}
