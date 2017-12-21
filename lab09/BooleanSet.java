/** Represent a set of nonnegative ints from 0 to maxElement - 1 for some
 *	initially specified maxElement.
 */
public class BooleanSet implements SimpleSet {

	/** contains[k] is true if k is in the set, false if it isn't. */
	private boolean[] contains;

	/** Initializes a set of ints from 0 to maxElement - 1. */
	public BooleanSet (int maxElement) {
		// YOUR CODE HERE
		contains = new boolean[maxElement];
	}

	/** Adds k to the set.
	 *	precondition: 0 <= k < maxElement.
	 *	postcondition: k is in this set.
	 */
	public void add(int k) {
		// YOUR CODE HERE

		if(k >= 0 && k < contains.length)
		{
			if(!contains[k])
			{
				contains[k] = true;
			}
		}
		else
		{
			throw new IllegalArgumentException();
		}
	}

	/** Removes k from the set.
	 *	precondition: 0 <= k < maxElement.
	 *	postcondition: k is not in this set.
	 */
	public void remove(int k) {
		// YOUR CODE HERE
		if(k>= 0 && k < contains.length)
		{
			if(contains[k])
			{
				contains[k] = false;
			}
		}
		else
		{
			throw new IllegalArgumentException();
		}
	}

	/** Return true if k is in this set, false otherwise.
	 *	precondition: 0 <= k < maxElement
	 */
	public boolean contains (int k) {
		if(k >= 0 && k < contains.length)
		{
			if(contains[k])
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			throw new IllegalArgumentException();
		}
		// YOUR CODE HERE
	}

	/** Return true if this set is empty, false otherwise. */
	public boolean isEmpty()
	{
		// YOUR CODE HERE
		for(int i = 0; i < contains.length; i++)
		{
			if(contains(i))
			{
				return false;
			}
		}
		return true;

	}

	/** Returns the number of items in the set. */
	public int size() {
		// YOUR CODE HERE
		int cardinality = 0;
		for(int i = 0; i < contains.length; i++)
		{
			if (contains(i)) {
				cardinality++;
			}
		}
		return cardinality;

	}
}
