module lynch.resources {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;

    opens Main to javafx.fxml;
    exports Main;
    exports Controller;
    opens Controller to javafx.fxml;
    exports DAO;
    opens DAO to javafx.fxml;
}