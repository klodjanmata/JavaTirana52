package CarRentalSystem;

import CarRentalSystem.Entitiy.Rental;
import CarRentalSystem.Repository.ClientRepository;
import CarRentalSystem.Repository.RentalRepository;
import CarRentalSystem.Repository.VehicleRepository;
import CarRentalSystem.Service.ClientService;
import CarRentalSystem.Service.RentalService;
import CarRentalSystem.Service.VehicleService;

public class ApplicationManager {
    private VehicleService vehicleService;
    private ClientService clientService;
    private ClientRepository clientRepository;
    private VehicleRepository vehicleRepository;
    private RentalService rentalService;
    private RentalRepository rentalRepository;

    public ApplicationManager() {
        clientRepository = new ClientRepository();
        vehicleRepository = new VehicleRepository();
        rentalRepository = new RentalRepository();

        vehicleService = new VehicleService(vehicleRepository.readFromFile());
        clientService = new ClientService(clientRepository.readFromFile());
        rentalService = new RentalService();
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

    public void addRental() {
        Rental rental = new Rental();
        // TODO check if client and car exists, if not, ask the user to register them and return
        rental.setClientId(Helper.getStringFromUser("ClientId"));
        rental.setLicensePlate(Helper.getStringFromUser("LicensePlate"));
        rentalService.add(rental);
    }




    public void shutDown() {
        clientRepository.writeToFile(clientService.getClientsMap());
        vehicleRepository.writeToFile(vehicleService.getVehicles());
    }


}
