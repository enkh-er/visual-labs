package application.controllers;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import application.model.*;
import javafx.application.Platform;
import javafx.beans.binding.*;
import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.LocalTimeStringConverter;
import javafx.util.converter.NumberStringConverter;
import sample.MaskedTextField;

import javax.swing.*;

public class OrderController {

    ObservableList<Order> orders= FXCollections.observableArrayList();
    ObservableList<Employee> employees= FXCollections.observableArrayList();
    ObservableList<Customer> customers= FXCollections.observableArrayList();
    final private DoubleProperty  unitPriceShirts=new ReadOnlyDoubleWrapper();
    final private DoubleProperty quantityShirts=new ReadOnlyDoubleWrapper();
    final private DoubleProperty subTotalShirts= new SimpleDoubleProperty();
    final private DoubleProperty unitPricePants= new SimpleDoubleProperty();
    final private DoubleProperty quantityPants= new SimpleDoubleProperty();
    final private DoubleProperty subTotalPants= new SimpleDoubleProperty();
    final private DoubleProperty unitPriceItem1= new SimpleDoubleProperty();
    final private DoubleProperty quantityItem1= new SimpleDoubleProperty();
    final private DoubleProperty subTotalItem1= new SimpleDoubleProperty();
    final private DoubleProperty unitPriceItem2= new SimpleDoubleProperty();
    final private DoubleProperty quantityItem2= new SimpleDoubleProperty();
    final private DoubleProperty subTotalItem2 = new SimpleDoubleProperty();
    final private DoubleProperty unitPriceItem3= new SimpleDoubleProperty() ;
    final private DoubleProperty  quantityItem3= new SimpleDoubleProperty();
    final private DoubleProperty subTotalItem3= new SimpleDoubleProperty();
    final private DoubleProperty unitPriceItem4= new SimpleDoubleProperty();
    final private DoubleProperty quantityItem4 = new SimpleDoubleProperty();
    final private DoubleProperty  subTotalItem4= new SimpleDoubleProperty();
    final private DoubleProperty cleaningTotal= new SimpleDoubleProperty();
    final private DoubleProperty taxRate=new SimpleDoubleProperty();
    final private DoubleProperty taxAmount=new SimpleDoubleProperty();
    final private DoubleProperty netPrice=new SimpleDoubleProperty();


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

