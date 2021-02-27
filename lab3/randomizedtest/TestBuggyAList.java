package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> lst = new AListNoResizing<>();
        BuggyAList<Integer> buggyLst = new BuggyAList<>();
        lst.addLast(1);
        lst.addLast(2);
        lst.addLast(3);
        buggyLst.addLast(1);
        buggyLst.addLast(2);
        buggyLst.addLast(3);
        assertEquals(lst.removeLast(),buggyLst.removeLast());
        assertEquals(lst.removeLast(),buggyLst.removeLast());
        assertEquals(lst.removeLast(),buggyLst.removeLast());
    }
  @Test
  public void randomizedTest() {
    AListNoResizing<Integer> L = new AListNoResizing<>();
    BuggyAList<Integer> buggyL = new BuggyAList<>();

    int N = 10000;
    for (int i = 0; i < N; i += 1) {
      int operationNumber = StdRandom.uniform(0, 3);
      if (operationNumber == 0) {
        // addLast
        int randVal = StdRandom.uniform(0, 100);
        L.addLast(randVal);
        buggyL.addLast(randVal);
      } else if (operationNumber == 1) {
        // getLast
        if (L.size() > 0) {
          assertEquals(L.getLast(), buggyL.getLast());
        }
      } else {
        if (L.size() > 0) {
          assertEquals(L.removeLast(), buggyL.removeLast());
        }
      }
    }
  }
}
