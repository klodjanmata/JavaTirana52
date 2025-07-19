package CarRentalSystem;

import java.util.Scanner;

public class Helper {

    public static String getStringFromUser(String message){
        System.out.print(message + ": ");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static int getIntFromUser(String message){
        System.out.print(message + ": ");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static float getFloatFromUser(String message){
        System.out.print(message + ": ");
        Scanner sc = new Scanner(System.in);
        return sc.nextFloat();
    }
}

