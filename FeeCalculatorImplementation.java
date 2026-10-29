package ParkingLotIV;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class FeeCalculatorImplementation implements FeeCalculator {
    @Override
    public double calculateFee(SpotType type, LocalDateTime entryTime, LocalDateTime exitTime) {
         if(type==null || entryTime==null || exitTime==null) {
             throw new IllegalArgumentException("Type and timestamps are required");
         }
        long minutes = ChronoUnit.MINUTES.between(entryTime, exitTime);

        if(minutes < 0) {
            throw new IllegalArgumentException("Exit time cannot be before entry time");
        }

        long hours = Math.max(1,(minutes+59)/60);
        int rate = switch (type) {
            case BIKE -> 20;
            case CAR -> 50;
            case TRUCK -> 100;
        };
        return hours * rate;
    }
}
