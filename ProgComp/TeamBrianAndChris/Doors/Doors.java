import java.util.ArrayList;

public class Doors {

	public static void main(String[] args) {

		int t = 2;
		int[] n = new int[t];
		ArrayList<String> ns = new ArrayList<String>();
		n[0] = 5;
		ns.add("11111");
		n[1] = 3;
		ns.add("101");
		
		for (int i = 0 ; i < n.length ; i++)
		{
			String nums = ns.get(i);
			int doors = 0;
			
			for(int x = 0 ; x < nums.length() ; x++)
			{
				if (nums.charAt(x) == '0')
				{
					doors = nums.length() - x;
					break;
				}
			}
			
			System.out.println(doors);
		}
	}
} 
