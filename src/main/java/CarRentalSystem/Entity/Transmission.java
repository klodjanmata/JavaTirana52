package CarRentalSystem.Entity;

import java.util.Arrays;

public enum Transmission {
    MANUAL,
    AUTOMATIC;

    public static String printAllValues() {
        return Arrays.toString(Transmission.values());
    }
}
