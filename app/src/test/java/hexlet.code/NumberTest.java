package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        numberSchemaTestNullBeforeRequired();
    }

    @Test
    @Order(2)
    public void testNumberSchemaAfterRequired() {
        numberSchema.required();
        numberSchemaTestNullAfterRequired();
        numberSchemaTestIsNumber();
        numberSchemaTestIsNumber2();
        numberSchemaTestIsNumberNotPositive();
        numberSchema.positive();
        numberSchemaTestPositive1();
        numberSchemaTestPositive2();
        numberSchemaTestPositive3();
        numberSchemaTestPositive3();
        numberSchemaTestPositive4();
    }

    @Test
    @Order(3)
    public void testNumberSchemaInRange() {
        numberSchema.range(5, 25);
        numberSchemaTestInRange1();
        numberSchemaTestInRange2();
        numberSchemaTestInRange3();
        numberSchemaTestInRange4();
        numberSchemaTestInRange5();

    }

    private void numberSchemaTestNullBeforeRequired() {
        assertTrue(numberSchema.isValid(null));
    }

    private void numberSchemaTestNullAfterRequired() {
        assertFalse(numberSchema.isValid(null));
    }

    private void numberSchemaTestPositive1() {
        assertTrue(numberSchema.isValid(5));
    }

    private void numberSchemaTestPositive2() {
        assertFalse(numberSchema.isValid(-5));
    }

    private void numberSchemaTestPositive3() {
        assertFalse(numberSchema.isValid(null));
    }
    private void numberSchemaTestPositive4() {
        assertFalse(numberSchema.isValid(0));
    }

    private void numberSchemaTestInRange1() {
        assertTrue(numberSchema.isValid(5));
    }
    private void numberSchemaTestInRange2() {
        assertTrue(numberSchema.isValid(25));
    }
    private void numberSchemaTestInRange3() {
        assertFalse(numberSchema.isValid(50));
    }
    private void numberSchemaTestInRange4() {
        assertFalse(numberSchema.isValid(4));
    }

    private void numberSchemaTestInRange5() {
        assertTrue(numberSchema.isValid(14));
    }

    private void numberSchemaTestIsNumber() {
        assertFalse(numberSchema.isValid("14"));
    }

    private void numberSchemaTestIsNumber2() {
        assertFalse(numberSchema.isValid(14.5));
    }

    private void numberSchemaTestIsNumberNotPositive() {
        assertTrue(numberSchema.isValid(-5));
    }
}
