package application.model;

import java.util.Objects;

public class Room {
    private String roomNo;
    private String roomType;
    private String bedType;
    private double rate;
    private String status;

    public Room() {
    }

    public Room(String roomNo, String roomType, String bedType, double rate, String status) {
        this.roomNo = roomNo;
        this.roomType = roomType;
        this.bedType = bedType;
        this.rate = rate;
        this.status = status;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room)) return false;
        Room room = (Room) o;
        return roomNo == room.roomNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNo);
    }
}
