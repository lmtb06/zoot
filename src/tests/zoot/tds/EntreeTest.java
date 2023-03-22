package zoot.tds;

import org.junit.jupiter.api.Test;
import zoot.tds.entrees.EntreeVariable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class EntreeTest {

    @Test
    void testEquals() {
        assertNotEquals(new Object(), new EntreeVariable("a"));
        assertNotEquals(new EntreeVariable("b"), new EntreeVariable("a"));
        assertEquals(new EntreeVariable("a"), new EntreeVariable("a"));
    }
}