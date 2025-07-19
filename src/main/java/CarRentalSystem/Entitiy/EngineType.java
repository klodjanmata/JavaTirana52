package CarRentalSystem.Entitiy;

import CarRentalSystem.Service.VehicleType;

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
