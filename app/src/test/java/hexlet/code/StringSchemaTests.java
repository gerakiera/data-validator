package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public final class StringSchemaTests {
    private StringSchema s;
    @BeforeEach
        void beforeEach() {
        Validator val = new Validator();
        s = val.string();
    }
    @Test
    public void testRequired() {
        assertTrue(s.required().isValid("string"));
        assertFalse(s.required().isValid(""));
        assertFalse(s.required().isValid(null));
    }
    @Test
    public void testMinLength() {
        String str = "hello";
        assertTrue(s.minLength(4).isValid(str));
        assertFalse(s.minLength(6).isValid(str));
    }
    @Test
    public void testContain() {
        String str = "hello";
        assertTrue(s.contains("hel").isValid(str));
        assertFalse(s.contains("or").isValid(str));
    }
}
