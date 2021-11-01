package sale;

import alert.CustomAlert;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.util.Callback;
import main.MainClass;
import model.Customer;
import model.Product;
import model.Purchase;
import model.Sale;
import util.SceneController;
import util.SceneEnum;

import java.io.IOException;
import java.time.LocalDate;

/**
 * @author enkherdene
 * @version 1
 * New Sale үүсгэх үйлдлүүдийг тодорхойлох, гүйцэтгэх
 * удирдах класс
 */
public class NewSaleController extends SceneController {

    String contentStyle="-fx-padding: 10;";

    @FXML
    private TextField txtBillNo;

    @FXML
    private TextField txtLocation;

    @FXML
    private TextField txtCustomerTin;

    @FXML
    private TextField txtCustomerDL;

    @FXML
    private ComboBox<String> cbCustomerName;

    @FXML
    private DatePicker dtpBillDate;

    @FXML
    private TableView<Sale> table;

    @FXML
    private Label lblTaxAmount;

    @FXML
    private Label lblTotal;

    @FXML
    private Label lblGrandTotal;

    @FXML
    private TextField txtCustomTaxAmount;

    @FXML
    private TextField txtDiscount;

    @FXML
    private ComboBox<String> cmbPercentage;

    private int available;


    TableColumn colID = new TableColumn("");
    TableColumn colCode = new TableColumn("Code");
    TableColumn colName = new TableColumn("Name");
    TableColumn colBatch = new TableColumn("Batch");
    TableColumn colExpiry = new TableColumn("Expiry");
    TableColumn colQuantity = new TableColumn("Quantity");
    TableColumn colReturn = new TableColumn("Return");
    TableColumn colRate = new TableColumn("Rate");
    TableColumn colMRP = new TableColumn("MRP");
    TableColumn colTax = new TableColumn("Tax");
    TableColumn colTotal = new TableColumn("Total");
    TableColumn colTaxAmt= new TableColumn("Tax Amt");
    TableColumn colGrandTotal = new TableColumn("Grand Total");
    TableColumn colRemove = new TableColumn("");

    ObservableList<String> customerNames= FXCollections.observableArrayList("none","haah");
    ObservableList<Sale> tableDatas= FXCollections.observableArrayList();
    ObservableList<String> cmbItems= FXCollections.observableArrayList("Percentage","Amount");
    ObservableList<Number> comboBoxProductCodes= FXCollections.observableArrayList();
    ObservableList<String> comboBoxProducts= FXCollections.observableArrayList();

    public void setAvailable(int available){
        this.available=available;
    }


    /**
     * hvsnegtiin talbariig vvsgene
     */
    private void createTableColumns(){
        table.getColumns().addAll(colID, colCode, colName,colBatch,colExpiry,colQuantity,
                colReturn,colRate,colMRP,colTax,colTotal,colTaxAmt,colGrandTotal,colRemove);
    }

    /**
     * Хэрэглэгчийн нэрсийг өгөгдлийн сангаас шүүж comboBox-д хийнэ
     */
    public void setCustomerNames(){
        for (Customer customer : owner.getCustomers()) {
            customerNames.add(customer.getName());
        }
        cbCustomerName.getItems().addAll(customerNames);
    }

    /**
     * Бүтээгдэхүүний нэр, кодыг observable list-д онооно
     */
    public void seProductNameAndCode(){
        for (Product product : owner.getProducts()) {
            comboBoxProductCodes.add(product.getId());
            comboBoxProducts.add(product.getName());
        }
    }
    /**
     * Хэрэглэгчийн нэр хоосон эсэхийг шалгана
     * @return хэрэглэгчийн нэр хоосон бол худал эсрэг тохиолдолд үнэн утга буцаана
     */
    public boolean CustomerIsEmpty(){
        if(cbCustomerName.getValue()==null||cbCustomerName.getValue().trim().isEmpty()){
            alertMessage(false,"Please select customer");
            return false;
        }
        return true;
    }

