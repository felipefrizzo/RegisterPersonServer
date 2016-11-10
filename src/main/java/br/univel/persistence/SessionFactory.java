package br.univel.persistence;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Created by felipefrizzo on 10/11/16.
 */
public class SessionFactory {

    private Session session;
    private Transaction transaction;
    private static org.hibernate.SessionFactory sessionFactory;
    private static SessionFactory instance;

    private SessionFactory() {
    }

    public static SessionFactory getInstance() {
        if (instance == null) {
            instance = new SessionFactory();
            configHibernateFactory();
        }

        return instance;
    }

    public static void configHibernateFactory() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public Session openSession() {
        session = sessionFactory.openSession();
        return session;
    }

    public Session openSessionWithTransaction() {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        return session;
    }

    public void closeSession() {
        session.close();
    }

    public void closeSessionWithTransaction() {
        transaction.commit();
        session.close();
    }

    public Session getSession() {
        return session;
    }

    public Transaction getTrasation() {
        return transaction;
    }

}
