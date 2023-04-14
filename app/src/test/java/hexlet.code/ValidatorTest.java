package hexlet.code;

import hexlet.code.schemas.NumberSchema;
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
    private static NumberSchema numberSchema;

    @BeforeAll
    public static void beforeAll() {
        Validator val = new Validator();
        stringSchema = val.string();
        numberSchema = val.number();
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
    @Test
    @Order(4)
    public void testNumberSchemaBeforeRequired() {
        NumberSchemaTestNullBeforeRequired();
    }

    @Test
    @Order(5)
    public void testNumberSchemaAfterRequired() {
        numberSchema.required();
        NumberSchemaTestNullAfterRequired();
        NumberSchemaTestIsNumber();
        NumberSchemaTestIsNumber2();
        NumberSchemaTestIsNumberNotPositive();
        numberSchema.positive();
        NumberSchemaTestPositive1();
        NumberSchemaTestPositive2();
        NumberSchemaTestPositive3();
        NumberSchemaTestPositive3();
        NumberSchemaTestPositive4();
    }

    @Test
    @Order(6)
    public void testNumberSchemaInRange() {
        numberSchema.range(5, 25);
        NumberSchemaTestInRange1();
        NumberSchemaTestInRange2();
        NumberSchemaTestInRange3();
        NumberSchemaTestInRange4();
        NumberSchemaTestInRange5();

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

    private void NumberSchemaTestNullBeforeRequired() {
        assertTrue(numberSchema.isValid(null));
    }

    private void NumberSchemaTestNullAfterRequired() {
        assertFalse(numberSchema.isValid(null));
    }

    private void NumberSchemaTestPositive1() {
        assertTrue(numberSchema.isValid(5));
    }

    private void NumberSchemaTestPositive2() {
        assertFalse(numberSchema.isValid(-15));
    }

    private void NumberSchemaTestPositive3() {
        assertFalse(numberSchema.isValid(null));
    }
    private void NumberSchemaTestPositive4() {
        assertFalse(numberSchema.isValid(0));
    }

    private void NumberSchemaTestInRange1() {
        assertTrue(numberSchema.isValid(5));
    }
    private void NumberSchemaTestInRange2() {
        assertTrue(numberSchema.isValid(25));
    }
    private void NumberSchemaTestInRange3() {
        assertFalse(numberSchema.isValid(50));
    }
    private void NumberSchemaTestInRange4() {
        assertFalse(numberSchema.isValid(4));
    }

    private void NumberSchemaTestInRange5() {
        assertTrue(numberSchema.isValid(14));
    }

    private void NumberSchemaTestIsNumber() {
        assertFalse(numberSchema.isValid("14"));
    }

    private void NumberSchemaTestIsNumber2() {
        assertFalse(numberSchema.isValid(14.5));
    }

    private void NumberSchemaTestIsNumberNotPositive() {
        assertTrue(numberSchema.isValid(-5));
    }
}
