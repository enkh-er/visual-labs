package application.model;

import java.util.Objects;

public class Customer {
    private String accountNo;
    private String firsName;
    private String lastName;
    private String phoneNo;
    private String emergencyName;
    private String emergencyPhone;

    public Customer(){

    }

    public Customer(String accountNo, String firsName, String lastName, String phoneNo, String emergencyName, String emergencyPhone) {
        this.accountNo = accountNo;
        this.firsName = firsName;
        this.lastName = lastName;
        this.phoneNo = phoneNo;
        this.emergencyName = emergencyName;
        this.emergencyPhone = emergencyPhone;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getFirsName() {
        return firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmergencyName() {
        return emergencyName;
    }

    public void setEmergencyName(String emergencyName) {
        this.emergencyName = emergencyName;
    }

    public String getEmergencyPhone() {
        return emergencyPhone;
    }

    public void setEmergencyPhone(String emergencyPhone) {
        this.emergencyPhone = emergencyPhone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return accountNo == customer.accountNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNo);
    }
}
