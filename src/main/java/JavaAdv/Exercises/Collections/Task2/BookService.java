package JavaAdv.Exercises.Collections.Task2;

import JavaAdv.Exercises.Helper;

import java.util.ArrayList;
import java.util.List;

public class BookService {
    List<Book> books;

    public BookService(){
        books = new ArrayList<>();
    }

    public BookService(List<Book> books) {
        this.books = books;
    }

    public void add() {
        Book book = new Book();
        System.out.println("Enter necessary parameters: ");
        book.setTitle(Helper.getStringFromUser("Title"));
        book.setIsbn(Helper.getStringFromUser("ISBN"));
        book.setYearOfRelease(Helper.getIntFromUser("YearOfRelease"));
        book.setPrice(Helper.getIntFromUser("Price"));
        printAllGenres();
        while(true){
            try{
                book.setGenre(Genre.valueOf(Helper.getStringFromUser("Genre").toUpperCase()));
                break;
            }catch (Exception e){
                System.out.println("Error in setting genre, try again");
            }
        }
        books.add(book);
        System.out.println("Book added successfully");
    }

    public void printAllGenres() {
        StringBuilder result = new StringBuilder("[ ");

        for (Genre genre : Genre.values()) {
            result.append(genre.name());  // or just 'genre'
            result.append(", ");
        }

        if (result.length() > 2) {
            result.setLength(result.length() - 2); // remove last comma and space
        }

        result.append(" ]");

        System.out.println(result);
    }



}
