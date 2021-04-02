package application.controllers;

import java.io.IOException;

import application.database.RoomDAO;
import application.model.Room;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class RoomsController {

    @FXML
    private TableView<Room> lvwRooms;

    @FXML
    private TableColumn<Room, String> colRoomNumber;

    @FXML
    private TableColumn<Room, String> colRoomType;

    @FXML
    private TableColumn<Room, String> colBedType;

    @FXML
    private TableColumn<Room, Double> colRate;

    @FXML
    private TableColumn<Room, String> colAvailable;

    ObservableList<Room> tableDatas= FXCollections.observableArrayList();

    RoomDAO dao=new RoomDAO();

    private Stage dialogStage;

    public ObservableList<Room> getTableDatas() {
        return tableDatas;
    }

    public void setDialogStage(javafx.stage.Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    @FXML
    void closeDialogStage(ActionEvent event) {
        dialogStage.close();
    }

    /**
     * Shine oroo vvsgeh tsonhiig vvsgene
     */
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
            controller.setRoomsController(this);
            newRoomStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Oroonii medeelliig hvsnegted haruulah method
     */
    public void updateTableData(){
        colRoomNumber.setCellValueFactory(new PropertyValueFactory<Room,String>("roomNo"));
        colRoomType.setCellValueFactory(new PropertyValueFactory<Room,String>("roomType"));
        colBedType.setCellValueFactory(new PropertyValueFactory<Room,String>("bedType"));
        colRate.setCellValueFactory(new PropertyValueFactory<Room,Double>("rate"));
        colAvailable.setCellValueFactory(new PropertyValueFactory<Room,String>("status"));
        tableDatas.addAll(dao.findAll());
        lvwRooms.setItems(tableDatas);
    }

    @FXML
    void initialize() {
        updateTableData();
    }
}
