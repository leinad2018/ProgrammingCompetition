import java.util.Scanner;
import java.util.ArrayList;
public class Lonely {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner input = new Scanner(System.in);
ArrayList<Long>party=new ArrayList<Long>();		
ArrayList<Long>ugh = new ArrayList<Long>();
long amt = input.nextLong();		
		
for (long count = 0; count < amt; count++)
{
	party.add(input.nextLong());
}
		

long num =0;
long found = 0;

		
for (long h = 0; h<amt; h++)
{
		for (long  i =0; i<amt;i++)
	{
			if(i!=h){
		if (party.get((int)h)==party.get((int)i))
		{
			ugh.add(party.get((int)h));
		}
			}
	}
	
	}

for (long k : ugh)
{
	System.out.print(k+ " ");
}
		
		


}
}
