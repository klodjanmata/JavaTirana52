package CarRentalSystem.Entity;

import java.util.Arrays;

public enum LicenceCategory {
    AM,
    A1,
    A2,
    A,
    B1,
    B,
    C1,
    C,
    D1,
    D,
    BE,
    C1E,
    CE,
    D1E,
    DE;

    public static String printAllValues() {
        return Arrays.toString(LicenceCategory.values());
    }
}
