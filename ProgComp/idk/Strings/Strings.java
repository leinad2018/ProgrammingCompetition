import java.util.Scanner;

public class Strings 
{
	public static void main(String[] args)
	{
		long sum = 0;
		
		Scanner in = new Scanner(System.in);
		
		long num = in.nextLong();
		
		for(long i = 0; i < num; i++)
		{
			long num1 = in.nextLong();
			sum += num1;
		}
		
		System.out.println(sum);
	}
}
