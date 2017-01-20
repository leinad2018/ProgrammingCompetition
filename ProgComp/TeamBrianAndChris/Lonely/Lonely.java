import java.util.Scanner;
import java.util.ArrayList;
public class Lonely {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner (System.in);
		int n=input.nextInt();
		ArrayList<Integer> arr= new ArrayList<Integer>();
		for(int i=0; i<n; i++)
		{arr.add(input.nextInt());
		}
		int search=0;

	for(int i=0; i<arr.size(); i++)
	{search=arr.get(i);
	int counter=0;
	{for(Integer temp: arr)
		{if(temp==search)
			{counter++;}
		}
	
		}
	if(counter!=2)
		{arr.remove(i);
	break;}
		}
	for(Integer temp: arr)
	System.out.print(temp+" ");
	
	}
	
	
}
