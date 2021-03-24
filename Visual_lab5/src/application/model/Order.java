package application.model;
import javafx.beans.property.*;

import java.time.LocalDate;
import java.time.LocalTime;

public class Order {
    private IntegerProperty cleaningOrderID;
    private StringProperty  employeeNumber;
    private StringProperty customerNumber;
    private ObjectProperty<LocalDate> dateLeft;
    private ObjectProperty<LocalTime> timeLeft;
    private ObjectProperty<LocalDate>dateExpected;
    private ObjectProperty<LocalTime>timeExpected;
    private StringProperty orderStatus ;
    private ObjectProperty<LocalDate>datePickedUp;
    private ObjectProperty<LocalTime>timePickedUp;
    private DoubleProperty  unitPriceShirts;
    private DoubleProperty quantityShirts;
    private DoubleProperty subTotalShirts ;
    private DoubleProperty unitPricePants;
    private DoubleProperty quantityPants;
    private DoubleProperty subTotalPants;
    private StringProperty item1Name;
    private DoubleProperty unitPriceItem1;
    private DoubleProperty quantityItem1;
    private DoubleProperty subTotalItem1;
    private StringProperty item2Name;
    private DoubleProperty unitPriceItem2;
    private DoubleProperty quantityItem2;
    private DoubleProperty subTotalItem2 ;
    private StringProperty item3Name;
    private DoubleProperty unitPriceItem3 ;
    private DoubleProperty  quantityItem3;
    private DoubleProperty subTotalItem3;
    private StringProperty item4Name;
    private DoubleProperty unitPriceItem4;
    private DoubleProperty quantityItem4 ;
    private DoubleProperty  subTotalItem4;
    private DoubleProperty cleaningTotal;
    private DoubleProperty taxRate;
    private DoubleProperty taxAmount;
    private DoubleProperty  netPrice;
    private StringProperty text;

    public Order(){
        this.cleaningOrderID=new SimpleIntegerProperty();
        this.employeeNumber=new SimpleStringProperty();
        this.customerNumber=new SimpleStringProperty();
        this.dateLeft=new SimpleObjectProperty<LocalDate>();
        this.timeLeft=new SimpleObjectProperty<LocalTime>();
        this.dateExpected=new SimpleObjectProperty<LocalDate>();
        this.timeExpected=new SimpleObjectProperty<LocalTime>();
        this.orderStatus =new SimpleStringProperty();
        this.datePickedUp=new SimpleObjectProperty<LocalDate>();
        this.timePickedUp=new SimpleObjectProperty<LocalTime>();
        this.unitPriceShirts=new SimpleDoubleProperty();
        this.quantityShirts=new SimpleDoubleProperty();
        this.subTotalShirts =new SimpleDoubleProperty();
        this.unitPricePants=new SimpleDoubleProperty();
        this.quantityPants=new SimpleDoubleProperty();
        this.subTotalPants=new SimpleDoubleProperty();
        this.item1Name=new SimpleStringProperty();
        this.unitPriceItem1=new SimpleDoubleProperty();
        this.quantityItem1=new SimpleDoubleProperty();
        this.subTotalItem1=new SimpleDoubleProperty();
        this.item2Name=new SimpleStringProperty();
        this.unitPriceItem2=new SimpleDoubleProperty();
        this.quantityItem2=new SimpleDoubleProperty();
        this.subTotalItem2 =new SimpleDoubleProperty();
        this.item3Name=new SimpleStringProperty();
        this.unitPriceItem3 =new SimpleDoubleProperty();
        this.quantityItem3=new SimpleDoubleProperty();
        this.subTotalItem3=new SimpleDoubleProperty();
        this.item4Name=new SimpleStringProperty();
        this.unitPriceItem4=new SimpleDoubleProperty();
        this.quantityItem4 =new SimpleDoubleProperty();
        this.subTotalItem4=new SimpleDoubleProperty();
        this.cleaningTotal=new SimpleDoubleProperty();
        this.taxRate=new SimpleDoubleProperty();
        this.taxAmount=new SimpleDoubleProperty();
        this.netPrice=new SimpleDoubleProperty();
        this.text=new SimpleStringProperty();
    }

    public int getCleaningOrderID() {
        return cleaningOrderID.get();
    }

    public IntegerProperty cleaningOrderIDProperty() {
        return cleaningOrderID;
    }

    public void setCleaningOrderID(int cleaningOrderID) {
        this.cleaningOrderID.set(cleaningOrderID);
    }

    public String getEmployeeNumber() {
        return employeeNumber.get();
    }

