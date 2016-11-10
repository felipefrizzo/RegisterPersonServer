package br.univel.persistence;

import java.util.List;

/**
 * Created by felipefrizzo on 10/11/16.
 */
public interface AbstractDaoService<T> {

    void save(final T entity);

    void update(final T entity);

    void delete(final T entity);

    T getById(final Long id);

    List<T> getAll();
}
