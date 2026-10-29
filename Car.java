package ParkingLotIV;

public class Car implements Vehicle {
    private final String number;
    public Car(String number) {
        this.number = number;
    }

    @Override
    public String getNumber() {
        return this.number;
    }

    @Override
    public VehicleType getType() {
        return VehicleType.CAR;
    }
}
