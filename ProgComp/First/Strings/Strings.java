import java.util.Scanner;

/**
 * Created by Gage Gosset on 1/20/2017.
 */
public class Strings {

    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        int numStrings=input.nextInt();
        int[] nums=new int[numStrings];
        for(int i=0;i<numStrings;i++)
            nums[i]=input.nextInt();

        long total=0;
        for (int j=0;j<numStrings;j++)
            total+=nums[j];
        System.out.println(total);
    }

}
