package CarRentalSystem.Repository;

import CarRentalSystem.Entitiy.Client;
import CarRentalSystem.Entitiy.LicenceCategory;
import CarRentalSystem.dbConnection.DatabaseConnection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

public class ClientRepository {
    private final String FILEPATH = "CarRentalFiles/Clients.csv";
    private final String SEPARATOR = ",";

    public void save(Client client){
        try(Connection con = DatabaseConnection.dbConnection()){
            PreparedStatement statement = con.prepareStatement("INSERT INTO client VALUES (?,?,?,?,?,?)");
            statement.setString(1, client.getId());
            statement.setString(2, client.getName());
            statement.setString(3, client.getLicenceId());
            statement.setString(4, client.getLicenceCategory().name());
            statement.setString(5, client.getGender() + "");
            statement.setString(6, client.getPhoneNumber());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public HashMap<String, Client> findAll() {
        try(Connection con = DatabaseConnection.dbConnection()){
            PreparedStatement statement = con.prepareStatement("SELECT * FROM client");
            ResultSet resultSet = statement.executeQuery();
            HashMap<String, Client> clients = new HashMap<>();
            while (resultSet.next()){
                Client client = new Client();
                client.setId(resultSet.getString("id"));
                client.setName(resultSet.getString("name"));
                client.setLicenceId(resultSet.getString("licenceId"));
                client.setLicenceCategory(LicenceCategory.valueOf(resultSet.getString("licenceCategory")));
                client.setGender(resultSet.getString("gender").charAt(0));
                client.setPhoneNumber(resultSet.getString("phoneNumber"));
            }
            return clients;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

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
