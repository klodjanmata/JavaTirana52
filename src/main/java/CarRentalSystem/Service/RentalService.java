package CarRentalSystem.Service;

import CarRentalSystem.Entitiy.Rental;
import CarRentalSystem.Helper;

import java.util.HashMap;

public class RentalService {
    HashMap<String, Rental> allRentals;
    HashMap<String, Rental> pastRentals;
    HashMap<String, Rental> activeRentals;

    public RentalService(){
        allRentals = new HashMap<>();
    }

    public void add(Rental rental){
        rental.setPricePerDay(Helper.getIntFromUser("Price Per Day"));
        rental.setNumberOfDays(Helper.getIntFromUser("Number of Days"));
        rental.setStartDate(Helper.getDateFromUser("Start Date"));
        rental.setReturnDate(Helper.getDateFromUser("Return Date"));
        rental.setTotalPrice(rental.getPricePerDay() * rental.getNumberOfDays());
        rental.setPaid(Helper.getBooleanFromUser("Is Paid"));
        rental.setId(Helper.getIntFromUser("Id"));
        allRentals.put(rental.getClientId(), rental);


    }

}
