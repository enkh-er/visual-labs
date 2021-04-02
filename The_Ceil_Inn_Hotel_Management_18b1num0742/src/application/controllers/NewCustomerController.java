package application.controllers;
import application.database.CustomerDAO;
import application.model.Customer;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.MaskedTextField;

public class NewCustomerController {

    @FXML
    private TextField txtAccountNumber;

    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtLastName;

    @FXML
    private MaskedTextField txtPhoneNumber;

    @FXML
    private TextField txtEmergencyName;

    @FXML
    private MaskedTextField txtEmergencyPhone;

    CustomerRecordController customerRecordController;

    public void setCustomerRecordController(CustomerRecordController customerRecordController) {
        this.customerRecordController = customerRecordController;
    }

    private Stage dialogStage;

    CustomerDAO dao=new CustomerDAO();

    public void setDialogStage(javafx.stage.Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void closeDialogStage(){
        dialogStage.close();
    }

    /**
     * Hereglegchiin medeelliig hadgalah method
     */
    public void saveCustomer(){
        if(isValid()){
            Customer customer=new Customer(txtAccountNumber.getText(),txtFirstName.getText(),txtLastName.getText(),
                    txtPhoneNumber.getText(),txtEmergencyName.getText(),txtEmergencyPhone.getText() );
            if(!dao.save(customer)){
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
                customerRecordController.getTableDatas().add(customer);
                clearFields();
            }
        }
    }

    /**
     * Hereglegchiin medeelliig awah form-iig tsewerlene
     */
    private void clearFields(){
        txtEmergencyName.setText(null);
        txtEmergencyPhone.setText(null);
        txtPhoneNumber.setText(null);
        txtLastName.setText(null);
        txtFirstName.setText(null);
        txtAccountNumber.setText(null);
    }

    /**
     * Hereglegchiin oruulsan medeelel zow esehiig shalgana
     * @return herew zow bol true, else false
     */
    private boolean isValid(){
        String errorMessage = "";

        if (txtAccountNumber.getText() == null || txtAccountNumber.getText().length() == 0) {
            errorMessage += "No valid Account Number!\n";
        }
        if (txtFirstName.getText() == null || txtFirstName.getText().length() == 0) {
            errorMessage += "No valid first name!\n";
        }
        if (txtLastName.getText() == null || txtLastName.getText().length() == 0) {
            errorMessage += "No valid last name!\n";
        }

        if (txtPhoneNumber.getText() == null || txtPhoneNumber.getText().length() == 0) {
            errorMessage += "No valid Phone Number!\n";
        }

        if (txtEmergencyName.getText() == null || txtEmergencyName.getText().length() == 0) {
            errorMessage += "No valid Emergency Name!\n";
        }
        if (txtEmergencyPhone.getText() == null || txtEmergencyPhone.getText().length() == 0) {
            errorMessage += "No valid Emergency Phone!\n";
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

    }
}
