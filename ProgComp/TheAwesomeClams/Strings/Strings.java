import java.util.Scanner;
public class Strings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner input = new Scanner(System.in);
long num = input.nextInt();
long sum = 0;
for(long i = 0; i<num; i++){
	sum+=input.nextInt();
}
System.out.println(sum);
	}

}
