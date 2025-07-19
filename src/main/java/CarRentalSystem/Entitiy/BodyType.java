package CarRentalSystem.Entitiy;

import java.util.Arrays;

public enum BodyType {
    COUPE,
    CABRIO,
    SPORTBACK,
    HATCHBACK,
    SALON,
    STATION_WAGON,
    LIMOUSINE,
    CROSS_OVER,
    SUV;

    public static String printAllValues() {
        return Arrays.toString(BodyType.values());
    }
}
