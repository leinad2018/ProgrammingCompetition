import java.util.Scanner;

public class Strings {
	
	public static void main(String [] args){
	Scanner in = new Scanner(System.in);
	long total=0;
	
		int amount=in.nextInt();
		for(int i=0;i<amount;i++){
			long temp=in.nextInt();
			total+=temp;
		
	}
		System.out.println(total);
		
	}

}
