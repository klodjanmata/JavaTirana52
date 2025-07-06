package JavaAdv.Exercises.Collections.Task2;

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

    public void add(Book book) {
        books.add(book);
    }



}
