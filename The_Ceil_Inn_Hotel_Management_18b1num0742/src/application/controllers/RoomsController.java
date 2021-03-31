package application.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class RoomsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<?> lvwRooms;

    @FXML
    private TableColumn<?, ?> colRoomNumber;

    @FXML
    private TableColumn<?, ?> colRoomType;

    @FXML
    private TableColumn<?, ?> colBedType;

    @FXML
    private TableColumn<?, ?> colRate;

    @FXML
    private TableColumn<?, ?> colAvailable;

    @FXML
    private Button btnClose;

    @FXML
    private Button btnNewRoom;

    private Stage dialogStage;

    public void setDialogStage(javafx.stage.Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    @FXML
    void closeDialogStage(ActionEvent event) {
        dialogStage.close();
    }

    @FXML
    private void handleNewRoom() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/NewRoom.fxml"));
            Parent page = loader.load();

            Stage newRoomStage = new Stage();
            newRoomStage.setTitle("Ceil Inn - New Room");
            newRoomStage.initModality(Modality.WINDOW_MODAL);
            newRoomStage.initOwner(dialogStage);
            Scene scene = new Scene(page);
            newRoomStage.setScene(scene);
            NewRoomController controller = loader.getController();
            controller.setDialogStage(newRoomStage);
            newRoomStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    void initialize() {

    }
}
