package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.HashMap;
import java.util.Map;

public class InnerValidationTest {
    private static MapSchema schema;

    @BeforeAll
    public static void beforeAll() {
        Validator val = new Validator();
        schema = val.map();
        Map<String, BaseSchema> schemas = new HashMap<>();
        schemas.put("name", val.string().required());
        schemas.put("age", val.number().positive());
        schema.shape(schemas);
    }

    @Test
    public void testInner() {
        isHuman1();
        isHuman2();
        isHuman3();
        isHuman4();
    }

    private void isHuman1() {
        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Kolya");
        human1.put("age", 100);
        assertTrue(schema.isValid(human1));
    }

    private void isHuman2() {
        Map<String, Object> human2 = new HashMap<>();
        human2.put("name", "Maya");
        human2.put("age", null);
        assertTrue(schema.isValid(human2));
    }

    private void isHuman3() {
        Map<String, Object> human3 = new HashMap<>();
        human3.put("name", "");
        human3.put("age", null);
        assertFalse(schema.isValid(human3));
    }

    private void isHuman4() {
        Map<String, Object> human4 = new HashMap<>();
        human4.put("name", "Valya");
        human4.put("age", -5);
        assertFalse(schema.isValid(human4));

    }
}
