package ParkingLotIV;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PFManager {
        private final Map<Integer,ParkingFloor> parkingFloors =  new HashMap<>();

        public void addParkingFloor(ParkingFloor pf) {
            if(pf==null) {
                throw new IllegalArgumentException("Parking floor cannot be null");
            }
            else if(parkingFloors.containsKey(pf.getFloorNumber())) {
                throw new IllegalArgumentException("Parking floor already exists");
            }
            parkingFloors.put(pf.getFloorNumber(),pf);
        }

        public void removeParkingFloor(ParkingFloor pf) {
            if(pf==null) {
                throw new IllegalArgumentException("Parking floor cannot be null");
            }
            else if(!parkingFloors.containsKey(pf.getFloorNumber())) {
                throw new IllegalArgumentException("Parking floor not exists");
            }
            ParkingFloor existing = parkingFloors.get(pf.getFloorNumber());
            boolean occupied = existing.getSpots().stream().anyMatch(spot -> !spot.isAvailable());
            if(occupied) {
                throw new IllegalStateException("Cannot remove floor with occupied spots");
            }
            parkingFloors.remove(pf.getFloorNumber());
        }

        public void addSpotToParkingFloor(ParkingFloor pf, Spot spot) {
            if(pf==null || spot==null) {
                throw new IllegalArgumentException("Parking Floor or Spot cannot be null");
            }
            else if(!parkingFloors.containsKey(pf.getFloorNumber())) {
                throw new IllegalArgumentException("Parking floor not exists");
            }
            else if(spot.getFloorNumber()!=pf.getFloorNumber()) {
                throw new IllegalArgumentException("Parking Floor Number and Spot Floor Number mismatch");
            }
            pf.addSpot(spot);
        }

        public void removeSpotFromParkingFloor(ParkingFloor pf, Spot spot) {
            if(pf==null || spot==null) {
                throw new IllegalArgumentException("Parking Floor or Spot cannot be null");
            }
            else if(!parkingFloors.containsKey(pf.getFloorNumber())) {
                throw new IllegalArgumentException("Parking floor not exists");
            }
            else if(spot.getFloorNumber()!=pf.getFloorNumber()) {
                throw new IllegalArgumentException("Parking Floor Number and Spot Number mismatch");
            }
            pf.removeSpot(spot);
        }

        public Spot getSpotForVehicleType(VehicleType vehicleType) {
            if(vehicleType==null) {
                throw new IllegalArgumentException("Vehicle type cannot be null");
            }
            for(Map.Entry<Integer, ParkingFloor> entry : parkingFloors.entrySet()) {
                for(Spot spot : entry.getValue().getSpots()) {
                    if(spot.getSpotType()==vehicleType && spot.isAvailable()) {
                        return spot;
                    }
                }
            }
            return null;
        }

        public List<Spot> getAvailableSpots(VehicleType vehicleType) {
            if(vehicleType==null) {
                throw new IllegalArgumentException("Vehicle type cannot be null");
            }
            List<Spot> spots = new ArrayList<>();
            for(Map.Entry<Integer, ParkingFloor> entry : parkingFloors.entrySet()) {
                for(Spot spot : entry.getValue().getSpots()) {
                    if(spot.getSpotType()==vehicleType && spot.isAvailable()) {
                        spots.add(spot);
                    }
                }
            }
            return spots;
        }

}
