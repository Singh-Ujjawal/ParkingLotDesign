package ParkingLotIV;

import java.util.List;

public interface ParkingLot {
    Ticket parkVehicle(Vehicle vehicle,Spot spot);
    double unparkVehicle(Ticket ticket);
    List<Spot> getAvailableSpots(SpotType type);
}
