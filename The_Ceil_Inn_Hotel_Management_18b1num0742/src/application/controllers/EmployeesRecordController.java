package application.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class EmployeesRecordController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<?> lvwEmployees;

    @FXML
    private Button btnClose;

    @FXML
    private Button btnNewEmployee;

    private Stage dialogStage;

    public void setDialogStage(javafx.stage.Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void closeDialogStage(){
        dialogStage.close();
    }

    @FXML
    private void handleNewEmployee() {
        try {
            System.out.println("here");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/NewEmployee.fxml"));
            Parent page = loader.load();

            Stage newEmployeeStage = new Stage();
            newEmployeeStage.setTitle("Ceil Inn - Customers Records");
            newEmployeeStage.initModality(Modality.WINDOW_MODAL);
            newEmployeeStage.initOwner(dialogStage);
            Scene scene = new Scene(page);
            newEmployeeStage.setScene(scene);
            NewEmployeeController controller = loader.getController();
            controller.setDialogStage(newEmployeeStage);
            newEmployeeStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void initialize() {

    }
}
