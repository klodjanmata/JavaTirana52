package CarRentalSystem.Service;

import CarRentalSystem.Entitiy.Rental;
import CarRentalSystem.Helper;
import CarRentalSystem.Repository.Rental_Id_Repository;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public  class RentalService {
    private HashMap<String, Rental> allRentals;
    private HashMap<String, Rental> pastRentals;
    private HashMap<String, Rental> activeRentals;
    private final Rental_Id_Repository idRepository = new Rental_Id_Repository();
    public static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public RentalService(){
        allRentals = new HashMap<>();
        pastRentals = new HashMap<>();
        activeRentals = new HashMap<>();
    }

    public RentalService(HashMap<String, Rental> allRentals,
                         HashMap<String, Rental> pastRentals,
                         HashMap<String, Rental> activeRentals) {
        this.allRentals = allRentals;
        this.pastRentals = pastRentals;
        this.activeRentals = activeRentals;
    }

    public RentalService(HashMap <String, Rental> allRentals){
        this.allRentals = allRentals;
    }

    public void addRental(Rental rental){
        rental.setPricePerDay(Helper.getIntFromUser("Price Per Day"));
        rental.setStartDate(Helper.getLocalDateFromUser("Start Date"));
        rental.setReturnDate(Helper.getLocalDateFromUser("Return Date"));
        if (!isAvailableOn(rental.getLicensePlate(), rental.getStartDate(), rental.getReturnDate())){
            System.out.println("Vehicle is not available on the selected dates");
            return;
        }
        rental.setNumberOfDays((int) ChronoUnit.DAYS.between(
                rental.getStartDate(), rental.getReturnDate()));
        rental.setTotalPrice(rental.getPricePerDay() * rental.getNumberOfDays());
        rental.setPaid(Helper.getBooleanFromUser("Is Paid"));
        int current = idRepository.readId() + 1;
        rental.setId(current);
        idRepository.saveId(current);
        allRentals.put(rental.getClientId(), rental);

    }

    private boolean isAvailableOn(String licencePlate, LocalDate start, LocalDate end){
        List<Rental> vehicleRentals = allRentals.values().stream()
                .filter(r -> r.getLicensePlate().equals(licencePlate))
                .filter(r -> r.getStartDate().isBefore(end) &&
                                    r.getReturnDate().isAfter(start))
                .toList();
        if (vehicleRentals.isEmpty()){
            return true;
        }
        return false;
    }

    public void printAllRentals(){
        System.out.println("****** Full Rental List ******");
        System.out.println("Id\tClientId\tLicene Plate\tPrice Per Day" +
                "\tNumber Per Day\tStart Date\t Retur Date" +
                "\t Total Price\tIs Paid");
        for (Rental rental : allRentals.values()){
            System.out.println(
                    rental.getId()+ "\t" +
                            rental.getClientId()+ "\t" +
                            rental.getLicensePlate()+ "\t" +
                            rental.getPricePerDay()+ "\t" +
                            rental.getNumberOfDays()+ "\t" +
                            DATE_FORMATTER.format(rental.getStartDate())+ "\t" +
                            DATE_FORMATTER.format(rental.getReturnDate())+ "\t" +
                            rental.getTotalPrice()+ "\t" +
                            rental.isPaid()
            );
        }
    }

    public HashMap<String, Rental> getAllRentals() {
        return allRentals;
    }

    public void setAllRentals(HashMap<String, Rental> allRentals) {
        this.allRentals = allRentals;
    }

    public HashMap<String, Rental> getPastRentals() {
        return pastRentals;
    }

    public void setPastRentals(HashMap<String, Rental> pastRentals) {
        this.pastRentals = pastRentals;
    }

    public HashMap<String, Rental> getActiveRentals() {
        return activeRentals;
    }

    public void setActiveRentals(HashMap<String, Rental> activeRentals) {
        this.activeRentals = activeRentals;
    }
}
