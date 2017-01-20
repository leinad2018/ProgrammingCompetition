import java.util.Scanner;

public class Recursion {
	private static long max;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long total = in.nextInt();
		max = in.nextInt();

		System.out.println(split((int)total));
	}

	public static long split(long in) {
		if (in <= max)
			return in;
		return smaller(split(in/3), split(split(in-in/3)));
		
	}
	public static long smaller(long one, long two)
	{
		if (one < two)
			return one;
		return two;
	}
}
