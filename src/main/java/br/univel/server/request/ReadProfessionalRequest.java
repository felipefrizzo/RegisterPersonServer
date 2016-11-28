package br.univel.server.request;

import br.univel.cryptography.Cryptography;
import br.univel.model.ErrorMessage;
import br.univel.model.Professional;
import br.univel.persistence.professional.ProfessionalService;
import br.univel.server.validation.ProfessionalValidation;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by felipefrizzo on 24/11/16.
 */
public class ReadProfessionalRequest implements GenericReadRequest {
    private final Professional professional;
    private final ProfessionalService service = new ProfessionalService();
    private final ProfessionalValidation validation = new ProfessionalValidation();
    private final ErrorMessage errorMessage = new ErrorMessage();

    /**
     * Initializes a newly created instance of this type with specific arguments.
     *
     * @param professional
     */
    public ReadProfessionalRequest(final Professional professional) {
        Objects.requireNonNull(professional, "Customer cannot be null");

        this.professional = professional;
    }

    @Override
    public Object read() {
        Object object;
        String error;

        switch (this.professional.getOperationType()) {
            case POST:
                error = validation.validation(this.professional);

                if (error == null) {
                    this.professional.setPassword(new Cryptography().createCryptography(this.professional.getPassword()));
                    service.save(this.professional);
                    errorMessage.setError(false);
                } else {
                    errorMessage.setError(true);
                    errorMessage.setErrorText(error);
                }

                object = errorMessage;
                break;
            case PUT:
                error = validation.validation(this.professional);

                if (error == null) {
                    this.professional.setPassword(new Cryptography().createCryptography(this.professional.getPassword()));
                    service.update(this.professional);
                    errorMessage.setError(false);
                } else {
                    errorMessage.setError(true);
                    errorMessage.setErrorText(error);
                }

                object = errorMessage;
                break;
            case DELETE:
                service.delete(this.professional);
                errorMessage.setError(false);
                object = errorMessage;
                break;
            case GET:
                ArrayList<Professional> professionals = (ArrayList<Professional>) service.getAll();
                object = professionals;
                break;
            case GETBYID:
                if (this.professional.getId() == null) {
                    errorMessage.setError(true);
                    errorMessage.setErrorText("Do not have Professional with this Id");

                    object = errorMessage;
                } else {
                    object = service.getById(this.professional.getId());
                }
                break;
            case GETBYUSERNAME:
                if (this.professional.getUsername().isEmpty()) {
                    errorMessage.setError(true);
                    errorMessage.setErrorText("Do not have Professional with this Usernmae");

                    object = errorMessage;
                } else {
                    object = service.getByUsername(this.professional.getUsername());
                }
                break;
            case LOGIN:
                if (this.professional.getUsername().isEmpty() || this.professional.getPassword().isEmpty()) {
                    errorMessage.setError(true);
                    errorMessage.setErrorText("Do not have Professional with this Usernmae or Password Invalid");

                    object = errorMessage;
                } else {
                    this.professional.setPassword(new Cryptography().createCryptography(this.professional.getPassword()));
                    Professional getProfessional = service.getByUsername(this.professional.getUsername());

                    if (getProfessional == null) {
                        errorMessage.setError(true);
                        errorMessage.setErrorText("The username is invalid.");

                        object = errorMessage;
                    } else if (getProfessional.getPassword().equals(this.professional.getPassword())) {
                        errorMessage.setError(false);
                        object = errorMessage;
                    } else {
                        errorMessage.setError(true);
                        errorMessage.setErrorText("The password is invalid.");

                        object = errorMessage;
                    }
                }
                break;
            default:
                throw new RuntimeException("Type cannot be found.");
        }

        return object;
    }
}
