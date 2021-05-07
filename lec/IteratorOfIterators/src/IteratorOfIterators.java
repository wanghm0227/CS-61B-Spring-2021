import java.util.*;

public class IteratorOfIterators implements Iterator<Integer> {
    LinkedList<Iterator<Integer>> list;

    public IteratorOfIterators(List<Iterator<Integer>> a) {
        this.list = new LinkedList<>();
        for (Iterator<Integer> iterator : a) {
            if (iterator.hasNext()) {
                list.addLast(iterator);
            }
        }
    }

    @Override
    public boolean hasNext() {
        return !list.isEmpty();
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Iterator<Integer> nextIterator = list.removeFirst();
        int ans = nextIterator.next();
        if (nextIterator.hasNext()) {
            list.addLast(nextIterator);
        }
        return ans;
    }
}