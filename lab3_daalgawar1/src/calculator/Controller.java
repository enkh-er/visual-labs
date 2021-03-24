package calculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.application.Platform;
/**
 * Controller class
 *@ersin 1.0
 * @author enkh-erdene
 * */
public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtNumber1;

    @FXML
    private TextField txtNumber2;

    @FXML
    private TextField txtResult;

    @FXML
    private RadioButton rdoAddition;

    @FXML
    private RadioButton rdoSubtraction;

    @FXML
    private RadioButton rdoMultiplication;

    @FXML
    private RadioButton rdoDivision;

    @FXML
    private Button btnClose;

    /**
     * add two numbers
     * @param event - button click
     * */
    @FXML
    void addNumber(ActionEvent event) {
        if(txtNumber1.getText()==null||txtNumber2.getText()==null||txtNumber2.getText().trim().isEmpty()||txtNumber1.getText().trim().isEmpty()){
            txtResult.setText("0.00");
        }
        else{
            float sum=Integer.parseInt(txtNumber1.getText())+Integer.parseInt(txtNumber2.getText());
            txtResult.setText(String.valueOf(sum));
        }

    }

    /**
     * close the program
     * @param event - button click
     * */
    @FXML
    void closeProgram(ActionEvent event) {
        Platform.exit();
    }

    /**
     * divide two numbers
     * @param event - button click
     * */
    @FXML
    void divNumber(ActionEvent event) {
        if(txtNumber1.getText()==null||txtNumber2.getText()==null||txtNumber2.getText().trim().isEmpty()||txtNumber1.getText().trim().isEmpty()){
            txtResult.setText("0.00");
        }
        else{
            float sum=Integer.parseInt(txtNumber1.getText())/Integer.parseInt(txtNumber2.getText());
            txtResult.setText(String.valueOf(sum));
        }
    }

    /**
     * multiply two numbers
     * @param event - button click
     * */
    @FXML
    void multNumber(ActionEvent event) {
        if(txtNumber1.getText()==null||txtNumber2.getText()==null||txtNumber2.getText().trim().isEmpty()||txtNumber1.getText().trim().isEmpty()){
            txtResult.setText("0.00");
        }
        else{
            float sum=Integer.parseInt(txtNumber1.getText())*Integer.parseInt(txtNumber2.getText());
            txtResult.setText(String.valueOf(sum));
        }
    }

    /**
     * Subract two numbers
     * @param event - button click
     * */
    @FXML
    void subNumber(ActionEvent event) {
        if(txtNumber1.getText()==null||txtNumber2.getText()==null||txtNumber2.getText().trim().isEmpty()||txtNumber1.getText().trim().isEmpty()){
            txtResult.setText("0.00");
        }
        else{
            float sum=Integer.parseInt(txtNumber1.getText())-Integer.parseInt(txtNumber2.getText());
            txtResult.setText(String.valueOf(sum));
        }
    }

    @FXML
    void initialize() {
    }
}
