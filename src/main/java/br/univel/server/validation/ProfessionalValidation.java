package br.univel.server.validation;

import br.univel.model.Professional;

import java.util.Objects;

/**
 * Created by felipefrizzo on 28/11/16.
 */
public class ProfessionalValidation implements GenericValidation<Professional> {
    @Override
    public String validation(final Professional object) {
        Objects.requireNonNull(object, "Object cannot be null");
        StringBuilder errorMessage = new StringBuilder();

        if (object.getName().isEmpty()) {
            errorMessage.append("Name cannot be empty\n");
        }
        if (object.getBirthday() == null) {
            errorMessage.append("Birthday cannot be empty\n");
        }
        if (object.getUsername().isEmpty()) {
            errorMessage.append("Username cannot be empty\n");
        }
        if (object.getPassword().isEmpty()) {
            errorMessage.append("Password cannot be empty\n");
        }
        if (object.getPassword().length() < 6) {
            errorMessage.append("Your password cannot be less than 6 digits\n");
        }

        if (errorMessage.length() > 0) {
            return errorMessage.toString();
        } else {
            return null;
        }
    }
}
