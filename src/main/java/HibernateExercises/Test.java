package HibernateExercises;

import HibernateExercises.Util.HibernateUtil;

public class Test {
    public static void main(String[] args) {
        HibernateUtil.getSessionFactory().openSession();
    }
}
