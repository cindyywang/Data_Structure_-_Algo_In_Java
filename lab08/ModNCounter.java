public class ModNCounter {

	private int myCount;
	private int max;

	public ModNCounter(int n)
	{
		myCount = 0;
		max = n - 1;
	}

	public void increment()
	{
		if(myCount < max)
		{
			myCount++;
		}
		else
		{
			reset();
		}
	}

	public void reset() {
		myCount = 0;
	}

	public int value() {
		return myCount;
	}

}
