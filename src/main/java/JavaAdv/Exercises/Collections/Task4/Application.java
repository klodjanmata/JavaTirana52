package JavaAdv.Exercises.Collections.Task4;

import JavaAdv.Exercises.Helper;

public class Application {
    private static NewspaperService newspaperService = new NewspaperService();

    public static void main(String[] args) {
        while (true){
            Menu.mainMenu();
            if(manageChoice(getChoice())){
                return;
            }
        }
    }

    public static int getChoice(){
        int choice;
        while(true){
            try {
                choice = Helper.getIntFromUser("Enter choice");
                return choice;
            }catch (Exception e){
                System.out.println("Invalid choice, try again");
            }
        }
    }

    public static boolean manageChoice(int choice){
        switch (choice){
            case 1:
                newspaperService.addNewspaperFromUser();
                break;
            case 0:
                return true;
        }
        return false;
    }

}
