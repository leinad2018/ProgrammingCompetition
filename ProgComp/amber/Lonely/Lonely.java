import java.util.Scanner;
import java.util.ArrayList;

public class Lonely 
{
	public static void main(String[] args)
	{
		ArrayList<Long> a = new ArrayList<Long>();
		ArrayList<Long> b = new ArrayList<Long>();
		Scanner in = new Scanner(System.in);
		long total = 0;
		long n = in.nextLong();
		String none = in.nextLine();
		String input = in.nextLine();	
		input += " ";
		for (int i = 0; i < n; i++)
		{
			int index = input.indexOf(" ");
			String e = input.substring(0, index);
			input = input.substring(index + 1);
			a.add(Long.parseLong(e));
		}
		for(int h = 0; h < a.size(); h++)
		{
			for (int x = 0; x < a.size(); x++)
			{
				if (a.get(h) == a.get(x) && h != x)
				{
					b.add(a.get(h));
				}
			}
		}
		String end = "";
		for (long g : b)
		{
			end += g + " ";
		}
		System.out.print(end);
	}
}
