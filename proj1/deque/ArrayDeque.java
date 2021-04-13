package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T> {
    T[] items;
    int size;
    int nextFirst;
    int nextLast;

    /**
     * Creates an empty array deque.
     */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    /**
     * Creates a deep copy of other.
     */
    public ArrayDeque(ArrayDeque other) {
        items = (T[]) new Object[size];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
        System.arraycopy(other, 0, this, 0, 8);
    }

    /**
     * Resizes the underlying array to the target capacity.
     */
    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        int tempIndex = nextFirst + 1;
        for (int i = 0; i < size; i += 1) {
            if (tempIndex == size) {
                tempIndex = 0;
            }
            if (items[tempIndex] != null) {
                a[i] = items[tempIndex];
            }
            tempIndex += 1;
        }
        nextFirst = a.length - 1;
        nextLast = size;
        items = a;
    }

    /**
     * Adds an item of type T to the front of the deque.
     */
    public void addFirst(T item) {
        items[nextFirst] = item;
        size += 1;
        if (nextFirst == 0) {
            nextFirst = items.length - 1;
        } else {
            nextFirst -= 1;
        }
        if (size == items.length) {
            resize(size * 2);
        }
    }

    /**
     * Adds an item of type T to the back of the deque.
     */
    public void addLast(T item) {
        items[nextLast] = item;
        size += 1;
        nextLast = (nextLast + 1) % items.length;
        if (size == items.length) {
            resize(size * 2);
        }

    }

    /**
     * Returns the number of items in the deque.
     */
    public int size() {
        return size;
    }

    /**
     * Prints the items in the deque from first to last, separated by a space.
     */
    public void printDeque() {
        for (int i = nextFirst + 1; i < size; i += 1) {
            System.out.print(items[i % items.length] + " ");
        }
        System.out.println();
    }

    /**
     * Removes and returns the item at the front of the deque.
     * If no such item exists, returns null.
     */
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        if ((size < items.length / 4) && (size > 16)) {
            resize(items.length / 4);
        }
        T temp;
        temp = items[(nextFirst + 1) % items.length];
        items[(nextFirst + 1) % items.length] = null;
        nextFirst = (nextFirst + 1) % items.length;
        size = size - 1;
        return temp;
    }

    /**
     * Removes and returns the item at the back of the deque.
     * If no such item exists, returns null.
     */
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        if ((size < items.length / 4) && (size > 16)) {
            resize(items.length / 4);
        }
        T temp;
        if (nextLast - 1 < 0) {
            temp = items[items.length - 1];
            items[items.length - 1] = null;
            nextLast = items.length - 1;
        } else {
            temp = items[nextLast - 1];
            items[nextLast - 1] = null;
            nextLast = nextLast - 1;
        }
        size = size - 1;
        return temp;
    }

    /**
     * Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null.
     */
    public T get(int index) {
        int first = nextFirst + 1;
        int pos = (first + index) % items.length;
        return items[pos];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (!(o instanceof Deque)) {
            return false;
        }

        ArrayDeque<T> other = (ArrayDeque<T>) o;
        if (other.size != this.size) {
            return false;
        }
        for (int i = 0; i < size; i += 1) {
            if (this.get(i) != other.get(i)) {
                return false;
            }
        }

        return true;
    }

    /**
     * The Deque objects we’ll make are iterable.
     */
    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    private class ArrayDequeIterator implements Iterator<T> {
        private int pos;

        public ArrayDequeIterator() {
            pos = nextFirst + 1;
        }

        public boolean hasNext() {
            return pos != nextLast;
        }

        public T next() {
            T returnItem = items[pos];
            pos = pos + 1;
            return returnItem;
        }
    }
}
