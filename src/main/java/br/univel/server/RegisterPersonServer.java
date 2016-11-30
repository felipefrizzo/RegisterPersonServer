package br.univel.server;

import java.io.IOException;

/**
 * Created by felipefrizzo on 10/11/16.
 */
public interface RegisterPersonServer {

    /**
     * Add listener on server to receive notifications.
     *
     * @param listener
     */
    void addListener(final RegisterPersonServerListener listener);

    /**
     * Remove the listener not to receive notifications.
     *
     * @param listener
     */
    void removeListener(final RegisterPersonServerListener listener);

    /**
     * Start server.
     */
    void start();

    /**
     * Shutdown server when started.
     */
    void shoutdown() throws IOException;

    /**
     * Create Thread to verify the server status.
     * @param time
     */
    void verifyServer(final Long time);
}
