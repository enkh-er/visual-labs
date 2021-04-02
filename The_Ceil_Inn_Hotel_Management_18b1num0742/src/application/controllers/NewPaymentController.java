package application.controllers;

import application.database.*;
import application.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.security.spec.ECField;
import java.time.LocalDate;

public class NewPaymentController {

    @FXML
    private DatePicker dtpPaymentDate;

    @FXML
    private TextField txtEmployeNumber;

    @FXML
    private TextField txtEmployeNme;

    @FXML
    private TextField txtOccupancyNumber;

    @FXML
    private TextField txtOccupancyDetails;

    @FXML
    private DatePicker dtpFirstDateOccupied;

    @FXML
    private DatePicker dtpLastDateOccupied;

    @FXML
    private TextField txtTotalNights;

    @FXML
    private TextField txtPhoneUse;

    @FXML
    private TextField txtAmountCharged;

    @FXML
    private TextField txtSubTotal;

    @FXML
    private TextField txtTaxRate;

    @FXML
    private TextField txtTaxAmount;

    @FXML
    private TextField txtTotalAmountPaid;

    @FXML
    private TextField txtReceiptNumber;

    OccupancyDAO occupancyDAO=new OccupancyDAO();
    EmployeeDAO employeeDAO=new EmployeeDAO();
    PaymentDAO paymentDAO=new PaymentDAO();

    private Stage dialogStage;

    PaymentsController paymentsController;

    public void setPaymentsController(PaymentsController paymentsController) {
        this.paymentsController = paymentsController;
    }

