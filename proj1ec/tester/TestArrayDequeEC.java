package tester;

import edu.princeton.cs.introcs.StdRandom;
import org.junit.Test;
import student.StudentArrayDeque;

import static org.junit.Assert.assertEquals;

public class TestArrayDequeEC {
    @Test
    public void randomizedRemoveFirstTest() {
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ad = new ArrayDequeSolution<>();

        for (int i = 0; i < 10; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();

            if (numberBetweenZeroAndOne < 0.5) {
                sad.addLast(i);
                ad.addLast(i);
            } else {
                sad.addFirst(i);
                ad.addFirst(i);
            }
        }

        for (int j = 0; j < 10; j += 1) {
            Integer expected = ad.removeFirst();
            Integer actual = sad.removeFirst();
            assertEquals("Expected: " + expected + " but got: " + actual, expected, actual);
        }
    }

    @Test
    public void randomizedRemoveLastTest() {
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ad = new ArrayDequeSolution<>();

        for (int i = 0; i < 10; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();

            if (numberBetweenZeroAndOne < 0.5) {
                sad.addLast(i);
                ad.addLast(i);
            } else {
                sad.addFirst(i);
                ad.addFirst(i);
            }
        }

        for (int j = 0; j < 10; j += 1) {
            Integer expected = ad.removeLast();
            Integer actual = sad.removeLast();
            assertEquals("Expected: " + expected + " but got: " + actual, expected, actual);
            }
        }
}
