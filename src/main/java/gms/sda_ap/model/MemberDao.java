package gms.sda_ap.model;

import gms.sda_ap.controller.customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MemberDao {

    public void saveMember(customer c) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(c);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
