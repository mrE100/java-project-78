package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class NumberTest {
    private static NumberSchema numberSchema;

    @BeforeAll
    public static void beforeAll() {
        Validator val = new Validator();
        numberSchema = val.number();
    }

    @Test
    @Order(1)
    public void testNumberSchemaBeforeRequired() {
        NumberSchemaTestNullBeforeRequired();
    }

    @Test
    @Order(2)
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
    @Order(3)
    public void testNumberSchemaInRange() {
        numberSchema.range(5, 25);
        NumberSchemaTestInRange1();
        NumberSchemaTestInRange2();
        NumberSchemaTestInRange3();
        NumberSchemaTestInRange4();
        NumberSchemaTestInRange5();

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
        assertFalse(numberSchema.isValid(-5));
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
