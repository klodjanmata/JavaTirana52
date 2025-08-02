package CarRentalSystem.Service;

import CarRentalSystem.Entitiy.*;
import CarRentalSystem.Helper;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

public class FilterService {
    private HashMap<String, Vehicle> vehicles;
    private List<Rental> rentals;

    public FilterService(HashMap<String, Vehicle> vehicles, List<Rental> rentals) {
        this.vehicles = vehicles;
        this.rentals = rentals;
    }

    public void filterByVehicleType(){
        System.out.println(VehicleType.printAllValues());
        String type = Helper.getStringFromUser("Vehicle Type");
        List<Vehicle> filteredList = vehicles.values().stream()
                .filter(v -> v.getVehicleType().name().equalsIgnoreCase(type))
                .toList();
        printVehicleList(filteredList);
    }

    public void filterByAvailability(){
        LocalDate start = Helper.getLocalDateFromUser("Start Date");
        LocalDate end = Helper.getLocalDateFromUser("Return Date");

        List<String> unAvailable = rentals.stream()
                .filter(r -> !(r.getStartDate().isBefore(end) &&
                                    r.getReturnDate().isAfter(start)))
                .map(Rental::getLicensePlate)
                .toList();
        List<Vehicle> availableVehicles = vehicles.values().stream()
                .filter(v -> !unAvailable.contains(v.getLicensePlate()))
                .toList();
        printVehicleList(availableVehicles);
    }

    public void filterByPriceRange(){
        int minPrice = Helper.getIntFromUser("Min Price");
        int maxPrice = Helper.getIntFromUser("Max Price");
        List<Vehicle> filteredList = vehicles.values().stream()
                .filter(v -> v.getMinPricePerDay() >= minPrice &&
                                    v.getMinPricePerDay() <= maxPrice)
                .toList();
        printVehicleList(filteredList);
    }

    public void filterByMake(){
        String make = Helper.getStringFromUser("Make");
        List<Vehicle> filteredList = vehicles.values().stream()
                .filter(v -> v.getMake().equalsIgnoreCase(make) ||
                        v.getMake().toUpperCase().contains(make.toUpperCase()))
                .toList();
        printVehicleList(filteredList);
    }

    public void filterByModel(){
        String model = Helper.getStringFromUser("Model");
        List<Vehicle> filteredList = vehicles.values().stream()
                .filter(v -> v.getModel().equalsIgnoreCase(model) ||
                        v.getModel().toUpperCase().contains(model.toUpperCase()))
                .toList();
        printVehicleList(filteredList);
    }

    public void filterByColor(){
        String color = Helper.getStringFromUser("Color");
        List<Vehicle> filteredList = vehicles.values().stream()
                .filter(v -> v.getColor().equalsIgnoreCase(color) ||
                        v.getColor().toUpperCase().contains(color.toUpperCase()))
                .toList();
        printVehicleList(filteredList);
    }

    public void filterByEngine(){
        System.out.println(EngineType.printAllValues());
        String engineType = Helper.getStringFromUser("EngineType");
        List<Vehicle> filteredList = vehicles.values().stream()
                .filter(v -> v.getClass().equals(Car.class))
                .filter(v -> ((Car) v).getEngineType().name().equalsIgnoreCase(engineType))
                .toList();
        printVehicleList(filteredList);
    }

    public void filterByTransmission(){
        System.out.println(Transmission.printAllValues());
        String transmission = Helper.getStringFromUser("Transmission");
        List<Vehicle> filteredList = vehicles.values().stream()
                .filter(v -> v.getClass().equals(Car.class))
                .filter(v -> ((Car) v).getTransmission().name().equalsIgnoreCase(transmission))
                .toList();
        printVehicleList(filteredList);
    }

    public void filterByBodyType(){
        System.out.println(BodyType.printAllValues());
        String bodyType = Helper.getStringFromUser("BodyType");
        List<Vehicle> filteredList = vehicles.values().stream()
                .filter(v -> v.getClass().equals(Car.class))
                .filter(v -> ((Car) v).getBodyType().name().equalsIgnoreCase(bodyType))
                .toList();
        printVehicleList(filteredList);
    }

    public void printVehicleList(List<Vehicle> list){
        System.out.println("######## Filtered Vehicle list ########");
        System.out.println("LicensePlate\tMake\tModel\tYear");
        for (Vehicle vehicle : list) {
            System.out.println(
                    vehicle.getLicensePlate() + "\t" +
                            vehicle.getMake() + "\t" +
                            vehicle.getModel() + "\t " +
                            vehicle.getYear()
            );
        }
    }
}
