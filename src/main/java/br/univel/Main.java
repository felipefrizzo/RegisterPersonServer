package br.univel;

import br.univel.server.RegisterPersonServer;
import br.univel.server.socket.ServerSocket;
import br.univel.view.RootLayoutController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/**
 * Created by felipefrizzo on 10/11/16.
 */
public class Main extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private final RegisterPersonServer server = new ServerSocket(8080);

    public static void main(final String[] args) {
        launch(args);
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    @Override
    public void start(final Stage primaryStage) throws Exception {
        Objects.requireNonNull(primaryStage, "Stage cannot be null");

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Register Person Server Application");

        this.server.verifyServer(10L);
        initRootLayout();
    }

    private void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));

            rootLayout = loader.load();

            primaryStage.setScene(new Scene(rootLayout));

            RootLayoutController controller = loader.getController();
            controller.setMain(this);
            controller.setServer(server);
            controller.start();

            primaryStage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
