package CarRentalSystem;

import CarRentalSystem.Entity.Client;
import CarRentalSystem.Entity.LicenceCategory;
import CarRentalSystem.Repository.ClientRepository;

import java.text.ParseException;

public class Test {
    public static void main(String[] args) throws ParseException {
        ClientRepository clientRepository = new ClientRepository();
        Client client = new Client();
//        client.setId("K12343211R");
//        client.setName("Janaq Kilica");
//        client.setGender('M');
//        client.setPhoneNumber("0699999999");
//        client.setLicenceId("123456789");
//        client.setLicenceCategory(LicenceCategory.B);
//        clientRepository.create(client);
//        System.out.println("Client added successfully");
        client = clientRepository.findById("K12343211R");
        System.out.println(client);

    }
}
