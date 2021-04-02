package application.controllers;

import application.database.EmployeeDAO;
import application.model.Employee;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewEmployeeController {

    @FXML
    private TextField txtEmployeeNumber;

    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtTitle;


    private Stage dialogStage;

    EmployeeDAO dao=new EmployeeDAO();

    EmployeesRecordController employeesRecordController;

    public void setEmployeesRecordController(EmployeesRecordController employeesRecordController) {
        this.employeesRecordController = employeesRecordController;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void closeDialogStage(){
        dialogStage.close();
    }

    public void saveCustomer(){
        if(isValid()){
            Employee employee=new Employee(txtEmployeeNumber.getText(),txtFirstName.getText(),txtLastName.getText(),
                    txtTitle.getText());
            if(!dao.save(employee)){
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
                employeesRecordController.getTableDatas().add(employee);
                clearFields();
            }
        }
    }

    /**
     * Ajilchnii medeelliig awah form-iig tsewerlene
     */
    private void clearFields(){
        txtEmployeeNumber.setText(null);
        txtLastName.setText(null);
        txtFirstName.setText(null);
        txtTitle.setText(null);
    }

    /**
     * Ajilchnii medeelel zow esehiig shalgana
     * @return herew zow bol true, else false
     */
    private boolean isValid(){
        String errorMessage = "";

        if (txtEmployeeNumber.getText() == null || txtEmployeeNumber.getText().length() == 0) {
            errorMessage += "No valid Employee Number!\n";
        }
        if (txtFirstName.getText() == null || txtFirstName.getText().length() == 0) {
            errorMessage += "No valid first name!\n";
        }
        if (txtLastName.getText() == null || txtLastName.getText().length() == 0) {
            errorMessage += "No valid last name!\n";
        }

        if (txtTitle.getText() == null || txtTitle.getText().length() == 0) {
            errorMessage += "No valid txtTitle!\n";
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
