package hzau.junit;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @description:
 * @author: su
 * @date: 2020/2/13
 */
public class CalculatorTest {
    @Before
    public void init() {
        System.out.println("init...");
    }


    @After
    public void close() {
        System.out.println("close");
    }

    @Test
    public void testAdd() {
        int result = new Calculator().add(1, 2);

        Assert.assertEquals(-1, result);
    }

    @Test
    public void testSub() {
    }
}
