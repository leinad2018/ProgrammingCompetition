import java.util.Scanner;

/**
 * Created by Gage Gosset on 1/20/2017.
 */
public class Doors {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numTest = input.nextInt();
        int times = 0;
        for (int i = 0; i < numTest; i++) {
            int numDoors = input.nextInt();
            String doors = input.next();
            times = numDoors - doors.indexOf("0");
            if(times==numDoors+1)
                times=0;
            System.out.println(times);
        }
    }
}

