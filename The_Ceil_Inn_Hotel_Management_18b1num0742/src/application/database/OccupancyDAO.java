package application.database;

import application.model.Customer;
import application.model.Occupancy;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.List;

public class OccupancyDAO implements DAO<Occupancy>{

    Connection conn=MySqlDaoFactory.createConnection();
    ResultSet rs=null;
    PreparedStatement ps=null;

    @Override
    public Occupancy findById(String id) {
        String sql="Select * from Occupancy where occupancyNumber=?";
        Occupancy occupancy=null;
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1,id);
            rs=ps.executeQuery();
            while(rs.next()) {
                occupancy=new Occupancy(rs.getString("occupancyNumber"),
                        LocalDate.parse(rs.getString("dateOccupied")),
                        rs.getString("processedBy"),rs.getString("processedFor"),
                        rs.getString("roomOccupied"),rs.getDouble("rateApplied"),
                        rs.getDouble("phoneUse"));
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return occupancy;
    }

    @Override
    public List<Occupancy> findAll() {
        ObservableList<Occupancy> list= FXCollections.observableArrayList();
        try {
            ps=conn.prepareStatement("Select * from Occupancy");
            rs=ps.executeQuery();
            while(rs.next()) {
                list.add(new Occupancy(rs.getString("occupancyNumber"),
                        LocalDate.parse(rs.getString("dateOccupied")),
                        rs.getString("processedBy"),rs.getString("processedFor"),
                        rs.getString("roomOccupied"),rs.getDouble("rateApplied"),
                        rs.getDouble("phoneUse")));
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean save(Occupancy occupancy) {
        String sql ="insert into Occupancy (occupancyNumber,dateOccupied,processedBy,processedFor,roomOccupied,rateApplied,phoneUse) values (?,?,?,?,?,?,?)";
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1, occupancy.getOccupancyNo());
            ps.setString(2, occupancy.getDateOccupied().toString());
            ps.setString(3, occupancy.getProcessedBy());
            ps.setString(4, occupancy.getProcessedFor());
            ps.setString(5, occupancy.getRoomOccupied());
            ps.setDouble(6, occupancy.getRateApplied());
            ps.setDouble(7, occupancy.getPhoneUse());
            ps.execute();
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
