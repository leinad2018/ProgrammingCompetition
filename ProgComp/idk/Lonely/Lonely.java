import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Lonely {

	public static void main(String[] args) {
		ArrayList<String> p = new ArrayList<String>();
		ArrayList<String> real = new ArrayList<String>();
		Scanner in = new Scanner(System.in);
		
		long n = in.nextLong();
		
		if(n >= 3)
		{
			String people = "";
			long size = n * 2;
			do
			{
				people = in.nextLine();
			}
			while(people.length() < size - 1);
			
			String[] num1 = people.split(" ");
			
			for(int i = 0; i < num1.length; i++)
			{
				p.add(num1[i]);
			}
			
			for(int j = 0; j < p.size(); j++)
			{
					for(int k = 0; k < p.size(); k++)
					{
						if(p.get(j).equals(p.get(k)))
						{
							real.add(p.get(j));
							real.add(p.get(k));
							p.remove(j);
							p.remove(k);
						}
					}	
				
			}
			
			for(int l = 0; l < real.size(); l++)
			{
				System.out.print(real.get(l) + " ");
			}
		}
	}

}