    /**
     * Хэрэглэгчийн нэрийг сонгосон бол хэрэглэгчийн мэдээллийг олоод
     * мэдээллийг нь textfield-үүдэд онооно
     * @param name хэрэглэгчийн нэр
     */
    public void getCustomerInfo(String name){
        for (Customer customer : owner.getCustomers()) {
            if(customer.getName()==name){
                txtCustomerDL.setText(customer.getCustomerDL());
                txtCustomerTin.setText(customer.getCustomerTIN());
                txtLocation.setText(customer.getLocation());
                return;
            }
        }
    }

    public void findBillNo(){
        int i=owner.getSales().size();
        txtBillNo.setText(String.valueOf(i));
    }

    /**
     * Шинэ Sale item хүснэгтэд нэмэх арга
     */
    @FXML
    void handleAddItem() {
        if(CustomerIsEmpty()){
            if(checkBeforeAddItem()){
                Sale sale=new Sale();
                sale.setCustomer(findCustomerName());
                sale.setBillNo(Integer.parseInt(txtBillNo.getText()));
                sale.setQuantity(0);
                sale.setReturnn(0);
                sale.setRate(0.00);
                sale.setMrp(0.00);
                sale.setTax(0.00);
                sale.setTotal(0.00);
                sale.setTaxAmt(0.00);
                sale.setGrandTotal(0.00);
                sale.setBillDate(dtpBillDate.getValue().toString());
                seProductNameAndCode();
                tableDatas.add(sale);
                table.setItems(tableDatas);
                setTableProperty();
            }
        }
    }

    public int findCustomerName(){
        String name=cbCustomerName.getValue();
        for(Customer customer:owner.getCustomers()){
            if(customer.getName().equals(name)){
                return customer.getId();
            }
        }
        return -1;
    }

    /**
     * Хэрэглэгч шинэ Sale item нэмэхэд өмнө нь sale item нэмсэх эсэхийг шалгана
     * мөн хэрэв өмнө нь шинэ item нэмсэн бол тэр Sale item-ийн product, batch, rate-н
     * утгыг зөв эсэхийг шалгана
     * @return
     */
    public boolean checkBeforeAddItem(){
        if(tableDatas.size()==0){
            return true;
        }
        if(validAddItem()){
            return true;
        }
        return false;
    }

    /**
     * Нэмэгдсэн Sale item-ын утгыг зөв эсэхийг шалгана
     * @return
     */
    public boolean validAddItem(){
        int index=tableDatas.size()-1;
        Sale sale=tableDatas.get(index);

        if(!checkProductName(index)){
            return false;
        }
        if(sale.getBatch()==null||sale.getBatch().trim().isEmpty()){
            alertMessage(false,"Batch Name should not be empty");
            return false;
        }
        if(sale.getQuantity()<=0){
            alertMessage(false,"Invalid product quantity");
            return false;
        }
        else{
            return true;
        }
    }

    /**
     * Sale хийх бүтээгдэхүүнээ сонгосон эсэхийг шалгана
     * @param i - observable list-д байх индэкс
     * @return - бүтээгдэхүүнээ сонгосон бол үнэн утга буцаана
     */
    public boolean checkProductName(int i){
        String errorMessage = "";
        Sale sale=tableDatas.get(i);
        if(sale.getProduct()==-1){
            errorMessage += "Please select a product code";
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            alertMessage(false,errorMessage);
            return false;
        }
    }

    /**
     * Sale-ийг цуцлана. Salelist-руу шилжинэ
     */
    @FXML
    void handleCancelSale() {
        owner.changeScene(SceneEnum.SCENE_SALE_LIST);
    }

    @FXML
    void handlePrintSale() {
        alertMessage(true,"Sale printed successfully");
    }

    /**
     * Sale-ийг хадгална
     */
    @FXML
    void handleSaveSale() {
        if(tableDatas.size()==0){
            alertMessage(false,"Please add product");
            return;
        }
        if(validAddItem()){
            int error=0;
            for(Sale sale:tableDatas){
                if(!db.insertSale(sale)){
                    error=-1;
                }
            }
            if(error==-1){
                alertMessage(false,"Could not save data, please try again");
            }
            else{
                alertMessage(true,"Customer details added successfully");
                owner.changeScene(SceneEnum.SCENE_SALE_LIST);
                owner.getSales().addAll(tableDatas);
            }

        }
    }

