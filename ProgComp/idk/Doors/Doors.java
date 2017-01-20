import java.util.Scanner;

public class Doors {
	public static void main(String[] args)
	{	
		long sol = 0;
		Scanner in = new Scanner(System.in);
		long tests = in.nextLong();
		
		for(long i = 0; i < tests; i++)
		{
			long doors = in.nextLong();
			String oorc = in.next();
			if(oorc.indexOf("0") == -1)
				System.out.println("0");
			else
			{
				sol = oorc.length() - oorc.indexOf("0");
				System.out.println(sol);
			}
		}
		}
	}

