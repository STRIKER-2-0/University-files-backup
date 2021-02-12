import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.InputMismatchException;

import static org.junit.Assert.*;

public class SeriesTest {
    private Series series;

    @Before
    public void init() {
        series = new Series();
    }

    @After
    public void tearDown() {
        series = null;
    }


    @Test
    public void findSum() {
        assertTrue(series.findSum(1) == (-1.0));
        //assertTrue(series.findSum(5) == (-0.296));
    }

    @Test
    public void findSum1() {
        assertTrue(series.findSum(10) == (-1.0));
    }
}