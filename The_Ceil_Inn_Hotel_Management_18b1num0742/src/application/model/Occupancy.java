package application.model;

import java.time.LocalDate;

public class Occupancy {
    private String occupancyNo;
    private LocalDate dateOccupied;
    private String processedBy;
    private String processedFor;
    private String roomOccupied;
    private double rateApplied;
    private double phoneUse;

    public Occupancy() {
    }

    public Occupancy(String occupancyNo, LocalDate dateOccupied, String processedBy, String processedFor, String roomOccupied, double rateApplied, double phoneUse) {
        this.occupancyNo = occupancyNo;
        this.dateOccupied = dateOccupied;
        this.processedBy = processedBy;
        this.processedFor = processedFor;
        this.roomOccupied = roomOccupied;
        this.rateApplied = rateApplied;
        this.phoneUse = phoneUse;
    }

    public String getOccupancyNo() {
        return occupancyNo;
    }

    public void setOccupancyNo(String occupancyNo) {
        this.occupancyNo = occupancyNo;
    }

    public LocalDate getDateOccupied() {
        return dateOccupied;
    }

    public void setDateOccupied(LocalDate dateOccupied) {
        this.dateOccupied = dateOccupied;
    }

    public String getProcessedBy() {
        return processedBy;
    }

    public void setProcessedBy(String processedBy) {
        this.processedBy = processedBy;
    }

    public String getProcessedFor() {
        return processedFor;
    }

    public void setProcessedFor(String processedFor) {
        this.processedFor = processedFor;
    }

    public String getRoomOccupied() {
        return roomOccupied;
    }

    public void setRoomOccupied(String roomOccupied) {
        this.roomOccupied = roomOccupied;
    }

    public double getRateApplied() {
        return rateApplied;
    }

    public void setRateApplied(double rateApplied) {
        this.rateApplied = rateApplied;
    }

    public double getPhoneUse() {
        return phoneUse;
    }

    public void setPhoneUse(double phoneUse) {
        this.phoneUse = phoneUse;
    }
}
