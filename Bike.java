package ParkingLotIV;

public class Bike implements Vehicle {
    private final String number;
    public Bike(String number) {
        this.number = number;
    }

    @Override
    public String getNumber() {
        return this.number;
    }

    @Override
    public VehicleType getType() {
        return VehicleType.BIKE;
    }
}
