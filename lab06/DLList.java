public class DLList {
    DLNode sentinel;
    int size;

    public class DLNode {
        Object item;
        DLNode prev, next;

        public DLNode(Object item, DLNode prev, DLNode next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
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
    public void insertBack(Object o) {
        DLNode n = new DLNode(o, sentinel.prev, sentinel);
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
    public Object get(int position) {
        DLNode curr = sentinel.next;
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
        DLNode curr = sentinel.next;
        while (curr != sentinel) {
            s.append(curr.item.toString());
            if (curr.next != sentinel) s.append(", ");
            curr = curr.next;
        }
        s.append(')');
        return s.toString();
    }

    /* Fill these in! */

    /**
     * Insert a new node into the DLList.
     * @param o Object to insert
     * @param position position to insert into. If position exceeds the size of the list, insert into
     *            the end of the list.
     */
    // position from 0
    public void insert(Object o, int position)
    {
        // fill me in
        // You should never need to type the word null or do any edge case checking.
        DLNode curr = sentinel.next;
        while((position > 0) && (curr != sentinel))
        {
            curr = curr.next;
            position--;
        }
        curr = new DLNode(o, curr.prev, curr);
        curr.prev.next = curr;
        curr.next.prev = curr;
        size++;


    }

    /**
     * Insert into the front of this list. You should can do this with a single call to insert().
     * @param o Object to insert
     */
    public void insertFront(Object o) {
        // fill me in
        insert(o,0);

    }

    /**
     * Remove all copies of Object o in this list
     * @param o Object to remove
     */
    //You should never need to type the word null or do any edge case checking.
    // Your only if statement should be in remove(Object o).
    public void remove(Object o)
    {
        // fill me in
        DLNode curr = sentinel.next;
        while(curr != sentinel)
        {
            if(curr.item == o)
            {
                curr.next.prev = curr.prev;
                curr.prev.next = curr.next;
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
    //You should never need to type the word null or do any edge case checking.
    public void remove(DLNode n)
    {
        // fill me in
        DLNode curr = sentinel.next;
        while(curr != n)
        {
            curr = curr.next;
        }
        curr.next.prev = curr.prev;
        curr.prev.next = curr.next;
        size--;

    }


    /**
     * Duplicate each node in this linked list destructively.
     */
    // Don't call any methods other than the DLNode constructor,
    // and don't call it more than once per node in the original list.
    public void doubleInPlace() {
        // fill me in
        DLNode curr = sentinel.next;
        while(curr != sentinel)
        {
            curr.next = new DLNode(curr.item, curr, curr.next);
            curr.next.next.prev = curr.next;
            curr = curr.next.next;
            size++;
        }
    }

    /**
     * Reverse the order of this list destructively.
     */
    // do not need any null checks or special cases.
    // only iterating through the list once and flipping all the pointers around as you go.
    public void reverse() {
        // fill me in
        DLNode curr = sentinel;
        DLNode end = sentinel.prev;
        // 2 makes things cleaner, however, still a lot to be cautious as pointers point to end/curr and updates

        while(end != sentinel)
        {
            curr.next = end;// no need for prev.next.next
            DLNode temp = end.prev;// temp!!!
            curr.next.prev = end.next;
            curr.next.next = temp;
            end = temp; // caution: end already changed
            curr = curr.next;
        }

    }

    public static void main(String[] args) {
        // you can add some quick tests here if you would like
        DLList l1 = new DLList();
        l1.insertFront(1);
        l1.insert(2,1);
        l1.insertBack(3);
        l1.reverse();
        System.out.println(l1.size);
        System.out.println(l1);
        System.out.println(l1.get(0));
        System.out.println(l1.get(1));
        System.out.println(l1.get(2));

    }
}
