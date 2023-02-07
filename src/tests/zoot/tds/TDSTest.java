package zoot.tds;

import org.junit.jupiter.api.Test;
import zoot.exceptions.DoubleDeclarationException;
import zoot.exceptions.VariableNonDeclarerException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

class TDSTest {

    @Test
    void ajouter() {
        TDS.getInstance().ajouter(new EntreeVariable("azerty"), new SymboleVariable(Type.ENTIER));

        assertThrowsExactly(DoubleDeclarationException.class,
                () -> TDS.getInstance().ajouter(new EntreeVariable("azerty"), new SymboleVariable(Type.ENTIER))
        );
    }

    @Test
    void identifier() {
        assertThrowsExactly(VariableNonDeclarerException.class,
                () -> TDS.getInstance().identifier(new EntreeVariable("azerty"))
        );
    }

    @Test
    void augmenterTailleZoneVariables() {
        assertEquals(0, TDS.getInstance().getTailleZoneVariables());

        TDS.getInstance().augmenterTailleZoneVariables(4);

        assertEquals(-4, TDS.getInstance().getTailleZoneVariables());

        TDS.getInstance().augmenterTailleZoneVariables(4);

        assertEquals(-8, TDS.getInstance().getTailleZoneVariables());

        TDS.getInstance().augmenterTailleZoneVariables(4);
    }
}