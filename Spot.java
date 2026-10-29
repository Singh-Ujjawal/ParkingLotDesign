package ParkingLotIV;

public class Spot {
    private final int id;
    private final SpotType spotType;
    private Vehicle vehicle;

    public Spot(int id,SpotType spotType) {
        this.id = id;
        this.spotType = spotType;
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

    public SpotType getSpotType() {
        return spotType;
    }

    public boolean isAvailable() {
        if(vehicle == null){
            return true;
        }
        return false;
    }
}
