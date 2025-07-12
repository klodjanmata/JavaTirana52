package JavaAdv.Exercises.Collections.Task2;

import java.util.Scanner;

public class Main {
    private static BookService bookService = new BookService();

    public static void main(String[] args) {
        while(true){
            printMenu();
            if(manageChoice(getChoice())){
                return;
            }
        }
    }

    public static int getChoice(){
        int choice;
        Scanner scanner = new Scanner(System.in);
        while(true){
            try {
                System.out.print("Enter choice: ");
                choice = scanner.nextInt();
//                if (choice > 1000){
//                    throw new BufferOverflowException();
//                }
                return choice;
//            }catch (InputMismatchException e){
//                System.out.println("Invalid choice, try again");
//                scanner.nextLine();
//            }catch (BufferOverflowException e){
//                System.out.println("Number is too big, try again");
            }catch (Exception e){
                System.out.println("Invalid choice, try again");
            }
        }
    }

    public static boolean manageChoice(int choice){
        switch(choice){
            case 1:
                System.out.println("Adding book");
                bookService.add();
                break;
            case 4:
                bookService.printBookList();
                break;
            case 0:
                System.out.println("Shutting down");
                return true;
        }
        return false;
    }

    public static void printMenu(){
        System.out.println("Chose an action:");
        System.out.println("1. Add Book");
        System.out.println("2. Remove Book");
        System.out.println("3. Search Book");
        System.out.println("4. Print Books List");
        System.out.println("0. Exit");
    }
}
