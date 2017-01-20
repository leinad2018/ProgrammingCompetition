import java.util.Scanner;
public class Strings {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int numofstrings = input.nextInt();
		// each element in the array is a string length
		long[] sum = new long[numofstrings];
		for (int i = 0; i < numofstrings; i++) {
			sum[i] = input.nextInt();
		}
		long answer = 0;
		for (long i : sum) {
			answer += i;
		}
		System.out.println(answer);
	}
}
