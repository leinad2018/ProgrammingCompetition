package project;

import java.util.Scanner;

public class Doors {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int cases = in.nextInt();
		in.nextLine();
		while (cases > 0) {
			int doorNum = in.nextInt();
			in.nextLine();
			String doors = in.nextLine();
			boolean done = false;
			int runs = 0;
			for (runs = 0; runs < doorNum && !done; runs++) {
				if (doors.charAt(runs) == '0')
					done = true;
			}
			if (runs == doorNum)
				System.out.println(0);
			else
				System.out.println(doorNum - runs + 1);
		}
	}
}
