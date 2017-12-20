/** A data structure to represent a Linked List of Integers.
 * Each IntList represents one node in the overall Linked List.
 *
 * @author Maurice Lee and Wan Fung Chui
 */

public class IntList {

    /** The integer stored by this node. */
    private int item;
    /** The next node in this IntList. */
    private IntList next;
    private int move;


    /** Constructs an IntList storing ITEM and next node NEXT. */
    public IntList(int item, IntList next) {
        this.item = item;
        this.next = next;
    }

    /** Constructs an IntList storing ITEM and no next node. */
    public IntList(int item) {
        this(item, null);
    }

    /** Returns an IntList consisting of the elements in ITEMS.
     * IntList L = IntList.list(1, 2, 3);
     * System.out.println(L.toString()) // Prints (1 2 3) */
    public static IntList list(int... items) {
        /** Check for cases when we have no element given. */
        if (items.length == 0) {
            return null;
        }
        /** Create the first element. */
        IntList head = new IntList(items[0]);
        IntList last = head;
        /** Create rest of the list. */
        for (int i = 1; i < items.length; i++) {
            last.next = new IntList(items[i]);
            last = last.next;
        }
        return head;
    }

    /** Returns the integer stored by this IntList. */
    public int item() {
        return item;
    }

    /** Returns the next node stored by this IntList. */
    public IntList next() {
        return next;
    }

    /**
     * Returns [position]th item in this list. Throws IllegalArgumentException
     * if index out of bounds.
     *
     * @param position, the position of element.
     * @return The element at [position]
     */
    public int get(int position) {
        // YOUR CODE HERE
        if(position < 0)
            throw new IllegalArgumentException("Position is out of range.");
        IntList iteration = this;
        for ( int i = 0; i < position; i++)
        {
            iteration = iteration.next;
            if(iteration == null)
                throw new IllegalArgumentException("Position is out of range.");
        }
        return iteration.item;
    }

    /**
     * Returns the size of the list.
     *
     * @return The size of the list.
     */
    public int size() {
        // YOUR CODE HERE
        int length = 0;
        IntList curr = this;
        while (curr != null)
        {
            length++;
            curr = curr.next;
        }
        return length;
    }

    /**
     * Returns the string representation of the list. For the list (1, 2, 3),
     * returns "( 1 2 3 )".
     *
     * @return The String representation of the list.
     */
    public String toString() {
        String s1 = "( ";
        IntList toBePrinted = this;
        while( toBePrinted != null)
        {
            s1 += toBePrinted.item + " ";
            toBePrinted = toBePrinted.next;
        }
        s1 += ")";
        // YOUR CODE HERE
        return s1;
    }

    /**
     * Returns whether this and the given list or object are equal.
     *
     * @param obj, another list (object)
     * @return Whether the two lists are equal.
     */
    public boolean equals(Object obj)
    {
        // YOUR CODE HERE
        IntList list = this;
        if(obj.getClass() == IntList.class)
        {
            //istanceof
            IntList object = (IntList)obj;
            if (object.size() == list.size())
            {
                while (object != null)
                {
                    if (object.item != list.item)
                        return false;
                    else
                    {
                        object = object.next;
                        list = list.next;
                    }
                }
                return true;
            }
            else
                return false;
        }
        else
            return false;
    }

    /**
     * Adds the given item at the end of the list.
     *
     * @param item, the int to be added.
     */
    public void add(int item) {
        // YOUR CODE HERE
        IntList thisList = this;
        if(thisList == null)
        {
            thisList = new IntList(item);
        }
        else
        {
            while(thisList.next != null)
            {
                thisList = thisList.next;
            }
            thisList.next = new IntList(item);
        }


    }

    /**
     * Returns the smallest element in the list.
     *
     * @return smallest element in the list
     */
    public int smallest() {
        // YOUR CODE HERE

        IntList loop = this;
        int min = loop.item;

        while((loop != null) && (loop.next != null))
        {
            min = Math.min(loop.item, loop.next.item);
            loop = loop.next;
        }
        return min;
    }

    /**
     * Returns the sum of squares of all elements in the list.
     *
     * @return The sum of squares of all elements.
     */
    public int squaredSum() {
        // YOUR CODE HERE
        IntList sum = this;
        int total = 0;
        while(sum != null)
        {
            total += (sum.item)*(sum.item);
            sum = sum.next;
        }
        return total;
    }

    /**
     * Returns a new IntList consisting of L1 followed by L2,
     * non-destructively.
     *
     * @param l1 list to be on the front of the new list.
     * @param l2 list to be on the back of the new list.
     * @return new list with L1 followed by L2.
     */
    public static IntList append(IntList l1, IntList l2) {
        // YOUR CODE HERE
        // recursive?
        IntList l3;
        if(l1 != null) {
            l3 = new IntList(l1.item);
            l1 = l1.next;
        }
        else
        {
            if(l2 != null)
            {
                l3 = new IntList(l2.item);
                l2 = l2.next;
            }
            else
            {
                l3 = null;
            }
        }
        while(l1 != null)
        {
            l3.add(l1.item);
            l1 = l1.next;
        }
        while(l2 != null)
        {
            l3.add(l2.item);
            l2 = l2.next;
        }
        return l3;
    }
}