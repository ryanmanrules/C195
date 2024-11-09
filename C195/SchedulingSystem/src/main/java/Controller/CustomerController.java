package Controller;

import DAO.Database;
import Model.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

//methods for loading existing customers, adding new customers, updating details, and deleting records.

public class CustomerController {
    @FXML private TextField customerNameField;
    @FXML private TextField addressField;
    @FXML private TextField postalCodeField;
    @FXML private TextField phoneField;
    @FXML private TextField divisionIdField;
    @FXML private TableView<Customer> customerTable;
    @FXML private TableColumn<Customer, Integer> customerIdColumn;
    @FXML private TableColumn<Customer, String> customerNameColumn;
    @FXML private TableColumn<Customer, String> addressColumn;
    @FXML private TableColumn<Customer, String> postalCodeColumn;
    @FXML private TableColumn<Customer, String> phoneColumn;
    @FXML private TableColumn<Customer, String> divisionColumn;


    @FXML
    public void addCustomer() {
        String name = customerNameField.getText();
        String address = addressField.getText();
        String postalCode = postalCodeField.getText();
        String phone = phoneField.getText();
        // Fetch division selection
        int divisionId = 0; // logic to retrieve ID from divisionComboBox
        boolean success = Database.addCustomer(name, address, postalCode, phone, divisionId);
        if (success) {
            loadCustomerData();
        } else {
            System.out.println("Failed to add customer.");
        }
    }

    private void loadCustomerData() {
    }

    public void updateCustomer(ActionEvent actionEvent) {
    }

    public void deleteCustomer(ActionEvent actionEvent) {
    }
}
