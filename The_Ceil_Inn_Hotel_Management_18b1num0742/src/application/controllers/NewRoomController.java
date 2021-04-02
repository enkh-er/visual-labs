package application.controllers;

import application.database.RoomDAO;
import application.model.Room;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class NewRoomController {

    @FXML
    private TextField txtRate;

    @FXML
    private TextField txtRoomNumber;

    @FXML
    private ComboBox<String> cbxRoomTypes;

    @FXML
    private ComboBox<String> cbxBedTypes;

    @FXML
    private ComboBox<String> cbxOccupanciesStatus;

    final private ObservableList<String> cbxItems1 = FXCollections.observableArrayList("Bedroom","Conference Room","Other");
    final private ObservableList<String> cbxItems2 = FXCollections.observableArrayList("King","Queen","Double","Other");
    final private ObservableList<String> cbxItems3 = FXCollections.observableArrayList("Available","Occupied","Other");

    RoomDAO dao=new RoomDAO();

    RoomsController roomsController;

    public void setRoomsController(RoomsController roomsController) {
        this.roomsController = roomsController;
    }


    @FXML
    void closeDialogStage(ActionEvent event) {
        dialogStage.close();
    }

    private Stage dialogStage;

    public void setDialogStage(javafx.stage.Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Combobox-ii anhnii utgiig onoono
     */
    private void setComboBoxItems(){
        cbxRoomTypes.setItems(cbxItems1);
        cbxBedTypes.setItems(cbxItems2);
        cbxOccupanciesStatus.setItems(cbxItems3);
    }

    public void saveCustomer(){
        if(isValid()){
            Room room=new Room(txtRoomNumber.getText(),cbxRoomTypes.getValue(),cbxBedTypes.getValue(),
                    Double.parseDouble(txtRate.getText()),cbxOccupanciesStatus.getValue());
            if(!dao.save(room)){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.initOwner(dialogStage);
                alert.setTitle("Database Error");
                alert.setHeaderText("Ogogdliin sand ogogdol oruulah ved aldaa garlaa");
                alert.showAndWait();
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.initOwner(dialogStage);
                alert.setTitle("Database");
                alert.setHeaderText("Ogogdol amjilttai orloo");
                alert.showAndWait();
                roomsController.getTableDatas().add(room);
                clearFields();
            }
        }
    }

    /**
     * Oroonii medeelliig awah form-iig tsewerlene
     */
    private void clearFields(){
        txtRate.setText(null);
        txtRoomNumber.setText(null);
        cbxBedTypes.setValue(null);
        cbxRoomTypes.setValue(null);
        cbxOccupanciesStatus.setValue(null);
    }

    /**
     * Oroonii medeelel zow esehiig shalgana
     * @return herew zow bol true, else false
     */
    private boolean isValid(){
        String errorMessage = "";

        if (txtRate.getText() == null || txtRate.getText().length() == 0) {
            errorMessage += "No valid Rate!\n";
        }
        if (txtRoomNumber.getText() == null || txtRoomNumber.getText().length() == 0) {
            errorMessage += "No valid Room Number!\n";
        }

        if (cbxRoomTypes.getValue() == null ) {
            errorMessage += "No valid Room Types!\n";
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);
            alert.showAndWait();
            return false;
        }
    }


    @FXML
    void initialize() {
        setComboBoxItems();
    }
}
