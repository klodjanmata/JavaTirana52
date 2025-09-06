package HibernateExercises;

import HibernateExercises.Entity.Genre;
import HibernateExercises.Repository.GenreRepository;

import java.util.List;

public class TestGenre {
    public static void main(String[] args) {
        Genre genre = new Genre();
        genre.setName("Thriller");
        Genre genre1 = new Genre();
        genre1.setName("Horror");
        Genre genre2 = new Genre();
        genre2.setName("Science Fiction");

        GenreRepository genreRepository = new GenreRepository();
        genreRepository.create(genre);
        genreRepository.create(genre1);
        genreRepository.create(genre2);

        System.out.println("All genres in DB:");
        List<Genre> genres = genreRepository.findAll();
        genres.forEach(System.out::println);

        System.out.println("#####READ#######");
        Genre theGenre = genreRepository.read(genre.getId());
        System.out.println(theGenre.toString());

        System.out.println("#####UPDATE#######");
        genre.setName("Drama");
        genreRepository.update(genre);
        System.out.println(genreRepository.read(genre.getId()).toString());

        System.out.println("#####DELETE#######");
        genreRepository.delete(genre1);

        System.out.println("All genres in DB:");
        List<Genre> finalGenres = genreRepository.findAll();
        finalGenres.forEach(System.out::println);

    }
}
