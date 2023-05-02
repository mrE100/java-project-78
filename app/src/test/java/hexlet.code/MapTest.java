package hexlet.code;

import hexlet.code.schemas.MapSchema;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;



import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MapTest {
    private static MapSchema mapSchema;

    @BeforeAll
    public static void beforeAll() {
        Validator val = new Validator();
        mapSchema = val.map();
    }

    @Test
    @Order(1)
    public void mapSchemaTestIsValidNull() {
        mapSchemaIsValidNull();
        mapSchema.required();
        mapSchemaIsValidNullWhenRequired();
    }

    @Test
    @Order(2)
    public void mapSchemaTestIsValidHashMap() {
        mapSchemaIsValidHashMap();
    }

    @Test
    @Order(3)
    public void mapSchemaTestSize() {
        mapSchema.sizeof(2);
        mapSchemaNotValidSize();
        mapSchemaIsValidSize();
    }

    private void mapSchemaIsValidNull()  {
        assertTrue(mapSchema.isValid(null));
    }

    private void mapSchemaIsValidNullWhenRequired() {
        assertFalse(mapSchema.isValid(null));
    }

    private void mapSchemaIsValidHashMap() {
        assertTrue(mapSchema.isValid(new HashMap<>()));
    }

    private void mapSchemaNotValidSize() {
        HashMap map = new HashMap();
        map.put("key1", "value1");
        assertFalse(mapSchema.isValid(map));
    }

    private void mapSchemaIsValidSize() {
        HashMap map = new HashMap();
        map.put("key1", "value1");
        map.put("key2", "value2");
        assertTrue(mapSchema.isValid(map));
    }
}
