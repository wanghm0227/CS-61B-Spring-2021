package OHQueueDemo;

public class TYIterator extends OHIterator {

    public TYIterator(OHRequest queue) {
        super(queue);
    }

    @Override
    public OHRequest next() {
        OHRequest r = super.next();
        if (curr != null && curr.description.contains("thank u")) {
            curr = curr.next;
        }
        return r;
    }
}