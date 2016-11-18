package br.univel.view;

import br.univel.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.util.Objects;

/**
 * Created by felipefrizzo on 18/11/16.
 */
public class RootLayoutController {
    private Main main;

    public void setMain(final Main main) {
        Objects.requireNonNull(main, "Main class cannot be null");

        this.main = main;
    }

    @FXML
    private ImageView imgServer;

    @FXML
    private TextField textFieldVerify;

    @FXML
    void handleRestartServer(ActionEvent event) {

    }
}
