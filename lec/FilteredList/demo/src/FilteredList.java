import java.util.*;

public class FilteredList<T> implements Iterable<T>{
    List<T> L;
    Predicate<T> filter;

    public FilteredList(List<T> L, Predicate<T> filter) {
        this.L = L;
        this.filter = filter;
    }

    @Override
    public Iterator<T> iterator() {
        return new FilteredListIterator();
    }

    private class FilteredListIterator implements Iterator<T> {
        private int index;

        public FilteredListIterator() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < L.size();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T item = L.get(index);
            moveIndex();
            return item;
        }

        private void moveIndex() {
            while(hasNext() && !filter.test(L.get(index))) {
                index += 1;
            }
        }
    }
}
