package CarRentalSystem;

import CarRentalSystem.Service.ClientService;
import CarRentalSystem.Service.VehicleService;

public class ApplicationManager {
    private VehicleService vehicleService;
    private ClientService clientService;

    public ApplicationManager() {
        vehicleService = new VehicleService();
        clientService = new ClientService();
    }

    public void addVehicle() {
        vehicleService.add();
    }

    public void printAllVehicles() {
        vehicleService.printAllVehicles();
    }

    public void addClient() {
        clientService.add();
    }

    public void printAllClients() {
        clientService.printAll();
    }

}
