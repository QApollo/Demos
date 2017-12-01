import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.ArithmeticException;


public class TestDemo {
    @Test

    public void testAdd() {
        assertEquals(Demo.calculate(2.0,3.0, "+"),5.0, 0.0);
        assertEquals(Demo.calculate(-2.0,3.0, "+"),1.0, 0.0);
        assertEquals(Demo.calculate(-2.0,-3.0, "+"),-5.0, 0.0);
        assertEquals(Demo.calculate(0.0,0.0, "+"),0.0, 0.0);
    }

    @Test

    public void testMinus() {
        assertEquals(Demo.calculate(2.0,3.0, "-"),-1.0, 0.0);
        assertEquals(Demo.calculate(-1.0,-3.0, "-"),2.0, 0.0);
        assertEquals(Demo.calculate(12.0,3.0, "-"),9.0, 0.0);
        assertEquals(Demo.calculate(0.0,0.0, "-"),0.0, 0.0);
    }

    @Test

    public void testMultiply() {
        assertEquals(Demo.calculate(2.0,3.0, "*"),6.0, 0.0);
        assertEquals(Demo.calculate(-1.0,-3.0, "*"),3.0, 0.0);
        assertEquals(Demo.calculate(12.0,3.0, "*"),36.0, 0.0);
        assertEquals(Demo.calculate(0.0,0.0, "*"),0.0, 0.0);
    }

    @Test

    public void testDivide() {
        assertEquals(Demo.calculate(3.0,3.0, "/"),1.0, 0.0);
        assertEquals(Demo.calculate(-3.0,-1.0, "/"),3.0, 0.0);
        assertEquals(Demo.calculate(12.0,3.0, "/"),4.0, 0.0);

    }


    @Test (expected = ArithmeticException.class)

    public void testArithmeticException(){
        Demo.calculate(1.0, 0.0, "/");

    }

}