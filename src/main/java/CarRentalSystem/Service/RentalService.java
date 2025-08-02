package CarRentalSystem.Service;

import CarRentalSystem.Entitiy.Rental;
import CarRentalSystem.Helper;
import CarRentalSystem.Repository.Rental_Id_Repository;

import java.util.HashMap;

public  class RentalService {
    private HashMap<String, Rental> allRentals;
    private HashMap<String, Rental> pastRentals;
    private HashMap<String, Rental> activeRentals;
    private final Rental_Id_Repository idRepository = new Rental_Id_Repository();

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
    //   public RentalService(HashMap <String, Rental> rentalHashMap){
    // this.allRentals = allRentals;
    // this.pastRentals = pastRentals;
    // this.activeRentals = activeRentals;
    //}

    public void addRental(Rental rental){
        rental.setPricePerDay(Helper.getIntFromUser("Price Per Day"));
        rental.setNumberOfDays(Helper.getIntFromUser("Number of Days"));
        rental.setStartDate(Helper.getDateFromUser("Start Date"));
        rental.setReturnDate(Helper.getDateFromUser("Return Date"));
        rental.setTotalPrice(rental.getPricePerDay() * rental.getNumberOfDays());
        rental.setPaid(Helper.getBooleanFromUser("Is Paid"));
        int current = idRepository.readId() + 1;
        rental.setId(current);
        idRepository.saveId(current);
        allRentals.put(rental.getClientId(), rental);

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
                            rental.getStartDate()+ "\t" +
                            rental.getReturnDate()+ "\t" +
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
