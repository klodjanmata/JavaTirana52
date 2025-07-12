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

    public void printBookList(){
        System.out.println(getHeader());
        for (Book book : books) {
            System.out.println(book.toString());
        }
    }

    public String getHeader(){
        return "ISBN\tTitle\tYearOfRelease\tPrice\tGenre\tAuthor";
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
        Author author = new Author();
        author.setFirstname(Helper.getStringFromUser("Authors Firstname"));
        author.setLastname(Helper.getStringFromUser("Authors Lastname"));
        book.setAuthor(author);
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
