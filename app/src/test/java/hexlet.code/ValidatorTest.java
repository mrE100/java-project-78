package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ValidatorTest {
    private static StringSchema stringSchema;

    @BeforeAll
    public static void beforeAll() {
        Validator val = new Validator();
        stringSchema = val.string();
    }

    @Test
    @Order(1)
    public void testBeforeRequired() {
        testNull();
        testEmpty();
    }

    @Test
    @Order(2)
    public void testAfterRequired() {
        stringSchema.required();
        testNullWhenRequire();
        testString();
        testInt();
    }

    @Test
    @Order(3)
    public void testContains() {
        testContains1();
        testContains2();
        testContains3();
        isValidAfterContains();
    }

    private void testNullWhenRequire() {
        assertFalse(stringSchema.isValid(null));
    }

    private void testNull() {
        assertTrue(stringSchema.isValid(null));
    }

    private void testEmpty() {
        assertTrue(stringSchema.isValid(""));
    }

    private void testString() {
        assertTrue(stringSchema.isValid("what does the fox say"));
    }

    private void testInt() {
        assertFalse(stringSchema.isValid(7));
    }

    private void testContains1() {
        stringSchema.contains("wh");
        assertTrue(stringSchema.isValid("what does the fox say"));
    }

    private void testContains2() {
        stringSchema.contains("what");
        assertTrue(stringSchema.isValid("what does the fox say"));
    }
    private void testContains3() {
        stringSchema.contains("whatthe");
        assertFalse(stringSchema.isValid("what does the fox say"));
    }

    private void isValidAfterContains() {
        assertFalse(stringSchema.isValid("what does the fox say"));
    }

}
