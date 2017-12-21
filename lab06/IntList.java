/** A data structure to represent a Linked List of Integers.
 * Each IntList represents one node in the overall Linked List.
 * Encapsulated version.
 */
public class IntList {

    /**
     * The head of the list is the first node in the list. 
     * If the list is empty, head is null 
     */
    private IntListNode head;
    private int size;

    /**
     * IntListNode is a nested class. It can be instantiated
     * when associated with an instance of IntList.
     */
    public class IntListNode {
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            IntListNode that = (IntListNode) o;

            if (item != that.item) return false;
            return next != null ? next.equals(that.next) : that.next == null;
        }


        @Override
        public String toString() {
            return "IntListNode{" +
                    "item=" + item +
                    ", next=" + next +
                    '}';
        }

        int item;
        IntListNode next;

        public IntListNode(int item, IntListNode next) {
            this.item = item;
            this.next = next;
        }
    }

    public int getSize() {
        return size;
    }

    public IntList() {}

    public IntList(int[] initial) {
        for (int i = initial.length - 1; i >= 0; i--) {
            head = new IntListNode(initial[i], head);
        }
        size = initial.length;
    }

    /**
     * Get the value at position pos. If the position does not exist, throw an
     * IndexOutOfBoundsException.
     * @param position to get from
     * @return the int at the position in the list.
     */
    public int get(int position) {
        if (position >= size) throw new IndexOutOfBoundsException("Position larger than size of list.");
        IntListNode curr = head;
        while (position > 0) {
            curr = curr.next;
            position--;
        }
        return curr.item;
    }

    /* Fill in below! */

    /**
     * Insert a new node into the IntList.
     * @param x value to insert
     * @param position position to insert into. If position exceeds the size of the list, insert into
     *            the end of the list.
     */
    public void insert(int x, int position) {

        // Fill me in!
        IntList list = this;
        IntListNode curr = list.head;
        if(curr == null)
        {
            list.head = new IntListNode(x, null);
        }
        else if (position >= size)
        {
            while((curr.next!=null)&&(curr!=null))
            {
                curr = curr.next;
            }
            curr.next = new IntListNode(x,null);
        }
        else if(position == 0)
        {
                list.head = new IntListNode(x, curr);
        }
        else
        {

            while(position != 1)
            {
                curr = curr.next;
                position--;
            }
            curr.next = new IntListNode(x, curr.next);
        }
        size++;

    }

    /**
     * Merge two sorted IntLists a and b into one sorted IntList containing all of their elements.
     * @return a new IntList without modifying either parameter
     */
    public static IntList merge(IntList a, IntList b) {
        // Fill me in!
        //static?
        //instance var : non-static var
        //main in the class
        //no this in static
        //main is the starting point of the program
        //nothing there so static


        IntList c = new IntList();
        IntListNode cNode =  c.new IntListNode(7, null);;
        IntListNode aNode = a.head;
        IntListNode bNode = b.head;
        //either one of them is null give me null ptr bNode.item||a...
        //unecessary because both the cNode and c.head at first points ti the same null and null changed to an small item from a/b
        while((aNode != null) && (bNode != null))
        {
            //aNode.next caused problem
            if(aNode.item > bNode.item)
            {
                //Instantiate un-static inner class inside static method
                System.out.println("func1" + bNode.item);
                cNode.next = c.new IntListNode(bNode.item,null);
                bNode = bNode.next;
            }
            else
            {
                System.out.println("func1" + aNode.item);
                cNode.next = c.new IntListNode(aNode.item,null);
                aNode = aNode.next;
            }


            cNode = cNode.next;
            if(c.head == null)
            {
                c.head = cNode;
            }

            c.size++;
        }
        while((aNode != null) && (bNode == null))
        {
            cNode.next = c.new IntListNode(aNode.item,null);
            aNode = aNode.next;
            cNode = cNode.next;
            if(c.head == null)
            {
                c.head = cNode;
            }
            c.size++;
        }
        while((bNode != null) && (aNode == null))
        {
            cNode.next = c.new IntListNode(bNode.item, null);
            cNode = cNode.next;
            if(c.head == null)
            {
                c.head = cNode;
            }

            bNode = bNode.next;
            System.out.println("func2");
            c.size++;
        }
        return c;
    }

    /**
     * Reverse the current list recursively, using a helper method.
     */
    public void reverse() {
        // Fill me in!
        IntList tobeReversed = this;
        this.head = this.reverseHelper(this.head,null);

    }

    private static IntListNode reverseHelper(IntListNode l, IntListNode soFar) {
        if (l == null)
        {
            return soFar;
        }
        else
        {
            IntListNode temp = l.next;
            l.next = soFar;
            return reverseHelper(temp , l);
        }
    }


    /* Optional! */

    /**
     * Remove the node at position from this list.
     * @param position int representing the index of the node to remove. If greater than the size
     *                 of this list, throw an IndexOutOfBoundsException.
     */
    public void remove(int position) {
        if (position >= size) throw new IndexOutOfBoundsException();
        // fill me in
        if (position < 0) throw new IndexOutOfBoundsException();
        IntList list = this;
        IntListNode curr = list.head;
        if(curr != null)
        {
            removeHelper(position, curr, null);
        }

    }

    private void removeHelper(int position, IntListNode curr, IntListNode pre)
    {
        
        if(position == 0)
        {
            // remove
            if(pre == null)
            {
                head = curr.next;
            }
            else if(curr.next != null)
            {
                IntListNode temp = curr.next;
                pre.next = temp;
            }
                
            curr = null;
            size--;

        }
        else {
            removeHelper(position - 1, curr.next, curr);
        }
    }

    public static void main(String[] args) {
        IntList l = new IntList();
        for(int i = 0; i < 10; i++) {
            l.insert(i, i);
        }
        System.out.println(l.get(5));
        System.out.println(l.get(6));
        System.out.println(l.getSize());
        l.remove(1);
        System.out.println(l.get(5));
        System.out.println(l.get(6));
        System.out.println(l.getSize());

    }
}
