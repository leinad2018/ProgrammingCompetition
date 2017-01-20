import java.util.Scanner;
import java.util.ArrayList;
public class Lonely {
	public static void main(String[] args){
		Scanner input =new Scanner(System.in);
		int n = input.nextInt();
		input.nextLine();
		String x = input.nextLine();
		int[] people = new int[n];
		String[] splitted = x.split(" ");
		
	
		ArrayList<Integer> goodPeople = new ArrayList<Integer>();

		for (int k =0; k<n;k++){
			people[k] =Integer.parseInt(splitted[k]);
		}
		for (int d=0; d<people.length;d++){
			for (int g=0; g<people.length;g++){
				
				if (people[d]==people[g] && g != d){
					System.out.print(people[d]+" ");
					break;
				}
			}
		}
	
	}

}
