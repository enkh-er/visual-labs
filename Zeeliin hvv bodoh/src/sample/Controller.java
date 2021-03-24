package sample;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

import javax.swing.JOptionPane;
import java.time.LocalDate;

/**
 * Programiin vildliig bolowsruulah Controller class
 */
public class Controller{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtPrincipal;

    @FXML
    private TextField txtInterestRate;

    @FXML
    private DatePicker dtpStartDate;

    @FXML
    private DatePicker dtpLoandEndDate;

    @FXML
    private TextField txtPeriods;

    @FXML
    private TextField txtInterestEarned;

    @FXML
    private TextField txtFutureValue;

    SimpleDateFormat format = new SimpleDateFormat("dddd, MMMM dd, yyyy");

    @FXML
    private Button btnClose;

    private double interestEarned=0;
    private double futureValue=0;
    private double principal=0;
    private double interestRate=0;
    private double periods=0;
    private LocalDate startDate,endDate;

    /**
     * Hereglegch utga oruulsan bol
     * hereglegchiin oruulsan utgiig unshin shalgaad
     * zeeliin hvv, bolon niit toloh tolboriig olno
     */
    public void calculateInterest() {

        //Hereglegch zeeliin hemjeeg oruulah talbart oorchlolt oruulsan ved duudagdana
        txtPrincipal.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> property, String oldValue, String newValue) {
                try {
                    if (newValue != null && !txtPrincipal.getText().trim().isEmpty()) {
                        principal = Double.parseDouble(newValue);
                        findInterestAndFutureValue();
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Invalid Principal Value");
                }
            }
        });

        //Hereglegch zeeliin hvvg oruulah talbart oorchlolt oruulsan ved duudagdana
//        txtInterestRate.textProperty().addListener(new ChangeListener<String>() {
//            @Override
//            public void changed(ObservableValue<? extends String> property, String oldValue, String newValue) {
//                try {
//                    if (newValue != null && !txtInterestRate.getText().trim().isEmpty()) {
//                        interestRate = Double.parseDouble(newValue) / 100;
//                        findInterestAndFutureValue();
//                    }
//                } catch (Exception e) {
//                    JOptionPane.showMessageDialog(null, "Invalid Interest Rate");
//                }
//            }
//        });

        txtInterestRate.textProperty().addListener((ov, oldValue, newValue)-> {

                try {
                    if (newValue != null && !txtInterestRate.getText().trim().isEmpty()) {
                        System.out.println(newValue+" hh");
                        interestRate = Double.parseDouble(newValue) / 100;
                        findInterestAndFutureValue();
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Invalid Interest Rate");
                }
        });

        //Hereglegch zeel ehleh ognoog oruulah talbart oorchlolt oruulsan ved duudagdana
        dtpStartDate.valueProperty().addListener((ov, oldValue, newValue) -> {
            startDate = newValue;
            findInterestAndFutureValue();
        });

        //Hereglegch zeel duusah ognoog oruulah talbart oorchlolt oruulsan ved duudagdana
        dtpLoandEndDate.valueProperty().addListener((ov, oldValue, newValue) -> {
            endDate = newValue;
            findInterestAndFutureValue();
        });
    }

    /**
     * Hereglegchiin oruulsan odor zow esehiig shalgana
     * Ingehdee zeeliin ehleh odor duusah odriin daraa baiwal exception vvsgene
     * @param startDate - zeeliin ehleh odor
     * @param endDate - zeeliin duusah odor
     */
    static void validateDate(LocalDate startDate,LocalDate endDate){
        if(startDate.isAfter(endDate))
            throw new IllegalArgumentException("Invalid Date Sequence: " +
                    "the end date must occur after the start date");
    }

    /**
     * Hereglegchiin ogson utguudaar
     * Zeeliin hvv bolon niit tolboriin hemjeeg oloh method
     */
    public void findInterestAndFutureValue(){
        if(isAllFieldNotEmpty()){
            double period=0;
            double p=0;
            try
            {
                validateDate(startDate,endDate);
            }
            catch(IllegalArgumentException e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            int  days  = (int) Math.abs(endDate.toEpochDay() - startDate.toEpochDay());
            txtPeriods.setText(String.valueOf(days));

            try
            {
                p = Double.parseDouble(txtPeriods.getText());
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Invalid number of days");
            }

            period=p/365;
            interestEarned = principal * interestRate * period;
            futureValue = principal + interestEarned;

            txtInterestEarned.setText("$"+String.format("%.2f",interestEarned));
            txtFutureValue.setText("$"+String.format("%.2f",futureValue));

        }

    }

    /**
     * Hereglegch bvh talbariin utgiig ogson esehiig shalgana
     * Boolean utga butsaana
     * @return herew bvh ogogdold utga oruulsan bol true
     * esreg tohioldold false utga butsaana
     */
    public boolean isAllFieldNotEmpty(){
        if(principal==0 || interestRate==0 || startDate==null||endDate==null){
            return false;
        }
        else{
            return true;
        }
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
     * Program ehlehees omno ajillah method
     */
    @FXML
    void initialize() {
        calculateInterest();
    }
}
