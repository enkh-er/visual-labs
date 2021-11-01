package sale;

import alert.CustomAlert;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import main.MainClass;
import model.Customer;
import model.Sale;
import util.SceneController;
import util.SceneEnum;

import java.time.LocalDate;

public class SaleListController extends SceneController {

    @FXML
    private TextField txtCustomerName;

    @FXML
    private DatePicker dtpBillDateTo;

    @FXML
    private DatePicker dtpBillDateFrom;

    @FXML
    private TextField txtBillNo;

    @FXML
    private SplitPane splitPane;

    @FXML
    private AnchorPane anchorPaneTable;

    @FXML
    private TableView<Sale> table;

    @FXML
    private TableColumn<Sale, Number> colId;

    @FXML
    private TableColumn<Sale, Number> colBllNo;

    @FXML
    private TableColumn<Sale, String> colBillDate;

    @FXML
    private TableColumn<Sale, Number> colBillCustomer;

    @FXML
    private TableColumn<Sale, Void> colBillEdit;

    @FXML
    private AnchorPane anchorPanePagination;

    @FXML
    private Pagination pagination;

    @FXML
    private Label lblPage;

    @FXML
    private ComboBox<Number> cbxRows;

    @FXML
    private TextField txtGoToPage;

    /**
     *  Sale-ийн мэдээллийг хайна
     */
    @FXML
    void searchSale() {
        if(checkDate()){
            FilteredList<Sale> filteredData = new FilteredList<>(owner.getSales(), b -> true);
            //Haih talbaruud hooson baiwal hooson utga butsaana
            if(txtCustomerName.getText().trim().isEmpty()
                    &&txtCustomerName.getText()==null
                    &&txtBillNo.getText().trim().isEmpty()
                    &&txtBillNo.getText()==null){
                return;
            }
            //haih talbariin hereglegchiin location hooson bish bol hereglegchiin nereer observable list dotor baigaa ogogdloos filter hiine
            if(txtBillNo.getText()!=null&&!txtBillNo.getText().trim().isEmpty()){
                int billNo=Integer.parseInt(txtBillNo.getText());
                filteredData.setPredicate(sale -> {
                    if (sale.getBillNo()==billNo) {
                        return true; // Filter matches customer location
                    }
                    else
                        return false; // Does not match.
                });
            }
            //haih talbariin hereglegchiin ner hooson bish bol hereglegchiin nereer observable list dotor baigaa ogogdloos filter hiine
            else if(txtCustomerName.getText()!=null||!txtCustomerName.getText().trim().isEmpty()){
                int id=getCustomerID(txtCustomerName.getText());
                filteredData.setPredicate(sale -> {
                    if (sale.getCustomer() == id ) {
                        return true; // Filter matches customer name
                    }
                    else   return false; // Does not match.
                });
            }
            SortedList<Sale> sortedData = new SortedList<>(filteredData);
            sortedData.comparatorProperty().bind(table.comparatorProperty());
            addButtonToTable();
            table.setItems(sortedData);
        }
    }

    public boolean checkDate(){
        if(dtpBillDateTo.getValue().isAfter(LocalDate.now())){
            alertMessage(false,"Invalid date range");
            return false;
        }
        return true;
    }

    public int getCustomerID(String name){
        for(Customer customer:owner.getCustomers()){
            if(customer.getName().equals(name)){
                return customer.getId();
            }
        }
        return -1;
    }

    @FXML
    void initialize(){
        dtpBillDateFrom.setValue(LocalDate.now());
        dtpBillDateTo.setValue(LocalDate.now());
        dtpBillDateFrom.valueProperty().bindBidirectional(dtpBillDateTo.valueProperty());
        colId.setCellValueFactory(cellData ->  new ReadOnlyObjectWrapper<Number>(table.getItems().indexOf(cellData.getValue())+1));
        colBllNo.setCellValueFactory(cellData -> cellData.getValue().billNoProperty());
        colBillDate.setCellValueFactory(cellData -> cellData.getValue().billDateProperty());
        colBillCustomer.setCellValueFactory(cellData -> cellData.getValue().customerProperty());
        addButtonToTable();
        checkDate();
    }

    @Override
    public void setOwner(MainClass owner) {
        this.owner = owner;
        table.setItems(owner.getSales());
    }

    /**
     * Хүснэгтэд өөрчлөх товчлуурыг нэмнэ
     */
    private void addButtonToTable() {

        Callback<TableColumn<Sale, Void>, TableCell<Sale, Void>> cellFactory = new Callback<TableColumn<Sale, Void>, TableCell<Sale, Void>>() {
            @Override
            public TableCell<Sale, Void> call(final TableColumn<Sale, Void> param) {
                final TableCell<Sale, Void> cell = new TableCell<Sale, Void>() {

                    private final Button btn = new Button("Edit");
                    {
                        //Butten deer darah ved duudagdana. Tuhain mornii customer-iin medeelliig new customer-ruu damjuulna
                        btn.setOnAction((ActionEvent event) -> {
                            Sale sale = table.getItems().get(getIndex());
                            owner.changeScene(SceneEnum.SCENE_NEW_SALE,sale);
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
        colBillEdit.setCellFactory(cellFactory);
    }

}
