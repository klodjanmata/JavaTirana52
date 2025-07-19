package CarRentalSystem.Entitiy;

public class Car extends Vehicle{

    private EngineType engineType;
    private int numberOfDoors;
    private boolean hasSunroof;
    private BodyType bodyType;
    private boolean hasNavigation;
    private Transmission transmission;

    public Car(String vin, String licensePlate, String make, String model, int year, String color, int seats, int minPricePerDay, int minNumberOfDays, EngineType engineType, int numberOfDoors, boolean hasSunroof, BodyType bodyType, boolean hasNavigation, Transmission transmission) {
        super(vin, licensePlate, make, model, year, color, seats, minPricePerDay, minNumberOfDays);
        this.engineType = engineType;
        this.numberOfDoors = numberOfDoors;
        this.hasSunroof = hasSunroof;
        this.bodyType = bodyType;
        this.hasNavigation = hasNavigation;
        this.transmission = transmission;
    }

    public Car(){
        super();
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public boolean isHasSunroof() {
        return hasSunroof;
    }

    public void setHasSunroof(boolean hasSunroof) {
        this.hasSunroof = hasSunroof;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }

    public boolean isHasNavigation() {
        return hasNavigation;
    }

    public void setHasNavigation(boolean hasNavigation) {
        this.hasNavigation = hasNavigation;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }
}
