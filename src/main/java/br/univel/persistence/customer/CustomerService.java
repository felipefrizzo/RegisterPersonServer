package br.univel.persistence.customer;

import br.univel.model.Customer;
import br.univel.persistence.GenericDaoService;
import br.univel.persistence.SessionFactory;

import java.util.List;
import java.util.Objects;

/**
 * Created by felipefrizzo on 10/11/16.
 */
public class CustomerService implements GenericDaoService<Customer> {
    private final SessionFactory session = SessionFactory.getInstance();
    private final CustomerDao dao = new CustomerDao();

    @Override
    public void save(final Customer entity) {
        Objects.requireNonNull(entity, "Entity cannot be null");

        session.openSessionWithTransaction();
        dao.save(entity);
        session.closeSessionWithTransaction();
    }

    @Override
    public void update(final Customer entity) {
        Objects.requireNonNull(entity, "Entity cannot be null");

        session.openSessionWithTransaction();
        dao.update(entity);
        session.closeSessionWithTransaction();
    }

    @Override
    public void delete(final Customer entity) {
        Objects.requireNonNull(entity, "Entity cannot be null");

        session.openSessionWithTransaction();
        dao.delete(entity);
        session.closeSessionWithTransaction();
    }

    @Override
    public Customer getById(final Long id) {
        Objects.requireNonNull(id, "Id cannot be null");

        session.openSessionWithTransaction();
        Customer client = dao.getById(id);
        session.closeSessionWithTransaction();

        return client;
    }

    @Override
    public List<Customer> getAll() {
        session.openSessionWithTransaction();
        List<Customer> list = dao.getAll();
        session.closeSessionWithTransaction();

        return list;
    }
}
