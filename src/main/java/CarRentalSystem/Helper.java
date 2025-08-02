package CarRentalSystem;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Helper {

    public static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public static String getStringFromUser(String message){
        System.out.print(message + ": ");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static char getCharFromUser(String message){
        return Helper.getStringFromUser(message).charAt(0);
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

    public static String convertListToString(List<String> values) {
        String result = "[";
        for (String value : values) {
            result += value + ", ";
        }
        result += "]";
        return result;
    }

    public static boolean getBooleanFromUser(String message){
        System.out.print(message + ": ");
        Scanner sc = new Scanner(System.in);
        return sc.nextBoolean();
    }

    public static LocalDate getLocalDateFromUser(String message){
        System.out.println("Expected date format: dd.MM.yyyy");
        System.out.print(message + ": ");
        Scanner sc = new Scanner(System.in);
        try {
            return LocalDate.parse(sc.nextLine(), DATE_FORMATTER);
        }catch (Exception e){
            return new Date().toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
        }

    }
}

