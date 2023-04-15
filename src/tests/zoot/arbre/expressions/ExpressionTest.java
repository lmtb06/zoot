package zoot.arbre.expressions;

import org.junit.jupiter.api.Test;
import zoot.arbre.expressions.operateurs.binaire.Somme;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExpressionTest {

    @Test
    void getNombreDePlaces() {
        // e = ( a + 1 ) + 2 // Nbre Ershov = 2
        Expression e = new Somme(new Somme(new Variable("a", 0), new ConstanteEntiere("1", 0), 0), new ConstanteEntiere("2", 0), 0);
        assertEquals(2, e.getNombreDePlaces());
    }
}