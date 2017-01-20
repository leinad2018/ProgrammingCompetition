import java.util.Scanner;
import java.util.ArrayList;
public class Doors {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		//input
		int testcases = input.nextInt();
		ArrayList <Long> doors = new ArrayList<Long>();
		ArrayList <String> strings = new ArrayList<String>();
		ArrayList <Integer> answers = new ArrayList<Integer>();
		for (int i = 0; i < testcases; i++) {
			// add number of doors
			doors.add(input.nextLong());
			String test = input.nextLine();
			strings.add(test);
		}
		for (String i : strings) {
			for (int j = 0; j < i.length(); j++) {
				int sum = 0;
				if (i.charAt(j) == '0') {
					sum += 1;
					for (int k = j; k < i.length(); k++) {
						int ones = 0;
						if (i.charAt(k) == 1) {
							ones ++;
						}
						sum += ones;
					}
				}
				answers.add(sum);
			}
		}
		//output
		for (int i = 0; i < testcases; i++) {
			System.out.println(answers.get(i));
		}
	}
}