    /**
     * Batch-ийг сонгох хүснэгтийг шинэ цонхонд харуулна
     */
    @FXML
    private void handleBatch(int productId,int index) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Batch2.fxml"));
            Parent page = loader.load();
            Stage batchStage = new Stage();
            batchStage.setTitle("Select Batch");
            batchStage.initModality(Modality.WINDOW_MODAL);
            batchStage.initOwner(parentStage);
            Scene scene = new Scene(page);
            batchStage.setScene(scene);
            BatchController controller = loader.getController();
            controller.setOwner(owner);
            controller.setNewSaleController(this);
            controller.setDialogStage(batchStage);
            controller.findBatchData(productId);
            controller.setIndex(index);
            batchStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setBatch(String batch,int index){
        System.out.println(batch+index);
        tableDatas.get(index).setBatch(batch);
    }

    /**
     * Rate-ийг сонгох хүснэгтийг харуулна
     */
    @FXML
    private void handleRate(int index) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Rate.fxml"));
            Parent page = loader.load();
            Stage rateStage = new Stage();
            rateStage.setTitle("Select Batch");
            rateStage.initModality(Modality.WINDOW_MODAL);
            rateStage.initOwner(parentStage);
            Scene scene = new Scene(page);
            rateStage.setScene(scene);
            RateController controller = loader.getController();
            controller.setOwner(owner);
            controller.setNewSaleController(this);
            controller.setDialogStage(rateStage);
            controller.setIndex(index);
            rateStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setSaleRate(int saleRate,int index){
        tableDatas.get(index).setRate(saleRate);
        calculateSale(tableDatas.get(index));
    }

    @FXML
    void initialize(){
        txtBillNo.setDisable(true);
        txtLocation.setDisable(true);
        txtCustomerTin.setDisable(true);
        txtCustomerDL.setDisable(true);
        dtpBillDate.setValue(LocalDate.now());
        createTableColumns();
        cmbPercentage.getItems().addAll(cmbItems);
//        setTableProperty();
        cbCustomerName.valueProperty().addListener((val,oldVal,newVal)->{
            getCustomerInfo(newVal);
        });
        calculateDiscountCustomTaxAmt();
    }

    /**
     * Main class-ыг тохируулна
     * @param owner Main class-аас дамжуулах объект
     */
    @Override
    public void setOwner(MainClass owner) {
        this.owner = owner;
        setCustomerNames();
        findBillNo();
    }

    /**
     * table-ийн талбаруудыг авах утгыг тохируулна
     */
    public void setTableProperty(){
        table.setEditable(true);
        table.getSelectionModel().setCellSelectionEnabled(true);
        addIdColumn();
        addTextfieldToTable(colQuantity,"quantity");
        addTextfieldToTable(colReturn,"returnn");
        colBatch.setCellValueFactory(new PropertyValueFactory<Sale,Number>("batch"));
        colRate.setCellValueFactory(new PropertyValueFactory<Sale,Number>("rate"));
        colMRP.setCellValueFactory(new PropertyValueFactory<Sale,Number>("mrp"));
        colTax.setCellValueFactory(new PropertyValueFactory<Sale,Number>("tax"));
        colTotal.setCellValueFactory(new PropertyValueFactory<Sale,Number>("total"));
        colTaxAmt.setCellValueFactory(new PropertyValueFactory<Sale,Number>("taxAmt"));
        colGrandTotal.setCellValueFactory(new PropertyValueFactory<Sale,Number>("grandTotal"));
        addComboBoxToTable(colName,comboBoxProducts);
        addComboBoxToTable(colCode,comboBoxProductCodes);
        addButtonToTable();
        addDatePickerToTable();
        table.getFocusModel().focusedCellProperty().addListener(
                new ChangeListener<TablePosition>() {
                    @Override
                    public void changed(ObservableValue<? extends TablePosition> observable,
                                        TablePosition oldPos, TablePosition pos) {
                        if(pos.getColumn()==3){
                            int index=pos.getRow();
                            if(checkProductName(index)){
                                handleBatch(tableDatas.get(index).getProduct(),index);
                            }
                        }
                        else if(pos.getColumn()==7){
                            int index=pos.getRow();
                            if(checkProductName(index)){
                                handleRate(index);
                            }
                        }
                    }
                });
    }

