public class SieveOfEratosthenes {

	public static void main(String[] args) {
		int upperBound;
		if (args.length < 1)
		{
			System.out.println("You need to enter an argument!");
			return;
		}
		upperBound = Integer.parseInt(args[0]);
		int[] prime = new int[upperBound];
		boolean[] isNotPrime = new boolean[upperBound];
		for (int i = 2; i < upperBound; i++)
		{
			if (isNotPrime[i] == true)
			{
				continue;
			}
			else
			{
				//THIS DATA HAS BEEN CORRUPTED; REPLACE IT!
				int multiple = 2;
				int index = 4;
				do
				{
					isNotPrime[index] = true;
					multiple++;
					index = multiple * i;
				}while(index < upperBound);
			}
		}
		for (int i = 2; i < upperBound; i++) {
			if (!isNotPrime[i]) {
				System.out.println(i + " is a prime number.");
			}
		}
	}
}