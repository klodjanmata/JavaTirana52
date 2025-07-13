package JavaAdv.Exercises.Generics.Task4;

public class Main {
    public static void main(String[] args) {
        MediaLibrary<Book> bookMediaLibrary = new MediaLibrary();
        MediaLibrary<Movie> movieMediaLibrary = new MediaLibrary();
        MediaLibrary<Newspaper> newspaperMediaLibrary = new MediaLibrary();
        MediaLibrary<Magazine> magazineMediaLibrary = new MediaLibrary();

        Book book = new Book();
        Movie movie = new Movie();
        Newspaper newspaper = new Newspaper();

        bookMediaLibrary.add(book);
        bookMediaLibrary.add(newspaper);
    }
}
