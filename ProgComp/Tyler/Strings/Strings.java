import java.util.Scanner;

public class Strings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		long sum = 0;
		int n = in.nextInt();
		while(n-->0){
			sum+=in.nextLong();
		}
		System.out.println(sum);
	}

}
