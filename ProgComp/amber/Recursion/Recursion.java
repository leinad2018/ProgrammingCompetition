import java.util.Scanner;

public class Recursion 
{
	public static void main(String[] args)
	{
		in = new Scanner(System.in);
		String temp = in.nextLine();
		int n = Integer.parseInt(temp.substring(0, temp.indexOf(" ")));
		int p = Integer.parseInt(temp.substring(temp.indexOf(" ") + 1));
		min = Integer.MAX_VALUE;
		System.out.println(happy(n, p));
	}
	
	public static int happy(int a, int b)
	{
		if (a < b)
		{
			return a;
		}
		else
		{
			int x = happy((int)Math.floor(a / 3), b);
			int y = happy((int) (a - Math.floor(a / 3)), b);
			
			if (min > x)
			{
				min = x;
			}
			if (min > y)
			{
				min = y;
			}
			return min;
		}
	}
	private static int min;
	private static Scanner in;
}
