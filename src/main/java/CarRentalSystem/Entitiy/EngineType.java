package CarRentalSystem.Entitiy;

import java.util.Arrays;


public enum EngineType {
    ELECTRIC,
    PETROL,
    DIESEL,
    LPG,
    HYBRID;

    public static String printAllValues() {
        return Arrays.toString(EngineType.values());
    }
}
