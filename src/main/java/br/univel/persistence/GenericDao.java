package br.univel.persistence;

import java.util.List;

/**
 * Created by felipefrizzo on 10/11/16.
 */
public interface GenericDao<T> {

    /**
     * Insert a new Object into the database.
     *
     * @param entity
     */
    void save(final T entity);

    /**
     * Update the state of Object.
     *
     * @param entity
     */
    void update(final T entity);

    /**
     * Delete a Object from the database.
     *
     * @param entity
     */
    void delete(final T entity);

    /**
     * Find Object by ID.
     *
     * @param id
     * @return
     */
    T getById(final Long id);

    /**
     * Find all Objects in the database.
     *
     * @return
     */
    List<T> getAll();
}
