package application.model;

import java.util.Objects;

public class Employee {
    private String employeeNo;
    private String firstName;
    private String lastName;
    private String title;

    public Employee() {
    }

    public Employee(String employeeNo, String firstName, String lastName, String title) {
        this.employeeNo = employeeNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
    }

    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return employeeNo == employee.employeeNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeNo);
    }
}
