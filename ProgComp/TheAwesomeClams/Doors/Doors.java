import java.util.Scanner;
public class Doors {

	public static void main(String[] args) {
		
	Scanner input = new Scanner(System.in);	
	int testCases= input.nextInt();
	
	for (int count = 0; count < testCases; count++)
	{
		int doors = input.nextInt();
		input.nextLine();
		String open = input.nextLine();
		
		if(open.contains("0")==false)
		{
			System.out.println(0);
		}
		else
		{
			
				int last = open.indexOf("0");
				String left = open.substring(last);
				System.out.println(left.length());
			
		
		}
		
	}
		
		

	}

}
