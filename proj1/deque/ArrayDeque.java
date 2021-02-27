package deque;

public class ArrayDeque<T> {
    T[] items;
    int size;
    int nextFirst;
    int nextLast;

    /** Creates an empty array deque. */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    /** Resizes the underlying array to the target capacity. */
    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        for (int i = 0; i < size; i += 1) {
            a[i] = items[i];
        }
        items = a;
    }

    /** Creates a deep copy of other. */
//    public ArrayDeque(ArrayDeque other) {
//        items = (T[]) new Object[8];
//        size = 0;
//        nextFirst = 0;
//        nextLast = 1;
//        System.arraycopy(other,0, this,0,8);
//    }

    /**  Adds an item of type T to the front of the deque. */
    public void addFirst(T item) {
        items[nextFirst] = item;
        if (nextFirst == 0) {
            nextFirst = items.length - 1;
        } else {
            nextFirst -= 1;
        }
        size += 1;
    }

    /** Adds an item of type T to the back of the deque. */
    public void addLast(T item) {
        items[nextLast] = item;
        if (nextLast == items.length - 1) {
            nextLast = 0;
        } else {
            nextLast += 1;
        }
        size += 1;
    }

    /** Returns true if deque is empty, false otherwise. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Returns the number of items in the deque. */
    public int size() {
        return size;
    }

    /** Prints the items in the deque from first to last, separated by a space. */
    public void printDeque() {
        for (int i = nextFirst + 1; i < size; i += 1) {
            if (i == items.length) {
                i = 0;
            }
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    /** Removes and returns the item at the front of the deque.
     *  If no such item exists, returns null. */
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        if ((size < items.length / 4) && (size > 16)) {
            resize(items.length / 4);
        }
        int first = nextFirst + 1;
        T temp;
        if (first == items.length) {
            first = 0;
        }
        temp = items[first];
        items[first] = null;
        nextFirst += 1;
        size -= 1;
        return temp;
    }

    /** Removes and returns the item at the back of the deque.
     *  If no such item exists, returns null. */
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        if ((size < items.length / 4) && (size > 16)) {
            resize(items.length / 4);
        }
        int last = nextLast - 1;
        T temp;
        if (last == items.length) {
            last = 0;
        }
        temp = items[last];
        items[last] = null;
        nextLast -= 1;
        size -= 1;
        return temp;
    }

    /** Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     *  If no such item exists, returns null.
     */
    public T get(int index) {
        return items[index];
    }
}
