package zoot.arbre.expressions;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConstanteEntiereTest {


    @Test
    void toMIPS_positif() {
        ConstanteEntiere constanteEntiere = new ConstanteEntiere("42", 0);

        assertEquals(constanteEntiere.toMIPS(), "li $v0, 42\n");
    }

    @Test
    void toMIPS_zero()
    {
        ConstanteEntiere constanteEntiere = new ConstanteEntiere("0", 0);

        assertEquals(constanteEntiere.toMIPS(), "li $v0, 0\n");
    }

    @Test
    void toMIPS_negatif()
    {
        ConstanteEntiere constanteEntiere = new ConstanteEntiere("-42", 0);

        assertEquals(constanteEntiere.toMIPS(), "li $v0, -42\n");
    }
}