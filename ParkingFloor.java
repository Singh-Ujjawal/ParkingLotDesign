package ParkingLotIV;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ParkingFloor {
    private final int floorNumber;
    private final List<Spot> spots;
    public ParkingFloor(int floorNumber) {
        this.floorNumber = floorNumber;
        this.spots = new ArrayList<>();
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void addSpot(Spot spot) {
        spots.add(spot);
    }

    public void removeSpot(Spot spot) {
        spots.remove(spot);
    }

    public List<Spot> getSpots() {
        return Collections.unmodifiableList(spots);
    }
}
