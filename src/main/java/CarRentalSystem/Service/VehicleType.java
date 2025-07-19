package CarRentalSystem.Service;

import CarRentalSystem.Entitiy.Vehicle;

import java.util.Arrays;

public enum VehicleType {
    CAR,
    MOTORCYCLE,
    MINIBUS;

    public static String printAllValues() {
        return Arrays.toString(VehicleType.values());
    }
}
