package application.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import application.model.Customer;
import application.model.Employee;
import application.model.Order;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.MaskedTextField;

public class EmployeeController {

    ObservableList<Employee> employees= FXCollections.observableArrayList();
    ObservableList<Order> orders= FXCollections.observableArrayList();
    ObservableList<Customer> customers= FXCollections.observableArrayList();

    public ObservableList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ObservableList<Order> orders) {
        this.orders = orders;
    }

    public ObservableList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ObservableList<Employee> employees) {
        this.employees = employees;
    }

    public ObservableList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ObservableList<Customer> customers) {
        this.customers = customers;
    }
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtTitle;

    @FXML
    private TextField txtHourlySalary;

    @FXML
    private MaskedTextField txtEmployeeNumber;

    @FXML
    private Button btnSubmit;

    @FXML
    private TableView<Employee> dgvEmployees;

    @FXML
    private Button btnClose;

    TableColumn colEmployeeID = new TableColumn("EmployeeID");
    TableColumn colEmployeeNumber = new TableColumn("EmployeeNumber");
    TableColumn colFirstName = new TableColumn("FirstName");
    TableColumn colFullName = new TableColumn("FullName");
    TableColumn colTitle = new TableColumn("Title");
    TableColumn colLastName = new TableColumn("LastName");
    TableColumn colHourlySalary = new TableColumn("HourlySalary");

    /**
     * Ajilchnii medeelliig haruulah hvsnegtiin talbariig vvsgene
     */
    private void createTableColumns(){
        dgvEmployees.getColumns().addAll(colEmployeeID, colEmployeeNumber, colFirstName,colLastName,
                colFullName,colTitle,colHourlySalary);
        colFullName.setPrefWidth(120);
        colTitle.setPrefWidth(140);
    }

    /**
     * Vndsen tsonhruu shiljine
     * @param event - button click
     * @throws IOException
     */
    @FXML
    void handleClose(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/cleaningOrder.fxml"));
        Parent homePage = loader.load();
        OrderController orderController=loader.getController();
        orderController.setEmployees(employees);
        orderController.setCustomers(customers);
        orderController.setOrders(orders);

        Scene homeScene = new Scene(homePage,600,680);
        String css= OrderController.class.getResource("../application.css").toExternalForm();
        homeScene.getStylesheets().add(css);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setTitle("Georgetown Cleaning Services - Cleaning Orders");
        app_stage.setScene(homeScene);
        app_stage.show();
    }

    /**
     * Ajilchin nemne
     * @param event - button click
     */
    @FXML
    void addEmployee(ActionEvent event) {
        if(allFieldsIsNotNull()&&validName()&&checkEmployeeNumber()){
            String empNum=txtEmployeeNumber.getText();
            String fName=txtFirstName.getText();
            String lName=txtLastName.getText();
            String title=txtTitle.getText();
            int salary= Integer.parseInt(txtHourlySalary.getText());
            try{
                System.out.println(empNum);
                Employee employee=new Employee();
                employee.setEmployeeID(employees.size()+1);
                employee.setEmployeeNumber(empNum);
                employee.setFirtsName(fName);
                employee.setLastName(lName);
                employee.setFullName(fName+", "+lName);
                employee.setTitle(title);
                employee.setHourlySalary(salary);
                employees.add(employee);
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Ali neg talbariin medeelel buruu baina!");
            }
            updateTableData();
            clearFields();
        }
    }

    /**
     * Bvh talbariin utga hooson bish esehiig shalgana
     * @return = bvh talbar hooson bish true, else false
     */
    public boolean allFieldsIsNotNull(){
        if(txtEmployeeNumber.getText().isEmpty()||txtFirstName.getText().isEmpty()
                ||txtLastName.getText().isEmpty()||txtTitle.getText().isEmpty()||txtHourlySalary.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Ali neg talbariin medeelel hooson baina!");
            return false;
        }
        return true;
    }

    /**
     * Ajilchnii nernii utga zow temdegt orson esehiig shalgana
     * @return
     */
    public boolean validName(){
        if(!txtFirstName.getText().matches("(?i)[a-z]([- ',.a-z]{0,23}[a-z])?")||
                !txtLastName.getText().matches("(?i)[a-z]([- ',.a-z]{0,23}[a-z])?")){
            JOptionPane.showMessageDialog(null, "Nernii utgand buruu temdegt orson baina!");
            return false;
        }
        return true;
    }

    /**
     * Ajilchnii dugaar dawhtsaj bui esehiig shalgana
     * @return = dawhtsaj baiwal false, else true
     */
    public boolean checkEmployeeNumber(){
        String empNum=txtEmployeeNumber.getText();
            for (Employee employee : employees) {
                if (employee.getEmployeeNumber().equals(empNum)) {
                    JOptionPane.showMessageDialog(null, "Achilnii dugaar dawhtsaj baina!");
                    return false;
                }
            }
        return true;
    }

    /**
     * Bvh talbariin utgiig hooson bolgono
     */
    private void clearFields(){
        txtHourlySalary.setText("");
        txtEmployeeNumber.setText("");
        txtFirstName.setText("");
        txtLastName.setText("");
        txtTitle.setText("");
    }

    /**
     * Ajilchnii medeelliig haruulah hvsnegtiin utgiig shinechilne
     */
    public void updateTableData() {
        colEmployeeID.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("employeeID"));
        colEmployeeNumber.setCellValueFactory(new PropertyValueFactory<Employee,String>("employeeNumber"));
        colFirstName.setCellValueFactory(new PropertyValueFactory<Employee,String>("firtsName"));
        colLastName.setCellValueFactory(new PropertyValueFactory<Employee,String>("lastName"));
        colFullName.setCellValueFactory(new PropertyValueFactory<Employee,String>("fullName"));
        colTitle.setCellValueFactory(new PropertyValueFactory<Employee,String>("title"));
        colHourlySalary.setCellValueFactory(new PropertyValueFactory<Employee,Integer>("hourlySalary"));
        dgvEmployees.setItems(getEmployees());
        dgvEmployees.setEditable(true);
    }


    /**
     * Programiig ehlvvlehed ajillah method
     */
    @FXML
    void initialize() {
        createTableColumns();
        updateTableData();
    }
}
