public class IntList {
	public int first;
	public IntList rest;

	public IntList(int f, IntList r) {
		first = f;
		rest = r;
	}

	/** Return the size of the list using... recursion! */
	public int size() {
		if (rest == null) {
			return 1;
		}
		return 1 + this.rest.size();
	}

	/** Return the size of the list using no recursion! */
	public int iterativeSize() {
		IntList p = this;
		int totalSize = 0;

		while (p != null) {
			totalSize += 1;
			p = p.rest;
		}

		return totalSize;
	}

	/** Returns the ith value in this list.*/
	public int get(int i) {
		if (i == 0) {
			return first;
		}
		return rest.get(i - 1);
	}

	public void addAdjacent() {
		IntList p = this;

		while (p.rest != null) {
			if (p.first == p.rest.first) {
				p.first *= 2;
				p.rest = p.rest.rest;
			} else {
				p = p.rest;
			}
		}
	}

	/** Square every item in IntList and insert x. */
	public void squareItemsAndInsert(int x) {
		IntList p = this;
		int length = this.size();

		while (length > 0) {
			p.rest = new IntList(p.first * p.first, p.rest);
			if (p.rest.rest != null) {
				p = p.rest.rest;
			} else {
				p = p.rest;
			}
			length -= 1;
		}

		p.rest = new IntList(x, null);
	}

	public static void main(String[] args) {
		IntList L = new IntList(3, null);
		L = new IntList(2, L);
		L = new IntList(1, L);
		L = new IntList(1, L);

		L.addAdjacent();
		L.squareItemsAndInsert(5);

		System.out.println(L.iterativeSize());
	}
}