package br.univel.view;

import br.univel.Main;
import br.univel.server.RegisterPersonServer;
import br.univel.server.RegisterPersonServerListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.util.Objects;

/**
 * Created by felipefrizzo on 18/11/16.
 */
public class RootLayoutController implements RegisterPersonServerListener{
    private Main main;
    private RegisterPersonServer server;

    public void setServer(final RegisterPersonServer server) {
        this.server = server;
    }

    public void setMain(final Main main) {
        Objects.requireNonNull(main, "Main class cannot be null");

        this.main = main;
    }

    public void start() {
        this.server.start();
        this.server.addListener(this);
    }

    @FXML
    private ImageView imgServer;

    @FXML
    private TextField textFieldVerify;

    @FXML
    void handleRestartServer(final ActionEvent event) {

    }

    @Override
    public void serverStarted(RegisterPersonServer server) {

    }

    @Override
    public void serverShutdown(RegisterPersonServer server) {

    }
}
