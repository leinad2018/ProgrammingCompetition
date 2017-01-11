import java.util.Scanner;

public class Strings {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		long sum = 0;
		for(int i = 0; i < n; i++){
			int temp = input.nextInt();
			sum += temp;
		}
		System.out.println(sum);
	}

}
