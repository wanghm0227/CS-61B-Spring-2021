package deque;

import edu.princeton.cs.algs4.ST;

public class LinkedListDeque<T> {
    private class StuffNode {
        public T item;
        public StuffNode next;
        public StuffNode prev;

        public StuffNode(T i, StuffNode n, StuffNode p) {
            item = i;
            next = n;
            prev = p;
        }
    }

    private StuffNode sentinel;
    private int size;

    /** Creates an empty linked list deque. */
     public LinkedListDeque() {
        sentinel = new StuffNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    /** Creates a deep copy of other. */
    public LinkedListDeque(LinkedListDeque<T> other) {
        sentinel = new StuffNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;

        for (int i = 0; i < other.size(); i++) {
            addLast(other.get(i));
        }
    }

    /** Adds an item of type T to the front of the deque. */
    public void addFirst(T item) {
        StuffNode s = new StuffNode(item, sentinel.next, sentinel);
        sentinel.next.prev = s;
        sentinel.next = s;
        size += 1;
    }

    /** Adds an item of type T to the back of the deque. */
    public void addLast(T item) {
        StuffNode s = new StuffNode(item, sentinel, sentinel.prev);
        sentinel.prev.next = s;
        sentinel.prev = s;
        size += 1;
    }

    /** Returns true if deque is empty, false otherwise. */
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    /** Returns the number of items in the deque. */
    public int size() {
        return size;
    }

    /** Prints the items in the deque from first to last, separated by a space. */
    public void printDeque() {
        StuffNode p = sentinel.next;
        while (p != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    /** Removes and returns the item at the front of the deque. If no such item exists, returns null. */
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T temp = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size -= 1;
        return temp;
    }

    /** Removes and returns the item at the back of the deque. If no such item exists, returns null. */
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T temp = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size -= 1;
        return temp;
    }

    /** Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     *  If no such item exists, returns null. */
    public T get(int index) {
        int i = 0;
        StuffNode p = sentinel.next;
        while (i < index) {
            p = p.next;
            if (p == sentinel) {
                return null;
            }
        }
        return p.item;
    }

    /**  Same as get, but uses recursion. */
    public T getRecursive(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        StuffNode p = sentinel.next;
        return getHelper(index,p);
    }

    private T getHelper(int index, StuffNode p) {
        if (index == 0) {
            return p.item;
        }
        return getHelper(index - 1, p.next);
    }

}
