package br.univel.persistence.customer;

import br.univel.model.Customer;
import br.univel.persistence.GenericDao;
import br.univel.persistence.SessionFactory;

import java.util.List;

/**
 * Created by felipefrizzo on 10/11/16.
 */
public class CustomerDao implements GenericDao<Customer> {
    private final SessionFactory session = SessionFactory.getInstance();

    @Override
    public void save(final Customer entity) {
        session.getSession().save(entity);
    }

    @Override
    public void update(final Customer entity) {
        session.getSession().update(entity);
    }

    @Override
    public void delete(final Customer entity) {
        session.getSession().delete(entity);
    }

    @Override
    public Customer getById(final Long id) {
        return session.getSession().get(Customer.class, id);
    }

    @Override
    public List<Customer> getAll() {
        return (List<Customer>) session.getSession().createQuery("from Customer").list();
    }
}
