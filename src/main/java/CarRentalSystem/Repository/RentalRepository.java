package CarRentalSystem.Repository;

import CarRentalSystem.Entitiy.Rental;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.HashMap;

public class RentalRepository {

    private final String FIlEPATH = "CarRentalFiles/Rentals.csv";
    private final String SEPARATOR = ",";
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

    public HashMap<String, Rental> readFromFile() {
        HashMap<String, Rental> rentalsMap = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FIlEPATH))) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(SEPARATOR);
                Rental rental = new Rental();
                rental.setId(Integer.parseInt(fields[1]));
                rental.setClientId(fields[2]);
                rental.setLicensePlate(fields[3]);
                rental.setPricePerDay(Integer.parseInt(fields[4]));
                rental.setNumberOfDays(Integer.parseInt(fields[5]));
                rental.setStartDate(dateFormat.parse(fields[6]));
                rental.setReturnDate(dateFormat.parse(fields[7]));
                rental.setTotalPrice(Integer.parseInt(fields[8]));
                rental.setPaid(Boolean.parseBoolean(fields[9]));
                rentalsMap.put(rental.getClientId(), rental);
            }
            reader.close();
            System.out.println("Successfully read rentals from the file ");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rentalsMap;
    }

    public void writeToFile(HashMap<String, Rental> rentalHashMap) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FIlEPATH))) {
            writer.write(getHeadLine());
            for(Rental r : rentalHashMap.values()){
                writer.newLine();
                writeRentalFields(r, writer);
            }
            writer.close();
            System.out.println("Successfully wrote rentals to the file");



        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    private void writeRentalFields (Rental r, BufferedWriter writer){
        try {
            writer.write(r.getId()+SEPARATOR);
            writer.write(r.getClientId()+SEPARATOR);
            writer.write(r.getLicensePlate()+SEPARATOR);
            writer.write(r.getPricePerDay()+SEPARATOR);
            writer.write(r.getNumberOfDays()+SEPARATOR);
            writer.write(dateFormat.format(r.getStartDate())+SEPARATOR);
            writer.write(dateFormat.format(r.getReturnDate())+SEPARATOR);
            writer.write(r.getTotalPrice()+SEPARATOR);
            writer.write(r.isPaid()+SEPARATOR);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private String getHeadLine() {
        return "Id , ClientId , Licence Plate , Price per Day , " +
                "Number of Days , Start Date , Return Date ,Total Price , Is Paid , ";
    }
}