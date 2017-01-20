import java.util.Scanner;

public class Recursion {
	public static void main (String[] args){
		Scanner input = new Scanner(System.in);
		
		String whole = input.nextLine();
		String[] parts = whole.split(" ");
		String part1 = parts[0];
		String part2 = parts[1];
		
		int x = Integer.parseInt(part1);
		int y = Integer.parseInt(part2);
		
		System.out.println(x%y);
	}
}
