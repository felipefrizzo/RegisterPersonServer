package br.univel.server;

import br.univel.model.Client;
import br.univel.model.Professional;

/**
 * Created by felipefrizzo on 10/11/16.
 */
public interface RegisterPersonServerListener {

    /**
     * Notify when the server has been started.
     *
     * @param server
     */
    void serverStarted(final RegisterPersonServer server);

    /**
     * Notify when the server has been disconnected.
     *
     * @param server
     */
    void serverShutdown(final RegisterPersonServer server);

    /**
     * Notify when server receives a Professional CRUD from client.
     *
     * @param professional
     */
    void professionalReceived(final Professional professional);

    /**
     * Notify when server receives a Client CRUD from client.
     *
     * @param client
     */
    void clientReceived(final Client client);
}
