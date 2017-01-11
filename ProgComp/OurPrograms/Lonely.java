import java.util.ArrayList;
import java.util.Scanner;

public class Lonely {
	
	public static void main(String[] a) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		ArrayList<Integer> people=new ArrayList<>();
		for (int i=0; i<n; i++) {
			people.add(s.nextInt());
		}
		for (int i=0; i<people.size(); i++) {
			int temp=people.get(i);
			people.remove(i);
			if (people.contains(temp)) {
				people.add(i, temp);
			}
		}
		for (int i:people) {
			System.out.print(i+" ");
		}
		
	}
}
