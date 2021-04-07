package tester;

import edu.princeton.cs.introcs.StdRandom;
import org.junit.Test;
import student.StudentArrayDeque;

import static org.junit.Assert.assertEquals;

public class TestArrayDequeEC {
    @Test
    public void randomizedRemoveFirstTest() {
        StudentArrayDeque<Integer> student = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> solution = new ArrayDequeSolution<>();

        for (int i = 0; i < 10; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();

            if (numberBetweenZeroAndOne < 0.5) {
                student.addLast(i);
                solution.addLast(i);
            } else {
                student.addFirst(i);
                solution.addFirst(i);
            }
        }

        for (int j = 0; j < 10; j += 1) {
            Integer expected = solution.removeFirst();
            Integer actual = student.removeFirst();
            assertEquals("Expected: " + expected + " but got: " + actual, expected, actual);
        }
    }

    @Test
    public void randomizedRemoveLastTest() {
        StudentArrayDeque<Integer> student = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> solution = new ArrayDequeSolution<>();

        for (int i = 0; i < 10; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();

            if (numberBetweenZeroAndOne < 0.5) {
                student.addLast(i);
                solution.addLast(i);
            } else {
                student.addFirst(i);
                solution.addFirst(i);
            }
        }

        for (int j = 0; j < 10; j += 1) {
            Integer expected = solution.removeLast();
            Integer actual = student.removeLast();
            assertEquals("Expected: " + expected + " but got: " + actual, expected, actual);
            }
        }
}
