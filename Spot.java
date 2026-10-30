package ParkingLotIV;

public class Spot {
    private final int id;
    private final VehicleType spotType;
    private final int floorNumber;
    private Vehicle vehicle;

    public Spot(int id,VehicleType spotType,int floorNumber) {
        this.id = id;
        this.spotType = spotType;
        this.floorNumber = floorNumber;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public int getId() {
        return id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public VehicleType getSpotType() {
        return spotType;
    }

    public boolean isAvailable() {
        if(vehicle == null){
            return true;
        }
        return false;
    }
}
