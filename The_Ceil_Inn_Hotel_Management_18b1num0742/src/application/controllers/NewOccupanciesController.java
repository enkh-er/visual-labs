package application.controllers;


import application.database.CustomerDAO;
import application.database.EmployeeDAO;
import application.database.OccupancyDAO;
import application.database.RoomDAO;
import application.model.Customer;
import application.model.Employee;
import application.model.Occupancy;
import application.model.Room;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDate;

public class NewOccupanciesController {

    @FXML
    private DatePicker dtpDateOccupied;

    @FXML
    private TextField txtEmployeNumber;

    @FXML
    private TextField txtEmployeNme;

    @FXML
    private TextField txtCustomerNumber;

    @FXML
    private TextField txtCustomerName;

    @FXML
    private TextField txtRoomNumber;

    @FXML
    private TextField txtRoomDescription;

    @FXML
    private TextField txtRateApplied;

    @FXML
    private TextField txtPhoneUse;

    @FXML
    private TextField txtOccupanyNumber;

    private Stage dialogStage;

    OccupancyDAO occupancyDAO=new OccupancyDAO();
    EmployeeDAO employeeDAO=new EmployeeDAO();
    CustomerDAO customerDAO=new CustomerDAO();
    RoomDAO roomDAO=new RoomDAO();

    OccupanciesController occupanciesController;

    public void setOccupanciesController(OccupanciesController occupanciesController) {
        this.occupanciesController = occupanciesController;
    }

    public void setDialogStage(javafx.stage.Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    @FXML
    void closeDialogStage(ActionEvent event) {
        dialogStage.close();
    }

    public void saveOccpancy(){
        if(isValid()){
            try{
                Occupancy occupancy=new Occupancy(txtOccupanyNumber.getText(),dtpDateOccupied.getValue(),txtEmployeNumber.getText(),
                        txtCustomerNumber.getText(),txtRoomNumber.getText(),Double.parseDouble(txtRateApplied.getText()),Double.parseDouble(txtPhoneUse.getText()));
                if(!occupancyDAO.save(occupancy)){
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
                    occupanciesController.getTableDatas().add(occupancy);
                    clearFields();
                }
                }
                 catch (Exception e){
                     e.printStackTrace();
                }

        }
    }

    /**
     * Tvreesiin medeelliig awah form-iig tsewerlene
     */
    private void clearFields(){
        txtOccupanyNumber.setText(null);
        txtEmployeNme.setText(null);
        txtEmployeNumber.setText(null);
        txtRoomNumber.setText(null);
        txtCustomerName.setText(null);
        txtCustomerNumber.setText(null);
        txtPhoneUse.setText(null);
        txtRateApplied.setText(null);
        txtRoomDescription.setText(null);
        dtpDateOccupied.setValue(null);
    }

    /**
     * Tvreeslegdsen oroonii medeelel zow esehiig shalgana
     * @return herew zow bol true, else false
     */
    private boolean isValid(){
        String errorMessage = "";

        if (txtOccupanyNumber.getText() == null || txtOccupanyNumber.getText().length() == 0) {
            errorMessage += "No valid Occupany Number!\n";
        }
        if (dtpDateOccupied.getValue() == null) {
            errorMessage += "No valid Date Occupied!\n";
        }
        if (txtCustomerNumber.getText() == null || txtCustomerNumber.getText().length() == 0) {
            errorMessage += "No valid last name!\n";
        }
        if(customerDAO.findById(txtCustomerNumber.getText())==null){
            errorMessage += "The customer number is incorrect!\n";
        }
        if(txtEmployeNumber.getText()!=null){
            if(employeeDAO.findById(txtEmployeNumber.getText())==null){
                errorMessage += "The employee number is incorrect!\n";
            }
        }
        if(txtRoomNumber.getText()!=null){
            if(roomDAO.findById(txtRoomNumber.getText())==null){
                errorMessage += "The room number is incorrect!\n";
            }
        }

        if(dtpDateOccupied.getValue().isAfter(LocalDate.now())){
            errorMessage += "The date is incorrect!\n";
        }

        if (txtRoomNumber.getText() == null || txtRoomNumber.getText().length() == 0) {
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

    /**
     * txtEmployeNme talbar der hulganii focus ochihod
     * Herew achilchnii dugaariig oruulsan bol achiljnii neriig ogogdliin sangaas olj
     * txtEmployeNme talbart ajilchnii neriig oruulna
     * txtCustomerName talbar der hulganii focus ochihod
     * Herew hereglegchiin dugaariig oruulsan bol hereglegchiin neriig ogogdliin sangaas olj
     * txtCustomerName talbart hereglegchiin neriig oruulna
     * txtRoomDescription talbar der hulganii focus ochihod
     * Herew oroonii dugaariig oruulsan bol oroonii medeelliih olj
     * txtRoomDescription talbart oroonii utga onoono
     */
        public void findEmployeeNameAndCustomerName(){
        txtEmployeNme.focusedProperty().addListener((val,oldVal,newVal)->{
            if(txtEmployeNumber.getText() != null&&txtEmployeNumber.getText().length()!=0){
                Employee emp=employeeDAO.findById(txtEmployeNumber.getText());
                if(emp!=null){
                    txtEmployeNme.setText(emp.getFirstName()+" "+emp.getLastName());
                }
            }
        });
            txtCustomerName.focusedProperty().addListener((val,oldVal,newVal)->{
                if(txtCustomerNumber.getText() != null&&txtCustomerNumber.getText().length()!=0){
                    Customer customer=customerDAO.findById(txtCustomerNumber.getText());
                    if(customer!=null)
                        txtCustomerName.setText(customer.getFirsName()+" "+customer.getLastName());
                }
            });
            txtRoomDescription.focusedProperty().addListener((val,oldVal,newVal)->{
                if(txtRoomNumber.getText() != null&&txtRoomNumber.getText().length()!=0){
                    Room room=roomDAO.findById(txtRoomNumber.getText());
                    if(room!=null)
                        txtRoomDescription.setText("Room Type: "+room.getRoomType()+", Bed Type: "+room.getBedType()+", Status: "+room.getStatus());
                }
            });
    }

    @FXML
    void initialize() {
        findEmployeeNameAndCustomerName();
    }
}
