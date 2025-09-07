package HibernateExercises;

import HibernateExercises.Entity.Actor;
import HibernateExercises.Entity.Genre;
import HibernateExercises.Entity.Movie;
import HibernateExercises.Repository.ActorRepository;
import HibernateExercises.Repository.GenreRepository;
import HibernateExercises.Repository.MovieRepository;
import HibernateExercises.Util.HibernateUtil;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        //testGenre();
        testActor();
        testMovie();
    }

    public static void testGenre(){
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

    public static void testMovie(){
        GenreRepository genreRepository = new GenreRepository();
        ActorRepository actorRepository = new ActorRepository();
        MovieRepository movieRepository = new MovieRepository();
        Movie movie = new Movie();
        movie.setTitle("Interstellar");
        movie.setYearOfRelease(2014);
        movie.setGenre(genreRepository.read(3L));
        movie.setActors(List.of(actorRepository.read(1L)));
        movieRepository.update(movie);
        System.out.println("**********All Movies in DB:*********");
        movieRepository.findAll().forEach(System.out::println);
    }

    public static void testActor(){
        ActorRepository actorRepository = new ActorRepository();
        MovieRepository movieRepository = new MovieRepository();
        Actor actor = new Actor();
        actor.setName("Tom");
        actor.setLastName("Cruise");
        actor.setYearOfBirth(1962);
        actor.setMovies(movieRepository.findAll());
        actorRepository.update(actor);
        System.out.println("#########All actors in DB#########");
        actorRepository.findAll().forEach(System.out::println);
    }
}
