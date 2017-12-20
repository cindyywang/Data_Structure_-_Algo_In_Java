import java.util.*;

public class AddingMachine {

	public static void main (String[] args) {

		Scanner scanner = new Scanner(System.in);
		boolean isPreviousZero = false;
		int total = 0;
		int subtotal = 0;
		int input;
		int last = 1;
		int MAXIMUM_NUMBER_OF_INPUTS = 100;
		int lens = 0;
    // TODO Add code here and elsewhere to complete AddingMachine
		int[] list = new int[100];
		while (true)
		{
			input = scanner.nextInt();
			if (input == 0)
			{
				if (isPreviousZero)
				{
					System.out.println("total " + total);
					for(int i = 0; i < lens; i++)
					{
						System.out.println(list[i]);
					}
					return;
				}
				else
				{
					System.out.println("subtotal " + subtotal);
					total += subtotal;
					subtotal = 0;
					isPreviousZero = true;
				}
			}
			subtotal += input;
			if (input != 0)
			{
				isPreviousZero = false;
				list[lens] = input;
				lens++;
			}
		   
		}
	}

}
