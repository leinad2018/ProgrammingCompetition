import java.util.Scanner;
public class Strings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner (System.in);
		
		int n=input.nextInt();
		int[] arr=new int[n];
		
		for (int i=0;i<arr.length;i++){
			arr[i]=input.nextInt();
		}
		long count=0;
		for (int temp: arr){
			count+=temp;
		}
		
		System.out.println(count);
		
	}

}
