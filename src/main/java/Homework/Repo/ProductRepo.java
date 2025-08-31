package Homework.Repo;

import Homework.Entity.Product;
import Homework.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProductRepo {

    public Product save(Product product){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(product);
            transaction.commit();
            return product;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }
}
