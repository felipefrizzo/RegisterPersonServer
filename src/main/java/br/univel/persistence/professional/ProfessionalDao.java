package br.univel.persistence.professional;

import br.univel.model.Professional;
import br.univel.persistence.GenericDao;
import br.univel.persistence.SessionFactory;

import java.util.List;

/**
 * Created by felipefrizzo on 23/11/16.
 */
public class ProfessionalDao implements GenericDao<Professional> {
    private final SessionFactory session = SessionFactory.getInstance();

    @Override
    public void save(final Professional entity) {
        session.getSession().save(entity);
    }

    @Override
    public void update(final Professional entity) {
        session.getSession().update(entity);
    }

    @Override
    public void delete(final Professional entity) {
        session.getSession().delete(entity);
    }

    @Override
    public Professional getById(final Long id) {
        return session.getSession().get(Professional.class, id);
    }

    @Override
    public List<Professional> getAll() {
        return (List<Professional>) session.getSession().createQuery("from Professional").list();
    }

    public Professional getByUsername(final String username) {
        return (Professional) session.getSession()
                .createQuery("from Professional where username=:username")
                .setParameter("username", username)
                .uniqueResult();
    }
}
