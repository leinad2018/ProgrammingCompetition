import java.util.Arrays;
import java.util.Scanner;

public class Recursion {
	static int[] memo;
	static int p;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		p = in.nextInt();
		memo = new int[n + 1];
		Arrays.fill(memo, -1);
		System.out.println(go(n));
	}

	public static int go(int n) {
		if(memo[n]!=-1)return memo[n];
		if(n<=p)return n;
		int ans = Math.min(go(n/3), go(n-n/3));
		return memo[n]=ans;
	}

}
