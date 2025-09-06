package HibernateExercises.Repository;

import HibernateExercises.Entity.Movie;
import HibernateExercises.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class MovieRepository {
    public Movie save(Movie movie){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(movie);
            transaction.commit();
            return movie;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return movie;
    }

    public Movie delete(Movie movie){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.remove(movie);
            transaction.commit();
            return movie;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return movie;
    }

    public Movie update(Movie movie){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.merge(movie);
            transaction.commit();
            return movie;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return movie;
    }

    public Movie readById(String id) {
        Transaction transaction = null;
        Movie movie = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            // Loads one Movie record with all its columns
            movie = session.get(Movie.class, id);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        return movie;
    }



    public List<Movie> findAll() {
        Transaction transaction = null;
        List<Movie> movies = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            // HQL query to fetch all Movie records
            movies = session.createQuery("from Movie", Movie.class).list();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        return movies;
    }

}
