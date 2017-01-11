import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Recursion {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int numOfPeople=s.nextInt();
		int max=s.nextInt();
		ArrayList<Integer> people=new ArrayList<Integer>();
		people.add(numOfPeople);
		for (int i=0; i<people.size(); i++) {
			int groupSize=people.get(i);
			if (groupSize>max) {
				people.remove(i);
				people.add(groupSize/3);
				people.add(groupSize-groupSize/3);
				i--;
			}
		}
		int min=Collections.min(people);
		System.out.println(min);
	}
	
	public static int getMinGroup(int people, int maxPeople) {
		if (people<=maxPeople) {
			return people;
		}
		return Math.min(getMinGroup(people/3, maxPeople), getMinGroup(people-people/3, maxPeople));
	}

}
