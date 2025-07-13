package JavaAdv.Exercises.Collections.Task2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BooksCsvUtil {
    private final String FILEPATH = "Files/Books.csv";
    private final String SEPARATOR = ",";

    public void writeToFile(List<Book> bookList) {
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILEPATH));
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
        List<Book> resultList = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(FILEPATH))){
            reader.readLine();
            String line;
            while((line = reader.readLine()) != null){
                String[] fields = line.split(SEPARATOR);
                Book b = new Book();
                b.setIsbn(fields[0]);
                b.setTitle(fields[1]);
                b.setYearOfRelease(Integer.parseInt(fields[2]));
                b.setPrice(Integer.parseInt(fields[3]));
                b.setGenre(Genre.valueOf(fields[4]));
                Author author = new Author();
                author.setFirstname(fields[5]);
                author.setLastname(fields[6]);
                b.setAuthor(author);
                resultList.add(b);
            }
            reader.close();
            System.out.println("Books read successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultList;
    }

    public String getHeader(){
        return "ISBN,Title,YearOfRelease,Price,Genre,AuthorFirstname,AuthorLastname";
    }
}
