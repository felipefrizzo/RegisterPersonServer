package br.univel.server.request;

import br.univel.model.Customer;
import br.univel.model.ErrorMessage;
import br.univel.persistence.customer.CustomerService;
import br.univel.server.validation.CustomerValidation;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by felipefrizzo on 24/11/16.
 */
public class ReadCustomerRequest implements GenericReadRequest {
    private final Customer customer;
    private final CustomerService service = new CustomerService();
    private final CustomerValidation validation = new CustomerValidation();
    private final ErrorMessage errorMessage = new ErrorMessage();

    /**
     * Initializes a newly created instance of this type with specific arguments.
     *
     * @param customer
     */
    public ReadCustomerRequest(final Customer customer) {
        Objects.requireNonNull(customer, "Customer cannot be null");

        this.customer = customer;
    }

    @Override
    public Object read() {
        Object object;
        String error;

        switch (this.customer.getOperationType()) {
            case POST:
                error = validation.validation(this.customer);

                if (error == null) {
                    service.save(this.customer);
                    errorMessage.setError(false);
                } else {
                    errorMessage.setError(true);
                    errorMessage.setErrorText(error);
                }

                object = errorMessage;
                break;
            case PUT:
                error = validation.validation(this.customer);

                if (error == null) {
                    service.update(this.customer);
                    errorMessage.setError(false);
                } else {
                    errorMessage.setError(true);
                    errorMessage.setErrorText(error);
                }

                object = errorMessage;
                break;
            case DELETE:
                service.delete(this.customer);
                errorMessage.setError(false);

                object = errorMessage;
                break;
            case GET:
                ArrayList<Customer> customers = (ArrayList<Customer>) service.getAll();
                object = customers;
                break;
            case GETBYID:
                if (this.customer.getId() == null) {
                    errorMessage.setError(true);
                    errorMessage.setErrorText("Do not have Customer with this Id");

                    object = errorMessage;
                } else {
                    object = service.getById(this.customer.getId());
                }
                break;
            default:
                throw new RuntimeException("Type cannot be found.");
        }

        return object;
    }
}
