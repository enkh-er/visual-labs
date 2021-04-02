package application.controllers;

import java.io.IOException;
import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class HomePageController {

    private Stage dialogStage;

    private Main main;

    @FXML
    void initialize() {
    }

    /**
     * Main classiig onoono
     * @param main = programiin vndsen main class
     */
    public void setMain(Main main) {
        this.main = main;
    }

    /**
     * Hereglegchiin medeelliig haruulah tsonhiig vvsgene
     */
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

    /**
     * Ajilchnii medeelliig haruulah tsonhiig vvsgene
     */
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

    /**
     * Oroonii medeelliig haruulah tsonhiig vvsgene
     */
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

    /**
     * Tvreeslegdsen oroonii medeelliig haruulah tsonhiig vvsgene
     */
    @FXML
    private void handleOccupancies() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/Occupancies.fxml"));
            Parent page = loader.load();
            dialogStage = new Stage();
            dialogStage.setTitle("Ceil Inn - Occupancies");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(main.getPrimaryStage());
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            OccupanciesController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            dialogStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tolboriin medeelliig haruulah tsonhiig vvsgene
     */
    @FXML
    private void handlePayments() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/Payments.fxml"));
            Parent page = loader.load();
            dialogStage = new Stage();
            dialogStage.setTitle("Ceil Inn - Payments");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(main.getPrimaryStage());
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            PaymentsController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            dialogStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Vndsen tsonhiig haana
     */
    @FXML
    private void handleCancel() {
        main.getPrimaryStage().close();
    }
}
