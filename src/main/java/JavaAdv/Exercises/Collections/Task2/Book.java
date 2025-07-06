package JavaAdv.Exercises.Collections.Task2;

import java.util.Objects;

public class Book {
    private String isbn;
    private String title;
    private int price;
    private int yearOfRelease;
    private Author author;
    private Genre genre;

    public Book(){}

    public Book(String isbn, String title, int price, int yearOfRelease,
                Author author, Genre genre) {
        this.isbn = isbn;
        this.title = title;
        this.price = price;
        this.yearOfRelease = yearOfRelease;
        this.author = author;
        this.genre = genre;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Book book)) return false;
        return price == book.price && yearOfRelease == book.yearOfRelease && Objects.equals(isbn, book.isbn) && Objects.equals(title, book.title) && Objects.equals(author, book.author) && genre == book.genre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, title, price, yearOfRelease, author, genre);
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", yearOfRelease=" + yearOfRelease +
                ", author=" + author +
                ", genre=" + genre +
                '}';
    }
}
