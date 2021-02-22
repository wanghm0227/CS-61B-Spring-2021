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

    /** Creates a deep copy of other. */
    public ArrayDeque(ArrayDeque other) {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
        System.arraycopy(other,0, this,0,8);
    }

    /**  Adds an item of type T to the front of the deque. */
    public void addFirst(T item) {
        items[nextFirst] = item;
        if (nextFirst == 0) {
            nextFirst = 7;
        } else {
            nextFirst -= 1;
        }
        size += 1;
    }

    /** Adds an item of type T to the back of the deque. */
    public void addLast(T item) {
        items[nextLast] = item;
        if (nextLast == 7) {
            nextLast = 0;
        } else {
            nextLast += 1;
        }
        size += 1;
    }

    /** Returns true if deque is empty, false otherwise. */
    public boolean isEmpty() {
        return size == 0 ? true : false;
    }

    /** Returns the number of items in the deque. */
    public int size() {
        return size;
    }

    /** Prints the items in the deque from first to last, separated by a space. */
    public void printDeque() {
        int i;
        if (nextFirst == 7) {
            i = 0;
        } else {
            i = nextFirst + 1;
        }
        while (i < size) {
            System.out.print(items[i] + " ");
            i += 1;
        }
        System.out.println();
    }

    /** Removes and returns the item at the front of the deque.
     *  If no such item exists, returns null. */
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        int i;
        T temp;
        if (nextFirst == 7) {
            temp = items[0];
            items[0] = null;
        } else {
            temp = items[nextFirst + 1];
            items[nextFirst + 1] = null;
        }
        if(size > 0) {
            size -= 1;
        }
        return temp;
    }

    /** Removes and returns the item at the back of the deque.
     *  If no such item exists, returns null. */
    public T removeLast() {
        int i;
        T temp;
        if (nextLast == 0) {
            temp = items[7];
            items[7] = null;
        } else {
            temp = items[nextLast - 1];
            items[nextLast - 1] = null;
        }
        if (size > 0) {
            size -= 1;
        }
        return temp;
    }

    /** Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     *  If no such item exists, returns null.
     */
    public T get(int index) {
        if (index >7 || index < 0) {
            return null;
        }
        return items[index];
    }
}
