package application.controllers;

import java.io.IOException;
import java.time.LocalDate;

import application.database.PaymentDAO;
import application.model.Payment;
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

public class PaymentsController {

    @FXML
    private TableView<Payment> lvwPayments;

    @FXML
    private TableColumn<Payment, Integer> colReceiptNumber;

    @FXML
    private TableColumn<Payment, String> colProcessedBy;

    @FXML
    private TableColumn<Payment, LocalDate> colPaymentDate;

    @FXML
    private TableColumn<Payment, String> colAccountNumber;

    @FXML
    private TableColumn<Payment, LocalDate> colFirstDayOccupied;

    @FXML
    private TableColumn<Payment, LocalDate> colLastDayOccupied;

    @FXML
    private TableColumn<Payment, Integer> colTotalNights;

    @FXML
    private TableColumn<Payment, Double> colAmountCharged;

    @FXML
    private TableColumn<Payment, Double> colPhoneUse;

    @FXML
    private TableColumn<Payment, Double> colSubTotal;

    @FXML
    private TableColumn<Payment, Double> colTaxRate;

    @FXML
    private TableColumn<Payment, Double> colTaxAmount;

    @FXML
    private TableColumn<Payment, Double> colTotalAmountPaid;

    private Stage dialogStage;

    ObservableList<Payment> tableDatas= FXCollections.observableArrayList();

    PaymentDAO dao=new PaymentDAO();

    public ObservableList<Payment> getTableDatas() {
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
     * Shine tolboriin barimt vvsgeh tsonhiig vvsgene
     */
    @FXML
    private void handleNewPayment() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/NewPayment.fxml"));
            Parent page = loader.load();
            Stage newPaymentStage = new Stage();
            newPaymentStage.setTitle("Ceil Inn - New Payment");
            newPaymentStage.initModality(Modality.WINDOW_MODAL);
            newPaymentStage.initOwner(dialogStage);
            Scene scene = new Scene(page);
            newPaymentStage.setScene(scene);
            NewPaymentController controller = loader.getController();
            controller.setDialogStage(newPaymentStage);
            controller.setPaymentsController(this);
            newPaymentStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tolboriin medeelliig hvsnegted haruulah method
     */
    public void updateTableData(){
        colReceiptNumber.setCellValueFactory(new PropertyValueFactory<Payment,Integer>("receiptNo"));
        colProcessedBy.setCellValueFactory(new PropertyValueFactory<Payment,String>("employeeNo"));
        colPaymentDate.setCellValueFactory(new PropertyValueFactory<Payment,LocalDate>("paymentDate"));
        colAccountNumber.setCellValueFactory(new PropertyValueFactory<Payment,String>("accountNo"));
        colFirstDayOccupied.setCellValueFactory(new PropertyValueFactory<Payment,LocalDate>("firstDayOccupied"));
        colLastDayOccupied.setCellValueFactory(new PropertyValueFactory<Payment,LocalDate>("lastDatOccupied"));
        colTotalNights.setCellValueFactory(new PropertyValueFactory<Payment,Integer>("totalNights"));
        colPhoneUse.setCellValueFactory(new PropertyValueFactory<Payment,Double>("phoneUse"));
        colAmountCharged.setCellValueFactory(new PropertyValueFactory<Payment,Double>("amountCharged"));
        colSubTotal.setCellValueFactory(new PropertyValueFactory<Payment,Double>("subTotal"));
        colTaxRate.setCellValueFactory(new PropertyValueFactory<Payment,Double>("taxRate"));
        colTaxAmount.setCellValueFactory(new PropertyValueFactory<Payment,Double>("taxAmount"));
        colTotalAmountPaid.setCellValueFactory(new PropertyValueFactory<Payment,Double>("totalAmoundPaid"));
        tableDatas.addAll(dao.findAll());
        lvwPayments.setItems(tableDatas);
    }

    @FXML
    void initialize() {
        updateTableData();
    }
}
