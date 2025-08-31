package CarRentalSystem.Entity;

public abstract class Vehicle {
    private VehicleType vehicleType;
    private String vin;
    private String licensePlate;
    private String make;
    private String model;
    private int year;
    private String color;
    private int seats;
    private int minPricePerDay;
    private int minNumberOfDays;
    private boolean available;

    public Vehicle(VehicleType vehicleType, String vin, String licensePlate, String make, String model,
                   int year, String color, int seats, int minPricePerDay, int minNumberOfDays,
                   boolean available) {
        this.vehicleType = vehicleType;
        this.vin = vin;
        this.licensePlate = licensePlate;
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.seats = seats;
        this.minPricePerDay = minPricePerDay;
        this.minNumberOfDays = minNumberOfDays;
        this.available = available;
    }

    public Vehicle(){}

    public int getMinPricePerDay() {
        return minPricePerDay;
    }

    public void setMinPricePerDay(int minPricePerDay) {
        this.minPricePerDay = minPricePerDay;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getMinNumberOfDays() {
        return minNumberOfDays;
    }

    public void setMinNumberOfDays(int minNumberOfDays) {
        this.minNumberOfDays = minNumberOfDays;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
