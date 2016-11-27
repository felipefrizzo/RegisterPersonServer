package br.univel.server.socket;

import br.univel.server.RegisterPersonServer;
import br.univel.server.RegisterPersonServerListener;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by felipefrizzo on 10/11/16.
 */
public class ServerSocket implements RegisterPersonServer, Runnable {

    private final Integer port;
    private java.net.ServerSocket server;
    private final Executor pool = Executors.newFixedThreadPool(8);
    private final List<RegisterPersonServerListener> listeners = new ArrayList<>();

    public ServerSocket(final Integer port) {
        this.port = port;
    }

    @Override
    public void addListener(final RegisterPersonServerListener listener) {
        this.listeners.add(listener);
    }

    @Override
    public void removeListener(final RegisterPersonServerListener listener) {
        this.listeners.remove(listener);
    }

    @Override
    public void start() {
        Objects.requireNonNull(this.port, "Port cannot be null");

        new Thread(this).start();
    }

    @Override
    public void shoutdown() throws IOException {
        if (this.server != null || !this.server.isClosed()) {
            this.server.close();
            this.listeners.forEach(listner -> listner.serverShutdown(this));
        }
    }

    @Override
    public void run() {
        try {
            this.server = new java.net.ServerSocket(this.port);
            this.listeners.forEach(listener -> listener.serverStarted(this));

            while(!server.isClosed()) {
                Socket connection = server.accept();
                this.pool.execute(
                    new ReadRequest(connection)
                );
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
