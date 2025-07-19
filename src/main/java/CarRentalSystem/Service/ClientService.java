package CarRentalSystem.Service;

import CarRentalSystem.Entitiy.Client;

import java.lang.ref.Cleaner;
import java.util.HashMap;

public class ClientService {
    private HashMap<String, Client> clients;

    public ClientService() {
        clients = new HashMap<>();
    }
}
