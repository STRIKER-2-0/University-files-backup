package com.nu.kovalova.finalTask.jUnit;

import com.nu.kovalova.finalTask.arithmetic.Sequence;
import org.junit.*;
import org.junit.Test;

public class ArithmeticTests {
    private static double delta;
    private int number;

    @BeforeClass
    public static void initializing() {
        System.out.println("Testing started ...");
        delta = 0.0005;
        System.out.println("Delta value is: " + delta);
    }

    @Test
    public void testFirstNaturalNumber() {
        number = 1;
        double expected = 0.5;
        double calculated = Sequence.calculate(number);
        System.out.println("Number is: "+number+" | expected value is: " + expected + " | calculated value is: " + calculated + " | delta is: " + delta);
        Assert.assertEquals(expected, calculated, delta);
    }

    @Test
    public void testSecondNaturalNumber() {
        number = 5;
        double expected = 0.4;
        double calculated = Sequence.calculate(5);
        System.out.println("Number is: "+number+" | expected value is: " + expected + " | calculated value is: " + calculated + " | delta is: " + delta);
        Assert.assertEquals(expected, calculated, delta);
    }

    @Test
    public void testThirdNaturalNumber() {
        number = 10;
        double expected = 0.382;
        double calculated = Sequence.calculate(10);
        System.out.println("Number is: "+number+" | expected value is: " + expected + " | calculated value is: " + calculated + " | delta is: " + delta);
        Assert.assertEquals(expected, calculated, delta);
    }

    @Test
    public void testFifthNaturalNumber() {
        number = 15;
        double expected = 0.388;
        double calculated = Sequence.calculate(15);
        System.out.println("Number is: "+number+" | expected value is: " + expected + " | calculated value is: " + calculated + " | delta is: " + delta);
        Assert.assertEquals(expected, calculated, delta);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUncorrectInput() {
        Sequence.calculate(0);
    }

    @AfterClass
    public static void finishTesting() {
        System.out.println("Finished!");
    }
}