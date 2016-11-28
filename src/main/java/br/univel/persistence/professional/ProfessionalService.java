package br.univel.persistence.professional;

import br.univel.model.Professional;
import br.univel.persistence.GenericDaoService;
import br.univel.persistence.SessionFactory;

import java.util.List;
import java.util.Objects;

/**
 * Created by felipefrizzo on 23/11/16.
 */
public class ProfessionalService implements GenericDaoService<Professional> {
    private final SessionFactory session = SessionFactory.getInstance();
    private final ProfessionalDao dao = new ProfessionalDao();

    @Override
    public void save(final Professional entity) {
        Objects.requireNonNull(entity, "Entity cannot be null");

        session.openSessionWithTransaction();
        dao.save(entity);
        session.closeSessionWithTransaction();
    }

    @Override
    public void update(final Professional entity) {
        Objects.requireNonNull(entity, "Entity cannot be null");

        session.openSessionWithTransaction();
        dao.update(entity);
        session.closeSessionWithTransaction();
    }

    @Override
    public void delete(final Professional entity) {
        Objects.requireNonNull(entity, "Entity cannot be null");

        session.openSessionWithTransaction();
        dao.delete(entity);
        session.closeSessionWithTransaction();
    }

    @Override
    public Professional getById(final Long id) {
        Objects.requireNonNull(id, "Id cannot be null");

        session.openSessionWithTransaction();
        Professional professional = dao.getById(id);
        session.closeSessionWithTransaction();

        return professional;
    }

    @Override
    public List<Professional> getAll() {
        session.openSessionWithTransaction();
        List<Professional> list = dao.getAll();
        session.closeSessionWithTransaction();

        return list;
    }

    public Professional getByUsername(final String username) {
        Objects.requireNonNull(username, "Username cannot be null");

        session.openSessionWithTransaction();
        Professional professional = dao.getByUsername(username);
        session.closeSessionWithTransaction();

        return professional;
    }
}