    public void calculateDiscountCustomTaxAmt(){
        txtCustomTaxAmount.textProperty().addListener((val,oldVal,newVal)->{
            int gt=Integer.parseInt(lblGrandTotal.getText());
            int d=Integer.parseInt(txtCustomTaxAmount.getText());
            int labelGrandTotal= gt+d;
            lblGrandTotal.setText(String.valueOf(labelGrandTotal));
        });
        txtDiscount.textProperty().addListener((val,oldVal,newVal)->{
            double t=Double.parseDouble(lblTotal.getText());
            double d=Double.parseDouble(txtDiscount.getText());
            System.out.println(t);
            System.out.println(d);
            double labelTotal=  t-(d*t/100);

            lblTotal.setText(String.valueOf(labelTotal));
        });
    }

    public void calculateSale(Sale sale){
        double total,taxAmount,grandTotal;
        if(sale.getQuantity()>0&&sale.getRate()>0){
            total=sale.getRate()*(sale.getQuantity()-sale.getReturnn());
            taxAmount=((total*sale.getRate()/100)*100)/100;
            grandTotal=((total+taxAmount)*100)/100;
            sale.setTotal(total);
            sale.setTaxAmt(taxAmount);
            sale.setGrandTotal(grandTotal);
            double lblTaxAmt=Double.parseDouble(lblTaxAmount.getText())+taxAmount;
            double labelTotal= (Double.parseDouble(lblTotal.getText())+total);
            int labelGrandTotal= (int) (Double.parseDouble(lblGrandTotal.getText())+grandTotal);
            lblTaxAmount.setText(String.valueOf(lblTaxAmt));
            lblTotal.setText(String.valueOf(labelTotal));
            lblGrandTotal.setText(String.valueOf(labelGrandTotal));
        }
    }

