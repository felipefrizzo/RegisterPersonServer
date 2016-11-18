package br.univel.persistence.client;

import br.univel.model.Client;
import br.univel.persistence.GenericDao;
import br.univel.persistence.SessionFactory;

import java.util.List;

/**
 * Created by felipefrizzo on 10/11/16.
 */
public class ClientDao implements GenericDao<Client> {
    private final static SessionFactory session = SessionFactory.getInstance();

    @Override
    public void save(final Client entity) {
        session.getSession().save(entity);
    }

    @Override
    public void update(final Client entity) {
        session.getSession().update(entity);
    }

    @Override
    public void delete(final Client entity) {
        session.getSession().delete(entity);
    }

    @Override
    public Client getById(final Long id) {
        Client client = session.getSession().get(Client.class, id);
        return client;
    }

    @Override
    public List<Client> getAll() {
        List<Client> list = session.getSession().createQuery("from Client").list();
        return list;
    }
}
