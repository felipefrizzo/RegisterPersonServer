package br.univel.server.socket;

import br.univel.model.Customer;
import br.univel.model.Professional;
import br.univel.persistence.customer.CustomerService;
import br.univel.persistence.professional.ProfessionalService;
import br.univel.server.request.ReadCustomerRequest;
import br.univel.server.request.ReadProfessionalRequest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by felipefrizzo on 14/11/16.
 */
public class ReadRequest implements Runnable {

    private final Socket connection;
    private final CustomerService customerService = new CustomerService();
    private final ProfessionalService professionalService = new ProfessionalService();

    /**
     * Initializes a newly created instance of this type with specific arguments.
     *
     * @param connection
     */
    public ReadRequest(final Socket connection) {
        this.connection = connection;
    }

    @Override
    public void run() {
        Objects.requireNonNull(connection, "Connection cannot be null");

        try (ObjectInputStream input = new ObjectInputStream(this.connection.getInputStream());
             ObjectOutputStream output = new ObjectOutputStream(this.connection.getOutputStream())) {
            Object object = input.readObject();

            if (object instanceof Customer) {
                Customer customer = (Customer) object;
                output.writeObject(new ReadCustomerRequest(customer).read());
                output.flush();

            } else if (object instanceof Professional) {
                Professional professional = (Professional) object;
                output.writeObject(new ReadProfessionalRequest(professional).read());
                output.flush();
            }

        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
