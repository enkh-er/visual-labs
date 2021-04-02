package application.database;

import application.model.Customer;
import application.model.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class EmployeeDAO implements DAO<Employee>{
    Connection conn=MySqlDaoFactory.createConnection();
    ResultSet rs=null;
    PreparedStatement ps=null;

    @Override
    public Employee findById(String id) {
        String sql="Select * from Employee where employeeNumber=?";
        Employee employee=null;
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1,id);
            rs=ps.executeQuery();
            while(rs.next()) {
                employee=new Employee(rs.getString("employeeNumber"),
                        rs.getString("firstName"),rs.getString("lastName"),
                        rs.getString("title"));
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public List<Employee> findAll() {
        ObservableList<Employee> list= FXCollections.observableArrayList();
        try {
            ps=conn.prepareStatement("Select * from Employee");
            rs=ps.executeQuery();
            while(rs.next()) {
                list.add(new Employee(rs.getString("employeeNumber"),
                        rs.getString("firstName"),rs.getString("lastName"),
                        rs.getString("title")));
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean save(Employee employee) {
        String sql ="insert into Employee (employeeNumber,firstName,lastName,title) values (?,?,?,?)";
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1, employee.getEmployeeNo());
            ps.setString(2, employee.getFirstName());
            ps.setString(3, employee.getLastName());
            ps.setString(4,employee.getTitle());
            ps.execute();
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
