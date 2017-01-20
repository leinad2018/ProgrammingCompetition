import java.util.Scanner;

public class Lonely {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] count = new int[10000];
		int[] stuff = new int[n];
		for(int i = 0; i < n; i++){
			stuff[i]=in.nextInt();
			count[stuff[i]]++;
		}
		for(int i = 0; i < n; i++){
			if(count[stuff[i]]==1)continue;
			System.out.print(stuff[i]+" ");
		}
	}

}
