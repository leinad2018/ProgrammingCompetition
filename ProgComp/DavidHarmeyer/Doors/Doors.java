import java.util.Scanner;

public class Doors {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int testCases=s.nextInt();
		outer: for (int testCase=0; testCase<testCases; testCase++) {
			int numberOfDoors=s.nextInt();
			s.nextLine();
			String line=s.nextLine();
			for (int i=0; i<line.length(); i++) {
				if (line.charAt(i)=='0') {
					System.out.println(numberOfDoors-i);
					continue outer;
				}
			}
			System.out.println(0);
		}
	}

}
