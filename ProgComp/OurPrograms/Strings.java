import java.util.Scanner;

public class Strings {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		long total=0;
		for (int i=0; i<n; i++) {
			total+=s.nextInt();
		}
		System.out.println(total);
	}

}
