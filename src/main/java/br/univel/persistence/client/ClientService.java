package br.univel.persistence.client;

import br.univel.model.Client;
import br.univel.persistence.AbstractDaoService;
import br.univel.persistence.SessionFactory;

import java.util.List;
import java.util.Objects;

/**
 * Created by felipefrizzo on 10/11/16.
 */
public class ClientService implements AbstractDaoService<Client> {
    private final static SessionFactory session = SessionFactory.getInstance();
    private final static ClientDao dao = new ClientDao();

    @Override
    public void save(final Client entity) {
        Objects.requireNonNull(entity, "Entity cannot be null");

        session.openSessionWithTransaction();
        dao.save(entity);
        session.closeSessionWithTransaction();
    }

    @Override
    public void update(final Client entity) {
        Objects.requireNonNull(entity, "Entity cannot be null");

        session.openSessionWithTransaction();
        dao.update(entity);
        session.closeSessionWithTransaction();
    }

    @Override
    public void delete(final Client entity) {
        Objects.requireNonNull(entity, "Entity cannot be null");

        session.openSessionWithTransaction();
        dao.delete(entity);
        session.closeSessionWithTransaction();
    }

    @Override
    public Client getById(final Long id) {
        Objects.requireNonNull(id, "Id cannot be null");

        session.openSessionWithTransaction();
        Client client = dao.getById(id);
        session.closeSessionWithTransaction();

        return client;
    }

    @Override
    public List<Client> getAll() {
        session.openSessionWithTransaction();
        List<Client> list = dao.getAll();
        session.closeSessionWithTransaction();

        return list;
    }
}
