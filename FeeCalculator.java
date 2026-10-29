package ParkingLotIV;

import java.time.LocalDateTime;

public interface FeeCalculator {
    double calculateFee(SpotType type, LocalDateTime entryTime, LocalDateTime exitTime);
}
