package br.univel.server;

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

}
