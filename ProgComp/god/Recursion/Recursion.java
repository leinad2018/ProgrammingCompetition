import java.util.Scanner;

public class Recursion {
	public Recursion() {

	}

	public long solve(long totalPeople, long happy) {
		happyGroupSize = happy;
		smallestGroupSize = totalPeople;
		if (totalPeople > happyGroupSize) {
			long oneGroup = (long) Math.floor(totalPeople / 3);
			long twoGroup = totalPeople - oneGroup;
			helper(oneGroup);
			helper(twoGroup);
			return smallestGroupSize;
		} else
			return smallestGroupSize;
	}

	public void helper(long group) {
		if (group < smallestGroupSize)
			smallestGroupSize = group;
		if (group > happyGroupSize){
			long one = (long) Math.floor(group / 3);
			long two = group - one;
				helper(one);
				helper(two);
		}
	}

	private long smallestGroupSize;
	private long happyGroupSize;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Recursion lel = new Recursion();
		long people = in.nextLong();
		long groupSize = in.nextLong();
		System.out.println(lel.solve(people, groupSize));
	}
}
