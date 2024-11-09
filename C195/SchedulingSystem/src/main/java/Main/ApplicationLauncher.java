package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import DAO.Database;

import java.util.Locale;
import java.util.ResourceBundle;

public class ApplicationLauncher extends Application {



    @Override
    public void start(Stage stage) {
        Database.openConnection(); // Open the connection at the start
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ApplicationLauncher.class.getResource("Login.fxml"));
            ResourceBundle bundle = ResourceBundle.getBundle("Language.MessagesBundle", Locale.getDefault());
            fxmlLoader.setResources(bundle);
            Scene scene = new Scene(fxmlLoader.load(), 800, 800);
            stage.setTitle("Login");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void stop() {
        Database.closeConnection(); // Close the connection on exit
    }


    public static void main(String[] args) {
        launch();
    }
}
