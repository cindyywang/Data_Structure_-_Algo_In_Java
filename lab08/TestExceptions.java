/**
 * Desired output
 * 1) got null pointer
 * 2) got illegal array store
 * 3) got illegal class cast
 */
public class TestExceptions {

	public static void main (String [ ] args) {
		//________________ ;
		int[] a = new int[3];

		try {
			//________________ ;
			int b = a[5];

		} catch (NullPointerException e) {
			System.out.println ("got null pointer");
		}
		try {
			//________________ ;
			char c = 'c';
			a[1] = c;

		} catch (ArrayStoreException e) {
			System.out.println ("got illegal array store");
		}
		try {
			//________________ ;
			Object x = new Integer(0);
			System.out.println((String)x);

		} catch (ClassCastException e) {
			System.out.println ("got illegal class cast");
		}
	}

}
