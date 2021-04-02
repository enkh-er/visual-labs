package application.controllers;

import java.io.IOException;
import java.time.LocalDate;

import application.database.OccupancyDAO;
import application.model.Occupancy;
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

public class OccupanciesController {


    @FXML
    private TableView<Occupancy> lvwOccupancies;

    @FXML
    private TableColumn<Occupancy, String> colOccupancyNumber;

    @FXML
    private TableColumn<Occupancy, LocalDate> colDateOccupied;

    @FXML
    private TableColumn<Occupancy, String> colProcessedBy;

    @FXML
    private TableColumn<Occupancy, String> colProcessedFor;

    @FXML
    private TableColumn<Occupancy, String> colRoomOccupied;

    @FXML
    private TableColumn<Occupancy, Double> colRateApplied;

    @FXML
    private TableColumn<Occupancy, Double> colPhoneUse;

    private Stage dialogStage;

    ObservableList<Occupancy> tableDatas= FXCollections.observableArrayList();

    OccupancyDAO dao=new OccupancyDAO();

    public ObservableList<Occupancy> getTableDatas() {
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
     * Shine tvrees vvsgeh tsonhiig vvsgene
     */
    @FXML
    private void handleNewOccupancy() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/NewOccupancies.fxml"));
            Parent page = loader.load();
            Stage newOccupancyStage = new Stage();
            newOccupancyStage.setTitle("Ceil Inn - New Room");
            newOccupancyStage.initModality(Modality.WINDOW_MODAL);
            newOccupancyStage.initOwner(dialogStage);
            Scene scene = new Scene(page);
            newOccupancyStage.setScene(scene);
            NewOccupanciesController controller = loader.getController();
            controller.setDialogStage(newOccupancyStage);
            controller.setOccupanciesController(this);
            newOccupancyStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tvreesiin medeelliig hvsnegted haruulah method
     */
    public void updateTableData(){
        colOccupancyNumber.setCellValueFactory(new PropertyValueFactory<Occupancy,String>("occupancyNo"));
        colDateOccupied.setCellValueFactory(new PropertyValueFactory<Occupancy,LocalDate>("dateOccupied"));
        colProcessedBy.setCellValueFactory(new PropertyValueFactory<Occupancy,String>("processedBy"));
        colProcessedFor.setCellValueFactory(new PropertyValueFactory<Occupancy,String>("processedFor"));
        colRoomOccupied.setCellValueFactory(new PropertyValueFactory<Occupancy,String>("roomOccupied"));
        colRateApplied.setCellValueFactory(new PropertyValueFactory<Occupancy,Double>("rateApplied"));
        colPhoneUse.setCellValueFactory(new PropertyValueFactory<Occupancy,Double>("phoneUse"));
        tableDatas.addAll(dao.findAll());
        lvwOccupancies.setItems(tableDatas);
    }

    @FXML
    void initialize() {
        updateTableData();
    }
}
