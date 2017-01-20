
import java.util.Scanner;


public class Strings 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		long n = in.nextInt();
		long total = 0;
		
		for(int x = 0; x < n; x++)
		{
			String i = in.next();
			
			total +=  Long.parseLong(i);;
		}
		System.out.println(total);
	}
}
