import java.util.Scanner;
import java.util.ArrayList;

public class Lonely {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		ArrayList<Integer> party = new ArrayList<Integer>();
		ArrayList<Integer> partyRight = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			party.add(input.nextInt());
		}
		for (int i = 0; i < party.size(); i++) {
			int temp = party.get(i);
			for (int r = 0; r < party.size(); r++) {
				if (r != i) {
					if (party.get(r) == temp) {
						partyRight.add(party.get(i));
					}
				}
			}
		}
		for (int i = 0; i < partyRight.size(); i++) {
			System.out.print(partyRight.get(i)+" ");
			}
		}
	}
