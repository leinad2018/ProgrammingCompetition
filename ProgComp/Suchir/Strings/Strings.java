import java.util.Scanner;

public class Strings {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long ans = 0;
		long loops = in.nextLong();
		for (long i = 0; i < loops; i++)
			ans += in.nextLong();
		System.out.println(ans);
		in.close();
	}
}
