package br.univel.persistence;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Created by felipefrizzo on 10/11/16.
 */
public final class SessionFactory {

    private Session session;
    private Transaction transaction;
    private static org.hibernate.SessionFactory sessionFactory;
    private static SessionFactory instance;

    private SessionFactory() {
    }

    /**
     *
     * @return the current value of the Instance.
     */
    public static SessionFactory getInstance() {
        synchronized (SessionFactory.class) {
            if (instance == null) {
                instance = new SessionFactory();
                configHibernateFactory();
            }
        }

        return instance;
    }

    /**
     * Method to configuration the Hibernate SessionFactory.
     */
    public static void configHibernateFactory() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    /**
     * Open only Session
     */
    public Session openSession() {
        session = sessionFactory.openSession();
        return session;
    }

    /**
     * Open Session with Transaction
     */
    public Session openSessionWithTransaction() {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        return session;
    }

    /**
     * Close only Session.
     */
    public void closeSession() {
        session.close();
    }

    /**
     * Close Session and Transaction.
     */
    public void closeSessionWithTransaction() {
        transaction.commit();
        session.close();
    }

    /**
     *
     * @return The current value of this Session
     */
    public Session getSession() {
        return session;
    }

    /**
     *
     * @return The current value of this Transition
     */
    public Transaction getTrasation() {
        return transaction;
    }

}
