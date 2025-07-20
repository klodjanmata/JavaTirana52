package CarRentalSystem.Service;

import CarRentalSystem.Entitiy.Client;
import CarRentalSystem.Entitiy.LicenceCategory;
import CarRentalSystem.Helper;

import java.lang.ref.Cleaner;
import java.util.HashMap;

public class ClientService {
    private HashMap<String, Client> clientsMap;

    public ClientService() {
        clientsMap = new HashMap<>();
    }

    public ClientService(HashMap<String, Client> clientsMap) {
        this.clientsMap = clientsMap;
    }

    public void add() {
        System.out.println("Add the necessary client information");
        Client client = new Client();
        client.setId(Helper.getStringFromUser("ID"));
        client.setName(Helper.getStringFromUser("Name"));
        client.setGender(Helper.getCharFromUser("Gender"));
        client.setPhoneNumber(Helper.getStringFromUser("PhoneNumber"));
        client.setLicenceId(Helper.getStringFromUser("LicenceId"));
        System.out.println(LicenceCategory.printAllValues());
        client.setLicenceCategory(LicenceCategory.valueOf(
                Helper.getStringFromUser("LicenceCategory").toUpperCase()
        ));
        clientsMap.put(client.getId(), client);
        System.out.println("Client with id: " +  client.getId() + " added successfully");

    }

    public void printAll(){
        System.out.println("######## Full Clients list ########");
        System.out.println("ID\tName\tGender\tPhoneNumber\tLicenceId\tLicenceCategory");
        for (Client client : clientsMap.values()) {
            System.out.println(
                    client.getId() + "\t" +
                    client.getName() + "\t" +
                    client.getGender() + "\t" +
                    client.getPhoneNumber() + "\t" +
                    client.getLicenceId() + "\t" +
                    client.getLicenceCategory()
            );
        }
    }

    public HashMap<String, Client> getClientsMap() {
        return clientsMap;
    }

    public void setClientsMap(HashMap<String, Client> clientsMap) {
        this.clientsMap = clientsMap;
    }
}
