package br.univel.view;

import br.univel.Main;
import br.univel.server.RegisterPersonServer;
import br.univel.server.RegisterPersonServerListener;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Created by felipefrizzo on 18/11/16.
 */
public class RootLayoutController implements RegisterPersonServerListener{
    private Main main;
    private RegisterPersonServer server;
    private final ScheduledExecutorService scheduled = Executors.newSingleThreadScheduledExecutor();

    /**
     * Set the server instance
     * @param server
     */
    public void setServer(final RegisterPersonServer server) {
        Objects.requireNonNull(server, "Server cannot be null");

        this.server = server;
    }

    /**
     * Set the main instance
     * @param main
     */
    public void setMain(final Main main) {
        Objects.requireNonNull(main, "Main class cannot be null");

        this.main = main;
    }

    /**
     * Start the server socket
     */
    public void start() {
        this.server.start();
        this.server.addListener(this);
    }

    @FXML
    private TextField textFieldVerify;

    @FXML
    private Circle circle;

    @FXML
    void handleRestartServer() {
        try {
            this.server.shoutdown();
            this.server.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void onKeyPressedVerifyServer(KeyEvent event) {
        textFieldVerify.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ENTER) {
                    server.getScheduledFuture().cancel(true);
                    server.verifyServer(Long.parseLong(textFieldVerify.getText()));
                }
            }
        });
    }

    @Override
    public void serverStarted(final RegisterPersonServer server) {
        circle.setFill(Color.GREEN);
    }

    @Override
    public void serverShutdown(final RegisterPersonServer server) {
        circle.setFill(Color.RED);
    }
}
