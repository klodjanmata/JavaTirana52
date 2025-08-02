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
        rentalService = new RentalService(rentalRepository.readFromFile());
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
        rental.setClientId(Helper.getStringFromUser("ClientId").toUpperCase());
        if (!checkIfClientExists(rental.getClientId())){
            System.out.println("Client does not exist! Register him/her first!");
            return;
        }
        rental.setLicensePlate(Helper.getStringFromUser("LicensePlate").toUpperCase());
        if (!checkIfCarExists(rental.getLicensePlate())){
            System.out.println("Car does not exist! Register it first!");
            return;
        }
        rentalService.addRental(rental);
    }

    private boolean checkIfCarExists(String licensePlate){
        return vehicleService.getVehicles().containsKey(licensePlate);
    }

    private boolean checkIfClientExists(String clientId){
        return clientService.getClientsMap().containsKey(clientId);
    }

    public void printAllRentals(){
        rentalService.printAllRentals();
    }

    public void shutDown() {
        clientRepository.writeToFile(clientService.getClientsMap());
        vehicleRepository.writeToFile(vehicleService.getVehicles());
        rentalRepository.writeToFile(rentalService.getAllRentals());
    }


}
