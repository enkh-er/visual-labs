package application.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CustomerRecordController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<?> lvwCustomers;

    @FXML
    private TableColumn<?, ?> colAccountNumber;

    @FXML
    private TableColumn<?, ?> colFirstName;

    @FXML
    private TableColumn<?, ?> colLastName;

    @FXML
    private TableColumn<?, ?> colPhoneNumber;

    @FXML
    private TableColumn<?, ?> colEmergencyName;

    @FXML
    private TableColumn<?, ?> colEmergencyPhone;

    @FXML
    private Button btnClose;

    @FXML
    private Button btnNewCustomer;

    private Stage dialogStage;

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void closeDialogStage(){
        dialogStage.close();
    }

    @FXML
    private void handleNewCustomer() {
        try {
            System.out.println("here");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/NewCustomerDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Stage newCustomerStage = new Stage();
            newCustomerStage.setTitle("Ceil Inn - Customers Records");
            newCustomerStage.initModality(Modality.WINDOW_MODAL);
            newCustomerStage.initOwner(dialogStage);
            Scene scene = new Scene(page);
            newCustomerStage.setScene(scene);
            NewCustomerController controller = loader.getController();
            controller.setDialogStage(newCustomerStage);
            newCustomerStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void initialize() {

    }

}
