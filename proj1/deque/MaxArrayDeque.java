package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque {
    Comparator comp;

    /** creates a MaxArrayDeque with the given Comparator. */
    public MaxArrayDeque(Comparator<T> c) {
        super();
        comp = c;
    }

    /** returns the maximum element in the deque as governed by the previously given Comparator.
     * If the MaxArrayDeque is empty, simply return null.
     */
    public T max() {
        if (isEmpty()) {
            return null;
        }

        T maxItem = (T) get(0);
        for (int i = 1; i < size; i += 1) {
            T item = (T) get(i);
            if (comp.compare(maxItem, item) <= 0) {
                maxItem = item;
            }
        }

        return maxItem;
    }

    /** returns the maximum element in the deque as governed by the parameter Comparator c.
     * If the MaxArrayDeque is empty, simply return null.
     */
    public T max(Comparator<T> c) {
        if (isEmpty()) {
            return null;
        }

        T maxItem = (T) get(0);
        for (int i = 1; i < size; i += 1) {
            T item = (T) get(i);
            if (c.compare(maxItem, item) <= 0) {
                maxItem = item;
            }
        }

        return maxItem;
    }
}
