import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	public static void main(String[] args) {
		
		boolean[] possible=new boolean[100000000];
		for (int i=0; i<possible.length; i++) {
			possible[i]=false;
		}
		
		possible[4]=possible[7]=true;
		for (int i=0; i<possible.length; i++) {
			if (possible[i]) {
				if (i+4<possible.length) {
					possible[i+4]=true;
				}
				if (i+7<possible.length) {
					possible[i+7]=true;
				}
			}
		}
		
		for (int i=0; i<possible.length; i++) {
			if (!possible[i]) {
				System.out.println(i);
			}
		}
		
		/*Scanner s=new Scanner(System.in);
		int games=s.nextInt();
		for (int game=0; game<games; game++) {
			int numberOfIntegers=s.nextInt();
			int[] array=new int[numberOfIntegers];
			for (int i=0; i<numberOfIntegers; i++) {
				array[i]=s.nextInt();
			}
			int[] bitCounts=new int[32];
			for (int i : array) {
				String binary=Integer.toBinaryString(i);
				for (int j=0; j<binary.length(); j++) {
					if (binary.charAt(binary.length()-1-j)=='1') {
						bitCounts[j]++;
					}
				}
			}
			boolean isETriplet=true;
			for (int i:bitCounts) {
				if (i%2!=0) {
					isETriplet=false;
				}
			}
			
			if (isETriplet) {
				System.out.println("L");
			}
			else {
				System.out.println("W");
			}
		}*/

	}
}
