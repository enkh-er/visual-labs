package sale;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.util.Callback;
import main.MainClass;
import model.Purchase;
import util.SceneController;

public class BatchController extends SceneController {

    @FXML
    private TableView<Purchase> table;

    @FXML
    private TableColumn<Purchase, String> batchName;

    @FXML
    private TableColumn<Purchase, String> colExpiry;

    @FXML
    private TableColumn<Purchase, Number> colRate;

    @FXML
    private TableColumn<Purchase, Number> colMRP;

    @FXML
    private TableColumn<Purchase, Number> colAvailable;

    @FXML
    private TableColumn<Purchase, Void> colSelect;

    private int index;

    private Stage dialogStage;

    private NewSaleController newSaleController;

    ObservableList<Purchase> batchList= FXCollections.observableArrayList();

    /**
     * Main объект үүсгэх метод
     * @param owner Main class-аас дамжуулах объект
     */
    public void setOwner(MainClass owner) { this.owner = owner; }

    public void setDialogStage(javafx.stage.Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setNewSaleController(NewSaleController newSaleController){
        this.newSaleController=newSaleController;
    }

    public void setIndex(int index){
        this.index=index;
    }

    public void closeDialogStage() {
        dialogStage.close();
    }

    /**
     * Хүснэгтэд өөрчлөх товчлуурыг нэмнэ
     */
    private void addButtonToTable() {

        Callback<TableColumn<Purchase, Void>, TableCell<Purchase, Void>> cellFactory = new Callback<TableColumn<Purchase, Void>, TableCell<Purchase, Void>>() {
            @Override
            public TableCell<Purchase, Void> call(final TableColumn<Purchase, Void> param) {
                final TableCell<Purchase, Void> cell = new TableCell<Purchase, Void>() {

                    private final Button btn = new Button("Select");
                    {
                        //Button deer darah ved duudagdana. Tuhain mornii customer-iin medeelliig new customer-ruu damjuulna
                        btn.setOnAction((ActionEvent event) -> {
                            Purchase batch = table.getItems().get(getIndex());
                            closeDialogStage();
//                            newSaleController.setAvailable(batch.getQuantity()-batch.getReturnn());
                            newSaleController.setAvailable(3);
                            newSaleController.setBatch(batch.getBatch(),index);
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
        colSelect.setCellFactory(cellFactory);
    }

    public void findBatchData(int code){
        for(Purchase p:owner.getPurchases()){
            if(p.getProduct()==code){
                int available=p.getQuantity()-p.getReturnn();
                if(available>0){
                    batchList.add(p);
                }
            }
        }
        table.setItems(batchList);
    }

    @FXML
    void initialize() {
        batchName.setCellValueFactory(cellData -> cellData.getValue().batchProperty());
        colExpiry.setCellValueFactory(cellData -> cellData.getValue().billDateProperty());
        colRate.setCellValueFactory(cellData -> cellData.getValue().rateProperty());
        colMRP.setCellValueFactory(cellData -> cellData.getValue().mrpProperty());

        colAvailable.setCellValueFactory(cellData -> {
            Purchase data = cellData.getValue();
            return Bindings.createIntegerBinding(
                    () -> {
                        try {
                            int returnn =data.getReturnn();
                            int quantity = data.getQuantity();
                            return quantity - returnn ;
                        } catch (NumberFormatException nfe) {
                            return 0 ;
                        }
                    },
                    data.returnnProperty(),
                    data.quantityProperty()
            );
        });
        addButtonToTable();
    }
}
