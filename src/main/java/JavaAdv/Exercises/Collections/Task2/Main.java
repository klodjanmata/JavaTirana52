package JavaAdv.Exercises.Collections.Task2;

public class Main {

    public static void main(String[] args) {
        BookService bookService = new BookService();
        while(true){
            printMenu();
            int choice;
        }
    }

    public static void printMenu(){
        System.out.println("Chose an action:");
        System.out.println("1. Add Book");
        System.out.println("2. Remove Book");
        System.out.println("3. Search Book");

        System.out.println("0. Exit");
    }
}
