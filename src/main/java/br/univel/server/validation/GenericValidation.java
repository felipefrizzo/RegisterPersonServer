package br.univel.server.validation;

/**
 * Created by felipefrizzo on 28/11/16.
 */
public interface GenericValidation<T> {
    /**
     * Validate object.
     * @param object
     * @return the error message
     */
    String validation(final T object);
}