    public void setDialogStage(javafx.stage.Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    @FXML
    void closeDialogStage(ActionEvent event) {
        dialogStage.close();
    }


    /**
     * Tolboriin medeelliig oruulah talbariig tsewerlene
     */
    private void clearFields(){
        dtpPaymentDate.setValue(null);
        txtEmployeNme.setText(null);
        txtEmployeNumber.setText(null);
        txtOccupancyNumber.setText(null);
        txtOccupancyDetails.setText(null);
        dtpFirstDateOccupied.setValue(null);
        txtPhoneUse.setText(null);
        txtAmountCharged.setText(null);
        txtSubTotal.setText(null);
        txtTaxRate.setText(null);
        txtTaxAmount.setText(null);
        txtTotalAmountPaid.setText(null);
        txtReceiptNumber.setText(null);
    }

    /**
     * Shine tolboriin medeelliig hadgalna
     */
    public void savePayment(){
        if(isValid()){
            try{
                int receiptNo=paymentsController.getTableDatas().size()+1;
                Payment payment=new Payment(receiptNo,txtEmployeNumber.getText(),dtpPaymentDate.getValue(),
                        txtOccupancyNumber.getText(),dtpFirstDateOccupied.getValue(),dtpLastDateOccupied.getValue(),
                        Integer.parseInt(txtTotalNights.getText()),Double.parseDouble(txtPhoneUse.getText()),
                        Double.parseDouble(txtAmountCharged.getText()),Double.parseDouble(txtSubTotal.getText()),
                        Double.parseDouble(txtTaxAmount.getText()),Double.parseDouble(txtTaxRate.getText()),
                        Double.parseDouble(txtTotalAmountPaid.getText()));
                if(!paymentDAO.save(payment)){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.initOwner(dialogStage);
                    alert.setTitle("Database Error");
                    alert.setHeaderText("Ogogdliin sand ogogdol oruulah ved aldaa garlaa");
                    alert.showAndWait();
                }else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.initOwner(dialogStage);
                    alert.setTitle("Database");
                    alert.setHeaderText("Ogogdol amjilttai orloo");
                    alert.showAndWait();
                    paymentsController.getTableDatas().add(payment);
                    clearFields();
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }

        }
    }

    /**
     * Tolboriin medeelel zow esehiig shalgana
     * @return herew zow bol true, else false
     */
    private boolean isValid(){
        String errorMessage = "";

        if (txtEmployeNumber.getText() == null || txtEmployeNumber.getText().length() == 0) {
            errorMessage += "No valid Employe Number!\n";
        }else{
            if(employeeDAO.findById(txtEmployeNumber.getText())==null){
                errorMessage += "The employee number is incorrect!\n";
            }
        }

        if (txtOccupancyNumber.getText() == null || txtOccupancyNumber.getText().length() == 0) {
            errorMessage += "No valid Occupancy Number!\n";
        }

        if (dtpPaymentDate.getValue() == null) {
            errorMessage += "No valid Payment Date !\n";
        }else {
            if(dtpPaymentDate.getValue().isAfter(LocalDate.now())){
                errorMessage += "The date is incorrect!\n";
            }
        }

        if (dtpFirstDateOccupied.getValue() == null||dtpLastDateOccupied.getValue()==null) {
            errorMessage += "No valid first and last occpied date!\n";
        }else {
            if(dtpFirstDateOccupied.getValue().isAfter(dtpLastDateOccupied.getValue())){
                errorMessage += "First and last occpied date is incorrect!\n";
            }
        }

        if (txtTotalNights.getText() == null || txtTotalNights.getText().length() == 0) {
            errorMessage += "No valid Total Nights!\n";
        }
        if (txtAmountCharged.getText() == null || txtAmountCharged.getText().length() == 0) {
            errorMessage += "No valid Amount Charged!\n";
        }
        if (txtPhoneUse.getText() == null || txtPhoneUse.getText().length() == 0) {
            errorMessage += "No valid Phone Use!\n";
        }
        if (txtTaxRate.getText() == null || txtTaxRate.getText().length() == 0) {
            errorMessage += "No valid Tax Rate!\n";
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

    /**
     * Hereglegchiin toloh tolboriig tootsno
     */
    public void calculatePayment(){
        try{
            if(txtAmountCharged.getText()!=null&&Double.parseDouble(txtAmountCharged.getText())!=0){
                int totalNight=Integer.parseInt(txtTotalNights.getText());
                double amountCharged=Double.parseDouble(txtAmountCharged.getText());
                double phoneUse=Double.parseDouble(txtPhoneUse.getText());
                double taxRate=Double.parseDouble(txtTaxRate.getText());
                double subTotal=(totalNight*amountCharged)+phoneUse;
                double taxAmount=subTotal*taxRate/100;
                double amountPaid=subTotal+taxAmount;

                txtSubTotal.setText(String.format("%.2f",subTotal));
                txtTaxAmount.setText(String.format("%.2f",taxAmount));
                txtTotalAmountPaid.setText(String.format("%.2f",amountPaid));
            }
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.showAndWait();
        }

    }

    /**
     * txtEmployeNme talbar der hulganii focus ochihod
     * Herew achilchnii dugaariig oruulsan bol achiljnii neriig ogogdliin sangaas olj
     * textfielded ajilchnii neriig olno
     * txtOccupancyDetails talbar der hulganii focus ochihod
     * Herew tvreeslegdsen oroonii dugaariig oruulbal tvreesiin medeelliih olj
     * delgerengvi talbart utga onoono
     */
    public void findEmployeeOccupied(){

        txtEmployeNme.focusedProperty().addListener((val,oldVal,newVal)->{
            if(txtEmployeNumber.getText() != null&&txtEmployeNumber.getText().length()!=0){
                Employee emp=employeeDAO.findById(txtEmployeNumber.getText());
                if(emp!=null)
                    txtEmployeNme.setText(emp.getFirstName()+" "+emp.getLastName());
            }
        });
        txtOccupancyDetails.focusedProperty().addListener((val,oldVal,newVal)->{
            if(txtOccupancyNumber.getText() != null&&txtOccupancyNumber.getText().length()!=0){
                Occupancy occupancy=occupancyDAO.findById(txtOccupancyNumber.getText());
                if(occupancy!=null)
                txtOccupancyDetails.setText("Processed By: "+occupancy.getProcessedBy()+", Processed For: "+occupancy.getProcessedFor()+", Room: "+occupancy.getRoomOccupied());
            }
        });
    }
    @FXML
    void initialize() {
        findEmployeeOccupied();
    }
}
