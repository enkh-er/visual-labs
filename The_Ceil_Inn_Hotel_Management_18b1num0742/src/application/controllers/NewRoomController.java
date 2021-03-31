package application.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewRoomController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label txtRate;

    @FXML
    private TextField txtRoomNumber;

    @FXML
    private TextField txtTitle;

    @FXML
    private ComboBox<?> cbxRoomTypes;

    @FXML
    private ComboBox<?> cbxBedTypes;

    @FXML
    private ComboBox<?> cbxOccupanciesStatus;

    @FXML
    private Button btnOK;

    @FXML
    private Button btnCancel;

    @FXML
    void closeDialogStage(ActionEvent event) {
        dialogStage.close();
    }

    private Stage dialogStage;

    public void setDialogStage(javafx.stage.Stage dialogStage) {
        this.dialogStage = dialogStage;
    }


    @FXML
    void initialize() {

    }
}
