import java.util.Scanner;

public class Doors 
{
	private String doorStatus;
	private String doors;
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int cases = in.nextInt();
		
		for(int i = cases; i > 0; i--)
		{
			String closetDoors = in.next();
			String openSequence = in.next();
			
			Doors myCloset = new Doors(closetDoors, openSequence);
			
			System.out.println(myCloset.giveAnswer());
		}
	}
	
	public Doors(String ds, String os)
	{
		doors = ds;
		doorStatus = os;
	}
	
	public int giveAnswer()
	{
		String status = doorStatus.toString();
		int openDoor = status.indexOf("0");
		if(openDoor == -1)
		{
			return 0;
		}

		else
		{
			int doors1 = Integer.parseInt(doors);
			
			int answer = doors1 - openDoor;
			return answer;
		}
	} 
}
