import java.util.Scanner;

public class Toaster {
	static int[] weights;
	static int[] values;
	static int p;
	static int n;
	static int[][] dp;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		p = in.nextInt();
		weights = new int[n];
		values = new int[n];
		for(int i = 0; i < n; i++){
			weights[i]=in.nextInt();
			values[i]=in.nextInt();
		}
		dp = new int[n][p + 1];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				dp[i][j] = -1;
			}
		}
		System.out.println(go(0, 0));
	}

	public static int go(int toaster, int weight) {
		if (toaster == n)
			return 0;
		if (dp[toaster][weight] != -1)
			return dp[toaster][weight];
		int ans = go(toaster + 1, weight);
		if (weight + weights[toaster] <= p) {
			ans = Math.max(ans, go(toaster + 1, weight + weights[toaster]) + values[toaster]);
		}
		return dp[toaster][weight]=ans;
	}

}
