public class DMSList {
  private IntNode sentinel;

  public DMSList() {
    sentinel = new IntNode(-1000, new LastIntNode());
  }

  public class IntNode {
    public int item;
    public IntNode next;

    public IntNode(int i, IntNode h) {
      item = i;
      next = h;
    }

    public int max() {
      return Math.max(item, next.max());
    }
  }

  public class LastIntNode extends IntNode {
    public LastIntNode() {
      super(0, null);
    }

    @Override
    public int max() {
      return 0;
    }
  }

  /* Returns 0 if list is empty. Otherwise, returns the max element. */
  public int max() {
    return sentinel.next.max();
  }

  public void insertFront(int x) {
    sentinel.next = new IntNode(x, sentinel.next);
  }

  public static void main(String[] args) {
    DMSList l = new DMSList();
    l.insertFront(3);
    l.insertFront(2);
    l.insertFront(1);
    l.insertFront(4);
    l.insertFront(5);
    System.out.println(l.max());
  }
}