package ParkingLotIV;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLotImpl implements ParkingLot {
    private int ticketID = 1;
    private final Map<Vehicle,Boolean> vehicleMap = new HashMap<Vehicle,Boolean>();
    private final Map<Integer,Ticket> ticketMap = new HashMap<Integer,Ticket>();
    private final PFManager manager = new PFManager();
    private final FeeCalculator feeCalculator = new FeeCalculatorImplementation();

    @Override
    public Ticket parkVehicle(Vehicle vehicle) {
        if(vehicle==null){
            throw new NullPointerException("Vehicle required");
        }
        if(vehicleMap.containsKey(vehicle)){
            throw new IllegalArgumentException("Vehicle already parked");
        }
        Spot spot = manager.getSpotForVehicleType(vehicle.getType());
        if(spot==null) {
            throw new IllegalArgumentException("Spot not available");
        }
        Ticket ticket = new Ticket(ticketID++,spot,vehicle, LocalDateTime.now());
        vehicleMap.put(vehicle,true);
        spot.setVehicle(vehicle);
        ticketMap.put(ticket.getId(),ticket);
        return ticket;
    }

    @Override
    public double unparkVehicle(int ticketID) {
        if(!ticketMap.containsKey(ticketID)) {
            throw new IllegalArgumentException("Ticket id not available");
        }
        Ticket ticket = ticketMap.get(ticketID);
        if(ticket.getStatus()==TicketStatus.COMPLETED) {
            throw new IllegalArgumentException("Ticket already used");
        }
        ticket.getSpot().setVehicle(null);
        ticket.setStatus(TicketStatus.COMPLETED);
        ticket.setExitTime(LocalDateTime.now());
        double amount = feeCalculator.calculateFee(ticket.getVehicle().getType(),ticket.getEntryTime(),ticket.getExitTime());
        ticket.setAmount(amount);
        vehicleMap.remove(ticket.getVehicle());
        ticketMap.remove(ticket.getId());
        return amount;
    }

    @Override
    public List<Spot> getAvailableSpots(VehicleType type) {
        return manager.getAvailableSpots(type);
    }
}
