import java.util.Scanner;

public class Doors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t-->0){
			int n = in.nextInt();
			String doors = in.next();
			int first = doors.indexOf("0");
			if(first==-1)first=n;
			System.out.println(n-(first));
		}
	}

}
