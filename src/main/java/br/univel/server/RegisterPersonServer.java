package br.univel.server;

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
    void shoudown();
}
