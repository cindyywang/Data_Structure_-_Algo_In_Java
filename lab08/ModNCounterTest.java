import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ying2ra on 7/6/17.
 */
public class ModNCounterTest {

    @org.junit.Test
    public void testConstructor() {
        ModNCounter c = new ModNCounter(2);
        assertTrue(c.value() == 0);
    }

    @org.junit.Test
    public void increment() throws Exception {
        ModNCounter c = new ModNCounter(2);
        c.increment();
        assertTrue(c.value()  == 1);
        c.increment();
        assertTrue(c.value() == 0);
        c.increment();
        assertTrue(c.value() == 1);
        c.increment();
        assertTrue(c.value() == 0);
    }

    @Test
    public void reset() throws Exception {
        ModNCounter c = new ModNCounter(2);
        c.increment();
        c.reset();
        assertTrue(c.value() == 0);
    }

}