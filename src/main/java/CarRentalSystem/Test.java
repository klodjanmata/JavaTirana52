package CarRentalSystem;

import CarRentalSystem.Entitiy.Car;
import CarRentalSystem.Entitiy.Vehicle;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) throws ParseException {
        boolean b = Helper.getBooleanFromUser("Test");
        System.out.println(b);
    }
}
