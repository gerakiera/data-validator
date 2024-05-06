package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public final class NumberSchemaTests {
    private NumberSchema n;
    @BeforeEach
    void beforeEach() {
        Validator val = new Validator();
        n = val.number();
    }
    @Test
    public void testRequired() {
        assertTrue(n.required().isValid(5));
        assertFalse(n.required().isValid(null));
    }
    @Test
    public void testPositive() {
        assertTrue(n.positive().isValid(5));
        assertFalse(n.positive().isValid(-1));
    }
    @Test
    public void testRrange() {
        assertTrue(n.range(1, 9).isValid(5));
        assertFalse(n.range(1, 3).isValid(5));
    }
}
