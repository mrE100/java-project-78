package hexlet.code;
import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StringTest {
    private static StringSchema stringSchema;

    @BeforeAll
    public static void beforeAll() {
        Validator val = new Validator();
        stringSchema = val.string();

    }

    @Test
    @Order(1)
    public void testStringSchemaBeforeRequired() {
        StringSchemaTestNull();
        StringSchemaTestEmpty();
    }

    @Test
    @Order(2)
    public void testStringSchemaAfterRequired() {
        stringSchema.required();
        StringSchemaTestNullWhenRequire();
        StringSchemaTestString();
        StringSchemaTestInt();
    }

    @Test
    @Order(3)
    public void testStringSchemaContains() {
        StringSchemaTestContains1();
        StringSchemaTestContains2();
        StringSchemaTestContains3();
        StringSchemaIsValidAfterContains();
    }

    private void StringSchemaTestNullWhenRequire() {
        assertFalse(stringSchema.isValid(null));
    }

    private void StringSchemaTestNull() {
        assertTrue(stringSchema.isValid(null));
    }

    private void StringSchemaTestEmpty() {
        assertTrue(stringSchema.isValid(""));
    }

    private void StringSchemaTestString() {
        assertTrue(stringSchema.isValid("what does the fox say"));
    }

    private void StringSchemaTestInt() {
        assertFalse(stringSchema.isValid(7));
    }

    private void StringSchemaTestContains1() {
        stringSchema.contains("wh");
        assertTrue(stringSchema.isValid("what does the fox say"));
    }

    private void StringSchemaTestContains2() {
        stringSchema.contains("what");
        assertTrue(stringSchema.isValid("what does the fox say"));
    }
    private void StringSchemaTestContains3() {
        stringSchema.contains("whatthe");
        assertFalse(stringSchema.isValid("what does the fox say"));
    }

    private void StringSchemaIsValidAfterContains() {
        assertFalse(stringSchema.isValid("what does the fox say"));
    }

}
