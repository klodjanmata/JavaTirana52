package HibernateExercises.Repository;

import HibernateExercises.Entity.Genre;
import HibernateExercises.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class GenreRepository {

    public Genre create(Genre genre){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(genre);
            transaction.commit();
            return genre;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return genre;
    }

    public Genre read(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Genre.class,id);
        }
    }

    public Genre update(Genre genre){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.merge(genre);
            transaction.commit();
            return genre;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return genre;
    }

    public Genre delete(Genre genre){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.remove(genre);
            transaction.commit();
            return genre;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return genre;
    }

    public List<Genre> findAll() {
        Transaction transaction = null;
        List<Genre> genres = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            // HQL query to fetch all Genre records
            genres = session.createQuery("from Genre", Genre.class).list();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        return genres;
    }
}