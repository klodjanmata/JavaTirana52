package CarRentalSystem;

import CarRentalSystem.Entitiy.Client;
import CarRentalSystem.Entitiy.Rental;
import CarRentalSystem.Repository.ClientRepository;
import CarRentalSystem.Repository.RentalRepository;
import CarRentalSystem.Repository.VehicleRepository;
import CarRentalSystem.Service.ClientService;
import CarRentalSystem.Service.FilterService;
import CarRentalSystem.Service.RentalService;
import CarRentalSystem.Service.VehicleService;
import CarRentalSystem.dbConnection.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

        executeUpgrade(clientService);
    }

    public void executeUpgrade(ClientService clientService){
        if (checkIfUpgradeNeeded("client")){
            for (Client c : clientService.getClientsMap().values()){
                clientRepository.save(c);
            }
            System.out.println("SAVED CLIENTS IN DATABASE");
        }
        if (checkIfUpgradeNeeded("vehicle")){

        }
        if (checkIfUpgradeNeeded("rental")){

        }
    }

    private boolean checkIfUpgradeNeeded(String tableName){
        try(Connection connection = DatabaseConnection.dbConnection()){
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM " + tableName + " LIMIT 1");
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                System.out.printf("NO UPGRADE NEEDED FOR " + tableName);
                return false;
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
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

    public void handleFilterSelection(int choice){
        FilterService filterService = new FilterService(vehicleService.getVehicles(),
                rentalService.getAllRentals().values().stream().toList());
        switch (choice){
            case 1:
                filterService.filterByVehicleType();
                break;
            case 2:
                filterService.filterByAvailability();
                break;
            case 3:
                filterService.filterByPriceRange();
                break;
            case 4:
                filterService.filterByMake();
                break;
            case 5:
                filterService.filterByModel();
                break;
            case 6:
                filterService.filterByColor();
                break;
            case 7:
                filterService.filterByEngine();
                break;
            case 8:
                filterService.filterByTransmission();
                break;
            case 9:
                filterService.filterByBodyType();
                break;
            default:
                System.out.println("Unsupported filter choice! Try again!");
                break;
        }
        return;
    }

}
