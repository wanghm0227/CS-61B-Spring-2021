public class IntList {

  public int first;
  public IntList rest;

  public IntList(int f, IntList r) {
    this.first = f;
    this.rest = r;
  }

  public static void evenOdd(IntList lst) {
    if (lst == null) {
      return;
    }
    IntList second = lst.rest;
    IntList odds = lst.rest;
    while (lst.rest != null && odds.rest != null) {
      lst.rest = lst.rest.rest;
      odds.rest = odds.rest.rest;
      lst = lst.rest;
      odds = odds.rest;
    }
    lst.rest = second;
  }

  public static IntList[] partition(IntList lst, int k) {
    IntList[] array = new IntList[k];
    int index = 0;
    IntList L = reverse(lst);

    while (L != null) {
      IntList tempNext = L.rest;
      array[index] = new IntList(L.first, array[index]);
      index = (index + 1) % k;
      L = tempNext;
    }
    return array;
  }

  public static IntList reverse(IntList lst) {
    if (lst == null) {
      return lst;
    }

    IntList result = new IntList(lst.first, null);
    IntList p = lst.rest;
    while (p != null) {
      result = new IntList(p.first, result);
      p = p.rest;
    }
    return result;
  }

  public static void main(String[] args) {
    IntList lst = new IntList(1, null);
    lst = new IntList(2, lst);
    lst = new IntList(3, lst);
    lst = new IntList(4, lst);
    lst = new IntList(5, lst);
    partition(lst, 2);
  }
}