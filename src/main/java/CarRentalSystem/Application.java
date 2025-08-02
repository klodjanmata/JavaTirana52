package CarRentalSystem;

public class Application {

    private static ApplicationManager applicationManager = new ApplicationManager();

    public static void main(String[] args) {
        while (true){
            Menu.mainMenu();
            if (manageAction(getChoice())){
                return;
            }
        }
    }

    private static int getChoice(){
        while (true){
            try{
                int choice = Helper.getIntFromUser("Chose");
                return choice;
            }
            catch (Exception e){
                System.out.println("Invalid input! Try again!");
            }
        }
    }

    private static boolean manageAction(int choice) {
        switch (choice) {
            case 1:
                applicationManager.addVehicle();
                break;
            case 2:
                applicationManager.printAllVehicles();
                break;
            case 3:
                applicationManager.addClient();
                break;
            case 4:
                applicationManager.printAllClients();
                break;
            case 5:
                applicationManager.addRental();
                break;
            case 6:
                applicationManager.printAllRentals();
                break;
            case 0:
                System.out.println("Shut down");
                applicationManager.shutDown();
                return true;
            default:
                System.out.println("Invalid choice!!!");
        }
        return false;
    }

}
