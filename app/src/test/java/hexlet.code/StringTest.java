package hexlet.code;
import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


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
        stringSchemaTestNull();
        stringSchemaTestEmpty();
    }

    @Test
    @Order(2)
    public void testStringSchemaAfterRequired() {
        stringSchema.required();
        stringSchemaTestNullWhenRequired();
        stringSchemaTestEmptyAfterRequired();
        stringSchemaTestString();
        stringSchemaTestInt();
    }

    @Test
    @Order(3)
    public void testStringSchemaContains() {
        stringSchemaTestContains1();
        stringSchemaTestContains2();
        stringSchemaTestContains3();
        stringSchemaIsValidAfterContains();
    }

    private void stringSchemaTestNullWhenRequired() {
        assertFalse(stringSchema.isValid(null));
    }

    private void stringSchemaTestNull() {
        assertTrue(stringSchema.isValid(null));
    }

    private void stringSchemaTestEmpty() {
        assertTrue(stringSchema.isValid(""));
    }

    private void stringSchemaTestEmptyAfterRequired() {
        assertFalse(stringSchema.isValid(""));
    }

    private void stringSchemaTestString() {
        assertTrue(stringSchema.isValid("what does the fox say"));
    }

    private void stringSchemaTestInt() {
        assertFalse(stringSchema.isValid(7));
    }

    private void stringSchemaTestContains1() {
        stringSchema.contains("wh");
        assertTrue(stringSchema.isValid("what does the fox say"));
    }

    private void stringSchemaTestContains2() {
        stringSchema.contains("what");
        assertTrue(stringSchema.isValid("what does the fox say"));
    }
    private void stringSchemaTestContains3() {
        stringSchema.contains("whatthe");
        assertFalse(stringSchema.isValid("what does the fox say"));
    }

    private void stringSchemaIsValidAfterContains() {
        assertFalse(stringSchema.isValid("what does the fox say"));
    }

}
