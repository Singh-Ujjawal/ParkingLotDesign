package ParkingLotIV;

import java.time.LocalDateTime;

public interface FeeCalculator {
    double calculateFee(VehicleType type, LocalDateTime entryTime, LocalDateTime exitTime);
}