    public ObservableList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ObservableList<Order> orders) {
        this.orders = orders;
    }


    @FXML
    private MaskedTextField txtEmployeeNumber;

    @FXML
    private TextField txtEmployeeName;

    @FXML
    private Button btnNewEmployee;

    @FXML
    private TextField txtCustomerName;

    @FXML
    private Button btnNewCustomer;

    @FXML
    private MaskedTextField txtCustomerPhone;

    @FXML
    private DatePicker dtpDatePickedUp;

    @FXML
    private DatePicker dtpDateLeft;

    @FXML
    private DatePicker dtpDateExpected;

    @FXML
    private Spinner<LocalTime> dtpTimePickedUp;

    @FXML
    private Spinner<LocalTime> dtpTimeExpected;

    @FXML
    private Spinner<LocalTime> dtpTimeLeft;

    @FXML
    private ComboBox<String> cbxItem2Name;

    @FXML
    private ComboBox<String> cbxItem1Name;

    @FXML
    private ComboBox<String> cbxItem3Name;

    @FXML
    private ComboBox<String> cbxItem4Name;

    @FXML
    private TextField txtUnitPriceShirts;

    @FXML
    private TextField txtUnitPricePants;

    @FXML
    private TextField txtUnitPriceItem2;

    @FXML
    private TextField txtUnitPriceItem3;

    @FXML
    private TextField txtUnitPriceItem4;

    @FXML
    private TextField txtUnitPriceItem1;

    @FXML
    private TextField txtQuantityItem2;

    @FXML
    private TextField txtQuantityItem3;

    @FXML
    private TextField txtQuantityItem1;

    @FXML
    private TextField txtQuantityShirts;

    @FXML
    private TextField txtQuantityPants;

    @FXML
    private TextField txtQuantityItem4;

    @FXML
    private TextField txtSubTotalItem3;

    @FXML
    private TextField txtSubTotalPants;

    @FXML
    private TextField txtSubTotalShirts;

    @FXML
    private TextField txtSubTotalItem2;

    @FXML
    private TextField txtSubTotalItem1;

    @FXML
    private TextField txtSubTotalItem4;

    @FXML
    private Button btnSave;

    @FXML
    private ComboBox<String> cbxOrderStatus;

    @FXML
    private TextField txtCleaningTotal;

    @FXML
    private TextField txtTaxRate;

    @FXML
    private TextField txtTaxAmount;

    @FXML
    private TextField txtNetPrice;

    @FXML
    private TextField txtCleaningOrderID;

    @FXML
    private TextField txtNotes;

    @FXML
    private Button btnOpen;

    @FXML
    private Button btnClose;

    @FXML
    private Button btnNewCleaningOrde;

    final private ObservableList<String> cbxItems1 = FXCollections.observableArrayList("None","Women Suit",
            "Dress","Regular Skirt","Skirt With Hook","Men's Suit 2Pc","Men's Suit 3Pc","Sweaters",
            "Silk Shirt","Tie","Coat","Jacket","Swede");

    final private ObservableList<String> cbxItems2 = FXCollections.observableArrayList("None","Women Suit",
            "Dress","Regular Skirt","Skirt With Hook","Men's Suit 2Pc","Men's Suit 3Pc","Sweaters",
            "Silk Shirt","Tie","Coat","Jacket","Swede");

    final private ObservableList<String> cbxItems3 = FXCollections.observableArrayList("None","Women Suit",
            "Dress","Regular Skirt","Skirt With Hook","Men's Suit 2Pc","Men's Suit 3Pc","Sweaters",
            "Silk Shirt","Tie","Coat","Jacket","Swede");

    final private ObservableList<String> cbxItems4 = FXCollections.observableArrayList("None","Women Suit",
            "Dress","Regular Skirt","Skirt With Hook","Men's Suit 2Pc","Men's Suit 3Pc","Sweaters",
            "Silk Shirt","Tie","Coat","Jacket","Swede");

    final private ObservableList<String> cbxItems5 = FXCollections.observableArrayList("Not Yet Ready",
            "Clean Ready for Picked up",
            "Picked up");


    /**
     *Shine ajilchin bvrtgeh tsonhiig vvsgene
     * @param event - button click
     * @throws IOException
     */
    @FXML
    void handleNewEmployee(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/employee.fxml"));
        Parent newEmployeePage = loader.load();
        EmployeeController empC=loader.getController();
        empC.setEmployees(getEmployees());
        empC.setCustomers(getCustomers());
        empC.setOrders(orders);
        empC.updateTableData();
        Scene newEmployeeScene = new Scene(newEmployeePage,700,550);
        String css= OrderController.class.getResource("../application.css").toExternalForm();
        newEmployeeScene.getStylesheets().add(css);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setTitle("Georgetown Cleaning Services - Employees Records");
        app_stage.setScene(newEmployeeScene);
        app_stage.show();
    }


    /**
     * Shine hereglegch bvrtgeh tsonhiig vvsgene
     * @param event - button click
     * @throws IOException
     */
    @FXML
    void handleNewCustomer(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/customer.fxml"));
        Parent newCustomerPage = loader.load();
        CustomerController cusC=loader.getController();
        cusC.setCustomers(customers);
        cusC.setEmployees(employees);
        cusC.setOrders(orders);
        cusC.updateTableData();
        Scene newCustomerScene = new Scene(newCustomerPage,550,550);
        String css= OrderController.class.getResource("../application.css").toExternalForm();
        newCustomerScene.getStylesheets().add(css);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setTitle("Georgetown Cleaning Services - Customer Records");
        app_stage.setScene(newCustomerScene);
        app_stage.show();
    }

    /**
     * Combobox-ii anhnii utgiig onoono
     */
    private void setComboBoxItems(){
        cbxItem1Name.setItems(cbxItems1);
        cbxItem2Name.setItems(cbxItems2);
        cbxItem3Name.setItems(cbxItems3);
        cbxItem4Name.setItems(cbxItems4);
        cbxOrderStatus.setItems(cbxItems5);
    }

    /**
     * Spinner-iin anhnii utgiig onoono
     */
    private void setSpinnerItems(){
        SpinnerValueFactory<LocalTime> value=getSpinnerFactory();
        value.setValue(LocalTime.now());
        SpinnerValueFactory<LocalTime> value2=getSpinnerFactory();
        value2.setValue(LocalTime.now());
        SpinnerValueFactory<LocalTime> value3=getSpinnerFactory();
        value3.setValue(LocalTime.now());
        dtpTimePickedUp.valueFactoryProperty().set(value);
        dtpTimeLeft.valueFactoryProperty().set(value);
        dtpTimeExpected.valueFactoryProperty().set(value3);
        dtpTimeExpected.setEditable(true);
        dtpTimeLeft.setEditable(true);
        dtpTimePickedUp.setEditable(true);
    }

    /**
     * spinner-t onooh utgiig butsaana
     * @return - local time
     */
    private SpinnerValueFactory<LocalTime> getSpinnerFactory(){
        SpinnerValueFactory<LocalTime> value = new SpinnerValueFactory<LocalTime>() {
            {
                String pattern = "HH:mm:ss a";
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
                setConverter(new LocalTimeStringConverter(formatter,null));
            }
            @Override
            public void decrement(int steps) {
                if (getValue() == null)
                    setValue(LocalTime.now());
                else {
                    LocalTime time = (LocalTime) getValue();
                    setValue(time.minusMinutes(steps));
                }
            }

            @Override
            public void increment(int steps) {
                if (this.getValue() == null)
                    setValue(LocalTime.now());
                else {
                    LocalTime time = (LocalTime) getValue();
                    setValue(time.plusMinutes(steps));
                }
            }
        };
        return value;
    }

    public void setBindings(){

        StringConverter<Number> converter = new NumberStringConverter();

//        unitPriceShirts.bind(new DoubleBinding() {
//            {
//                bind(txtUnitPricePants.textProperty());
//            }
//            @Override
//            protected double computeValue() {
//                return Double.parseDouble(txtUnitPricePants.getText());
//            }
//        });

//        unitPriceShirts.bind(txtUnitPricePants.opacityProperty());

        subTotalShirts.bind(unitPriceShirts.multiply(quantityShirts));
        subTotalPants.bind(unitPricePants.multiply(quantityPants));
        subTotalItem1.bind(unitPriceItem1.multiply(quantityItem1));
        subTotalItem2.bind(unitPriceItem2.multiply(quantityItem2));
        subTotalItem3.bind(unitPriceItem3.multiply(quantityItem3));
        subTotalItem3.bind(unitPriceItem3.multiply(quantityItem3));
        cleaningTotal.bind(subTotalShirts.add(subTotalPants).add(subTotalItem1).add(subTotalItem2).add(subTotalItem3).add(subTotalItem4));
        taxAmount.bind(cleaningTotal.multiply(taxRate).divide(100));
        netPrice.bind(cleaningTotal.add(taxAmount));

        Bindings.bindBidirectional(txtQuantityItem2.textProperty(), quantityItem2, converter);
        Bindings.bindBidirectional(txtQuantityItem3.textProperty(), quantityItem3, converter);
        Bindings.bindBidirectional(txtQuantityItem4.textProperty(), quantityItem4, converter);
        Bindings.bindBidirectional(txtSubTotalShirts.textProperty(), subTotalShirts, converter);
        Bindings.bindBidirectional(txtSubTotalPants.textProperty(), subTotalPants, converter);
        Bindings.bindBidirectional(txtSubTotalItem1.textProperty(), subTotalItem1, converter);
        Bindings.bindBidirectional(txtSubTotalItem2.textProperty(), subTotalItem2, converter);
        Bindings.bindBidirectional(txtSubTotalItem3.textProperty(), subTotalItem3, converter);
        Bindings.bindBidirectional(txtSubTotalItem4.textProperty(), subTotalItem4, converter);
        Bindings.bindBidirectional(txtCleaningTotal.textProperty(), cleaningTotal, converter);
        Bindings.bindBidirectional(txtTaxRate.textProperty(), taxRate, converter);
        Bindings.bindBidirectional(txtTaxAmount.textProperty(), taxAmount, converter);
        Bindings.bindBidirectional(txtNetPrice.textProperty(), netPrice, converter);
        Bindings.bindBidirectional(txtUnitPriceShirts.textProperty(), unitPriceShirts, converter);
        Bindings.bindBidirectional(txtUnitPricePants.textProperty(), unitPricePants, converter);
        Bindings.bindBidirectional(txtUnitPriceItem1.textProperty(), unitPriceItem1, converter);
        Bindings.bindBidirectional(txtUnitPriceItem2.textProperty(), unitPriceItem2, converter);
        Bindings.bindBidirectional(txtUnitPriceItem3.textProperty(), unitPriceItem3, converter);
        Bindings.bindBidirectional(txtUnitPriceItem4.textProperty(), unitPriceItem4, converter);
        Bindings.bindBidirectional(txtQuantityShirts.textProperty(), quantityShirts, converter);
        Bindings.bindBidirectional(txtQuantityPants.textProperty(), quantityPants, converter);
        Bindings.bindBidirectional(txtQuantityItem1.textProperty(), quantityItem1, converter);

    }

    /**
     * Zahialga belen boloh hugatsaag tootsno
     */
    public void dtpTimeLeft_ValueChanged(){
        dtpTimeLeft.focusedProperty().addListener(new ChangeListener<Boolean>()
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
            {
               LocalDate dateLeft=dtpDateLeft.getValue();
               LocalTime timeLeft=dtpTimeLeft.getValue();
               LocalTime time9AM=LocalTime.of(9, 0, 0, 11001);

                if(time9AM.isAfter(timeLeft)){
                    dtpDateExpected.setValue(dateLeft);

                    SpinnerValueFactory<LocalTime> value=getSpinnerFactory();
                    value.setValue(LocalTime.of(17, 0, 0, 11001));
                    dtpTimeExpected.valueFactoryProperty().set(value);

               }
                else{

                    if(dateLeft.getDayOfWeek()== DayOfWeek.SATURDAY){
                        dtpDateExpected.setValue(dateLeft.plusDays(2));
                        SpinnerValueFactory<LocalTime> value=getSpinnerFactory();
                        value.setValue(LocalTime.of(8, 0, 0, 11001));
                        dtpTimeExpected.valueFactoryProperty().set(value);
                    }
                    else{
                        dtpDateExpected.setValue(dateLeft.plusDays(1));
                        SpinnerValueFactory<LocalTime> value=getSpinnerFactory();
                        value.setValue(LocalTime.of(8, 0, 0, 11001));
                        dtpTimeExpected.valueFactoryProperty().set(value);
                    }
                }
            }
        });
    }

    /**
     * On sariin anhnii utgiig tootsno
     */
    public void setDate(){
        LocalDate today = LocalDate.now();
        dtpDateLeft.setValue(today);
        dtpDateExpected.setValue(today);
        dtpDatePickedUp.setValue(today);
    }

    /**
     * Hereglegchiin utasnii dugaar bolon ajilchnii dugaariig oruulwal
     * tuhain hereglegch bolon ajilchnii neriig olj haruulna
     */
    public void setEmpNameAndCusName(){
        txtEmployeeNumber.textProperty().addListener(
                (arg,oldVal,newVal)->{
                    for (Employee employee : employees) {
                        if (employee.getEmployeeNumber().equals(newVal)) {
                            txtEmployeeName.setText(employee.getFullName());
                        }
                    }
                }
        );

        txtCustomerPhone.textProperty().addListener(
                (arg,oldVal,newVal)->{
                    for (Customer customer : customers) {
                        if (customer.getPhoneNumber().equals(newVal) ) {
                            txtCustomerName.setText(customer.getFullName());
                        }
                    }
                }
        );

        txtUnitPriceShirts.textProperty().addListener(
                (arg,oldVal,newVal)->{
                    double d=Double.parseDouble(newVal)+Double.parseDouble(txtQuantityShirts.textProperty().get());
                   txtSubTotalShirts.setText(String.valueOf(d));
                }
        );

    }

    /**
     * Shine zahialgiig burtgene
     * Bvrgegdsen zahialga baiwal utgiig ni oorchilno
     * @param event - button click
     */
    @FXML
    void saveCleaningOrder(ActionEvent event){
        if(checkEmployee()&&checkCustomer()){
            if(txtCleaningOrderID.getText().isEmpty()){
                Order order=new Order();
                order.setCleaningOrderID(orders.size()+1);
                order.setEmployeeNumber(txtEmployeeNumber.getText());
                order.setCustomerNumber(txtCustomerPhone.getText());
                order.setDateLeft(dtpDateLeft.getValue());
                order.setTimeLeft(dtpTimeLeft.getValue());
                order.setDateExpected(dtpDateExpected.getValue());
                order.setTimeExpected(dtpTimeExpected.getValue());
                order.setDatePickedUp(dtpDatePickedUp.getValue());
                order.setTimePickedUp(dtpTimePickedUp.getValue());
                order.setUnitPriceShirts(Double.parseDouble(txtUnitPriceShirts.getText()));
                order.setQuantityShirts(Double.parseDouble(txtQuantityShirts.getText()));
                order.setSubTotalShirts(Double.parseDouble(txtSubTotalShirts.getText()));
                order.setUnitPricePants(Double.parseDouble(txtUnitPricePants.getText()));
                order.setQuantityPants(Double.parseDouble(txtQuantityPants.getText()));
                order.setSubTotalPants(Double.parseDouble(txtSubTotalPants.getText()));
                order.setUnitPriceItem1(Double.parseDouble(txtUnitPriceItem1.getText()));
                order.setQuantityItem1(Double.parseDouble(txtQuantityItem1.getText()));
                order.setSubTotalItem1(Double.parseDouble(txtSubTotalItem1.getText()));
                order.setUnitPriceItem2(Double.parseDouble(txtUnitPriceItem2.getText()));
                order.setQuantityItem2(Double.parseDouble(txtQuantityItem2.getText()));
                order.setSubTotalItem2(Double.parseDouble(txtSubTotalItem2.getText()));
                order.setUnitPriceItem3(Double.parseDouble(txtUnitPriceItem3.getText()));
                order.setQuantityItem3(Double.parseDouble(txtQuantityItem3.getText()));
                order.setSubTotalItem3(Double.parseDouble(txtSubTotalItem3.getText()));
                order.setUnitPriceItem4(Double.parseDouble(txtUnitPriceItem4.getText()));
                order.setQuantityItem4(Double.parseDouble(txtQuantityItem4.getText()));
                order.setSubTotalItem4(Double.parseDouble(txtSubTotalItem4.getText()));
                order.setOrderStatus(cbxOrderStatus.getValue());
                order.setItem1Name(cbxItem1Name.getValue());
                order.setItem2Name(cbxItem2Name.getValue());
                order.setItem3Name(cbxItem3Name.getValue());
                order.setItem4Name(cbxItem4Name.getValue());
                order.setCleaningTotal(Double.parseDouble(txtCleaningTotal.getText()));
                order.setTaxRate(Double.parseDouble(txtTaxRate.getText()));
                order.setTaxAmount(Double.parseDouble(txtTaxAmount.getText()));
                order.setNetPrice(Double.parseDouble(txtNetPrice.getText()));
                order.setText(txtNotes.getText());

                orders.add(order);
                JOptionPane.showMessageDialog(null, order.getCleaningOrderID()+" dugaartai zahialgiig amjilttai bvrtgelee.");
                btnNewCleaningOrder_Click();
            }
            else {
                for(Order order:orders){
                    if(Integer.parseInt( txtCleaningOrderID.getText())==order.getCleaningOrderID()){
                        order.setEmployeeNumber(txtEmployeeNumber.getText());
                        order.setCustomerNumber(txtCustomerPhone.getText());
                        order.setDateLeft(dtpDateLeft.getValue());
                        order.setTimeLeft(dtpTimeLeft.getValue());
                        order.setDateExpected(dtpDateExpected.getValue());
                        order.setTimeExpected(dtpTimeExpected.getValue());
                        order.setDatePickedUp(dtpDatePickedUp.getValue());
                        order.setTimePickedUp(dtpTimePickedUp.getValue());
                        order.setUnitPriceShirts(Double.parseDouble(txtUnitPriceShirts.getText()));
                        order.setQuantityShirts(Double.parseDouble(txtQuantityShirts.getText()));
                        order.setSubTotalShirts(Double.parseDouble(txtSubTotalShirts.getText()));
                        order.setUnitPricePants(Double.parseDouble(txtUnitPricePants.getText()));
                        order.setQuantityPants(Double.parseDouble(txtQuantityPants.getText()));
                        order.setSubTotalPants(Double.parseDouble(txtSubTotalPants.getText()));
                        order.setUnitPriceItem1(Double.parseDouble(txtUnitPriceItem1.getText()));
                        order.setQuantityItem1(Double.parseDouble(txtQuantityItem1.getText()));
                        order.setSubTotalItem1(Double.parseDouble(txtSubTotalItem1.getText()));
                        order.setUnitPriceItem2(Double.parseDouble(txtUnitPriceItem2.getText()));
                        order.setQuantityItem2(Double.parseDouble(txtQuantityItem2.getText()));
                        order.setSubTotalItem2(Double.parseDouble(txtSubTotalItem2.getText()));
                        order.setUnitPriceItem3(Double.parseDouble(txtUnitPriceItem3.getText()));
                        order.setQuantityItem3(Double.parseDouble(txtQuantityItem3.getText()));
                        order.setSubTotalItem3(Double.parseDouble(txtSubTotalItem3.getText()));
                        order.setUnitPriceItem4(Double.parseDouble(txtUnitPriceItem4.getText()));
                        order.setQuantityItem4(Double.parseDouble(txtQuantityItem4.getText()));
                        order.setSubTotalItem4(Double.parseDouble(txtSubTotalItem4.getText()));
                        order.setOrderStatus(cbxOrderStatus.getValue());
                        order.setItem1Name(cbxItem1Name.getValue());
                        order.setItem2Name(cbxItem2Name.getValue());
                        order.setItem3Name(cbxItem3Name.getValue());
                        order.setItem4Name(cbxItem4Name.getValue());
                        order.setCleaningTotal(Double.parseDouble(txtCleaningTotal.getText()));
                        order.setTaxRate(Double.parseDouble(txtTaxRate.getText()));
                        order.setTaxAmount(Double.parseDouble(txtTaxAmount.getText()));
                        order.setNetPrice(Double.parseDouble(txtNetPrice.getText()));
                        order.setText(txtNotes.getText());
                        JOptionPane.showMessageDialog(null, order.getCleaningOrderID()+" dugaartai zahialgiig amjilttai oorchilloo.");
                        btnNewCleaningOrder_Click();
                        return;
                    }
                }
            }
        }

    }

    /**
     * Zahialgiin barimtiig olj neene
     * @param event
     */
    @FXML
    void btnOpen_Click(ActionEvent event){
        if(txtCleaningOrderID.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Barimtiin dugaariig oruulaad neeh towch der darna uu!");
            return;
        }
        for (Order order:orders ) {
            if(order.getCleaningOrderID()==Integer.parseInt(txtCleaningOrderID.getText())){
                txtEmployeeNumber.setText(order.getEmployeeNumber());
                txtCustomerPhone.setText(order.getCustomerNumber());
                SpinnerValueFactory<LocalTime> value=getSpinnerFactory();
                SpinnerValueFactory<LocalTime> value2=getSpinnerFactory();
                SpinnerValueFactory<LocalTime> value3=getSpinnerFactory();
                value.setValue(order.getTimeExpected());
                value2.setValue(order.getTimeLeft());
                value3.setValue(order.getTimePickedUp());
                dtpTimeExpected.setValueFactory(value);
                dtpTimeLeft.setValueFactory(value2);
                dtpTimePickedUp.setValueFactory(value3);
                dtpDatePickedUp.setValue(order.getDatePickedUp());
                dtpDateLeft.setValue(order.getDateLeft());
                dtpDateExpected.setValue(order.getDateExpected());
                cbxOrderStatus.setValue(order.getOrderStatus());
                txtUnitPriceShirts.setText(String.valueOf(order.getUnitPriceShirts()));
                txtQuantityShirts.setText(String.valueOf(order.getQuantityShirts())) ;
                txtUnitPricePants.setText(String.valueOf(order.getUnitPricePants())) ;
                txtQuantityPants.setText(String.valueOf(order.getQuantityPants())) ;
                cbxItem1Name.setValue(order.getItem1Name());
                txtUnitPriceItem1.setText(String.valueOf(order.getUnitPriceItem1())) ;
                txtQuantityItem1.setText(String.valueOf(order.getQuantityItem1())) ;
                cbxItem2Name.setValue(order.getItem2Name());
                txtUnitPriceItem2.setText(String.valueOf(order.getUnitPriceItem2())) ;
                txtQuantityItem2.setText(String.valueOf(order.getQuantityItem2())) ;
                cbxItem3Name.setValue(order.getItem3Name());
                txtUnitPriceItem3.setText(String.valueOf(order.getUnitPriceItem3())) ;
                txtQuantityItem3.setText(String.valueOf(order.getQuantityItem3())) ;
                cbxItem4Name.setValue(order.getItem3Name());
                txtUnitPriceItem4.setText(String.valueOf(order.getUnitPriceItem4())) ;
                txtQuantityItem4.setText(String.valueOf(order.getQuantityItem4())) ;
                txtTaxRate.setText(String.valueOf(order.getTaxRate())) ;
                txtNotes.setText(order.getText());
                return;
            }

        }
        JOptionPane.showMessageDialog(null,txtCleaningOrderID.getText()+" dugaartai barimt oldsongvi!");

    }

    /**
     * Shine zahialga vvsgeh talbariig vvsgej. huuchin talbariig tsewerlej baina
     */
    public void btnNewCleaningOrder_Click(){
        txtEmployeeNumber.setText("");
        txtEmployeeName.setText("");
        txtCustomerPhone.setText("");
        txtCustomerName.setText("");
        txtCleaningOrderID.setText("");
        setSpinnerItems();
        setDate();
        cbxOrderStatus.setValue("Not Yet Ready");
        txtUnitPriceShirts.setText("1.25");
        txtQuantityShirts.setText("0") ;
        txtSubTotalShirts.setText("0") ;
        txtUnitPricePants.setText("1.95") ;
        txtQuantityPants.setText("0") ;
        txtSubTotalPants.setText("0") ;
        cbxItem1Name.setValue("None");
        txtUnitPriceItem1.setText("0") ;
        txtQuantityItem1.setText("0") ;
        txtSubTotalItem1.setText("0") ;
        cbxItem2Name.setValue("None");
        txtUnitPriceItem2.setText("0") ;
        txtQuantityItem2.setText("0") ;
        txtSubTotalItem2.setText("0") ;
        cbxItem3Name.setValue("None");
        txtUnitPriceItem3.setText("0") ;
        txtQuantityItem3.setText("0") ;
        txtSubTotalItem3.setText("0") ;
        cbxItem4Name.setValue("None");
        txtUnitPriceItem4.setText("0") ;
        txtQuantityItem4.setText("0") ;
        txtSubTotalItem4.setText("0") ;
        txtCleaningTotal.setText("0") ;
        txtTaxRate.setText("7.75") ;
        txtTaxAmount.setText("0") ;
        txtNotes.setText("");
    }

    /**
     * Achilchnii ner bolon dugaariig shalgana
     * @return herew ajilchnii medeelel baiwal true
     * esreg ved false butsaana
     */
    public boolean checkEmployee(){
        String empNum=txtEmployeeNumber.getText();
        if(empNum.isEmpty()){
            JOptionPane.showMessageDialog(null, "Achilnii dugaar hooson baina!");
            return false;
        }
        else{
            for (Employee employee : employees) {
                if (employee.getEmployeeNumber().equals(empNum)&&employee.getFullName().equals(txtEmployeeName.getText())) {
                    return true;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Achilnii medeelel oldsongvi!");
        return false;
    }

    /**
     * Tuhain hereglegchiin medeelel baigaa esehiin shalgana
     * @return - hereglegch baiwal true, else false butsaana
     */
    public boolean checkCustomer(){
        String cusPhone=txtCustomerPhone.getText();
        if(cusPhone.isEmpty()){
            JOptionPane.showMessageDialog(null, "Hereglegchiin dugaar hooson baina!");
            return false;
        }
        else{
            for (Customer customer : customers) {
                if (customer.getPhoneNumber().equals(cusPhone) &&customer.getFullName().equals(txtCustomerName.getText())) {
                    return true;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Hereglegchiin medeelel oldsongvi!");
        return false;
    }

    /**
     * Programiin vil ajilgaag zogsoono
     * @param event - button click
     */
    @FXML
    void closeProgram(ActionEvent event) {
        Platform.exit();
    }

    /**
     * Program ehlehed shaardlagatai method-iig duudna
     */
    public void initProgram(){
        setComboBoxItems();
        setBindings();
        btnNewCleaningOrder_Click();
        dtpTimeLeft_ValueChanged();
        setEmpNameAndCusName();
    }

    @FXML
    void initialize() {
        initProgram();
    }
}
