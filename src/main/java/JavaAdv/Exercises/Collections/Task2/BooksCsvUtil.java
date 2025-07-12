package JavaAdv.Exercises.Collections.Task2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class BooksCsvUtil {
    private final String FILEPATH = "Files/Books.csv";
    private final String SEPARATOR = ", ";

    public void writeToFile(List<Book> bookList) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILEPATH))){
            writer.write(getHeader());
            for(Book b : bookList){
                writer.newLine();
                writer.write(b.getIsbn() + SEPARATOR);
                writer.write(b.getTitle() + SEPARATOR);
                writer.write(b.getYearOfRelease() + SEPARATOR);
                writer.write(b.getPrice() + SEPARATOR);
                writer.write(b.getGenre().name() + SEPARATOR);
                writer.write(b.getAuthor().getFirstname() + SEPARATOR);
                writer.write(b.getAuthor().getLastname());
            }
            writer.close();
            System.out.println("Books written successfully");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    public List<Book> readFromFile() {
        return null;
    }

    public String getHeader(){
        return "ISBN,Title,YearOfRelease,Price,Genre,AuthorFirstname,AuthorLastname";
    }
}
