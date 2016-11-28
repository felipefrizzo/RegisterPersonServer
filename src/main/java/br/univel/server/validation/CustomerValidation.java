package br.univel.server.validation;

import br.univel.model.Customer;

import java.util.Objects;

/**
 * Created by felipefrizzo on 28/11/16.
 */
public class CustomerValidation implements GenericValidation<Customer> {

    @Override
    public String validation(final Customer object) {
        Objects.requireNonNull(object, "Object cannot be null");
        StringBuilder errorMessage = new StringBuilder();

        if (object.getName().isEmpty()) {
            errorMessage.append("Name cannot be empty\n");
        }
        if (object.getBirthday() == null) {
            errorMessage.append("Birthday cannot be empty\n");
        }
        if (object.getCpf().isEmpty()) {
            errorMessage.append("Cpf cannot be empty\n");
        }
        if (object.getRg().isEmpty()) {
            errorMessage.append("Rg cannot be empty\n");
        }

        if (errorMessage.length() > 0) {
            return errorMessage.toString();
        } else {
            return null;
        }
    }
}
