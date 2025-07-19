package CarRentalSystem.Repository;

import CarRentalSystem.Entitiy.Client;
import CarRentalSystem.Entitiy.Vehicle;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.HashMap;

public class ClientRepository {
    private final String FILEPATH = "CarRentalFiles/Clients.csv";
    private final String SEPARATOR = ",";

    public void writeToFile(HashMap<String, Client> clients) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILEPATH))){
            writer.write(getHeadline());
            for (Client c : clients.values()){
                writer.newLine();
                writer.write(c.getId() + SEPARATOR);
                writer.write(c.getName() + SEPARATOR);
                writer.write(c.getLicenceId() + SEPARATOR);
                writer.write(c.getGender() + SEPARATOR);
                writer.write(c.getPhoneNumber() + SEPARATOR);
                writer.write(c.getLicenceCategory().name());
            }
            writer.close();
            System.out.println("Successfully wrote clients to the file");
        }catch (Exception e) {
            System.out.println("Could not write Clients in file");
            e.printStackTrace();
        }
    }

    private String getHeadline() {
        return "Id,Name,LicenceId,Gender,PhoneNumber,LicenceCategory";
    }

    public HashMap<String, Client> readFromFile(){
        return null;
    }
}
