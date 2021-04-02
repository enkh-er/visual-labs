package application.database;

import application.model.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class CustomerDAO implements DAO<Customer>{

    Connection conn=MySqlDaoFactory.createConnection();
    ResultSet rs=null;
    PreparedStatement ps=null;

    @Override
    public Customer findById(String id) {
        String sql="Select * from Customer where accountNumber=?";
        Customer customer=null;
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1,id);
            rs=ps.executeQuery();
            while(rs.next()) {
                customer=new Customer(rs.getString("accountNumber"),
                        rs.getString("firstName"),rs.getString("lastName"),
                        rs.getString("phoneNumber"),rs.getString("emergencyName"),
                        rs.getString("emergencyPhone"));
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public List<Customer> findAll() {
        ObservableList<Customer> list= FXCollections.observableArrayList();
        try {
            ps=conn.prepareStatement("Select * from Customer");
            rs=ps.executeQuery();
            while(rs.next()) {
                list.add(new Customer(rs.getString("accountNumber"),
                        rs.getString("firstName"),rs.getString("lastName"),
                        rs.getString("phoneNumber"),rs.getString("emergencyName"),
                        rs.getString("emergencyPhone")));
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean save(Customer customer) {
        String sql ="insert into Customer (accountNumber,firstName,lastName,phoneNumber,emergencyName,emergencyPhone) values (?,?,?,?,?,?)";
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1, customer.getAccountNo());
            ps.setString(2, customer.getFirsName());
            ps.setString(3, customer.getLastName());
            ps.setString(4, customer.getPhoneNo());
            ps.setString(5, customer.getEmergencyName());
            ps.setString(6, customer.getEmergencyPhone());
            ps.execute();
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
