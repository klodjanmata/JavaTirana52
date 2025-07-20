package CarRentalSystem;

import CarRentalSystem.Entitiy.Car;
import CarRentalSystem.Entitiy.Vehicle;

public class Test {
    public static void main(String[] args) {
        Vehicle v = new Car();
        System.out.println(v.getClass().getName());
    }
}
