import org.junit.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ying2ra on 7/6/17.
 */
public class MeasurementTest {
    @org.junit.Test
    public void testMeasurement() throws Exception
    {
        Measurement a = new Measurement();
        assertEquals(a.getFeet(), 0);
        assertEquals(a.getInches(), 0);

        Measurement b = new Measurement(1);
        assertEquals(b.getFeet(), 1);
        assertEquals(b.getInches(), 0);

        Measurement c = new Measurement(1, 12);
        assertEquals(c.getFeet(),2);
        assertEquals(c.getInches(), 0);

        Measurement d = new Measurement(1, 11);
        assertEquals(d.getFeet(),1);
        assertEquals(d.getInches(), 11);
    }

    @Test
    public void testPlus() throws Exception
    {
        Measurement a = new Measurement(1,6);
        Measurement b = new Measurement(2,5);
        assertEquals(a.plus(b).toString(), "3'11\"");


    }

    @Test
    public void testMinus() throws Exception
    {
        Measurement a = new Measurement(2,7);
        Measurement b = new Measurement(1,6);
        assertEquals(a.minus(b).toString(),"1'1\"");
    }

    @Test
    public void testMultiple() throws Exception
    {
        Measurement a = new Measurement(7,7);
        assertEquals(a.multiple(2).toString(), "15'2\"");
    }

    @Test
    public void testToString() throws Exception
    {
        Measurement a = new Measurement(2,13);
        assertEquals(a.toString(),"3'1\"");

    }

}