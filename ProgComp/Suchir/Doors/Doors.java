import java.util.Scanner;

public class Doors {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long loops = in.nextLong();
		for (long i = 0; i < loops; i++) {
			in.nextLong();
			String num = in.next();
			for (int j = 0; j < num.length(); j++) {
				if (num.substring(j, j + 1).equals("0")) {
					System.out.println(num.length() - j);
					j = num.length();
				} else if (j == num.length() - 1)
					System.out.println(0);
			}
		}
		in.close();
	}
}
