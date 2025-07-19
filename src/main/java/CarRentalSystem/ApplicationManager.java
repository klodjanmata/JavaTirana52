package CarRentalSystem;

import CarRentalSystem.Entitiy.Vehicle;
import CarRentalSystem.Service.VehicleService;

public class ApplicationManager {
    private VehicleService vehicleService;

    public ApplicationManager() {
        vehicleService = new VehicleService();
    }

    public void addVehicle() {
        vehicleService.add();
    }

    public void printAllVehicles() {
        vehicleService.printAllVehicles();
    }

}
