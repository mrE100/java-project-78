package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidatorTest {
    private final Validator val = new Validator();

    @BeforeAll
    public static void beforeAll() {

    }

    @Test
    public void testNumberSchema() {
        NumberSchema schema = val.number();

        assertTrue(schema.isValid(null));
        assertTrue(schema.positive().isValid(null));

        schema.required();

        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(5));
        assertFalse(schema.isValid("5"));
        assertFalse(schema.isValid(-8));

        schema.range(5, 25);

        assertTrue(schema.isValid(5));
        assertTrue(schema.isValid(21));
        assertTrue(schema.isValid(25));
        assertFalse(schema.isValid(50));
        assertFalse(schema.isValid(2));
    }

    @Test
    public void testStringSchema() {
        StringSchema stringSchema = val.string();
        assertTrue(stringSchema.isValid(""));
        assertTrue(stringSchema.isValid(null));

        stringSchema.required();

        assertTrue(stringSchema.isValid("what does the fox say"));
        assertTrue(stringSchema.isValid("hexlet"));

        assertFalse(stringSchema.isValid(null));
        assertFalse(stringSchema.isValid(7));
        assertFalse(stringSchema.isValid(""));

        assertTrue(stringSchema.minLength(1).isValid("five"));
        assertFalse(stringSchema.minLength(12).isValid("five"));

        assertTrue(stringSchema.contains("wh").isValid("what does the fox say"));
        assertTrue(stringSchema.contains("what").isValid("what does the fox say"));
        assertFalse(stringSchema.contains("whatthe").isValid("what does the fox say"));

        assertFalse(stringSchema.isValid("what does the fox say"));
    }

    @Test
    public void testMapSchema() {
        MapSchema mapSchema = val.map();

        assertTrue(mapSchema.isValid(null));

        mapSchema.required();

        assertFalse(mapSchema.isValid(null));
        assertTrue(mapSchema.isValid(new HashMap<>()));

        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        assertTrue(mapSchema.isValid(data));

        mapSchema.sizeof(2);

        assertFalse(mapSchema.isValid(data));
        data.put("key2", "value2");
        assertTrue(mapSchema.isValid(data));
    }

    @Test
    public void testInnerValidation() {
        MapSchema schema = val.map();
        Map<String, BaseSchema> schemas = new HashMap<>();
        schemas.put("name", val.string().required());
        schemas.put("age", val.number().positive());
        schema.shape(schemas);

        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Kolya");
        human1.put("age", 100);
        assertTrue(schema.isValid(human1));

        Map<String, Object> human2 = new HashMap<>();
        human2.put("name", "Maya");
        human2.put("age", null);
        assertTrue(schema.isValid(human2));

        Map<String, Object> human3 = new HashMap<>();
        human3.put("name", "");
        human3.put("age", null);
        assertFalse(schema.isValid(human3));

        Map<String, Object> human4 = new HashMap<>();
        human4.put("name", "Valya");
        human4.put("age", -5);
        assertFalse(schema.isValid(human4));
    }

}
