package application.model;
import javafx.beans.property.*;

public class Customer {
    private IntegerProperty  customerID;
    private StringProperty  fullName;
    private StringProperty  phoneNumber;

    public Customer(IntegerProperty customerID, StringProperty fullName, StringProperty phoneNumber) {
        this.customerID = customerID;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
    }

    public Customer(){
        this.customerID=new SimpleIntegerProperty();
        this.fullName=new SimpleStringProperty();
        this.phoneNumber=new SimpleStringProperty();
    }

    public int getCustomerID() {
        return customerID.get();
    }

    public IntegerProperty customerIDProperty() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID.set(customerID);
    }

    public String getFullName() {
        return fullName.get();
    }

    public StringProperty fullNameProperty() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName.set(fullName);
    }

    public String getPhoneNumber() {
        return phoneNumber.get();
    }

    public StringProperty phoneNumberProperty() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }
}
