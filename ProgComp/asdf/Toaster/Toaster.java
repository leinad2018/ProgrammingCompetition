import java.util.Scanner;

public class Toaster {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int numberOfToasters=s.nextInt();
		int maxWeight=s.nextInt();
		int[] weights=new int[numberOfToasters];
		int[] values=new int[numberOfToasters];
		for (int i=0; i<numberOfToasters; i++) {
			weights[i]=s.nextInt();
			values[i]=s.nextInt();
		}
		
		int maxValue=0;
		for (int counter=0; counter<Math.pow(2, numberOfToasters); counter++) {
			String contains=Integer.toBinaryString(counter);
			while (contains.length()!=numberOfToasters) {
				contains="0"+contains;
			}
			int totalWeight=0, totalValue=0;
			for (int i=0; i<numberOfToasters; i++) {
				if (contains.charAt(i)=='1') {
					totalWeight+=weights[i];
					totalValue+=values[i];
				}
			}
			if (totalWeight<=maxWeight) {
				maxValue=Math.max(maxValue, totalValue);
			}
		}
		System.out.println(maxValue);

	}

}
