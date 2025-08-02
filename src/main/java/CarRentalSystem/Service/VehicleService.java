package CarRentalSystem.Service;

import CarRentalSystem.Entitiy.*;
import CarRentalSystem.Helper;

import java.util.HashMap;

public class VehicleService {
    HashMap<String, Vehicle> vehicles;

    public VehicleService(){
        vehicles = new HashMap<>();
    }

    public VehicleService(HashMap<String, Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public void add() {
        System.out.println("Input Correct Data");
        System.out.println(VehicleType.printAllValues());
        String vehicleType = Helper.getStringFromUser("VehicleType");
        Vehicle newVehicle = null;
        if (vehicleType.equalsIgnoreCase(VehicleType.CAR.name())) {
            newVehicle = getCarFromUser();
        }
        else if (vehicleType.equalsIgnoreCase(VehicleType.MOTORCYCLE.name())) {
            System.out.println("Not supported vehicle type");
        }
        else if (vehicleType.equalsIgnoreCase(VehicleType.MINIBUS.name())) {
            System.out.println("Not supported vehicle type");
        }
        if (newVehicle != null){
            vehicles.put(newVehicle.getLicensePlate(), newVehicle);
            System.out.println("Vehicle added successfully");
            return;
        }
        else {
            System.out.println("Can't add vehicle");
        }
    }

    public void printAllVehicles() {
        System.out.println("######## Vehicles list ########");
        System.out.println("LicensePlate\tMake\tModel\tYear");
        for (Vehicle vehicle : vehicles.values()) {
            System.out.println(
                    vehicle.getLicensePlate() + "\t" +
                    vehicle.getMake() + "\t" +
                    vehicle.getModel() + "\t " +
                    vehicle.getYear()
            );
        }
    }

    private void getVehicleFromUser(Vehicle vehicle) {
        vehicle.setVin(Helper.getStringFromUser("Vin"));
        vehicle.setLicensePlate(Helper.getStringFromUser("LicensePlate"));
        vehicle.setMake(Helper.getStringFromUser("Make"));
        vehicle.setModel(Helper.getStringFromUser("Model"));
        vehicle.setYear(Helper.getIntFromUser("Year"));
        vehicle.setColor(Helper.getStringFromUser("Color"));
        vehicle.setSeats(Helper.getIntFromUser("Seats"));
        vehicle.setMinPricePerDay(Helper.getIntFromUser("MinPricePerDay"));
        vehicle.setMinNumberOfDays(Helper.getIntFromUser("MinNumberOfDays"));
        vehicle.setAvailable(true);
    }

    private Vehicle getCarFromUser() {
        Car car = new Car();
        car.setVehicleType(VehicleType.CAR);
        getVehicleFromUser(car);

        System.out.println(EngineType.printAllValues());
        car.setEngineType(EngineType.valueOf(
                Helper.getStringFromUser("EngineType").toUpperCase()));
        car.setNumberOfDoors(Helper.getIntFromUser("NumberOfDoors"));
        car.setHasSunroof(Helper.getBooleanFromUser("HasSunroof"));
        System.out.println(BodyType.printAllValues());
        car.setBodyType(BodyType.valueOf(
                Helper.getStringFromUser("BodyType").toUpperCase()));
        car.setHasNavigation(Helper.getBooleanFromUser("HasNavigation"));
        System.out.println(Transmission.printAllValues());
        car.setTransmission(Transmission.valueOf(
                Helper.getStringFromUser("Transmission").toUpperCase()
        ));
        return car;
    }

    private Vehicle getMinibusFromUser() {
        MiniBuss miniBuss = new MiniBuss();
        miniBuss.setVehicleType(VehicleType.MINIBUS);
        getVehicleFromUser(miniBuss);
        // Minibuss specific atributes
        return miniBuss;
    }

    public HashMap<String, Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(HashMap<String, Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
