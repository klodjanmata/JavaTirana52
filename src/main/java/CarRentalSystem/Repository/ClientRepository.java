package CarRentalSystem.Repository;

import CarRentalSystem.Entitiy.Client;
import CarRentalSystem.Entitiy.LicenceCategory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
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
        HashMap<String, Client> clients = new HashMap<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(FILEPATH))){
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null){
                String[] parts = line.split(SEPARATOR);
                Client client = new Client();
                client.setId(parts[0]);
                client.setName(parts[1]);
                client.setLicenceId(parts[2]);
                client.setGender(parts[3].charAt(0));
                client.setPhoneNumber(parts[4]);
                client.setLicenceCategory(LicenceCategory.valueOf(parts[5]));

                clients.put(client.getId(), client);
            }
            reader.close();
            System.out.println("Successfully read clients to the file");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return clients;
    }
}
