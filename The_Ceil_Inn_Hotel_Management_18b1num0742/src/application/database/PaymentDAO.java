package application.database;

import application.model.Payment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public class PaymentDAO implements DAO<Payment>{

    Connection conn=MySqlDaoFactory.createConnection();
    ResultSet rs=null;
    PreparedStatement ps=null;

    @Override
    public Payment findById(String id) {
        return null;
    }

    @Override
    public List<Payment> findAll() {
        ObservableList<Payment> list= FXCollections.observableArrayList();
        try {
            ps=conn.prepareStatement("Select * from Payment");
            rs=ps.executeQuery();
            while(rs.next()) {
                list.add(new Payment(rs.getInt("receiptNumber"),
                        rs.getString("employeeNumber"), LocalDate.parse(rs.getString("paymentDate")),
                        rs.getString("accountNumber"),LocalDate.parse(rs.getString("firstDayOccupied")),
                        LocalDate.parse(rs.getString("lastDatOccupied")),rs.getInt("totalNights"),
                        rs.getDouble("phoneUse"),
                        rs.getDouble("amountCharged"),rs.getDouble("subTotal")
                        ,rs.getDouble("taxRate"),rs.getDouble("taxAmount")
                        ,rs.getDouble("totalAmoundPaid")));
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean save(Payment payment) {
        String sql ="insert into Payment (receiptNumber,employeeNumber,paymentDate,accountNumber,firstDayOccupied,lastDatOccupied,totalNights,phoneUse," +
                "amountCharged,subTotal,taxRate,taxAmount,totalAmoundPaid) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            ps=conn.prepareStatement(sql);
            ps.setInt(1, payment.getReceiptNo());
            ps.setString(2, payment.getEmployeeNo());
            ps.setString(3,payment.getPaymentDate().toString());
            ps.setString(4, payment.getAccountNo());
            ps.setString(5,payment.getFirstDayOccupied().toString());
            ps.setString(6, payment.getLastDatOccupied().toString());
            ps.setInt(7, payment.getTotalNights());
            ps.setDouble(8,payment.getPhoneUse());
            ps.setDouble(9,payment.getAmountCharged());
            ps.setDouble(10, payment.getSubTotal());
            ps.setDouble(11,payment.getTaxRate());
            ps.setDouble(12, payment.getTaxAmount());
            ps.setDouble(13,payment.getTotalAmoundPaid());

            ps.execute();
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
