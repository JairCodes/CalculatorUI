package calculatordemo2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private static Calculator classUnderTest;
    private static Calculator unitTest;



    @BeforeAll
    public static void setUp() {
        classUnderTest = new Calculator();
        unitTest = new Calculator();

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

    @DisplayName("Testing adding")
    @Test
    void addition(){
        unitTest.twoOpCaller(Calculator.twoOperator.add,5.0);
        double answer = unitTest.twoOpCaller(Calculator.twoOperator.normal,3.0);
        assertEquals(8.0, answer);
    }

    //  @DisplayName("Testing normal")
    // @Test
    //  void normal(){
    //     unitTest.twoOpCaller(Calculator.twoOperator.add,5.0);
    //     double answer = unitTest.twoOpCaller(Calculator.twoOperator.normal,3.0);
    //     assertEquals(3.0, answer);
    // }
    @DisplayName("Testing subtract")
    @Test
    void subtract(){
        unitTest.twoOpCaller(Calculator.twoOperator.subtract,5.0);
        double answer = unitTest.twoOpCaller(Calculator.twoOperator.normal,3.0);
        assertEquals(2.0, answer);
    }
    @DisplayName("Testing mul")
    @Test
    void mul(){
        unitTest.twoOpCaller(Calculator.twoOperator.multiply,5.0);
        double answer = unitTest.twoOpCaller(Calculator.twoOperator.normal,3.0);
        assertEquals(15.0, answer);
    }
    @DisplayName("Testing div")
    @Test
    void div(){
        unitTest.twoOpCaller(Calculator.twoOperator.divide,20.0);
        double answer = unitTest.twoOpCaller(Calculator.twoOperator.normal,5.0);
        assertEquals(4.0, answer);
    }
    @DisplayName("Testing multest1")
    @Test
    void multest1(){
        unitTest.twoOpCaller(Calculator.twoOperator.multiply,10.0);
        double answer = unitTest.twoOpCaller(Calculator.twoOperator.divide,5.0);
        answer = unitTest.twoOpCaller(Calculator.twoOperator.normal,5.0);
        assertEquals(10.0, answer);
    }
    @DisplayName("Testing multest2")
    @Test
    void multest2(){
        unitTest.twoOpCaller(Calculator.twoOperator.add,20.0);
        double answer = unitTest.twoOpCaller(Calculator.twoOperator.divide,40.0);
        answer = unitTest.twoOpCaller(Calculator.twoOperator.normal,20.0);
        assertEquals(3.0, answer);
    }
    @DisplayName("Testing multest3")
    @Test
    void multest3(){
        unitTest.twoOpCaller(Calculator.twoOperator.add,20.0);
        double answer = unitTest.twoOpCaller(Calculator.twoOperator.divide,5.0);
        answer = unitTest.twoOpCaller(Calculator.twoOperator.add,5.0);
        answer = unitTest.twoOpCaller(Calculator.twoOperator.normal,10.0);

        assertEquals(15.0, answer);
    }

    @DisplayName("first test for op")
    @Test
    void testop(){
        unitTest.twoOpCaller(Calculator.twoOperator.subtract, 20.0);
        double answer = unitTest.twoOpCaller(Calculator.twoOperator.normal, 15.0);
        assertEquals(5.0, answer);
    }
    

    @DisplayName("second test for op")
    @Test
    void testop2(){
        unitTest.twoOpCaller(Calculator.twoOperator.add, 20.0);
        double answer = unitTest.twoOpCaller(Calculator.twoOperator.normal, 15.0);
        assertEquals(35.0, answer);
    }

    @DisplayName("Tests whether an error is thrown if a null mode is passed")
    @Test
    void testThrowError() {
        assertThrows(Error.class, () -> classUnderTest.calcScience(null, 10.0));
    }
}
