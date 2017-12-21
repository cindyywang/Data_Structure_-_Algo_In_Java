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
        /*if(c > 11)
        {
            int temp = c;
            c %= 12;
            b +=  (temp/12);
        }*/
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
        /*int bInch = b.getInches();
        int bFeet = b.getFeet();*/
        Measurement b = new Measurement(2,5);
        //Measurement c = new Measurement(3,11);
        /*if(bInch > 11)
        {
            int temp = bInch;
            bInch = bInch % 12;
            bFeet +=  (temp/12);
        }*/
        assertEquals(a.plus(b).toString(), "3'11\"");


    }

    @Test
    public void testMinus() throws Exception
    {
        Measurement a = new Measurement(2,7);
        Measurement b = new Measurement(1,6);
        //Measurement c = new Measurement(1, 1);
        assertEquals(a.minus(b).toString(),"1'1\"");
    }

    @Test
    public void testMultiple() throws Exception
    {
        Measurement a = new Measurement(7,7);
        //Measurement b = new Measurement(14,14);
        assertEquals(a.multiple(2).toString(), "15'2\"");
    }

    @Test
    public void testToString() throws Exception
    {
        Measurement a = new Measurement(2,13);
        assertEquals(a.toString(),"3'1\"");

    }

}