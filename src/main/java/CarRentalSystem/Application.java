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
            case 0:
                System.out.println("Shut down");
                return true;
            default:
                System.out.println("Invalid choice!!!");
        }
        return false;
    }

}
