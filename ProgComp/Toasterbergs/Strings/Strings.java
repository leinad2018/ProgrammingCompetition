import java.util.Scanner;
import java.util.ArrayList;
public class Strings {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		ArrayList <Long> knots = new ArrayList<Long>();
		
		long n = 0;
		long l = 0;
		long sum= 0;
		
		n = input.nextInt();
	
		
		for (int i =0; i < n; i ++)
			{
				
				knots.add(input.nextLong());
			}
		for (int i =0; i < n; i ++)
		{
			sum += knots.get(i);
		}
		System.out.println(sum);

	}

}
