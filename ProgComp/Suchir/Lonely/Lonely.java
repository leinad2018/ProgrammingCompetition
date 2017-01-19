import java.util.ArrayList;
import java.util.Scanner;

public class Lonely {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String ans = "";
		ArrayList<Integer> people = new ArrayList<Integer>();
		ArrayList<Integer> noDavid = new ArrayList<Integer>();
		int numbers = in.nextInt();
		for (int i = 0; i < numbers; i++)
			people.add(in.nextInt());
		for (int i = 0; i < numbers; i++) {
			int temp = people.remove(0);
			if (people.contains(temp) || noDavid.contains(temp))
				noDavid.add(temp);
			else
				break;
		}
		for (Integer e : people)
			noDavid.add(e);
		for (Integer e : noDavid)
			ans = ans + e + " ";
		System.out.print(ans);
		in.close();
	}
}
