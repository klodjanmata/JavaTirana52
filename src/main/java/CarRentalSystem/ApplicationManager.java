package CarRentalSystem;

import CarRentalSystem.Repository.ClientRepository;
import CarRentalSystem.Repository.VehicleRepository;
import CarRentalSystem.Service.ClientService;
import CarRentalSystem.Service.VehicleService;

public class ApplicationManager {
    private VehicleService vehicleService;
    private ClientService clientService;
    private ClientRepository clientRepository;
    private VehicleRepository vehicleRepository;

    public ApplicationManager() {
        clientRepository = new ClientRepository();
        vehicleRepository = new VehicleRepository();

        vehicleService = new VehicleService();
        clientService = new ClientService(clientRepository.readFromFile());
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




    public void shutDown() {
        clientRepository.writeToFile(clientService.getClientsMap());
        vehicleRepository.writeToFile(vehicleService.getVehicles());
    }


}
