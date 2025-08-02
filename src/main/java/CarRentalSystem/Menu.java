package CarRentalSystem;

public class Menu {

    public static void mainMenu(){
        System.out.println("\n");
        System.out.println(" ********** Welcome to Car RentalSystem  **********");
        System.out.println("Chose your action!");
        System.out.println("1. Add Vehicle");
        System.out.println("2. Print All Vehicles");
        System.out.println("3. Add Client");
        System.out.println("4. Print All Clients");
        System.out.println("5. Rent a car");
        System.out.println("6. Print all rentals");
        System.out.println("7. Advanced Filters");
        System.out.println("0. Shut down");
    }

    public static void filterMenu(){
        System.out.println("Chose your filter!");
        System.out.println("1. Filter by Vehicle Type");
        System.out.println("2. Filter by Availability");
        System.out.println("3. Filter by Price Range");
        System.out.println("4. Filter by Make");
        System.out.println("5. Filter by Model");
        System.out.println("6. Filter by Color");
        System.out.println("7. Filter by Engine");
        System.out.println("8. Filter by Transmission");
        System.out.println("9. Filter by Body Type");
    }
}
