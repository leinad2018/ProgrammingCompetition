import java.util.Scanner;
public class Strings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		boolean test = true;
		long add = 0;
		long n = 0;
		n = input.nextInt();
		for (int i = 0; i < n; i++) {
			add += input.nextLong();
		}
		System.out.println(add);
	}

}
