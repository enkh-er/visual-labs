package sale;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.MainClass;
import model.Customer;
import model.Purchase;
import util.SceneController;

public class RateController extends SceneController {

    @FXML
    private TextField txtRate;

    @FXML
    private TableView<Purchase> table;

    @FXML
    private TableColumn<Purchase, String> colBatch;

    @FXML
    private TableColumn<Purchase, Number> colSaleRate;

    @FXML
    private TableColumn<Purchase, Number> colPurchaseRate;

    @FXML
    private TableColumn<Purchase, Number> colMRP;

    private int index;

    private Stage dialogStage;

    private NewSaleController newSaleController;

    ObservableList<Purchase> rateList= FXCollections.observableArrayList();

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

    public void handleSave(){
        if(rateIsEmpty()){
            try {
                int rate=Integer.parseInt(txtRate.getText());
                closeDialogStage();
                newSaleController.setSaleRate(rate,index);

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private boolean rateIsEmpty(){
        String errorMessage = "";
        if(txtRate.getText()==null||txtRate.getText().length()==0){
            errorMessage += "Invalid sale rate";
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            alertMessage(false,errorMessage);
            return false;
        }
    }

    @FXML
    void initialize() {

    }
}
