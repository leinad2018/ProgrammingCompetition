import java.util.Scanner;


public class Doors {
	public Doors() {
		
	}
	
	public int solve(int numOfDoors, String unsolvedDoors) {
		if (unsolvedDoors.indexOf("0") == -1)
			solvedDoors = 0;
		else
			solvedDoors = numOfDoors - unsolvedDoors.indexOf("0");
		return solvedDoors;
	}
	
	private int solvedDoors;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Doors lel = new Doors();
		int testCases = in.nextInt();
		for (int i = 0; i < testCases; i++) {
			int numOfDoors = in.nextInt();
			String unsolvedDoors = in.next();
			System.out.println(lel.solve(numOfDoors, unsolvedDoors));
		}
	}
}
