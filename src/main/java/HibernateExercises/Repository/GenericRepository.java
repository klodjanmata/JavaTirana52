package HibernateExercises.Repository;

import HibernateExercises.Entity.Actor;
import HibernateExercises.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

public class GenericRepository<T, ID extends Serializable> {
    private final Class<T> entityClass;

    public GenericRepository(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public T create(T entity) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(entity);
            tx.commit();
            return entity;
        }
    }

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

    public T read(ID id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(entityClass, id);
        }
    }

    public T update(T entity) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.merge(entity);
            tx.commit();
            return entity;
        }
    }

    public void delete(T entity) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.remove(entity);
            tx.commit();
        }
    }

    public List<T> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from " + entityClass.getSimpleName(), entityClass).list();
        }
    }
}
