package application.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class HomePageController {

    private Stage dialogStage;

    private Main main;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCustomers;

    @FXML
    private Button btnOcupancies;

    @FXML
    private Button btnRooms;

    @FXML
    private Button btnPayments;

    @FXML
    private Button btnEmployees;

    @FXML
    private Button btnClose;

    @FXML
    void initialize() {

    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    private void handleCustomerRecords() {
        try {
            System.out.println("here");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/CustomerRecords.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            dialogStage = new Stage();
            dialogStage.setTitle("Ceil Inn - Customers Records");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(main.getPrimaryStage());
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            CustomerRecordController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            dialogStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleEmployeesRecords() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/EmployeesRecord.fxml"));
            Parent page = loader.load();
            dialogStage = new Stage();
            dialogStage.setTitle("Ceil Inn - Employess Records");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(main.getPrimaryStage());
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            EmployeesRecordController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            dialogStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void handleRoomsRecords() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/Rooms.fxml"));
            Parent page = loader.load();
            dialogStage = new Stage();
            dialogStage.setTitle("Ceil Inn - Rooms");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(main.getPrimaryStage());
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            RoomsController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            dialogStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleCancel() {
        main.getPrimaryStage().close();
    }
}
