package HibernateExercises.Repository;

import HibernateExercises.Entity.Actor;
import HibernateExercises.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ActorRepository {

    public Actor create(Actor actor){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(actor);
            transaction.commit();
            return actor;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return actor;
    }

    public Actor read(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Actor.class,id);
        }
    }

    public Actor update(Actor actor){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.merge(actor);
            transaction.commit();
            return actor;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return actor;
    }

    public Actor delete(Actor actor){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.remove(actor);
            transaction.commit();
            return actor;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return actor;
    }

    public List<Actor> findAll() {
        Transaction transaction = null;
        List<Actor> actors = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            // HQL query to fetch all Actor records
            actors = session.createQuery("from Actor", Actor.class).list();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        return actors;
    }
}
