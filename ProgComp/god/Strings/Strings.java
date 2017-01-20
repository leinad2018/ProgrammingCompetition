import java.util.Scanner;

public class Strings {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		long n = in.nextLong();
		long sum = 0;
		
		for(long i = 0; i < n; i++)
		{
			long num = in.nextLong();
			sum += num;
			
		}
		
		System.out.println(sum);
		in.close();
	}

}
