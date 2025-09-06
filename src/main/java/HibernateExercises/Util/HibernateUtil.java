package HibernateExercises.Util;

import CarRentalSystem.Entity.Client;
import HibernateExercises.Entity.Actor;
import HibernateExercises.Entity.Genre;
import HibernateExercises.Entity.Movie;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    public static SessionFactory buildSessionFactory() {
        try{
            return new Configuration()
                    .configure("hibernateexercises.cfg.xml")
                    .addAnnotatedClass(Genre.class)
                    .addAnnotatedClass(Actor.class)
                    .addAnnotatedClass(Movie.class)
                    .buildSessionFactory();
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        sessionFactory.close();
    }

}

