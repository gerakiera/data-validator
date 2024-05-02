package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;

public class MapSchemaTests {
    private MapSchema mapSchema;
    @BeforeEach
    void beforeEach() {
        Validator val = new Validator();
        mapSchema = val.map();
    }
    @Test
    public void testRequired() {
        assertTrue(mapSchema.required().isValid(new HashMap<>()));
        assertFalse(mapSchema.isValid(null));
        HashMap<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        assertTrue(mapSchema.isValid(data));
    }
    @Test
    public void testSizeOf() {
        assertTrue(mapSchema.sizeof(0).isValid(new HashMap<>()));
        HashMap<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        data.put("key2", "value2");
        assertTrue(mapSchema.sizeof(1).isValid(data));
        assertFalse(mapSchema.sizeof(3).isValid(data));
    }
}
