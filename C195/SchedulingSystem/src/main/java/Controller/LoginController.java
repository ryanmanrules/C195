package Controller;

import DAO.Database;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.util.Locale;
import java.util.ResourceBundle;

public class LoginController {
    private ResourceBundle bundle;

    @FXML
    private TextField userNameEntry;

    @FXML
    private PasswordField passwordEntry;

    @FXML
    private Label logInErrorLog;

    @FXML
    private Label timeZoneLabel;

    @FXML
    private Button logInButton;

    @FXML
    public void initialize() {
        Locale locale = Locale.getDefault();
        bundle = ResourceBundle.getBundle("lynch.resources.Language.MessagesBundle", locale);

        logInButton.setText(bundle.getString("login_button"));
        timeZoneLabel.setText(bundle.getString("timezone_label") + ": " + java.time.ZoneId.systemDefault().toString());
    }

    @FXML
    private void onLoginButtonClicked() {
        String username = userNameEntry.getText();
        String password = passwordEntry.getText();

        if (Database.validateUserCredentials(username, password)) {
            logInErrorLog.setText(bundle.getString("login_success"));
            // Code to transition to the main application screen
        } else {
            logInErrorLog.setText(bundle.getString("login_error"));
        }
    }
}
