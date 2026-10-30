package ParkingLotIV;

import java.util.List;

public interface ParkingLot {
    Ticket parkVehicle(Vehicle vehicle);
    double unparkVehicle(int ticketID);
    List<Spot> getAvailableSpots(VehicleType type);
}
