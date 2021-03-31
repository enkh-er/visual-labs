package application.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewCustomerController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtAccountNumber;

    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtPhoneNumber;

    @FXML
    private TextField txtEmergencyName;

    @FXML
    private TextField txtEmergencyPhone;

    @FXML
    private Button btnOK;

    @FXML
    private Button btnCancel;

    private Stage dialogStage;

    public void setDialogStage(javafx.stage.Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void closeDialogStage(){
        dialogStage.close();
    }
    @FXML
    void initialize() {

    }
}
