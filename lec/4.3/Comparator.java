public interface Comparator<T> {
    /* Return negative number if o1 < o2.
    *  Return 0 if o1 equals o2.
    *  Return positive number if o1 > o2. **/
    int compare(T o1, T o2);
}
