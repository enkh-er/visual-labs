package application.controllers;

import java.io.IOException;

import application.database.CustomerDAO;
import application.model.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CustomerRecordController {
    /**
     * Hereglegchiin ogogdliin awah list
     */
    ObservableList<Customer> tableDatas= FXCollections.observableArrayList();
    /**
     * Hereglegchiin ogogliin santai haritsaj object
     */
    CustomerDAO dao=new CustomerDAO();

    @FXML
    private TableView<Customer> lvwCustomers;

    @FXML
    private TableColumn<Customer, String> colAccountNumber;

    @FXML
    private TableColumn<Customer,String> colFirstName;

    @FXML
    private TableColumn<Customer, String> colLastName;

    @FXML
    private TableColumn<Customer, String> colPhoneNumber;

    @FXML
    private TableColumn<Customer,String> colEmergencyName;

    @FXML
    private TableColumn<Customer, String> colEmergencyPhone;

    private Stage dialogStage;

    /**
     * Hereglegchiin medeelliig haruulah tsonhiig onoono
     * @param dialogStage =  Hereglegchiin medeelliig haruulah tsonh
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Hereglegchiin medeelliig haruulah tsonhiig haana
     */
    public void closeDialogStage(){
        dialogStage.close();
    }

    /**
     * Hereglegchiin ogogdliig butsaana
     * @return = hereglegchiin method
     */
    public ObservableList<Customer> getTableDatas() {
        return tableDatas;
    }

    /**
     * Shine hereglegch vvsgeh tsonh vvsgene
     */
    @FXML
    private void handleNewCustomer() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/NewCustomerDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Stage newCustomerStage = new Stage();
            newCustomerStage.setTitle("Ceil Inn - Customers Records");
            newCustomerStage.initModality(Modality.WINDOW_MODAL);
            newCustomerStage.initOwner(dialogStage);
            Scene scene = new Scene(page);
            newCustomerStage.setScene(scene);
            NewCustomerController controller = loader.getController();
            controller.setCustomerRecordController(this);
            controller.setDialogStage(newCustomerStage);
            newCustomerStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Hereglegchiin medeelliig hvsnegted haruulna
     */
    public void updateTableData(){
        colAccountNumber.setCellValueFactory(new PropertyValueFactory<Customer,String>("accountNo"));
        colFirstName.setCellValueFactory(new PropertyValueFactory<Customer,String>("firsName"));
        colLastName.setCellValueFactory(new PropertyValueFactory<Customer,String>("lastName"));
        colPhoneNumber.setCellValueFactory(new PropertyValueFactory<Customer,String>("phoneNo"));
        colEmergencyName.setCellValueFactory(new PropertyValueFactory<Customer,String>("emergencyName"));
        colEmergencyPhone.setCellValueFactory(new PropertyValueFactory<Customer,String>("emergencyPhone"));
        tableDatas.addAll(dao.findAll());
        lvwCustomers.setItems(tableDatas);
    }

    @FXML
    void initialize() {
        updateTableData();
    }

}
