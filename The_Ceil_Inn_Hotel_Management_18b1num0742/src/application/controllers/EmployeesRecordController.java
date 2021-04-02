package application.controllers;

import java.io.IOException;

import application.database.EmployeeDAO;
import application.model.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class EmployeesRecordController {

    ObservableList<Employee> tableDatas= FXCollections.observableArrayList();
    EmployeeDAO dao=new EmployeeDAO();

    @FXML
    private TableView<Employee> lvwEmployees;

    @FXML
    private TableColumn<Employee, String> colEmployeeNumber;

    @FXML
    private TableColumn<Employee, String> colFirstName;

    @FXML
    private TableColumn<Employee, String> colLastName;

    @FXML
    private TableColumn<Employee, String> colTitle;

    private Stage dialogStage;

    /**
     * Ajilchnii ogogdlvvdiig butsaana
     * @return = Ajilchnii ogogdlvvd
     */
    public ObservableList<Employee> getTableDatas() {
        return tableDatas;
    }

    /**
     * Ajilchnii medeelliig hvsnegted haruulah method
     */
    public void updateTableData(){
        colEmployeeNumber.setCellValueFactory(new PropertyValueFactory<Employee,String>("employeeNo"));
        colFirstName.setCellValueFactory(new PropertyValueFactory<Employee,String>("firstName"));
        colLastName.setCellValueFactory(new PropertyValueFactory<Employee,String>("lastName"));
        colTitle.setCellValueFactory(new PropertyValueFactory<Employee,String>("title"));
        tableDatas.addAll(dao.findAll());
        lvwEmployees.setItems(tableDatas);
    }


    /**
     * Ajilchnii medeelliig haruulah tsonhiig  onoono
     * @param dialogStage = Ajilchnii medeelliig haruulah tsonh
     */
    public void setDialogStage(javafx.stage.Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Ajilchnii medeelliig haruulah tsonhiig haana
     */
    public void closeDialogStage(){
        dialogStage.close();
    }

    /**
     * Shine ajilchin vvsgeh tsonhiig vvsgene
     */
    @FXML
    private void handleNewEmployee() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/NewEmployee.fxml"));
            Parent page = loader.load();

            Stage newEmployeeStage = new Stage();
            newEmployeeStage.setTitle("Ceil Inn - Customers Records");
            newEmployeeStage.initModality(Modality.WINDOW_MODAL);
            newEmployeeStage.initOwner(dialogStage);
            Scene scene = new Scene(page);
            newEmployeeStage.setScene(scene);
            NewEmployeeController controller = loader.getController();
            controller.setDialogStage(newEmployeeStage);
            controller.setEmployeesRecordController(this);
            newEmployeeStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void initialize() {
        updateTableData();
    }
}
