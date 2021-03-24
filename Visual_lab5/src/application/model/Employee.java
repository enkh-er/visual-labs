package application.model;
import javafx.beans.property.*;

public class Employee {
    private IntegerProperty employeeID;
    private StringProperty employeeNumber;
    private StringProperty firtsName;
    private StringProperty lastName;
    private StringProperty fullName;
    private StringProperty title;
    private IntegerProperty hourlySalary;

    public Employee(IntegerProperty employeeID, StringProperty employeeNumber, StringProperty firtsName, StringProperty lastName, StringProperty fullName, StringProperty title, IntegerProperty hourlySalary) {
        this.employeeID = employeeID;
        this.employeeNumber = employeeNumber;
        this.firtsName = firtsName;
        this.lastName = lastName;
        this.fullName = fullName;
        this.title = title;
        this.hourlySalary = hourlySalary;
    }

    public Employee(){
        this.employeeID=new SimpleIntegerProperty();
        this.employeeNumber=new SimpleStringProperty();
        this.firtsName=new SimpleStringProperty();
        this.lastName=new SimpleStringProperty();
        this.fullName=new SimpleStringProperty();
        this.title=new SimpleStringProperty();
        this.hourlySalary=new SimpleIntegerProperty();
    }

    public int getEmployeeID() {
        return employeeID.get();
    }

    public IntegerProperty employeeIDProperty() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID.set(employeeID);
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

    public String getFirtsName() {
        return firtsName.get();
    }

    public StringProperty firtsNameProperty() {
        return firtsName;
    }

    public void setFirtsName(String firtsName) {
        this.firtsName.set(firtsName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
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

    public String getTitle() {
        return title.get();
    }

    public StringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public int getHourlySalary() {
        return hourlySalary.get();
    }

    public IntegerProperty hourlySalaryProperty() {
        return hourlySalary;
    }

    public void setHourlySalary(int hourlySalary) {
        this.hourlySalary.set(hourlySalary);
    }
}
