import java.util.ArrayList;
import java.util.Scanner;

public class Lonely {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		ArrayList<Long> numbers = new ArrayList<Long>();
		
		Long howMany = in.nextLong();
		long lonely = 0;
		
		for(int n = 0; n < howMany; n++)
		{
			numbers.add(in.nextLong());
		}
		boolean duplicate = false;
		for(Long l : numbers)
		{
			duplicate = false;
			for(int i = 0; i < howMany; i++)
			{
				if(l.equals(numbers.get(i)) && i != numbers.indexOf(l))
				{
					duplicate = true;
				}
			}
			if(!duplicate)
			{
				lonely = l;
			}
		}
		numbers.remove(lonely);
		for(Long bleh : numbers)
		{
			System.out.print(bleh + " ");
		}
	}
}
