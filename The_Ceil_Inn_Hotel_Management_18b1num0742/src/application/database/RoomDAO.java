package application.database;

import application.model.Room;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class RoomDAO implements DAO<Room>{

    Connection conn=MySqlDaoFactory.createConnection();
    ResultSet rs=null;
    PreparedStatement ps=null;

    @Override
    public Room findById(String id) {
        String sql="Select * from Room where roomNumber=?";
        Room room=null;
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1,id);
            rs=ps.executeQuery();
            while(rs.next()) {
                room=new Room(rs.getString("roomNumber"),
                        rs.getString("roomType"),rs.getString("bedType"),
                        rs.getDouble("rate"),rs.getString("status"));
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return room;
    }

    @Override
    public List<Room> findAll() {
        ObservableList<Room> list= FXCollections.observableArrayList();
        try {
            ps=conn.prepareStatement("Select * from Room");
            rs=ps.executeQuery();
            while(rs.next()) {
                list.add(new Room(rs.getString("roomNumber"),
                        rs.getString("roomType"),rs.getString("bedType"),
                        rs.getDouble("rate"),rs.getString("status")));
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean save(Room room) {
        String sql ="insert into Room (roomNumber,roomType,bedType,rate,status) values (?,?,?,?,?)";
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1, room.getRoomNo());
            ps.setString(2, room.getRoomType());
            ps.setString(3,room.getBedType());
            ps.setDouble(4, room.getRate());
            ps.setString(5,room.getStatus());
            ps.execute();
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
