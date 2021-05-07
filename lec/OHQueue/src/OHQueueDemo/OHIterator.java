package OHQueueDemo;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class OHIterator implements Iterator<OHRequest> {
    OHRequest curr;

    public OHIterator(OHRequest queue) {
        this.curr = queue;
    }

    public boolean isGood(String description) {
        return description != null && description.length() > 5;
    }

    @Override
    public boolean hasNext() {
        while (curr != null) {
            if (isGood(curr.description)) {
                return true;
            } else {
                curr = curr.next;
            }
        }
        return false;
    }

    @Override
    public OHRequest next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        OHRequest q = curr;
        curr = curr.next;
        return q;
    }
}
