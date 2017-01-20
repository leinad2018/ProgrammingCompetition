import java.util.ArrayList;
import java.util.Scanner;

public class Lonely {
	
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int amount= in.nextInt();
		ArrayList<Integer> array = new ArrayList<Integer>();
		for(int b=0; b<amount;b++)
		{
			int input = in.nextInt();
			array.add(input);
		}
		
		for (int i=0; i<array.size(); i++)
		{
			boolean hasPair = false;
			int num1 = array.get(i);
			for(int j=i+1; j<array.size(); j++)
			{
				int num2 = array.get(j);
				if (num1==num2)
				{
					hasPair=true;
				}
			}
			if (!hasPair)
			{
				david = array.get(i);
				hasPair=false;
			}
			
		}
		
		array.remove(david);
		
		for (int a=0; a<array.size(); a++)
		{
			System.out.print(array.get(a) + " ");
		}
	}

	private static int david;
}
