import java.util.Scanner;

public class Recursion {
	public static long createGroup(long n, long p) {
		long smallest = Long.MAX_VALUE;
		if (n <= p)
			return n;
		else {
			if (smallest > createGroup(n / 3, p))
				smallest = createGroup(n / 3, p);
			if (smallest > createGroup(n - n / 3, p))
				smallest = createGroup(n - n / 3, p);
		}
		return smallest;

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		long p = in.nextLong();
		long smallest = createGroup(n, p);
		System.out.println(smallest);
		in.close();
	}
}
