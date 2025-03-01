import java.util.Arrays;
public class FixedSizeList implements SimpleList {

    /**
     * List of elements.
     */
    protected int[] values;
    /**
     * Number of array cells used by the list.
     */
    int count = 0;

    /**
     * Initializes a FixedSizeList with specified capacity. The capacity is the
     * the actual size of the array (i.e. the max number of items it can hold).
     */
    public FixedSizeList(int capacity) {
        // YOUR CODE HERE
        values = new int[capacity];
    }

    /**
     * Returns the number of items in the list.
     */
    public int size() {
        // YOUR CODE HERE
        return count;
        // fine

    }

    /**
     * Returns true if the list is empty, else false.
     */
    public boolean isEmpty() {
        // YOUR CODE HERE
        if (size() == 0) {
            return true;
        } else {
            return false;
        }
        //fine

    }

    /**
     * Adds the int k to the list by placing it in the first unused spot in
     * values.
     */
    public void add(int k) {
        // YOUR CODE HERE
        if ((count + 1) <= values.length) {
            values[count] = k;
            count++;
        }
        else
        {
            throw new ListException("OUt of bound");
        }
    }

    /**
     * Removes k from the list if it is present. If k appears multiple times,
     * it only removes the first occurence of k.
     */
    public void remove(int k) {
        // YOUR CODE HERE
        int i = 0;
        while ((get(i) != k) && (i < count)) 
        {
            i++;
        }
        if ((get(i) == k) && (i < count)) {
            removeIndex(i);
        }
    }

    /**
     * Returns if the collection contains k.
     */

    public boolean contains(int k) {
        // YOUR CODE HERE
        for (int i = 0; i < count; i++) {
            if (values[i] == k) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the integer stored at the i-th index in the list.
     */
    public int get(int i) {
        // YOUR CODE HERE
        if (i >= count || i < 0) {
            throw new ListException("Index: " + i + " does not exist.");
        } else {
            return values[i];
        }

    }

    /**
     * Inserts k into the list at position i by shifting each element at index
     * i and onwards one entry to the right.
     * "Precondition: i is between 0 and count, inclusive."!!!
     */
    public void add(int i, int k) {
        // It can be at any i in the capacity though if might not be contributed to the list if i >= count+1
        if (count + 1 <= values.length)
        {
            if (i >= 0 && i < count + 1)
            {
                for (int j = count; j > i; j--)
                {
                    values[j] = values[j - 1];
                }
                values[i] = k;
                count++;
            } else {
                throw new ListException("Index: " + i + " does not exist.");
            }
        }
        else
            {
                throw new ListException("OUt of capacity");
            }
    }

    /**
     * Removes the entry at position i by shifting each element after position
     * i one entry to the left.
     */

    public void removeIndex(int i) {
        // YOUR CODE HERE
        // from 2 to 1
        try {
            for (int k = i; k < count-1; k++) {
                values[k] = values[k + 1];
            }
            values[count-1] = 0;
            count--;

        } catch (ListException e) {
            System.err.println("Index: " + i + " does not exist");
        }
    }
    public static void main(String[] args)
    {
        FixedSizeList a = new FixedSizeList(7);
        a.add(0,1);
        a.add(2);
        a.add(3);
        for (int i = 4; i < 7; i++)
        {
            a.add(i);
        }
        a.add(6, 10);
        System.out.println(Arrays.toString(a.values));
    }
}