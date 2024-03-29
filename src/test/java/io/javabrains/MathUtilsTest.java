package io.javabrains;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class MathUtilsTest {
    MathUtils mathUtils;

    @BeforeAll
    static void beforeAllInit()
    {
        System.out.println("This needs to run before all....");
    }

    @BeforeEach
    void init()
    {
        mathUtils = new MathUtils();
    }

    @AfterEach
    void cleanup()
    {
        System.out.println("Cleaning up ......");
    }

    @Test
    @EnabledOnOs(OS.MAC)
    @DisplayName("Testing add method")
    void testAdd() {

        int expected = 2;
        int actual = mathUtils.add(1,1);
        assertEquals(expected, actual, "The add method should add two numbers");
    }

    @Test
    void testComputeCircleArea()
    {
        assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), "Should return right circle Area");
    }

    @Test
    void testDivide()
    {
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0), "Divide by zero should throw");
    }

}