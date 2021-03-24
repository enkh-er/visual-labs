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

public class CustomerController {

    ObservableList<Customer> customers= FXCollections.observableArrayList();
    ObservableList<Order> orders= FXCollections.observableArrayList();
    ObservableList<Employee> employees= FXCollections.observableArrayList();

    public ObservableList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ObservableList<Customer> customers) {
        this.customers = customers;
    }


    public ObservableList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ObservableList<Employee> employees) {
        this.employees = employees;
    }

    public ObservableList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ObservableList<Order> orders) {
        this.orders = orders;
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtCustomerPhone;

    @FXML
    private TextField txtCustomerName;

    @FXML
    private Button btnSubmit;

    @FXML
    private TableView<Customer> dgvCustomers;

    @FXML
    private Button btnClose;
    TableColumn colCustomerID = new TableColumn("CustomerID");
    TableColumn colPhoneNumber = new TableColumn("PhoneNumber");
    TableColumn colFullName = new TableColumn("FullName");

    /**
     * Hereglegchiin medeellig haruulah hvsnegtiin talbariig vvsgene
     */
    public void createTableColumns(){
        dgvCustomers.getColumns().addAll(colCustomerID, colPhoneNumber, colFullName);
        colFullName.setPrefWidth(200);
        colCustomerID.setPrefWidth(110);
        colPhoneNumber.setPrefWidth(200);
    }

    /**
     * Vndsen tsonhnruu shiljine
     * @param event = button click
     * @throws IOException
     */
    @FXML
    void handleClose(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/cleaningOrder.fxml"));
        Parent homePage = loader.load();
        OrderController orderController=loader.getController();
        orderController.setCustomers(customers);
        orderController.setEmployees(employees);
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
     * hereglegchiin medeelliig haruulah hvsnegtiin utgiig shinechilne
     */
    public void updateTableData() {
        colCustomerID.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("customerID"));
        colPhoneNumber.setCellValueFactory(new PropertyValueFactory<Employee,String>("phoneNumber"));
        colFullName.setCellValueFactory(new PropertyValueFactory<Employee,String>("fullName"));
        dgvCustomers.setItems(customers);
        dgvCustomers.setEditable(true);
    }

    /**
     * Shine hereglegch nemne
     * @param event = button click
     */
    @FXML
    void addCustomer(ActionEvent event)  {
        if(allFieldsIsNotNull()&&validName()&&checkCustomerPhone()){
            String customerPhone=txtCustomerPhone.getText();
            String customerName=txtCustomerName.getText();
            try{
                Employee employee=new Employee();
                Customer customer=new Customer();
                customer.setCustomerID(customers.size()+1);
                customer.setFullName(customerName);
                customer.setPhoneNumber(customerPhone);
                customers.add(customer);
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Ali neg talbariin medeelel buruu baina!");
            }
            updateTableData();
            clearFields();
        }
    }

    public boolean allFieldsIsNotNull(){
        if(txtCustomerName.getText().isEmpty()||txtCustomerPhone.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Ali neg talbariin medeelel hooson baina!");
            return false;
        }
        return true;
    }

    /**
     * Hereglegchiin nernii utga zow temdegt bgaa esehiig shalgana
     * @return nernii utga zow bol true, else fasel
     */
    public boolean validName(){
        if(!txtCustomerName.getText().matches("(?i)[a-z]([- ',.a-z]{0,23}[a-z])?")){
            JOptionPane.showMessageDialog(null, "Nernii utgand buruu temdegt orson baina!");
            return false;
        }
        return true;
    }

    /**
     * Hereglegchiin utasnii dugaar dawhtsah bui esehiig shalgana
     * @return = hereglegchiin utasnii dugaar dawhtsaagvi bol true, else false
     */
    public boolean checkCustomerPhone(){
        String cusNum=txtCustomerPhone.getText();
        for (Customer customer : customers) {
            if (customer.getPhoneNumber().equals(cusNum)) {
                JOptionPane.showMessageDialog(null, "Hereglegchiin utasnii dugaar dawhtsaj baina!");
                return false;
            }
        }
        return true;
    }

    /**
     * Bvh talbariin utgiig hooson bolgono
     */
    private void clearFields(){
        txtCustomerPhone.setText("");
        txtCustomerName.setText("");
    }

    /**
     * Program ehlehed ajillah method
     */
    @FXML
    void initialize() {
        createTableColumns();
        updateTableData();
    }
}
