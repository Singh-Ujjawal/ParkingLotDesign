package ParkingLotIV;

import java.time.LocalDateTime;

public class Ticket {
    private final int id;
    private TicketStatus status;
    private Spot spot;
    private final LocalDateTime dateTime;
    public Ticket(int id, TicketStatus status, Spot spot, LocalDateTime dateTime) {
        this.id = id;
        this.status = status;
        this.spot = spot;
        this.dateTime = dateTime;
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

    public void setSpot(Spot spot) {
        this.spot = spot;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

}
