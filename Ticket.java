package ParkingLotIV;

import java.time.LocalDateTime;

public class Ticket {
    private final int id;
    private final Vehicle vehicle;
    private final Spot spot;
    private final LocalDateTime entryTime;

    private LocalDateTime exitTime;
    private TicketStatus status;
    private double amount;


    public Ticket(int id, Spot spot,Vehicle vehicle, LocalDateTime entryTime) {
        this.id = id;
        this.status = TicketStatus.ACTIVE;
        this.spot = spot;
        this.entryTime = entryTime;
        this.vehicle = vehicle;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getId() {
        return id;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public Spot getSpot() {
        return spot;
    }


    public LocalDateTime getEntryTime() {
        return entryTime;
    }

}