    public StringProperty employeeNumberProperty() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber.set(employeeNumber);
    }

    public String getCustomerNumber() {
        return customerNumber.get();
    }

    public StringProperty customerNumberProperty() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber.set(customerNumber);
    }

    public LocalDate getDateLeft() {
        return dateLeft.get();
    }

    public ObjectProperty<LocalDate> dateLeftProperty() {
        return dateLeft;
    }

    public void setDateLeft(LocalDate dateLeft) {
        this.dateLeft.set(dateLeft);
    }

    public LocalTime getTimeLeft() {
        return timeLeft.get();
    }

    public ObjectProperty<LocalTime> timeLeftProperty() {
        return timeLeft;
    }

    public void setTimeLeft(LocalTime timeLeft) {
        this.timeLeft.set(timeLeft);
    }

    public LocalDate getDateExpected() {
        return dateExpected.get();
    }

    public ObjectProperty<LocalDate> dateExpectedProperty() {
        return dateExpected;
    }

    public void setDateExpected(LocalDate dateExpected) {
        this.dateExpected.set(dateExpected);
    }

    public LocalTime getTimeExpected() {
        return timeExpected.get();
    }

    public ObjectProperty<LocalTime> timeExpectedProperty() {
        return timeExpected;
    }

    public void setTimeExpected(LocalTime timeExpected) {
        this.timeExpected.set(timeExpected);
    }

    public String getOrderStatus() {
        return orderStatus.get();
    }

    public StringProperty orderStatusProperty() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus.set(orderStatus);
    }

    public LocalDate getDatePickedUp() {
        return datePickedUp.get();
    }

    public ObjectProperty<LocalDate> datePickedUpProperty() {
        return datePickedUp;
    }

    public void setDatePickedUp(LocalDate datePickedUp) {
        this.datePickedUp.set(datePickedUp);
    }

    public LocalTime getTimePickedUp() {
        return timePickedUp.get();
    }

    public ObjectProperty<LocalTime> timePickedUpProperty() {
        return timePickedUp;
    }

    public void setTimePickedUp(LocalTime timePickedUp) {
        this.timePickedUp.set(timePickedUp);
    }

    public double getUnitPriceShirts() {
        return unitPriceShirts.get();
    }

    public DoubleProperty unitPriceShirtsProperty() {
        return unitPriceShirts;
    }

    public void setUnitPriceShirts(double unitPriceShirts) {
        this.unitPriceShirts.set(unitPriceShirts);
    }

    public double getQuantityShirts() {
        return quantityShirts.get();
    }

    public DoubleProperty quantityShirtsProperty() {
        return quantityShirts;
    }

    public void setQuantityShirts(double quantityShirts) {
        this.quantityShirts.set(quantityShirts);
    }

    public double getSubTotalShirts() {
        return subTotalShirts.get();
    }

    public DoubleProperty subTotalShirtsProperty() {
        return subTotalShirts;
    }

    public void setSubTotalShirts(double subTotalShirts) {
        this.subTotalShirts.set(subTotalShirts);
    }

    public double getUnitPricePants() {
        return unitPricePants.get();
    }

    public DoubleProperty unitPricePantsProperty() {
        return unitPricePants;
    }

    public void setUnitPricePants(double unitPricePants) {
        this.unitPricePants.set(unitPricePants);
    }

    public double getQuantityPants() {
        return quantityPants.get();
    }

    public DoubleProperty quantityPantsProperty() {
        return quantityPants;
    }

    public void setQuantityPants(double quantityPants) {
        this.quantityPants.set(quantityPants);
    }

    public double getSubTotalPants() {
        return subTotalPants.get();
    }

    public DoubleProperty subTotalPantsProperty() {
        return subTotalPants;
    }

    public void setSubTotalPants(double subTotalPants) {
        this.subTotalPants.set(subTotalPants);
    }

    public String getItem1Name() {
        return item1Name.get();
    }

    public StringProperty item1NameProperty() {
        return item1Name;
    }

    public void setItem1Name(String item1Name) {
        this.item1Name.set(item1Name);
    }

    public double getUnitPriceItem1() {
        return unitPriceItem1.get();
    }

    public DoubleProperty unitPriceItem1Property() {
        return unitPriceItem1;
    }

    public void setUnitPriceItem1(double unitPriceItem1) {
        this.unitPriceItem1.set(unitPriceItem1);
    }

    public double getQuantityItem1() {
        return quantityItem1.get();
    }

    public DoubleProperty quantityItem1Property() {
        return quantityItem1;
    }

    public void setQuantityItem1(double quantityItem1) {
        this.quantityItem1.set(quantityItem1);
    }

    public double getSubTotalItem1() {
        return subTotalItem1.get();
    }

    public DoubleProperty subTotalItem1Property() {
        return subTotalItem1;
    }

    public void setSubTotalItem1(double qubTotalItem1) {
        this.subTotalItem1.set(qubTotalItem1);
    }

    public String getItem2Name() {
        return item2Name.get();
    }

    public StringProperty item2NameProperty() {
        return item2Name;
    }

    public void setItem2Name(String item2Name) {
        this.item2Name.set(item2Name);
    }

    public double getUnitPriceItem2() {
        return unitPriceItem2.get();
    }

    public DoubleProperty unitPriceItem2Property() {
        return unitPriceItem2;
    }

    public void setUnitPriceItem2(double unitPriceItem2) {
        this.unitPriceItem2.set(unitPriceItem2);
    }

    public double getQuantityItem2() {
        return quantityItem2.get();
    }

    public DoubleProperty quantityItem2Property() {
        return quantityItem2;
    }

    public void setQuantityItem2(double quantityItem2) {
        this.quantityItem2.set(quantityItem2);
    }

    public double getSubTotalItem2() {
        return subTotalItem2.get();
    }

    public DoubleProperty subTotalItem2Property() {
        return subTotalItem2;
    }

    public void setSubTotalItem2(double subTotalItem2) {
        this.subTotalItem2.set(subTotalItem2);
    }

    public String getItem3Name() {
        return item3Name.get();
    }

    public StringProperty item3NameProperty() {
        return item3Name;
    }

    public void setItem3Name(String item3Name) {
        this.item3Name.set(item3Name);
    }

    public double getUnitPriceItem3() {
        return unitPriceItem3.get();
    }

    public DoubleProperty unitPriceItem3Property() {
        return unitPriceItem3;
    }

    public void setUnitPriceItem3(double unitPriceItem3) {
        this.unitPriceItem3.set(unitPriceItem3);
    }

    public double getQuantityItem3() {
        return quantityItem3.get();
    }

    public DoubleProperty quantityItem3Property() {
        return quantityItem3;
    }

    public void setQuantityItem3(double quantityItem3) {
        this.quantityItem3.set(quantityItem3);
    }

    public double getSubTotalItem3() {
        return subTotalItem3.get();
    }

    public DoubleProperty subTotalItem3Property() {
        return subTotalItem3;
    }

    public void setSubTotalItem3(double qubTotalItem3) {
        this.subTotalItem3.set(qubTotalItem3);
    }

    public String getItem4Name() {
        return item4Name.get();
    }

    public StringProperty item4NameProperty() {
        return item4Name;
    }

    public void setItem4Name(String item4Name) {
        this.item4Name.set(item4Name);
    }

    public double getUnitPriceItem4() {
        return unitPriceItem4.get();
    }

    public DoubleProperty unitPriceItem4Property() {
        return unitPriceItem4;
    }

    public void setUnitPriceItem4(double unitPriceItem4) {
        this.unitPriceItem4.set(unitPriceItem4);
    }

    public double getQuantityItem4() {
        return quantityItem4.get();
    }

    public DoubleProperty quantityItem4Property() {
        return quantityItem4;
    }

    public void setQuantityItem4(double quantityItem4) {
        this.quantityItem4.set(quantityItem4);
    }

    public double getSubTotalItem4() {
        return subTotalItem4.get();
    }

    public DoubleProperty subTotalItem4Property() {
        return subTotalItem4;
    }

    public void setSubTotalItem4(double subTotalItem4) {
        this.subTotalItem4.set(subTotalItem4);
    }

    public double getCleaningTotal() {
        return cleaningTotal.get();
    }

    public DoubleProperty cleaningTotalProperty() {
        return cleaningTotal;
    }

    public void setCleaningTotal(double cleaningTotal) {
        this.cleaningTotal.set(cleaningTotal);
    }

    public double getTaxRate() {
        return taxRate.get();
    }

    public DoubleProperty taxRateProperty() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate.set(taxRate);
    }

    public double getTaxAmount() {
        return taxAmount.get();
    }

    public DoubleProperty taxAmountProperty() {
        return taxAmount;
    }

    public void setTaxAmount(double taxAmount) {
        this.taxAmount.set(taxAmount);
    }

    public double getNetPrice() {
        return netPrice.get();
    }

    public DoubleProperty netPriceProperty() {
        return netPrice;
    }

    public void setNetPrice(double netPrice) {
        this.netPrice.set(netPrice);
    }

    public String getText() {
        return text.get();
    }

    public StringProperty textProperty() {
        return text;
    }

    public void setText(String text) {
        this.text.set(text);
    }
}
