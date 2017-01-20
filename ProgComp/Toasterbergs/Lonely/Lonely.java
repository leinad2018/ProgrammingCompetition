import java.util.ArrayList;
import java.util.Scanner;
public class Lonely {


	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int n = 0;
		int bich = 0;
		String chot = "";
		String bith = "";
		
		n = input.nextInt();
		if ( n >= 3 && n < 1000)
		{
			n = n;
		}
		else 
		{
			n = 0;
		}
		input.nextLine();
		chot = input.nextLine();
		for(int a = 0; a < n*2-1; a ++)
		{
			if (!(chot.charAt(a) == (' ')))
			{
					for ( int j = 0; j < (n*2)-1; j ++)
					{
						if ( j != a)
						{
							if(chot.charAt(a) == chot.charAt(j))
							{
								bith += chot.charAt(a) + " ";
							}
						}
					}		
			}
		}
		System.out.print(bith);
	}
	

}
