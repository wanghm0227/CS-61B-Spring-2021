package flik;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestFlik {
    /** Tests the isSameNumber method of the Flik class. */
    @Test
    public void testIsSameNumber() {
        for (int i = 0; i < 10000; i += 1) {
            assertTrue(Flik.isSameNumber(i, i));
        }
    }


}