    public void addDatePickerToTable(){
        //Expiry
        Callback<TableColumn<Purchase, Void>, TableCell<Purchase, Void>> cellFactory = new Callback<TableColumn<Purchase, Void>, TableCell<Purchase, Void>>() {
            @Override
            public TableCell<Purchase, Void> call(final TableColumn<Purchase, Void> param) {
                final TableCell<Purchase, Void> cell = new TableCell<Purchase, Void>() {

                    private final DatePicker dp = new DatePicker();
                    {
                        dp.setValue(LocalDate.now());
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(dp);
                        }
                    }
                };
                return cell;
            }
        };
        colExpiry.setCellFactory(cellFactory);
    }

    /**
     * Table-ийн өгөгдсөн талбар шинэ мөр нэмэгдэх болгонд тухайн мөрийн тоогоор
     * хүснэгтийн дугаарыг онооно
     */
    private void addIdColumn(){
        colID.setCellFactory((col) -> {
            TableCell<Sale, Number> cell = new TableCell<Sale, Number>() {
                @Override
                public void updateItem(Number item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);

                    if (!empty) {
                        int rowIndex = this.getIndex() + 1;
                        this.setText(String.valueOf(rowIndex));
                    }
                }
            };
            return cell;
        });
    }

    /**
     * Table-ийн өгөгдсөн талбарт textfield нэмнэ
     * @param column - textfield нэмэх талбар
     */
    private  void addTextfieldToTable(TableColumn column,String pName){
        Callback<TableColumn<Sale, Void>, TableCell<Sale, Void>> cellFactory = new Callback<TableColumn<Sale, Void>, TableCell<Sale, Void>>() {
            @Override
            public TableCell<Sale, Void> call(final TableColumn<Sale, Void> param) {
                final TableCell<Sale, Void> cell = new TableCell<Sale, Void>() {
                    private final TextField textField = new TextField("0");
                    {
                        textField.setStyle("-fx-border-color: white");
                        textField.textProperty().addListener((val,oldVal,newVal)->{
                            try {
                                System.out.println("textfield daragdlaa "+newVal);
                                int i=getIndex();
                                Sale sale=tableDatas.get(i);
                                if(column==colQuantity){
                                    textField.setText(textField.getText());
                                    sale.setQuantity(Integer.parseInt(textField.getText()));
                                    calculateSale(sale);
                                }
                                if(column==colReturn){
                                    int returnn=Integer.parseInt(textField.getText());
                                    if(sale.getQuantity()>=returnn){
                                        textField.setText(textField.getText());
                                        sale.setReturnn(returnn);
                                        calculateSale(sale);
                                    }
                                    else {
                                        alertMessage(false,"Invalid return quantity");
                                    }

                                }
                            }catch (Exception e){
                                e.printStackTrace();
                            }

                        });
                    }
                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(textField);
                        }
                    }
                };
                return cell;
            }
        };
        column.setCellFactory(cellFactory);
    }

    private final  ComboBox comboBoxCode=new ComboBox();
    private  ComboBox comboBoxName=new ComboBox();

    /**
     * Table-ийн өгөгдсөн талбарт комбобокс нэмнэ
     * @param column - комбобокс нэмэх талбар
     * @param list - комбобоксийн авах утга
     */
    private  void addComboBoxToTable(TableColumn column,ObservableList list) {
        Callback<TableColumn<Sale, Void>, TableCell<Sale, Void>> cellFactory = new Callback<TableColumn<Sale, Void>, TableCell<Sale, Void>>() {
            @Override
            public TableCell<Sale, Void> call(final TableColumn<Sale, Void> param) {
                final TableCell<Sale, Void> cell = new TableCell<Sale, Void>() {
                    private final ComboBox comboBox = new ComboBox(list);
                    {
                        comboBox.valueProperty().addListener((val,oldVal,newVal)->{
                            if(column==colCode){
                                Sale sale=tableDatas.get(getIndex());
                                sale.setProduct((int)newVal);
                                sale.setBatch("");
                                //id-aar ni product name-iig database-aas haij olno
                                tableDatas.get(getIndex());
                                for (Product product : owner.getProducts()) {
                                    if(product.getId()==(int)newVal){
                                        sale.setTax(product.getTax());
                                    }
                                }
                            }
                            else {
                                //product name-aar ni id-iig database-aas haij olno
                                System.out.println("combo box product daragdlaa "+newVal);
                            }
//                            tableDatas.get(getIndex()).set

                        });
                    }
                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(comboBox);
                        }
                    }
                };
                return cell;
            }
        };
        column.setCellFactory(cellFactory);
    }

    /**
     * Хүснэгтэд өөрчлөх товчлуурыг нэмнэ
     */
    private void addButtonToTable() {

        Callback<TableColumn<Sale, Void>, TableCell<Sale, Void>> cellFactory = new Callback<TableColumn<Sale, Void>, TableCell<Sale, Void>>() {
            @Override
            public TableCell<Sale, Void> call(final TableColumn<Sale, Void> param) {
                final TableCell<Sale, Void> cell = new TableCell<Sale, Void>() {

                    private final Button btn = new Button("Remove");
                    {
                        //Butten deer darah ved duudagdana. Tuhain mornii customer-iin medeelliig new customer-ruu damjuulna
                        btn.setOnAction((ActionEvent event) -> {
                            CustomAlert customAlert=new CustomAlert(Alert.AlertType.CONFIRMATION,"Confirm","Are you sure you want to delete this item","","Yes","Cancel");
                            int result = customAlert.customShowAndWait();
                            if(result==1){
                                Sale sale = table.getItems().get(getIndex());
                                double lblTaxAmt=Double.parseDouble(lblTaxAmount.getText())-sale.getTaxAmt();
                                double labelTotal= (Double.parseDouble(lblTotal.getText())-sale.getTotal());
                                int labelGrandTotal= (int) (Double.parseDouble(lblGrandTotal.getText())-sale.getGrandTotal());
                                lblTaxAmount.setText(String.valueOf(lblTaxAmt));
                                lblTotal.setText(String.valueOf(labelTotal));
                                lblGrandTotal.setText(String.valueOf(labelGrandTotal));
                                tableDatas.remove(sale);
                            }
                        });
                    }
                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };
        colRemove.setCellFactory(cellFactory);
    }

}
