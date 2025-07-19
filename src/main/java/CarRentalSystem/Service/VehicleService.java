package CarRentalSystem.Service;

import CarRentalSystem.Entitiy.Car;
import CarRentalSystem.Entitiy.MiniBuss;
import CarRentalSystem.Entitiy.Vehicle;
import CarRentalSystem.Helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VehicleService {
    HashMap<String, Vehicle> vehicles = new HashMap<>();

    public void add() {
        System.out.println("Input Correct Data");
        System.out.println(VehicleType.printAllValues());
        String vehicleType = Helper.getStringFromUser("VehicleType");
        Vehicle newVehicle;
        if (vehicleType.equalsIgnoreCase(VehicleType.CAR.name())) {
            newVehicle = getCarFromUser();
        }
        else if (vehicleType.equalsIgnoreCase(VehicleType.MOTORCYCLE.name())) {

        }
        else if (vehicleType.equalsIgnoreCase(VehicleType.MINIBUS.name())) {

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
        getVehicleFromUser(car);


        return car;
    }

    private Vehicle getMinibusFromUser() {
        MiniBuss miniBuss = new MiniBuss();
        getVehicleFromUser(miniBuss);
        // Minibuss specific atributes
        return miniBuss;
    }
}
