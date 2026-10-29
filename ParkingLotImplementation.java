package ParkingLotIV;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLotImplementation  implements ParkingLot {
    private final SpotService spotService;
    private final FeeCalculator feeCalculator;
    private final Map<Integer,Ticket> activeTickets = new HashMap<>();
    private final Map<String,Vehicle> vehicles = new HashMap<>();
    private int ticketID = 1;

    public ParkingLotImplementation(SpotService spotService, FeeCalculator feeCalculator) {
        this.spotService = spotService;
        this.feeCalculator = feeCalculator;
    }

    @Override
    public Ticket parkVehicle(Vehicle vehicle,Spot spot) {
        if(vehicle==null || spot==null){
            System.out.println("Vehicle or spot is not available.");
            return null;
        }
        else if(!(vehicle.getType().name().equals(spot.getSpotType().name()))) {
            System.out.println("Vehicle Type and Spot Type are not same");
            return null;
        }
        else if (!spot.isAvailable()) {
            System.out.println("Spot is not available");
            return null;
        }
        else if(vehicles.get(vehicle.getNumber())==vehicle) {
            System.out.println("Vehicle is already parked.");
            return null;
        }
        spot.setVehicle(vehicle);
        Ticket ticket = new Ticket(ticketID++,TicketStatus.ACTIVE,spot, LocalDateTime.now());
        activeTickets.put(ticket.getId(),ticket);
        vehicles.put(vehicle.getNumber(),vehicle);
        return ticket;
    }

    @Override
    public double unparkVehicle(Ticket ticket) {
        if(ticket == null || activeTickets.get(ticket.getId()) != ticket || ticket.getStatus() != TicketStatus.ACTIVE) {
            throw new IllegalArgumentException("Invalid or inactive ticket");
        }
        ticket.getSpot().setVehicle(null);
        ticket.setStatus(TicketStatus.COMPLETED);
        activeTickets.remove(ticket.getId());
        vehicles.remove(ticket.getSpot().getVehicle().getNumber());
        return feeCalculator.calculateFee(ticket.getSpot().getSpotType(),ticket.getDateTime(),LocalDateTime.now());
    }

    @Override
    public List<Spot> getAvailableSpots(SpotType type) {
        return spotService.getAvailableSpotListOfSpotType(type);
    }
}
