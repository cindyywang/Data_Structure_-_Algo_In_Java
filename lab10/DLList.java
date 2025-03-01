import java.util.Iterator;
public class DLList<T> implements Iterable<T>{
    DLNode<T> sentinel;
    int size;

    private class DLListIterator implements Iterator<T>
    {
        DLNode<T> curr;

        // Constructor is needed for member var, or cause null ptr exception

        public DLListIterator()
        {
            curr = sentinel;
        }

        public boolean hasNext()
        {
            if (curr.next != sentinel)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        public T next()
        {
            if(curr.next != sentinel)
            {
                curr = curr.next;
                return curr.item;
            }
            else
            {
                return null;
            }
        }

    }

    public Iterator<T> iterator()
    {

        return new DLListIterator();
    }

    public class DLNode<T> {
        private T item;
        DLNode<T> prev, next;

        public DLNode(T item, DLNode prev, DLNode next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            DLNode<T> dlNode = (DLNode<T>) o;

            if (!item.equals(dlNode.item)) return false;
            if (!prev.equals(dlNode.prev)) return false;
            return next.equals(dlNode.next);
        }

        @Override
        public String toString() {
            return "DLNode{" +
                    "item=" + item +
                    '}';
        }
    }

    /**
     * Construct a new DLList with a sentinel that points to itself.
     */
    public DLList() {
        sentinel = new DLNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    /**
     * Insert into the end of this list
     * @param o Object to insert
     */
    public void insertBack(T o) {
        DLNode<T> n = new DLNode<>(o, sentinel.prev, sentinel);
        n.next.prev = n;
        n.prev.next = n;
        size++;
    }


    /**
     * Get the value at position pos. If the position does not exist, return null (the item of
     * the sentinel).
     * @param position to get from
     * @return the Object at the position in the list.
     */
    public T get(int position) {
        DLNode<T> curr = sentinel.next;
        while (position > 0 && curr != sentinel) {
            curr = curr.next;
            position--;
        }

        return curr.item;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("DLList(");
        DLNode<T> curr = sentinel.next;
        while (curr != sentinel) {
            s.append(curr.item.toString());
            if (curr.next != sentinel) s.append(", ");
            curr = curr.next;
        }
        s.append(')');
        return s.toString();
    }

    /**
     * Insert a new node into the DLList.
     * @param o Object to insert
     * @param position position to insert into. If position exceeds the size of the list, insert into
     *            the end of the list.
     */
    public void insert(T o, int position) {
        DLNode<T> curr = sentinel;
        while (position > 0 && curr.next != sentinel) {
            curr = curr.next;
            position--;
        }
        DLNode<T> n = new DLNode<>(o, curr, curr.next);
        n.next.prev = n;
        n.prev.next = n;
        size++;
    }

    /**
     * Insert into the front of this list. You should can do this with a single call to insert().
     * @param o Object to insert
     */
    public void insertFront(T o) {
        insert(o, 0);
    }

    /**
     * Remove all copies of Object o in this list
     * @param o Object to remove
     */
    public void remove(T o) {
        DLNode<T> curr = sentinel.next;
        while (curr != sentinel) {
            if (curr.item.equals(o)) {
                curr.prev.next = curr.next;
                curr.next.prev = curr.prev;
                size--;
            }
            curr = curr.next;
        }
    }

    /**
     * Remove a DLNode from this list. Does not error-check to make sure that the node actually
     * belongs to this list.
     * @param n DLNode to remove
     */
    public void remove(DLNode<T> n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
        size--;
    }

    /**
     * Duplicate each node in this linked list destructively.
     */
    public void doubleInPlace() {
        DLNode<T> curr = sentinel.next;
        while (curr != sentinel) {
            DLNode<T> dup = new DLNode<T>(curr.item, curr, curr.next);
            dup.prev.next = dup;
            dup.next.prev = dup;
            curr = dup.next;
        }
        size *= 2;
    }

    /**
     * Reverse the order of this list destructively.
     */
    public void reverse() {
        DLNode<T> curr = sentinel;
        do {
            DLNode<T> tmp = curr.prev;
            curr.prev = curr.next;
            curr.next = tmp;
            curr = curr.prev;
        } while (curr != sentinel);
    }

    public static void main(String[] args) {
        DLList<String> l = new DLList<>();
        l.insertFront("Me");
        l.insertBack("ow~!");
        System.out.println(l.get(0) + l.get(1));
    }
    // Local test
    /*public static void main(String[] args) {
        DLList<String> l = new DLList<String>();
        l.insertBack("CS");
        l.insertBack(61);
        l.insertBack("BL!");
        System.out.println("l = " + l);

        l.insertBack(2);
        l.insertFront(1);
        System.out.println("l.get(0) = " + l.get(0));
        l.insert(4, 1);
        l.remove(1);
        System.out.println("l = " + l);
        l.doubleInPlace();
        System.out.println("l = " + l);
        l.reverse();
        System.out.println("l = " + l);
    }*/
}
