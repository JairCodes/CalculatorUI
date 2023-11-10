package calculatordemo2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import org.checkerframework.checker.units.qual.C;

class CalculatorTest {
    private static Calculator classUnderTest;
    private static Calculator unitTest;
    private static Calculator unitTestop;
    private static Calculator unit8test;

    @BeforeAll
    public static void setUp() {
        classUnderTest = new Calculator();
        unitTest = new Calculator();
        unitTestop = new Calculator();
        unit8test = new Calculator();
    }

    @DisplayName("Tests the square function")
    @Test
    void testSquare() {
        double num = 5.0;
        assertEquals(num*num, classUnderTest.calcScience(Calculator.singleOperator.square, num));
    }

    @DisplayName("Tests the square root function")
    @Test
    void testSquareRoot() {
        double num = 9.0;
        assertEquals(Math.sqrt(num), classUnderTest.calcScience(Calculator.singleOperator.squareRoot, num));
    }

    @DisplayName("Tests the 1/x function")
    @Test
    void testOneDividedBy() {
        double num = 2.0;
        assertEquals(1/num, classUnderTest.calcScience(Calculator.singleOperator.oneDevidedBy, num));
    }

    @DisplayName("Tests the cosine function in degrees")
    @Test
    void testCos() {
        double num = 45.0;
        assertEquals(Math.cos(num), classUnderTest.calcScience(Calculator.singleOperator.cos, num));
    }

    @DisplayName("Tests the sine function in degrees")
    @Test
    void testSin() {
        double num = 30.0;
        assertEquals(Math.sin(num), classUnderTest.calcScience(Calculator.singleOperator.sin, num));
    }

    @DisplayName("Tests the tangent function in degrees")
    @Test
    void testTan() {
        double num = 60.0;
        assertEquals(Math.tan(num), classUnderTest.calcScience(Calculator.singleOperator.tan, num));
    }
    
    @DisplayName("Tests the Arctangent function in degrees")
    @Test
    void testATan() {
        double num = 5.0;
        assertEquals(Math.atan(num), classUnderTest.calcScience(Calculator.singleOperator.ATan, num));
    }

    @DisplayName("Tests the sine function in degrees")
    @Test
    void testASin() {
        double num = 1.0;
        assertEquals(Math.asin(num), classUnderTest.calcScience(Calculator.singleOperator.ASin, num));
    }

    @DisplayName("Tests the cosine function in degrees")
    @Test
    void testACos() {
        double num = 1.0;
        assertEquals(Math.acos(num), classUnderTest.calcScience(Calculator.singleOperator.ACos, num));
    }

   @DisplayName("Testing adding")
    @Test
    void addition(){
        unitTest.num1 = 5.0;
        unitTest.num2 = 3.0;
        unitTest.mode = Calculator.twoOperator.add;
        assertEquals(8.0, unitTest.twoOpOperations());
    }

     @DisplayName("Testing normal")
    @Test
     void normal(){
        unitTest.num1 = 14.0;
        unitTest.num2 = 3.0;
        unitTest.mode = Calculator.twoOperator.normal;
        assertEquals(3.0, unitTest.twoOpOperations());
    }

    @DisplayName("Testing subtract")
    @Test
    void subtract(){
        unitTest.num1 = 57.0;
        unitTest.num2 = 29.0;
        unitTest.mode = Calculator.twoOperator.subtract;
        assertEquals(28.0, unitTest.twoOpOperations());
    }

    @DisplayName("Testing mul")
    @Test
    void mul(){
        unitTest.num1 = 9.0;
        unitTest.num2 = 11.0;
        unitTest.mode = Calculator.twoOperator.multiply;
        assertEquals(99.0, unitTest.twoOpOperations());
    }
    @DisplayName("Testing div")
    @Test
    void div(){
        unitTest.num1 = 39.0;
        unitTest.num2 = 13.0;
        unitTest.mode = Calculator.twoOperator.divide;
        assertEquals(3.0, unitTest.twoOpOperations());
    }

    @DisplayName("Testing multest1")
    @Test
    void multest1(){
        unitTest.num1 = 4.0;
        unitTest.num2 = 5.0;
        unitTest.mode = Calculator.twoOperator.add;
        unitTest.num1 = unitTest.twoOpOperations();
        unitTest.num2 = 41.0;
        unitTest.mode = Calculator.twoOperator.multiply;
        assertEquals(369.0, unitTest.twoOpOperations());
    }

    @DisplayName("Testing multest2")
    @Test
    void multest2(){
        unitTest.num1 = 187.0;
        unitTest.num2 = 2.0;
        unitTest.mode = Calculator.twoOperator.divide;
        unitTest.num1 = unitTest.twoOpOperations();
        unitTest.num2 = 3.0;
        unitTest.mode = Calculator.twoOperator.multiply;
        assertEquals(280.5, unitTest.twoOpOperations());
    }
    @DisplayName("Testing multest3")
    @Test
    void multest3(){
        unitTest.num1 = 5236.0;
        unitTest.num2 = 1390.0;
        unitTest.mode = Calculator.twoOperator.subtract;
        unitTest.num1 = unitTest.twoOpOperations();
        unitTest.num2 = 3.0;
        unitTest.mode = Calculator.twoOperator.multiply;
        unitTest.num1 = unitTest.twoOpOperations();
        unitTest.num2 = 15.0;
        unitTest.mode = Calculator.twoOperator.divide;
        unitTest.num1 = unitTest.twoOpOperations();
        unitTest.num2 = 499.0;
        unitTest.mode = Calculator.twoOperator.add;

        assertEquals(1268.2, unitTest.twoOpOperations());
    }
    
    @DisplayName("first test for op")
    @Test
    void testop(){
        unitTestop.twoOpCaller(Calculator.twoOperator.subtract, 20.0);
        double answer = unitTestop.twoOpCaller(Calculator.twoOperator.normal, 15.0);
        assertEquals(5.0, answer);
    }

    @DisplayName("second test for op")
    @Test
    void testop2(){
        
        unitTestop.twoOpCaller(Calculator.twoOperator.multiply, 10.0);
        double answer = unitTestop.twoOpCaller(Calculator.twoOperator.normal, 5.0);
        assertEquals(50.0, answer);
    }

    @DisplayName("Tests whether an error is thrown if a null mode is passed")
    @Test
    void testThrowError() {
        assertThrows(Error.class, () -> classUnderTest.calcScience(null, 10.0));
    }
}
